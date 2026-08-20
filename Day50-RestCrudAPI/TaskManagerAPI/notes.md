# Day 50 - Building a Full REST CRUD API

Fifty days - marking it with a complete, realistic Spring Boot API: a
Task Manager supporting Create, Read, Update, and Delete over HTTP.

## What I learned

### 1. Recap: Day 49 only covered GET
Today adds the other HTTP verbs - the full CRUD picture.

### 2. @RequestBody - receiving JSON as a Java object
```java
@PostMapping("/tasks")
public Task createTask(@RequestBody Task task) {
    // Spring automatically converts incoming JSON into a Task object
}
```
The REVERSE of Day 49's record-to-JSON - now JSON becomes a Java object.

### 3. The full set of mapping annotations
```java
@GetMapping     // read
@PostMapping    // create
@PutMapping     // update (replace)
@DeleteMapping  // delete
```

### 4. ResponseEntity - controlling status codes properly
```java
@GetMapping("/tasks/{id}")
public ResponseEntity<Task> getTask(@PathVariable int id) {
    Optional<Task> task = taskService.findById(id); // Day 38's Optional
    if (task.isPresent()) {
        return ResponseEntity.ok(task.get());       // 200 OK
    }
    return ResponseEntity.notFound().build();         // 404 Not Found
}
```
A plain return type always sends 200, even for "not found" - misleading
to API consumers. ResponseEntity fixes that.

### 5. Building the layers - Controller -> Service
```java
@RestController
@RequestMapping("/tasks") // shared prefix for ALL endpoints
public class TaskController { }

@Service
public class TaskService {
    // business logic lives HERE, not in the controller
}
```
Keeping the Controller thin (HTTP concerns only) and the Service focused
on logic is standard Spring architecture.

### 6. Testing with curl
Browsers can only easily send GET requests - curl handles the rest:
```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Learn Spring","completed":false}'
curl -X PUT http://localhost:8080/tasks/1 -H "Content-Type: application/json" -d '{"title":"Learn Spring Boot","completed":true}'
curl -X DELETE http://localhost:8080/tasks/1
curl http://localhost:8080/tasks
```

### 7. Validation basics
```java
if (task.getTitle() == null || task.getTitle().isBlank()) {
    return ResponseEntity.badRequest().build(); // 400 Bad Request
}
```

## How to actually run this and test the full CRUD flow

```bash
cd Day50-RestCrudAPI/TaskManagerAPI
mvn spring-boot:run
```

**In a SECOND terminal, walk through the full lifecycle:**

```bash
# CREATE a task
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Learn Spring Boot","completed":false}'

# READ all tasks
curl http://localhost:8080/tasks

# READ one task (use the id from the create response, likely 1)
curl http://localhost:8080/tasks/1

# UPDATE that task
curl -X PUT http://localhost:8080/tasks/1 -H "Content-Type: application/json" -d '{"title":"Learn Spring Boot","completed":true}'

# DELETE that task
curl -X DELETE http://localhost:8080/tasks/1

# Confirm it's gone (should return 404)
curl -i http://localhost:8080/tasks/1
```
(`-i` shows the response headers/status code, which is useful for
confirming 404 vs 200.)

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does `getAllTasks()` NOT need a `ResponseEntity` wrapper (it just returns `List<Task>` directly), while `getTask(id)` DOES need one?
- Why is data stored in-memory (`List<Task>` in `TaskService`) going to disappear every time the server restarts - what would fix that (hint: Day 45's JDBC, or tomorrow's topic)?
- Why does `@RequestMapping("/tasks")` on the CLASS combined with `@PostMapping` (no path) on a method result in the FULL path being just `/tasks`, not `/tasks/tasks`?
