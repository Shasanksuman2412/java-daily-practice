# Day 61 - Dockerizing the Spring Boot Application

We built and documented a real API - today we package it so it runs
IDENTICALLY on any machine with Docker installed, no manual Java/Maven
setup required at all.

## What I learned

### 1. Why Docker?
"Works on my machine" is a real problem - different JDK versions, missing
Maven, OS differences. A CONTAINER bundles the app with everything it
needs (JVM, dependencies, config) into one portable unit that runs the
same way everywhere.

### 2. The Dockerfile - a multi-stage build
```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```
Two stages: the BUILD stage needs the full Maven+JDK toolchain (large).
The FINAL image only needs a lightweight JRE to RUN the already-compiled
jar - everything else from stage 1 gets discarded, keeping the final
image small.

### 3. .dockerignore - don't copy unnecessary files into the build
Same idea as .gitignore (Day 3) - keeps the Docker build context small
and fast.

### 4. Building and running the image
```bash
docker build -t taskmanager-api .
docker run -p 8080:8080 taskmanager-api
```
`-p 8080:8080` maps the container's port to your machine's port.

### 5. Persisting the database outside the container
Containers are EPHEMERAL - stop the container, anything written inside it
(like the H2 file) is gone. A VOLUME maps a real folder to a folder
inside the container:
```bash
docker run -p 8080:8080 -v $(pwd)/data:/app/data taskmanager-api
```

### 6. docker-compose.yml - one command instead of long flags
```yaml
services:
  taskmanager:
    build: .
    ports:
      - "8080:8080"
    volumes:
      - ./data:/app/data
```
```bash
docker compose up --build
```

### 7. Environment variables - configuring without rebuilding
Real apps override secrets (like `jwt.secret`) via environment variables
at runtime, never hardcoded in `application.properties` for production.

## How to actually run this (requires Docker installed)

**Check Docker is installed:**
```bash
docker --version
```

**Option A - plain Docker commands:**
```bash
cd Day61-Docker/TaskManagerJPA
docker build -t taskmanager-api .
docker run -p 8080:8080 -v $(pwd)/data:/app/data -e JWT_SECRET=mysecret taskmanager-api
```

**Option B - docker-compose (recommended, matches the config file):**
```bash
cd Day61-Docker/TaskManagerJPA
docker compose up --build
```
Wait for the Spring Boot startup logs to appear, then test exactly as
before:
```bash
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'
```

**Prove persistence survives a container restart:**
```bash
docker compose down    # stops and removes the container
docker compose up      # starts a fresh container
```
Log in as admin again - the seeded account (and any tasks you created)
should still be there, because they live in `./data` on your REAL
machine, not inside the now-deleted container.

**Check what's actually in the image:**
```bash
docker images
docker history taskmanager-api
```

## Commands I ran
```bash
docker compose up --build
```

## Questions / things to revisit
- Why does the multi-stage Dockerfile copy `pom.xml` and run `mvn dependency:go-offline` BEFORE copying the actual source code - what does this ordering optimize for on REBUILDS?
- Why does data survive a `docker compose down` + `docker compose up` cycle, but would NOT survive if the volume mapping were removed from `docker-compose.yml`?
- Why is hardcoding `jwt.secret` directly in `application.properties` (like earlier days did) considered worse practice than reading it from an environment variable, especially once the app runs inside a container that might get shared or deployed?
