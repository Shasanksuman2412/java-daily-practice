# Day 55 - Practice Exercises: Spring Security Basics

Try to solve these YOURSELF first, without looking at SecurityConfig.java
or Solutions.

All require running the app and testing with curl using `-u username:password`.

---

### Exercise 1: Add a third user with a different role (Easy-Medium)
Add a `moderator` user with role `MODERATOR` to `userDetailsService()`.
Don't grant it any special permissions yet - just confirm it can
authenticate (test with a GET request) but gets 403 on POST, same as a
regular USER currently does.

---

### Exercise 2: Let MODERATOR update tasks but not delete them (Easy-Medium)
Modify the security rules so `PUT /tasks/**` allows BOTH `ADMIN` and
`MODERATOR` roles (hint: `.hasAnyRole("ADMIN", "MODERATOR")`), but
`DELETE` still requires ONLY `ADMIN`. Test all three scenarios: admin
deleting (works), moderator deleting (403), moderator updating (works).

---

### Exercise 3: Make project creation open to any authenticated user (Medium)
Change the rule so `POST /projects` is allowed for ANY authenticated user
(not just ADMIN), while `POST /tasks` still requires ADMIN. Test creating
a project as the regular `user` account (should now succeed).

---

### Exercise 4: Add a public health-check endpoint (Medium-Hard)
Add a new endpoint `GET /health` returning `"OK"` with NO controller-level
security concerns - but configure it in `SecurityConfig` to be `permitAll()`
(accessible with ZERO credentials). Confirm `curl http://localhost:8080/health`
works with no `-u` flag at all, while `/tasks` still requires auth.

---

### Exercise 5: Get the currently authenticated username in a controller (Harder)
Look up `Authentication` / `Principal` injection in a Spring controller
method (e.g., adding a parameter of type `Authentication authentication`
to a method, then calling `authentication.getName()`). Add an endpoint
`GET /whoami` that returns the currently logged-in username as a String.
Test as both `user` and `admin` and confirm each sees their own username.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does `.hasAnyRole("ADMIN", "MODERATOR")` need to be checked BEFORE any more general rule like `.anyRequest().authenticated()` - what would happen if the order were reversed?
- [ ] In Exercise 4, why does `permitAll()` need to be explicitly configured, rather than just NOT adding a security check for that path - what's Spring Security's DEFAULT behavior for unmatched paths (check the last line: `.anyRequest().authenticated()`)?
- [ ] In Exercise 5, why does `Authentication.getName()` correctly return "user" or "admin" without you ever having to manually pass that information through the request?
- [ ] Why is storing users IN-MEMORY (today's approach) clearly not suitable for a real production application - what would you need instead (hint: think about Day 51's JPA)?

If you're unsure on any of these, revisit `notes.md` before moving to Day 56.
