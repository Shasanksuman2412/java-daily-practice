# Day 52 - Bean Validation & Global Exception Handling

We've been manually checking `if (title == null...)` and repeating similar
404 logic everywhere - today makes both concerns clean, consistent, and
centralized across the WHOLE API.

## What I learned

### 1. The problem with manual validation
```java
if (task.getTitle() == null || task.getTitle().isBlank()) {
    return ResponseEntity.badRequest().build();
}
```
Scales badly - every field, every endpoint needs its own check. Also
gives the API consumer ZERO information about what went wrong.

### 2. Bean Validation - annotate the field, not the logic
```java
@NotBlank(message = "Title is required")
@Size(max = 100, message = "Title must be under 100 characters")
private String title;
```

### 3. @Valid - triggering validation in the controller
```java
@PostMapping
public Task createTask(@Valid @RequestBody Task task) {
    return taskService.addTask(task);
}
```
If validation fails, Spring throws `MethodArgumentNotValidException`
AUTOMATICALLY - before the method body even runs.

### 4. A custom exception for "not found"
```java
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(int id) {
        super("Task not found with id: " + id);
    }
}
```
```java
taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id)); // Day 38!
```

### 5. @RestControllerAdvice - ONE place for the WHOLE API
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(TaskNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(404, e.getMessage()));
    }
}
```
Applies across EVERY controller in the app - not repeated per-controller
like Day 50's Exercise 5.

### 6. A consistent error response shape
```java
public record ErrorResponse(int status, String message) {
} // Day 35's records
```
Every error from every endpoint comes back looking the same.

### 7. Why centralizing matters
One consistent error format across the ENTIRE application, changed in ONE
place - instead of every controller repeating its own error logic.

## How to actually run this and see both features in action

```bash
cd Day52-ValidationAndExceptionHandling/TaskManagerJPA
mvn spring-boot:run
```

**Test validation failing (empty title):**
```bash
curl -i -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"","completed":false}'
```
Should return `400` with a JSON body like `{"status":400,"message":"Title is required"}`.

**Test validation passing:**
```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Learn validation","completed":false}'
```
Should succeed and return the created task.

**Test the custom 404:**
```bash
curl -i http://localhost:8080/tasks/999
```
Should return `404` with `{"status":404,"message":"Task not found with id: 999"}`
instead of a bare, unhelpful 404.

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does `@Valid` need to be paired with `@RequestBody` specifically - what would happen if `@Valid` were used without it?
- Why does `TaskNotFoundException` extend `RuntimeException` (unchecked, Day 15) rather than a checked `Exception` - what would break in the controller if it were checked?
- Why does `@RestControllerAdvice` apply to EVERY controller automatically, without needing to import or reference `GlobalExceptionHandler` anywhere in `TaskController`?
