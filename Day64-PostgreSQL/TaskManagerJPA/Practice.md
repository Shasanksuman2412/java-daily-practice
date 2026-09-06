# Day 64 - Practice Exercises: Migrating to PostgreSQL

These require Docker (for local testing) and ideally your Render account
from Day 63 (for the cloud portion).

---

### Exercise 1: Run the full stack locally with real Postgres (Easy-Medium)
```bash
docker compose up --build
```
Confirm both containers start, and the app works exactly as before via
curl. Confirm `docker ps` shows TWO running containers.

---

### Exercise 2: Prove persistence survives a full teardown (Easy-Medium)
Create a task, run `docker compose down`, then `docker compose up` again.
Confirm the task is STILL there. Then try `docker compose down -v` (the
`-v` flag also removes volumes) and `docker compose up` again - confirm
the data IS gone this time. Explain in a comment why `-v` specifically
makes the difference.

---

### Exercise 3: Connect a GUI tool to inspect the database (Medium)
Install a free tool like TablePlus, DBeaver, or pgAdmin. Connect to
`localhost:5432` using the credentials from `docker-compose.yml`
(taskuser/taskpass/taskdb). Browse the actual tables Hibernate created
and confirm they match your `@Entity` classes.

---

### Exercise 4: Redeploy to Render with real persistence (Medium-Hard)
Update your Render deployment with today's code (either update the
existing service or redeploy via Blueprint). Register a new user,
redeploy (push a trivial change to trigger it), and confirm the user
SURVIVES this time - the opposite result from Day 63's Exercise 4.

---

### Exercise 5: Simulate a database failure locally (Harder)
With `docker compose up` running, manually stop JUST the postgres
container (`docker stop <postgres-container-name>`) while leaving the
app running. Try hitting an endpoint and observe what error occurs.
Restart postgres and confirm the app recovers (you may need to restart
the app container too, depending on connection pool behavior). Explain in
a comment why a real production system would want automatic reconnection
handling for exactly this scenario.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does `docker compose down` (without `-v`) preserve the named volume, while `-v` destroys it - what's the actual scope of what gets deleted in each case?
- [ ] In Exercise 3, why do the table names/columns you see in the GUI tool match your `@Entity` classes so closely - what generated that schema, and when did it run?
- [ ] In Exercise 4, why does this redeploy behave DIFFERENTLY from Day 63's, given that the APPLICATION CODE for creating a user didn't change at all between the two days?
- [ ] In Exercise 5, why might a real production app want to RETRY a failed database connection automatically for a few seconds, rather than immediately crashing on the first failed query?

If you're unsure on any of these, revisit `notes.md`.

Sixty-four days in, and the project now has a real, persistent database
both locally and in the cloud - genuinely production-grade data storage,
not just a learning-friendly stand-in.
