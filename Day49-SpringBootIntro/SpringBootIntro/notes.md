# Day 49 - Introduction to Spring Boot

A genuine shift - everything so far has been plain Java. Spring Boot is
the dominant framework for building real-world Java applications (web
APIs, enterprise systems), and it changes how code gets structured and
wired together.

## What I learned

### 1. What is Spring Boot, and why does it exist?
Plain Java requires manually wiring everything - creating objects,
passing dependencies, configuring servers. Spring Boot AUTOMATES most of
that:
- **Dependency Injection (DI)** - Spring creates and wires objects for you
- **Auto-configuration** - sensible defaults, minimal setup
- **Embedded server** - no separate server install; `mvn spring-boot:run` just works
- **Huge ecosystem** - database, security, testing all integrate cleanly

### 2. Creating a project - Spring Initializr
The standard way to start is start.spring.io, a web tool generating a
ready-to-go project. Today's `pom.xml` is already set up, skipping that
step.

### 3. The entry point - @SpringBootApplication
```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
ONE annotation enables auto-configuration, component scanning, and starts
an embedded web server.

### 4. Your first REST endpoint - @RestController
```java
@RestController
public class GreetingController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
```
Visit `http://localhost:8080/hello` after running - no `ServerSocket`, no
manual HTTP parsing (unlike Day 47) - Spring handles all of that.

### 5. Dependency Injection - the core idea
Instead of a class creating its own dependencies (`new SomeService()`),
Spring INJECTS them automatically:
```java
@Service
public class GreetingService {
    public String getGreeting(String name) { ... }
}
```
```java
public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService; // Spring provides this automatically
}
```

### 6. @PathVariable and @RequestParam
```java
@GetMapping("/greet/{name}")
public String greet(@PathVariable String name) { ... } // from the URL PATH

@GetMapping("/add")
public int add(@RequestParam int a, @RequestParam int b) { ... } // from the QUERY STRING
```

## How to actually run this

This needs Maven (same as Days 40, 45, 48).

```bash
cd Day49-SpringBootIntro/SpringBootIntro
mvn spring-boot:run
```
Maven downloads Spring Boot automatically and starts an embedded server on
port 8080. You'll see a lot of startup log output, ending with something
like "Started DemoApplication".

**Then, in a browser (or a NEW terminal with curl):**
```
http://localhost:8080/hello
http://localhost:8080/greet/Shasank
http://localhost:8080/add?a=5&b=3
```
Or from a terminal:
```bash
curl http://localhost:8080/hello
curl http://localhost:8080/greet/Shasank
curl "http://localhost:8080/add?a=5&b=3"
```

Press `Ctrl+C` in the terminal running the server to stop it.

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does `@RestController` mean you never need to manually write HTTP response code (status codes, headers) the way you might expect from Day 47's raw sockets?
- Why does Spring automatically know to give `GreetingController`'s constructor a `GreetingService` instance - what's actually scanning for the `@Service` annotation and connecting the two?
- What's the practical difference between `@PathVariable` (`/greet/Shasank`) and `@RequestParam` (`/add?a=5&b=3`) - when would you reach for each in a real API design?
