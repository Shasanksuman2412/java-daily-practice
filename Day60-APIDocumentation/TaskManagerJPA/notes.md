# Day 60 - API Documentation with Swagger/OpenAPI

Sixty days - let's make the API self-documenting, with a live interactive
UI anyone can use to explore and test it.

## What I learned

### 1. Why this matters
Right now, the only way to know what endpoints exist is to read the
source code. Real APIs need documentation that's ALWAYS accurate -
generated from the code itself, not hand-written docs that go stale.

### 2. Adding springdoc-openapi - instant documentation
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```
Just this dependency, ZERO other code, generates a working interactive UI
at `/swagger-ui.html` - it scans every `@RestController` automatically.

### 3. Global API info - OpenApiConfig
```java
@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .info(new Info().title("Task Manager API").version("1.0")...);
}
```

### 4. Documenting the JWT security scheme
```java
.components(new Components().addSecuritySchemes("bearerAuth",
        new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")))
```
This is what makes the "Authorize" button appear in Swagger UI.

### 5. Enriching individual endpoints
```java
@Operation(summary = "Get a task by ID", description = "...")
@ApiResponses({
    @ApiResponse(responseCode = "200", description = "Task found"),
    @ApiResponse(responseCode = "404", description = "Task not found")
})
@GetMapping("/{id}")
public TaskDTO getTask(@PathVariable int id) { ... }
```

### 6. Grouping endpoints with @Tag
```java
@Tag(name = "Tasks", description = "Endpoints for managing tasks")
@RestController
public class TaskController { ... }
```

### 7. Opening the endpoint up in security config
```java
.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
```

### 8. Using it - the real payoff
Visit the UI, click Authorize, paste a JWT, and every "Try it out" call
is authenticated automatically - no more manually copying curl commands.

## How to actually use this

```bash
cd Day60-APIDocumentation/TaskManagerJPA
mvn spring-boot:run
```

**Open in a browser:**
```
http://localhost:8080/swagger-ui.html
```

You should see three groups: **Auth**, **Tasks**, **Projects** - each with
their endpoints, descriptions, and expected responses, all generated from
the annotations.

**Get a token first (still easiest via curl or Postman):**
```bash
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'
```
Copy the `token` value.

**In Swagger UI:**
1. Click the **Authorize** button (top right, with a lock icon)
2. Paste the token (just the raw token, Swagger adds "Bearer" automatically)
3. Click Authorize, then Close
4. Expand any endpoint (e.g. `POST /tasks`), click **Try it out**, fill in
   a sample request body, click **Execute**
5. You'll see the real HTTP response, status code, and headers - directly
   in the browser, no terminal needed

**View the raw machine-readable spec:**
```
http://localhost:8080/v3/api-docs
```
This is the JSON that Swagger UI itself is built from - the same spec
format tools like Postman can import directly.

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does adding just ONE dependency (with no extra Java code) already produce a working Swagger UI - what is springdoc actually scanning to build that page?
- Why does the "Authorize" button need the security SCHEME defined in `OpenApiConfig`, separate from Spring Security's OWN `SecurityConfig` rules - aren't these describing the same thing?
- Why is it useful for `/swagger-ui/**` to be `permitAll()`, while the actual task/project endpoints STILL enforce authentication when "tried out" from within that same UI?
