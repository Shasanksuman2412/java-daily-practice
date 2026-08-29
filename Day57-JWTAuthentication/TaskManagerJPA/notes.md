# Day 57 - JWT Authentication

HTTP Basic Auth sends credentials on EVERY single request. Today switches
to the industry-standard approach for REST APIs: log in once, get a
signed token, use that token instead of your password for every
subsequent call.

## What I learned

### 1. What is a JWT?
A self-contained, SIGNED string encoding claims (username, role, expiry).
The server VERIFIES it wasn't tampered with via a cryptographic signature,
without storing any session state - that's "stateless."

### 2. The login flow
```
POST /auth/login {username, password}
  -> server verifies credentials, generates and returns a signed JWT

Every subsequent request:
  Authorization: Bearer <token>
  -> server verifies the signature, extracts username/role
```

### 3. Generating a token - JwtUtil
```java
public String generateToken(String username, String role) {
    return Jwts.builder()
            .subject(username)
            .claim("role", role)
            .issuedAt(now)
            .expiration(expiry)
            .signWith(secretKey)
            .compact();
}
```

### 4. Validating a token
```java
Jwts.parser().verifyWith(secretKey).build()
        .parseSignedClaims(token).getPayload().getSubject();
```
If the signature doesn't match or the token expired, parsing throws
automatically.

### 5. A custom filter - checking the token on every request
```java
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    protected void doFilterInternal(...) {
        String header = request.getHeader("Authorization");
        // extract token, validate, set SecurityContext
        chain.doFilter(request, response);
    }
}
```
Runs BEFORE every request reaches a controller - Day 55's filter-chain
concept, extended with our own custom step.

### 6. Making the app stateless
```java
.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
```
No server-side session storage - every request carries its own proof.

### 7. Testing the full flow
Log in once, reuse the token for every request after that.

## How to actually run this and test the full JWT flow

```bash
cd Day57-JWTAuthentication/TaskManagerJPA
mvn spring-boot:run
```

**Log in as the seeded admin and capture the token:**
```bash
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'
```
Copy the `token` value from the response.

**Use that token instead of a username/password:**
```bash
TOKEN="paste-the-token-here"
curl http://localhost:8080/tasks -H "Authorization: Bearer $TOKEN"
```

**Try WITHOUT the token (should be 401):**
```bash
curl -i http://localhost:8080/tasks
```

**Register + login as a normal user, confirm they can't create (403):**
```bash
curl -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d '{"username":"shasank","password":"mypassword"}'
USER_TOKEN=$(curl -s -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"shasank","password":"mypassword"}')
# extract the token value manually from the JSON response above, then:
curl -i -H "Authorization: Bearer <paste-user-token>" -X POST http://localhost:8080/projects -H "Content-Type: application/json" -d '{"name":"test"}'
```

**Try a wrong password (should be 401 with a clear message):**
```bash
curl -i -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"wrongpassword"}'
```

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does the server NEVER need to look up a token in a database to validate it - what does the cryptographic SIGNATURE guarantee that makes a database check unnecessary?
- Why is `SessionCreationPolicy.STATELESS` important here - what would happen (memory-wise, scalability-wise) if the server DID keep a session for every logged-in user?
- What happens to a user's access the moment their JWT expires - do they need to explicitly "log out," or does it just stop working on its own at the expiration time encoded in the token?
