# ---- Stage 1: build the app with Maven ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# ---- Stage 2: run it with just a lightweight JRE, no Maven needed ----
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# wget is needed for the HEALTHCHECK below - alpine images are minimal
# and don't include it by default
RUN apk add --no-cache wget

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# New today: a REAL healthcheck, backed by Day 66's Actuator endpoint.
# Docker (and cloud platforms reading this same signal) can now tell
# whether the app is ACTUALLY ready to serve traffic, not just "the
# process is running" - the app could be up but still failing to connect
# to Postgres, for example, and this would correctly report unhealthy.
HEALTHCHECK --interval=30s --timeout=3s --start-period=20s --retries=3 \
    CMD wget -qO- http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
