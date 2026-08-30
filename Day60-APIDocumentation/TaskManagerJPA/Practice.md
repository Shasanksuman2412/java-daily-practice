# Day 60 - Practice Exercises: API Documentation

Try to solve these YOURSELF first, without looking at OpenApiConfig.java
or the annotated TaskController/AuthController/ProjectController.

All require running the app and using the Swagger UI in a browser.

---

### Exercise 1: Document the remaining ProjectController endpoints (Easy-Medium)
Add `@Operation` annotations to `getProject`, `createProject`,
`deleteProject`, and `getProjectTasks` in `ProjectController` - one clear
`summary` each. Reload Swagger UI and confirm the descriptions appear.

---

### Exercise 2: Document a request body example (Easy-Medium)
Look up `@io.swagger.v3.oas.annotations.media.Schema` and add an
`example` value to `CreateTaskRequest.title` so Swagger UI pre-fills a
sample value in the "Try it out" text box instead of showing an empty
string.

---

### Exercise 3: Try out the full flow directly in the browser (Medium)
Using ONLY the Swagger UI (no curl at all): register a new user, log in,
copy the token, click Authorize, then create a project, add two tasks to
it, and delete one of them - all through the interactive UI.

---

### Exercise 4: Export and inspect the raw OpenAPI spec (Medium-Hard)
Visit `/v3/api-docs`, save the JSON response to a file, and open it in a
text editor. Find the section describing `POST /tasks` and identify: the
required request body schema, the possible response codes, and the
security requirement. Explain in a comment how this JSON maps to what you
SEE rendered in the Swagger UI page.

---

### Exercise 5: Group and hide an endpoint (Harder)
Look up `@Hidden` (from `io.swagger.v3.oas.annotations`) and apply it to
one endpoint you don't want documented (e.g., a debug-only route if you
have one, or temporarily hide `/tasks/completed`). Confirm it disappears
from Swagger UI but still WORKS when called directly via curl - proving
`@Hidden` only affects documentation visibility, not actual behavior.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does adding an `example` value only affect the DOCUMENTATION/UI experience, not the actual validation rules already defined by `@NotBlank`?
- [ ] In Exercise 4, why is the OpenAPI spec described as "machine-readable" - what OTHER tools (besides Swagger UI) might be able to consume that same JSON file usefully?
- [ ] In Exercise 5, why does `@Hidden` NOT provide any actual security - what would you need to add ADDITIONALLY if you wanted that endpoint to be truly inaccessible, not just undocumented?
- [ ] Looking back at the full 12-day Spring Boot arc (Days 49-60): which single day's addition do you think made the API feel most "real" or production-ready to you personally, and why?

If you're unsure on any of these, revisit `notes.md`.

## Sixty days, twelve of them building one real API
Day 49 was a single `/hello` endpoint. Day 60 is a secured, tested,
paginated, database-backed, self-documenting REST API with proper
architecture (entities, DTOs, services, controllers, exception handling).
That's what daily, incremental practice compounds into.
