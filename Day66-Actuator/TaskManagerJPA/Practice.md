# Day 66 - Practice Exercises: Spring Boot Actuator

These require Docker running locally (for Postgres) and curl or a browser.

---

### Exercise 1: Explore the exposed endpoints (Easy-Medium)
With the app running, hit `/actuator` itself (no sub-path) as an
authenticated ADMIN. Confirm it returns a list of all currently EXPOSED
endpoints with their URLs - a built-in directory of what's available.

---

### Exercise 2: Add a custom info field (Easy-Medium)
Add `info.app.author=YourName` to `application.properties`. Restart, hit
`/actuator/info` as ADMIN, and confirm your custom field appears in the
response alongside `name`, `description`, and `java-version`.

---

### Exercise 3: Watch a metric change in real time (Medium)
Hit `/actuator/metrics/http.server.requests` as ADMIN. Note the current
`count` value. Make 5 more requests to any endpoint (like `/tasks`), then
check the metric again - confirm the count increased by roughly 5,
proving it's tracking REAL request traffic, not a static value.

---

### Exercise 4: Write a custom health indicator (Medium-Hard)
Look up `HealthIndicator` (implement the interface, create a
`@Component`). Write one that always reports `UP` with a custom detail
message, like checking if a specific configuration value is present.
Restart, check `/actuator/health` as ADMIN, and confirm your custom
indicator appears alongside `db` and `diskSpace` in the component breakdown.

---

### Exercise 5: Simulate a DOWN database and observe the health check (Harder)
With `docker compose up` running, stop JUST the postgres container:
```bash
docker stop <postgres-container-name>
```
Hit `/actuator/health` (public, unauthenticated) again. Confirm the
overall status flips to `DOWN` (even without showing details to an
anonymous caller). Then check `docker ps` and confirm the taskmanager
container's Docker-level health status ALSO flips to unhealthy. Restart
postgres and confirm both recover.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 3, why does `http.server.requests` count EVERY request, including the ones you make just to CHECK the metric itself - is there a way this could create a slightly misleading feedback loop?
- [ ] In Exercise 4, why does a custom `HealthIndicator` get automatically picked up and included in `/actuator/health` just by being a `@Component` - what mechanism is scanning for it?
- [ ] In Exercise 5, why does the PUBLIC (unauthenticated) health check still correctly show `DOWN` overall, even though it doesn't reveal WHICH component failed - what's the security tradeoff being made there?
- [ ] Why would a real production team wire their Actuator health endpoint into an EXTERNAL uptime monitor (like a service that pages someone at 3am), rather than just occasionally checking it manually?

If you're unsure on any of these, revisit `notes.md`.

Sixty-six days in, and the application can now honestly answer the
question "are you actually working right now?" - a small addition with
genuinely outsized production value.
