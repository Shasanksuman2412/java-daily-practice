# ---- Stage 1: build the app with Maven ----
# Uses a full Maven + JDK image, which is large, but we DISCARD this
# entire stage afterward - only the final .jar survives into Stage 2.
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy just the pom.xml FIRST, and download dependencies before copying
# source code. Docker caches each instruction as a separate "layer" - as
# long as pom.xml doesn't change, this dependency-download layer is
# REUSED on future builds, even if your Java code changes constantly.
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# ---- Stage 2: run it with just a lightweight JRE, no Maven needed ----
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Only copy the FINISHED jar from Stage 1 - none of the Maven cache,
# source code, or build tools make it into this final, much smaller image.
COPY --from=build /app/target/*.jar app.jar

# Create the folder our H2 database file will be written into (see
# application.properties) - this is what gets mounted as a volume.
RUN mkdir -p /app/data

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
