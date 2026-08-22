# Day 54 - DTOs (Data Transfer Objects)

Yesterday we patched an infinite-loop problem with @JsonManagedReference/
@JsonBackReference - today we solve it properly, and stop exposing our
database entities directly to the outside world.

## What I learned

### 1. The problem with returning entities directly
```java
@GetMapping("/{id}")
public Task getTask(@PathVariable int id) { ... } // raw JPA entity leaks out
```
Leaks internal database structure into the API. Renaming a database
column breaks the API. Forces awkward workarounds (yesterday's Jackson
annotations) just to control serialization.

### 2. The DTO pattern - a separate shape just for the API
```java
public record TaskDTO(int id, String title, boolean completed, int projectId) {
}
```
The API returns THIS, not the entity - completely decoupled.

### 3. Mapping between entity and DTO
```java
public static TaskDTO toDTO(Task task) {
    int projectId = task.getProject() != null ? task.getProject().getId() : 0;
    return new TaskDTO(task.getId(), task.getTitle(), task.isCompleted(), projectId);
}
```
`Task.project` never gets serialized directly - no infinite loop risk,
no Jackson annotations needed on the entity anymore.

### 4. Separate request DTOs - controlling what clients can send
```java
public record CreateTaskRequest(
        @NotBlank(message = "Title is required") String title
) {
}
```
Clients can only send exactly the fields allowed - can't sneak in an `id`
or set `completed=true` on a brand new task.

### 5. Nested DTOs - a Project with its Tasks, cleanly
```java
public record ProjectDTO(int id, String name, int taskCount, List<TaskDTO> tasks) {
}
```
```java
List<TaskDTO> taskDTOs = project.getTasks().stream()
        .map(TaskMapper::toDTO)
        .collect(Collectors.toList());
```
No annotations, no cycle risk - TaskDTO simply has no "project" field.

### 6. The controller now speaks DTOs, not entities
```java
@GetMapping("/{id}")
public TaskDTO getTask(@PathVariable int id) {
    return TaskMapper.toDTO(taskService.findById(id));
}
```

### 7. Why this matters in real projects
- **Security** - never accidentally expose internal fields (like a
  password hash on a User entity)
- **Stability** - database refactors don't break API consumers
- **Clarity** - the API's actual shape is explicit, not just "whatever the
  entity happens to look like"

## How to actually run this and compare to Day 53

```bash
cd Day54-DTOs/TaskManagerJPA
mvn spring-boot:run
```

**Create a project and add tasks - notice request/response bodies now:**
```bash
curl -X POST http://localhost:8080/projects -H "Content-Type: application/json" -d '{"name":"Learn DTOs"}'
curl -X POST http://localhost:8080/projects/1/tasks -H "Content-Type: application/json" -d '{"title":"Understand mapping"}'
curl http://localhost:8080/projects/1
```

**Try sending extra fields the DTO doesn't accept:**
```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Sneaky task","completed":true,"id":999}'
curl http://localhost:8080/tasks
```
Notice the new task's `id` is server-assigned (NOT 999) and `completed`
is `false` regardless of what was sent - `CreateTaskRequest` simply
doesn't have those fields, so Jackson ignores them entirely.

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does sending `"completed":true` in a POST to `/tasks` get silently IGNORED, rather than causing an error - what does `CreateTaskRequest`'s structure guarantee?
- Compare Day 53's `Task.java` to today's - why could the `@JsonBackReference` annotation be safely removed entirely?
- Why does `ProjectController.getProjectTasks()` reuse `ProjectMapper.toDTO(...).tasks()` instead of writing separate mapping logic - what does this reveal about how DTOs let you REUSE mapping logic across endpoints?
