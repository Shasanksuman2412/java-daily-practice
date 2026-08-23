# Day 55 - Spring Security Basics

Right now, anyone can hit the API and create, update, or delete anything.
Today locks it down properly with authentication and role-based access.

## What I learned

### 1. What Spring Security actually does
A FILTER CHAIN that intercepts every request BEFORE it reaches
controllers - checking credentials, permissions, blocking unauthorized
access early.

### 2. Adding the dependency changes everything immediately
The moment `spring-boot-starter-security` is on the classpath, Spring
Boot AUTO-SECURES every endpoint by default, generating a random password
printed in the startup logs - we configure this properly instead.

### 3. Defining users - UserDetailsService
```java
@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails user = User.withUsername("user")
            .password(encoder.encode("password123"))
            .roles("USER")
            .build();
    return new InMemoryUserDetailsManager(user, admin);
}
```
NEVER store plain-text passwords - always encode them.

### 4. Password encoding - BCryptPasswordEncoder
```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // one-way hashing, industry standard
}
```

### 5. The SecurityFilterChain - deciding what needs what
```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers(HttpMethod.GET, "/tasks/**").authenticated()   // any logged-in user
    .requestMatchers(HttpMethod.POST, "/tasks/**").hasRole("ADMIN") // only ADMIN
    .anyRequest().authenticated()
)
.httpBasic(Customizer.withDefaults()); // simple username:password auth
```

### 6. Testing with HTTP Basic Auth via curl
```bash
curl -u user:password123 http://localhost:8080/tasks         # works - USER can read
curl -u user:password123 -X POST http://localhost:8080/tasks # 403 Forbidden
curl -u admin:admin123 -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"New task"}' # works
```

### 7. No credentials at all
```bash
curl -i http://localhost:8080/tasks
```
Returns 401 Unauthorized - blocked BEFORE it ever reaches TaskController.

## How to actually run this and test all three scenarios

```bash
cd Day55-SpringSecurity/TaskManagerJPA
mvn spring-boot:run
```

**Scenario 1 - no credentials (should fail with 401):**
```bash
curl -i http://localhost:8080/tasks
```

**Scenario 2 - USER role reading (should succeed):**
```bash
curl -u user:password123 http://localhost:8080/tasks
```

**Scenario 3 - USER role trying to create (should fail with 403):**
```bash
curl -i -u user:password123 -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Test"}'
```

**Scenario 4 - ADMIN role creating (should succeed):**
```bash
curl -X POST http://localhost:8080/projects -u admin:admin123 -H "Content-Type: application/json" -d '{"name":"Secured Project"}'
```

**Scenario 5 - ADMIN role deleting (should succeed):**
```bash
curl -i -u admin:admin123 -X DELETE http://localhost:8080/projects/1
```

Notice the STATUS CODES are meaningfully different: 401 (not authenticated
at all) vs 403 (authenticated, but not ALLOWED to do this specific thing).

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does a request with NO credentials get 401 (Unauthorized), while a request with VALID credentials but the WRONG role gets 403 (Forbidden) - what's the actual distinction Spring Security is making?
- Why is `BCryptPasswordEncoder` used instead of just comparing plain-text password strings directly - what would go wrong if the H2 database (or its file) were ever leaked?
- Why does GET stay open to BOTH roles (`.authenticated()`) while POST/PUT/DELETE require SPECIFICALLY `.hasRole("ADMIN")` - what real-world access pattern does this mirror?
