# Day 64 - Migrating to PostgreSQL

Directly fixing yesterday's honest caveat - swapping H2's ephemeral file
storage for a real, persistent, production-grade database.

## What I learned

### 1. Why PostgreSQL?
H2 is great for learning, but not what real production systems use.
PostgreSQL is genuine, battle-tested, and most cloud platforms (including
Render) offer MANAGED PostgreSQL - persistence, backups, and scaling
handled for you.

### 2. Adding the PostgreSQL driver
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
H2 moves to TEST-ONLY scope - still perfect for fast in-memory tests
(Day 58), no longer used by the real running app.

### 3. Environment-variable-driven connection config
```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:taskdb}
spring.datasource.username=${DB_USER:taskuser}
spring.datasource.password=${DB_PASSWORD:taskpass}
```
Same pattern as Day 63's `$PORT` - sensible local defaults, fully
overridable via environment variables in production.

### 4. Running PostgreSQL locally with Docker Compose
```yaml
services:
  postgres:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: taskdb
      POSTGRES_USER: taskuser
      POSTGRES_PASSWORD: taskpass
    volumes:
      - pgdata:/var/lib/postgresql/data
  taskmanager:
    depends_on:
      - postgres
    environment:
      - DB_HOST=postgres
```

### 5. Hibernate auto-detects the database dialect
No extra configuration needed - Hibernate reads the JDBC URL
(`jdbc:postgresql://...`) and generates PostgreSQL-flavored SQL
automatically, including for `ddl-auto=update`.

### 6. Deploying with a real managed database on Render
```yaml
databases:
  - name: task-manager-db
    plan: free
```
`render.yaml`'s `fromDatabase` wires connection details in automatically
- no manual copy-pasting of credentials.

### 7. An honest note about tests
Tests still run against in-memory H2, not real Postgres - fast and
simple, but not a PERFECT match for production behavior. Real teams often
use Testcontainers for full parity when it genuinely matters - a good
future topic, not required today.

## How to actually run this locally with Docker Compose

```bash
cd Day64-PostgreSQL/TaskManagerJPA
docker compose up --build
```
Notice TWO containers start now (postgres AND taskmanager), not just one
like Day 61. Test exactly as before:
```bash
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'
```

**Prove it's REAL persistence now:**
```bash
docker compose down    # stops and removes containers
docker compose up      # fresh containers, but...
```
Log in as admin - still works, because data lives in the NAMED VOLUME
(`pgdata`), completely independent of the containers themselves.

**Peek inside the real database (optional, if you have `psql` or a GUI tool):**
```bash
docker exec -it <container-name> psql -U taskuser -d taskdb -c "SELECT * FROM users;"
```

## How to update your existing Render deployment

If you deployed on Day 63:
1. Push today's code (with the Postgres changes) to GitHub
2. In Render, either update your existing service's Blueprint to match
   the new `render.yaml` (adds a database automatically), OR delete the
   old service and redeploy fresh using "New +" -> "Blueprint" pointing at
   this repo, which will read `render.yaml` and provision BOTH the web
   service AND the database together
3. Confirm: register a user, redeploy (push a trivial change), and this
   time confirm the user SURVIVES the redeploy - the exact opposite of
   Day 63's Exercise 4 result

## Commands I ran
```bash
docker compose up --build
```

## Questions / things to revisit
- Why does moving `h2` to `<scope>test</scope>` in `pom.xml` NOT break anything - which parts of the app still legitimately need it, and which no longer do?
- Why does `docker compose down` followed by `docker compose up` now preserve data, when the SAME commands on Day 61's H2-only setup would have too (with its volume) - what's actually different between the two approaches' risk profiles?
- Why does a MANAGED database (Render's `databases:` section) matter more for a real deployment than just running Postgres in a container yourself - what operational work does "managed" take off your plate?
