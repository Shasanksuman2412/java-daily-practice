# Day 56 - Database-Backed Authentication

Day 55's notes flagged this limitation ourselves: in-memory users aren't
suitable for a real app. Today fixes it - users live in the database
(Day 51's JPA), plus a proper registration endpoint.

## What I learned

### 1. The User entity
```java
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password; // always ENCODED, never plain text
    private String role;     // "USER" or "ADMIN"
}
```

### 2. UserRepository - finding a user by username
```java
Optional<User> findByUsername(String username); // Day 38's Optional
```

### 3. A custom UserDetailsService - replacing Day 55's in-memory version
```java
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
```
Spring Security calls this AUTOMATICALLY during login - never called
directly.

### 4. A registration endpoint - creating new users safely
```java
@PostMapping("/auth/register")
public String register(@Valid @RequestBody RegisterRequest request) {
    user.setPassword(passwordEncoder.encode(request.password())); // NEVER plain text
    user.setRole("USER"); // registrations default to USER, not ADMIN
    userRepository.save(user);
}
```

### 5. The chicken-and-egg problem - seeding an initial admin
With zero users in a fresh database, nobody could log in at all. A
`CommandLineRunner` seeds one admin account on startup if none exists.
```java
@Component
public class DataInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            // create and save the seed admin
        }
    }
}
```

### 6. Updating SecurityConfig
The `InMemoryUserDetailsManager` bean is GONE entirely - Spring Security
automatically picks up `CustomUserDetailsService` since it's the ONLY
`UserDetailsService` bean in the application context.

### 7. Testing the full flow
Register, then log in AS that new user - real end-to-end authentication.

## How to actually run this and test the full flow

```bash
cd Day56-DatabaseAuth/TaskManagerJPA
mvn spring-boot:run
```

Watch the startup logs for: `Seeded initial admin account: admin / admin123`

**Register a brand new user:**
```bash
curl -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d '{"username":"shasank","password":"mypassword"}'
```

**Log in AS that new user (proves it's really in the database):**
```bash
curl -u shasank:mypassword http://localhost:8080/tasks
```

**Try registering the SAME username again (should fail with 409):**
```bash
curl -i -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d '{"username":"shasank","password":"different"}'
```

**Confirm the seeded admin still works:**
```bash
curl -X POST http://localhost:8080/projects -u admin:admin123 -H "Content-Type: application/json" -d '{"name":"Real Admin Project"}'
```

**Confirm the NEW user (role USER) can't create - same rule as Day 55:**
```bash
curl -i -u shasank:mypassword -X POST http://localhost:8080/projects -H "Content-Type: application/json" -d '{"name":"Should fail"}'
```

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does `CustomUserDetailsService` never get called EXPLICITLY anywhere in our code - what mechanism actually triggers `loadUserByUsername()` during a request?
- Why does `DataInitializer` check `if (userRepository.findByUsername("admin").isEmpty())` BEFORE creating the admin - what would happen on every server restart without that check?
- Why does `register()` ALWAYS set `role` to `"USER"`, never letting the client specify their own role - what security problem would allowing that create?
