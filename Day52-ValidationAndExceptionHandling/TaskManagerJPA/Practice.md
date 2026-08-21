# Day 52 - Practice Exercises: Bean Validation & Global Exception Handling

Try to solve these YOURSELF first, without looking at Task.java,
TaskNotFoundException.java, GlobalExceptionHandler.java,
ErrorResponse.java, or the updated Service/Controller files.

All require running the app and testing with curl.

---

### Exercise 1: Add more validation rules (Easy-Medium)
Add a `int priority` field to `Task` with `@Min(1)` and `@Max(5)`
(look up `jakarta.validation.constraints.Min`/`Max`). Test creating a task
with priority 10 (should fail with 400) and priority 3 (should succeed).

---

### Exercise 2: A custom exception for invalid operations (Easy-Medium)
Create `TaskAlreadyCompletedException extends RuntimeException`. In
`TaskService`, add a method `completeTask(int id)` that throws this
exception if the task is ALREADY completed, otherwise marks it complete.
Add a handler for it in `GlobalExceptionHandler` returning a 409 Conflict
status (`HttpStatus.CONFLICT`).

---

### Exercise 3: Return ALL validation errors, not just the first (Medium)
Currently `handleValidation()` only returns the FIRST error message.
Modify it to collect ALL field errors into a `List<String>` and return
them together (you'll need a different `ErrorResponse` shape, or a new
record with a `List<String> messages` field). Test with a request that
fails validation in MULTIPLE ways at once.

---

### Exercise 4: A 400 handler for malformed JSON (Medium-Hard)
Add a handler for `HttpMessageNotReadableException` (from Day 50's
Exercise 5!) to `GlobalExceptionHandler`, returning a friendly
`ErrorResponse` instead of Spring's default error page. Test by sending
deliberately broken JSON (like missing a closing brace).

---

### Exercise 5: Trace the full exception flow (Harder - conceptual)
Add a `System.out.println()` at the START of each method in
`GlobalExceptionHandler`. Trigger each type of error (validation failure,
not found, malformed JSON) and watch the console output. Write a short
comment explaining, in your own words, the FULL path an error takes: from
where it's thrown, to where Spring catches it, to which handler method
runs, to what the client actually receives.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does using a CUSTOM exception (rather than reusing `TaskNotFoundException`) make the error more meaningful to API consumers?
- [ ] In Exercise 3, why does returning ALL validation errors at once (rather than just the first) matter for a real frontend form with multiple fields?
- [ ] Why does `GlobalExceptionHandler` need a method for EACH distinct exception type, rather than one generic method catching everything?
- [ ] Looking at Exercise 5's trace: why does the ORDER matter - specifically, why must `@Valid` validation fail and throw BEFORE your controller method body ever executes?

If you're unsure on any of these, revisit `notes.md` before moving to Day 53.
