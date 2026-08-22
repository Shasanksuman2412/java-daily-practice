# Day 54 - Practice Exercises: DTOs

Try to solve these YOURSELF first, without looking at TaskDTO.java,
ProjectDTO.java, TaskMapper.java, ProjectMapper.java, or the updated
controllers.

All require running the app and testing with curl.

---

### Exercise 1: Add a summary DTO (Easy-Medium)
Create a `ProjectSummaryDTO(int id, String name, int taskCount)` - like
`ProjectDTO` but WITHOUT the full nested task list (useful for a "list
all projects" view where you don't need every task's details). Add an
endpoint `GET /projects/summary` returning `List<ProjectSummaryDTO>`.

---

### Exercise 2: A DTO that hides completed tasks (Easy-Medium)
Add a method to `TaskMapper` (or a new mapper method) that converts a
`Project` to a `ProjectDTO` but only includes INCOMPLETE tasks in the
`tasks` list. Add an endpoint `GET /projects/{id}/pending` using it.

---

### Exercise 3: Validate that request DTOs actually protect fields (Medium)
Deliberately try to POST a task with a fake `projectId` field to see if
it does anything:
```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Test","projectId":999}'
```
Confirm the field is silently ignored (since `CreateTaskRequest` has no
`projectId` field) and the task is created with NO project attached.
Write a comment explaining why this is actually a SAFETY feature, not a bug.

---

### Exercise 4: A PATCH-style partial update DTO (Medium-Hard)
Create `PatchTaskRequest(String title, Boolean completed)` where BOTH
fields are nullable (use the wrapper `Boolean`, not primitive `boolean`,
Day 29!) - meaning the client can send just ONE field to update, leaving
the other unspecified. Add a `PATCH /tasks/{id}` endpoint that only
updates fields that were actually provided (non-null).

---

### Exercise 5: Compare API stability - rename an entity field (Harder - conceptual)
Rename `Task.title` to `Task.taskTitle` throughout the entity, repository
query methods, and service - but DON'T change `TaskDTO`'s `title` field
name. Update `TaskMapper` to bridge the two names. Confirm the API's JSON
response STILL says `"title"` even though the database column changed.
Explain in a comment why this proves DTOs protect API consumers from
internal refactors.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 3, why does sending a `projectId` field in the request body get silently ignored rather than causing an error - what would need to change for the API to actually SUPPORT setting a project at creation time?
- [ ] In Exercise 4, why does `Boolean completed` (wrapper) matter here specifically - what would break if it were `boolean completed` (primitive) instead, given Day 29's autoboxing lessons?
- [ ] In Exercise 5, why does renaming an ENTITY field never break the API, as long as the DTO and mapper stay consistent?
- [ ] Why might a REAL production team maintain a `ProjectSummaryDTO` AND a full `ProjectDTO` as SEPARATE types, rather than just always returning the full one?

If you're unsure on any of these, revisit `notes.md` before moving to Day 55.
