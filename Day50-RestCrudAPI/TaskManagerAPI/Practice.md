# Day 50 - Practice Exercises: REST CRUD API

Try to solve these YOURSELF first, without looking at Task.java,
TaskService.java, TaskController.java, or Solutions files.

All require running the app and testing with curl (or a tool like Postman
if you have it installed).

---

### Exercise 1: Add a priority field (Easy-Medium)
Add a `String priority` field to `Task` (with getter/setter). Update the
POST endpoint to accept it. Create a task with a priority via curl and
confirm it comes back correctly in GET requests.

---

### Exercise 2: Filter tasks by completion status (Easy-Medium)
Add an endpoint `GET /tasks/completed` that returns only tasks where
`completed == true`, using a stream `.filter()` (Day 19) in `TaskService`.
Test with a mix of completed and incomplete tasks.

---

### Exercise 3: Count endpoint (Medium)
Add `GET /tasks/count` that returns just the total number of tasks as a
plain integer (not wrapped in JSON object, just the number itself).

---

### Exercise 4: Partial update with PATCH (Medium-Hard)
Add a `@PatchMapping("/tasks/{id}/complete")` endpoint that marks a task
as completed WITHOUT requiring the full Task object in the request body
(unlike PUT, which replaces everything). Test with:
```bash
curl -X PATCH http://localhost:8080/tasks/1/complete
```

---

### Exercise 5: Proper error handling for invalid input (Harder)
Currently, POSTing invalid JSON (like missing quotes) causes Spring to
return a generic 400 error page. Add a
`@ExceptionHandler(HttpMessageNotReadableException.class)` method to
`TaskController` that returns a friendlier custom error message instead.
(Look up `@ExceptionHandler` if unfamiliar - it lets you customize how a
controller responds to specific exception types.)

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 4, why is PATCH considered semantically different from PUT - what's the actual REST convention distinction between "replace everything" vs "update part of it"?
- [ ] In Exercise 2, why does filtering happen in `TaskService` (not directly in the controller) - what's the architectural reason for keeping that logic out of `TaskController`?
- [ ] Why does Exercise 3's endpoint returning a plain `int` still work correctly as an HTTP response, even though it's not JSON in the traditional `{...}` sense?
- [ ] In Exercise 5, why might a REAL production API want CUSTOM error responses instead of Spring's default error page - think about what a mobile app or frontend consuming this API would need to parse reliably?

If you're unsure on any of these, revisit `notes.md` before moving to Day 51.
