# Day 61 - Practice Exercises: Docker

These require Docker installed and running on your machine. If you don't
have it yet, install Docker Desktop first (docker.com), then come back.

---

### Exercise 1: Build and run the image (Easy-Medium)
Run through the full `docker compose up --build` flow. Confirm you can
`curl http://localhost:8080/auth/login` successfully from your host
machine while the app runs INSIDE a container.

---

### Exercise 2: Prove the image is portable (Easy-Medium)
After building the image, run `docker images` and note the image ID.
Stop the container. Without touching the Dockerfile or source code again,
run the SAME image with a DIFFERENT host port mapping:
```bash
docker run -p 9090:8080 -v $(pwd)/data:/app/data taskmanager-api
```
Confirm the API is now reachable at `http://localhost:9090` instead of
8080 - the container itself didn't need any changes, only the port
mapping did.

---

### Exercise 3: Inspect the image layers (Medium)
Run `docker history taskmanager-api` and look at the list of layers.
Identify which layer corresponds to `COPY --from=build /app/target/*.jar
app.jar` and note its size compared to the base JRE image layer.

---

### Exercise 4: Break persistence on purpose, then fix it (Medium-Hard)
Temporarily remove the `volumes:` section from `docker-compose.yml`.
Rebuild and run, create a task, then `docker compose down` and
`docker compose up` again. Confirm the task is GONE (since nothing was
persisted outside the container). Restore the `volumes:` section and
confirm data persists correctly again.

---

### Exercise 5: Add a healthcheck (Harder)
Look up Docker `HEALTHCHECK` instructions. Add one to the Dockerfile that
periodically curls `/actuator/health` (you'll need to add
`spring-boot-starter-actuator` as a dependency for this endpoint to
exist) or a simpler existing endpoint. Rebuild, run `docker ps`, and
confirm the container shows a "healthy" status after Spring Boot finishes
starting.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does the SAME Docker image work on a different port with zero rebuild - what does this prove about the separation between "what's built" and "how it's run"?
- [ ] In Exercise 4, why does removing the volume mapping specifically cause data loss, when the DATABASE CODE itself (application.properties, JPA config) never changed at all?
- [ ] In Exercise 3, why is the final image's jar layer typically much SMALLER than the base JRE layer, given that the whole Spring Boot app (with all its dependencies) is bundled into that one jar file?
- [ ] Why does a HEALTHCHECK (Exercise 5) matter more for a container running in a REAL deployment (like a cloud server) than it does when you're just running it locally on your own machine for testing?

If you're unsure on any of these, revisit `notes.md`.

Sixty-one days in, and the API from Day 49-60 can now be shipped to
literally any machine with Docker installed - a genuinely useful,
real-world skill on top of everything already built.
