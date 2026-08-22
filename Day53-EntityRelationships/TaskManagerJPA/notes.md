# Day 53 - Entity Relationships (@OneToMany / @ManyToOne)

Every real application has related tables - today adds a Project that
owns many Tasks, the most common relationship pattern in JPA.

## What I learned

### 1. The relationship being built
One `Project` has many `Task`s. Each `Task` belongs to exactly one
`Project`. In database terms: `Task` gets a foreign key column pointing
back to its Project.

### 2. The "many" side - @ManyToOne
```java
@Entity
public class Task {
    @ManyToOne
    @JoinColumn(name = "project_id") // the actual foreign key column
    @JsonBackReference // prevents infinite JSON recursion
    private Project project;
}
```

### 3. The "one" side - @OneToMany
```java
@Entity
public class Project {
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>();
}
```
`mappedBy = "project"` tells JPA that `Task.project` is what actually owns
this relationship in the database - this side is just the Java-level
convenience view.

### 4. The infinite loop problem - and its fix
Without help, serializing a Project would include its tasks, and each
task would include its project, which includes its tasks again - forever.
```java
@JsonManagedReference  // forward direction - INCLUDE in JSON
@JsonBackReference      // back direction - OMIT from JSON
```
This breaks the cycle.

### 5. cascade = CascadeType.ALL - operations flow through
```java
projectRepository.save(project);   // ALSO saves new Tasks attached to it
projectRepository.delete(project); // ALSO deletes its Tasks
```
Without cascade, each Task would need saving/deleting manually and
separately.

### 6. Creating a task under a specific project
```java
@PostMapping("/projects/{projectId}/tasks")
public Task addTaskToProject(@PathVariable int projectId, @Valid @RequestBody Task task) {
    Project project = projectService.findById(projectId); // throws if missing
    task.setProject(project);
    return taskService.addTask(task);
}
```

### 7. Fetching a project's tasks
```java
@GetMapping("/projects/{id}/tasks")
public List<Task> getProjectTasks(@PathVariable int id) {
    return projectService.findById(id).getTasks();
}
```

## How to actually run this and test the relationship

```bash
cd Day53-EntityRelationships/TaskManagerJPA
mvn spring-boot:run
```

**Create a project:**
```bash
curl -X POST http://localhost:8080/projects -H "Content-Type: application/json" -d '{"name":"Learn Spring Boot"}'
```
Note the `id` returned (likely 1).

**Add tasks to that project:**
```bash
curl -X POST http://localhost:8080/projects/1/tasks -H "Content-Type: application/json" -d '{"title":"Learn JPA relationships","completed":false}'
curl -X POST http://localhost:8080/projects/1/tasks -H "Content-Type: application/json" -d '{"title":"Test the API","completed":false}'
```

**Fetch the project with all its tasks included:**
```bash
curl http://localhost:8080/projects/1
```
You should see the project's JSON with a `tasks` array containing BOTH
tasks - notice the tasks do NOT loop back and re-include the project
(thanks to `@JsonBackReference`).

**Fetch just the tasks list for that project:**
```bash
curl http://localhost:8080/projects/1/tasks
```

**Delete the project and confirm its tasks are gone too (cascade):**
```bash
curl -X DELETE http://localhost:8080/projects/1
curl -i http://localhost:8080/tasks/1
```
That last call should return 404 - the task was cascade-deleted along
with its parent project.

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does `@JsonManagedReference` go on `Project.tasks` but `@JsonBackReference` goes on `Task.project` - what determines which side gets which annotation?
- Why does `mappedBy = "project"` reference the FIELD NAME in `Task`, not a column name or table name?
- What would happen if you deleted a Task directly (not through its Project) - would the Project still show the correct remaining tasks afterward?
