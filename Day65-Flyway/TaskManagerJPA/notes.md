# Day 65 - Database Migrations with Flyway

`ddl-auto=update` has been quietly guessing at our schema this whole
time - today replaces that guesswork with explicit, versioned, auditable
SQL migrations, the way real production teams manage schema changes.

## What I learned

### 1. Why ddl-auto=update is risky for production
Hibernate INFERS the schema from `@Entity` classes and tries to patch the
database to match - no history, no review process, and it can guess
wrong (especially for renames or complex changes). No record of WHAT
changed or WHEN.

### 2. Flyway - versioned, explicit migrations
SQL files named `V1__description.sql`, `V2__description.sql`, etc., in
`src/main/resources/db/migration/`. Flyway applies them IN ORDER, exactly
once, tracked in its own `flyway_schema_history` table - a real audit trail.

### 3. Adding the dependency
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-database-postgresql</artifactId>
</dependency>
```

### 4. Switching Hibernate to validate mode
```properties
spring.jpa.hibernate.ddl-auto=validate
```
Hibernate now only CHECKS entities match the database - never modifies
anything. Flyway becomes the single source of truth for schema changes.

### 5. Writing the migrations
```sql
-- V1__create_users_table.sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);
```
The `User` entity got `@Table(name = "users")` added - "user" is a
reserved word in the SQL standard, a genuine common gotcha worth avoiding
deliberately now that we're being explicit about schema.

### 6. Flyway runs automatically on startup
No code needed - Spring Boot detects Flyway on the classpath and runs
pending migrations BEFORE the app finishes starting.

### 7. Adding a new migration later
```sql
-- V4__add_index_on_task_title.sql
CREATE INDEX idx_task_title ON task(title);
```
NEVER edit an already-applied migration file - always add a NEW one.
This is the core discipline of the whole approach.

### 8. Tests stay on H2 with create-drop - a deliberate, acknowledged tradeoff
```properties
spring.flyway.enabled=false
```
Tests use fast, disposable H2, not Flyway-managed Postgres - same honest
tradeoff acknowledged since Day 64.

## How to actually run this locally

```bash
cd Day65-Flyway/TaskManagerJPA
docker compose up --build
```

**Watch the startup logs closely this time** - you should see Flyway log
lines like:
```
Migrating schema "public" to version "1 - create users table"
Migrating schema "public" to version "2 - create project table"
Migrating schema "public" to version "3 - create task table"
Migrating schema "public" to version "4 - add index on task title"
```

Test exactly as before:
```bash
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'
```

**Inspect the migration history table (optional, via a GUI tool or psql):**
```sql
SELECT * FROM flyway_schema_history;
```
You'll see one row per migration, with checksums, timestamps, and
success/failure status - the audit trail `ddl-auto=update` never gave us.

**Try starting completely fresh (wipes the volume):**
```bash
docker compose down -v
docker compose up --build
```
Watch Flyway run ALL four migrations again from scratch against a brand
new, empty database - proving they're fully reproducible.

## How to redeploy to Render

Push today's code, then update your existing Render service (or redeploy
via Blueprint) same as Day 64. Flyway will run automatically against
Render's managed Postgres database on startup, exactly like it does
locally.

## Commands I ran
```bash
docker compose up --build
```

## Questions / things to revisit
- Why does `spring.jpa.hibernate.ddl-auto=validate` (not `none`) matter - what does `validate` still actively DO, even though it never modifies the schema?
- Why does the `V1`, `V2`, `V3` NUMBERING matter so much - what would happen if `V3__create_task_table.sql` (which references `project`) ran BEFORE `V2__create_project_table.sql`?
- Why is renaming `User`'s table to `"users"` (via `@Table`) a genuinely better long-term decision than leaving it as the Hibernate default, now that the schema is explicit and version-controlled?
