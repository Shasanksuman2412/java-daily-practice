# Day 65 - Practice Exercises: Database Migrations with Flyway

These require Docker running locally (for the Postgres portion).

---

### Exercise 1: Run the full stack and watch Flyway migrate (Easy-Medium)
```bash
docker compose up --build
```
Watch the startup logs and confirm you see all four `Migrating schema...`
lines. Confirm the app works exactly as before via curl.

---

### Exercise 2: Inspect flyway_schema_history (Easy-Medium)
Connect to the Postgres container (via a GUI tool or
`docker exec -it <container> psql -U taskuser -d taskdb`) and run:
```sql
SELECT version, description, success FROM flyway_schema_history;
```
Confirm you see 4 rows, all marked successful.

---

### Exercise 3: Add a new migration - a priority column (Medium)
Add a field `String priority` to the `Task` entity. Write a NEW migration
file `V5__add_priority_to_task.sql`:
```sql
ALTER TABLE task ADD COLUMN priority VARCHAR(50);
```
Restart the app (`docker compose up --build` again) and confirm Flyway
picks up and applies ONLY the new V5 migration (not re-running V1-V4).

---

### Exercise 4: Try breaking the "never edit old migrations" rule (Medium-Hard)
Go back and edit `V1__create_users_table.sql` (change something trivial,
like a column type). Try restarting the app. Confirm Flyway REFUSES to
start, complaining about a checksum mismatch. Revert your edit and
confirm the app starts normally again. Explain in a comment WHY Flyway
enforces this so strictly.

---

### Exercise 5: Simulate a failed migration (Harder)
Write a deliberately broken migration `V6__broken_migration.sql` with
invalid SQL syntax (e.g., `CREATE TALBE typo_test (id INT);`). Restart
the app and observe Flyway fail loudly with a clear error, refusing to
start the application at all. Fix or remove the broken file, and confirm
the app recovers. Explain in a comment why "fail loudly and refuse to
start" is a SAFER behavior than "silently skip the broken migration."

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 3, how does Flyway know to run ONLY V5 and not re-run V1-V4 - what information does it check first?
- [ ] In Exercise 4, why does Flyway use CHECKSUMS (not just filenames) to detect edited migrations - what would a filename-only check miss?
- [ ] In Exercise 5, why is it better for the WHOLE APPLICATION to fail to start on a broken migration, rather than starting up with a partially-applied or inconsistent schema?
- [ ] Why does the discipline "always add a new migration, never edit an old one" matter MORE once an app has real users and a real production database, compared to during early solo development?

If you're unsure on any of these, revisit `notes.md`.

Sixty-five days in, and the project's database schema is now fully
version-controlled, auditable, and reproducible - a genuine production
practice, not just a convenient shortcut.
