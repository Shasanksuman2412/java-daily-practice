# Day 56 - Practice Exercises: Database-Backed Authentication

Try to solve these YOURSELF first, without looking at User.java,
UserRepository.java, CustomUserDetailsService.java, AuthController.java,
DataInitializer.java, or the updated SecurityConfig.java.

All require running the app and testing with curl.

---

### Exercise 1: Verify users are really in the database (Easy-Medium)
After registering a user via `/auth/register`, open the H2 console
(`http://localhost:8080/h2-console`) and run `SELECT * FROM USER;`.
Confirm you can see the username and role, but that the password column
shows a long BCrypt hash, NOT the plain-text password you sent.

---

### Exercise 2: An admin-only endpoint to promote a user (Easy-Medium)
Add `PUT /admin/users/{username}/promote` (ADMIN-only, configure in
`SecurityConfig`) that finds a user by username and changes their role to
`"ADMIN"`. Test: register a new user, confirm they can't create projects,
promote them as admin, confirm they NOW can.

---

### Exercise 3: List all registered users (ADMIN only) (Medium)
Add `GET /admin/users` (ADMIN-only) returning a `List<String>` of all
usernames (NOT passwords!). Use a simple DTO or just map usernames from
`userRepository.findAll()`.

---

### Exercise 4: Prevent an empty or duplicate role field (Medium-Hard)
Currently `role` is just a raw String with no validation. Add a check in
`AuthController.register()` (or a custom validator) ensuring the role
being set is always exactly `"USER"` server-side, REGARDLESS of anything
a malicious client might try to inject via extra JSON fields. Confirm
`RegisterRequest` genuinely has no `role` field for a client to abuse
(reference Day 54's DTO safety lesson).

---

### Exercise 5: Case-insensitive username lookup (Harder)
Currently, `findByUsername("Shasank")` and `findByUsername("shasank")`
are treated as DIFFERENT users. Add a custom query
`findByUsernameIgnoreCase(String username)` to `UserRepository` (Spring
Data supports this naming pattern) and use it in
`CustomUserDetailsService`. Test logging in with different capitalizations
of the same username.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why does the password column show a LONG hash rather than the original password - could someone theoretically reverse a BCrypt hash back to the plain password?
- [ ] In Exercise 2, why does promoting a user require them to LOG OUT and back IN (or make a fresh request) to see the new permissions take effect, rather than updating instantly mid-session?
- [ ] In Exercise 4, why is it safer for `role` to be COMPLETELY ABSENT from `RegisterRequest` rather than present but "validated" - what's the difference between "can't be set" and "gets overwritten if set incorrectly"?
- [ ] In Exercise 5, why does `findByUsernameIgnoreCase` need to be a SEPARATE method from `findByUsername`, rather than Spring somehow "just knowing" you want case-insensitivity?

If you're unsure on any of these, revisit `notes.md` before moving to Day 57.
