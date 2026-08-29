# Day 57 - Practice Exercises: JWT Authentication

Try to solve these YOURSELF first, without looking at JwtUtil.java,
JwtAuthenticationFilter.java, or the updated AuthController/SecurityConfig.

All require running the app and testing with curl.

---

### Exercise 1: Decode a JWT manually to see its structure (Easy-Medium)
Log in and get a token. Paste it into a site like jwt.io (or manually
Base64-decode the first two dot-separated parts yourself). Identify the
header, payload (claims), and signature sections. Confirm you can see
your username and role in plain text in the payload - explain in a
comment why this means a JWT should NEVER contain sensitive data like a
password.

---

### Exercise 2: Test an expired token (Easy-Medium)
Temporarily change `jwt.expirationMs` in `application.properties` to
`5000` (5 seconds). Restart the app, log in, wait 10 seconds, then try
using that token. Confirm you get rejected (treated as unauthenticated).
Change the expiration back afterward.

---

### Exercise 3: Add a `/auth/me` endpoint (Medium)
Add an endpoint `GET /auth/me` that returns the CURRENTLY authenticated
username (hint: inject `Authentication authentication` as a parameter,
like Day 55's Exercise 5, and call `authentication.getName()`). Test with
a valid token and confirm it matches who you logged in as.

---

### Exercise 4: Tamper with a token and confirm it's rejected (Medium-Hard)
Take a valid token, change ONE character in the middle of it (like
flipping a letter), and try using it in a request. Confirm you get
rejected. Explain in a comment WHY changing even one character breaks the
signature verification completely (research how JWT signatures work at a
high level if needed).

---

### Exercise 5: Add a token refresh concept (Harder - conceptual)
Real APIs often issue a SHORT-lived access token plus a LONGER-lived
refresh token, so users don't have to re-enter passwords constantly.
Sketch out (in comments/pseudocode, doesn't need to fully work) how you
would add a `POST /auth/refresh` endpoint that takes a valid-but-not-yet-
expired token and issues a NEW one with a fresh expiration, without
requiring the username/password again.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why is it safe for a JWT's PAYLOAD to be readable by anyone (it's just Base64, not encrypted), while still being safe from TAMPERING?
- [ ] In Exercise 2, why does an expired token get rejected WITHOUT the server needing to track "logged out" state anywhere - what's actually being checked?
- [ ] In Exercise 4, why does changing even ONE character anywhere in the token invalidate the ENTIRE thing, rather than just that one part?
- [ ] Why do real systems (Exercise 5) commonly use SHORT-lived access tokens even though it means more frequent token issuance - what security benefit does a short expiration provide over a long-lived one?

If you're unsure on any of these, revisit `notes.md` before moving to Day 58.
