# Day 66 - Spring Boot Actuator (Monitoring & Observability)

Production apps need visibility into their own health and behavior -
today adds that with almost zero code.

## What I learned

### 1. What is Spring Boot Actuator?
Production-ready endpoints for monitoring and managing the app - health
status, metrics, environment info - all generated automatically.

### 2. Adding the dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
Just this - `/actuator/health` immediately becomes available.

### 3. /actuator/health - and it knows about our real database now
```json
{ "status": "UP" }
```
With `spring-boot-starter-data-jpa` and a real datasource (Day 64's
PostgreSQL) on the classpath, Actuator AUTOMATICALLY checks database
connectivity - no code needed.

### 4. Exposing more endpoints
```properties
management.endpoints.web.exposure.include=health,info,metrics
```
By default only `/health` is exposed over HTTP - others need explicit opt-in.

### 5. /actuator/info - custom build/app metadata
```properties
info.app.name=Task Manager API
info.app.description=...
```

### 6. /actuator/metrics - JVM and HTTP metrics for free
```
/actuator/metrics/jvm.memory.used
/actuator/metrics/http.server.requests
```

### 7. Securing Actuator - health public, everything else locked down
```java
.requestMatchers("/actuator/health").permitAll()
.requestMatchers("/actuator/**").hasRole("ADMIN")
```
```properties
management.endpoint.health.show-details=when-authorized
management.endpoint.health.roles=ADMIN
```
Public callers see just `{"status":"UP"}` - authenticated ADMINs see the
full breakdown (database connectivity, disk space, etc).

### 8. Connecting back to Day 61's Docker HEALTHCHECK exercise
```dockerfile
HEALTHCHECK --interval=30s --timeout=3s CMD wget -qO- http://localhost:8080/actuator/health || exit 1
```
Now genuinely meaningful - Docker can tell if the app is ACTUALLY ready
to serve traffic (including database connectivity), not just "the
process is running."

## How to actually run this and explore the endpoints

```bash
cd Day66-Actuator/TaskManagerJPA
docker compose up --build
```

**Public health check (no credentials needed):**
```bash
curl http://localhost:8080/actuator/health
```
Should show just `{"status":"UP"}`.

**Detailed health check (as ADMIN):**
```bash
TOKEN=$(curl -s -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}' | grep -o '"token":"[^"]*' | cut -d'"' -f4)
curl http://localhost:8080/actuator/health -H "Authorization: Bearer $TOKEN"
```
Now shows a full breakdown including `db: UP` (Postgres connectivity)
and `diskSpace: UP`.

**App info:**
```bash
curl http://localhost:8080/actuator/info -H "Authorization: Bearer $TOKEN"
```

**A specific metric:**
```bash
curl http://localhost:8080/actuator/metrics/jvm.memory.used -H "Authorization: Bearer $TOKEN"
```

**Confirm the Docker healthcheck is actually working:**
```bash
docker ps
```
Look at the STATUS column for the taskmanager container - it should show
`(healthy)` after the initial `--start-period` passes.

## Commands I ran
```bash
docker compose up --build
docker ps
```

## Questions / things to revisit
- Why does `/actuator/health` automatically report on database connectivity, even though we never wrote a single line of code checking it ourselves?
- Why does the health endpoint show DIFFERENT levels of detail depending on whether the caller is authenticated - what's the security reasoning behind hiding internals from anonymous callers?
- Why does the Docker `HEALTHCHECK` matter for something like Render's deployment (Day 63) - what decision might Render make differently based on a container reporting unhealthy vs healthy?
