# Day 53 - Practice Exercises: Entity Relationships

Try to solve these YOURSELF first, without looking at Project.java,
Task.java, ProjectService.java, ProjectController.java, or the updated
GlobalExceptionHandler.

All require running the app and testing with curl.

---

### Exercise 1: Move a task to a different project (Easy-Medium)
Add a method `moveTask(int taskId, int newProjectId)` to `ProjectService`
that finds the task, finds the new project, and reassigns
`task.setProject(newProject)`, saving the change. Add an endpoint
`PUT /tasks/{taskId}/move/{newProjectId}` for it. Test by creating 2
projects and moving a task between them.

---

### Exercise 2: Count tasks per project (Easy-Medium)
Add an endpoint `GET /projects/{id}/task-count` that returns just the
number of tasks in a project (`project.getTasks().size()`). Test with
projects containing different numbers of tasks.

---

### Exercise 3: Prevent deleting a project with incomplete tasks (Medium)
Create a `ProjectHasIncompleteTasksException`. In `deleteProject()`, check
if ANY task in the project has `completed == false` using a stream
(Day 19) - if so, throw the exception instead of deleting. Add a handler
for it in `GlobalExceptionHandler` returning 409 Conflict. Test with a
project that has an incomplete task (should fail) and one where all tasks
are complete (should succeed).

---

### Exercise 4: A second relationship - tags on tasks (Medium-Hard)
Create a `Tag` entity (`id`, `name`) with a `@ManyToMany` relationship to
`Task` (a task can have multiple tags, a tag can apply to multiple tasks).
Look up `@ManyToMany` and `@JoinTable` - this is a genuinely different
relationship type from today's one-to-many. Add basic endpoints to
create tags and attach them to tasks.

---

### Exercise 5: Verify cascade behavior in the H2 console (Harder - conceptual)
Create a project with 2 tasks. Open `http://localhost:8080/h2-console`
and run `SELECT * FROM TASK;` - confirm you can see the `PROJECT_ID`
foreign key column populated correctly. Then delete the project via the
API and re-run the same query - confirm the tasks are ACTUALLY gone from
the database, not just hidden from the API.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why does reassigning `task.setProject(newProject)` and calling `save()` work to "move" a task, without needing to touch either Project's `tasks` list directly?
- [ ] In Exercise 3, why does checking `getTasks()` with a stream filter work here, when `getTasks()` itself is populated automatically by JPA rather than manually maintained?
- [ ] In Exercise 4, what's the fundamental structural difference between `@OneToMany`/`@ManyToOne` (today's topic) and `@ManyToMany` - why does `@ManyToMany` need an extra JOIN TABLE in the database?
- [ ] In Exercise 5, why does confirming behavior directly in the H2 console (raw SQL) matter MORE than just trusting what the REST API returns?

If you're unsure on any of these, revisit `notes.md` before moving to Day 54.
