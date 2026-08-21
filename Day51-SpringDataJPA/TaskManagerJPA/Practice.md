# Day 51 - Practice Exercises: Spring Data JPA

Try to solve these YOURSELF first, without looking at Task.java,
TaskRepository.java, TaskService.java, TaskController.java, or Solutions.

All require running the app and testing with curl, and RESTARTING the
server at least once to verify persistence.

---

### Exercise 1: Add a priority field with persistence (Easy-Medium)
Add a `String priority` field to the `Task` entity (getter/setter). Create
a task with a priority via curl, restart the server, and confirm the
priority value is still there when you GET it again.

---

### Exercise 2: A custom query method by title (Easy-Medium)
Add `List<Task> findByTitleContaining(String keyword)` to `TaskRepository`
(Spring Data supports this naming pattern too - no SQL needed). Add an
endpoint `GET /tasks/search?keyword=...` that uses it. Test searching for
a partial title match.

---

### Exercise 3: Count query using Spring Data naming (Medium)
Add `long countByCompleted(boolean completed)` to `TaskRepository`. Add an
endpoint `GET /tasks/stats` that returns a String like
`"3 completed, 5 pending"` using this method twice (once with true, once
with false).

---

### Exercise 4: Sorting results (Medium-Hard)
Look up `JpaRepository`'s built-in `findAll(Sort sort)` method. Add an
endpoint `GET /tasks/sorted` that returns all tasks sorted alphabetically
by title using `Sort.by("title")`.

---

### Exercise 5: Verify the H2 console shows real data (Harder - conceptual)
After creating several tasks via curl, open `http://localhost:8080/h2-console`
in a browser, connect using the JDBC URL from `application.properties`,
and run `SELECT * FROM TASK;` directly in SQL. Compare what you see there
to what `GET /tasks` returns - confirm they match exactly, proving the
REST API and the raw database are showing the SAME underlying data.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does Spring understand `findByTitleContaining` specifically as "SQL LIKE %keyword%" - what's the naming CONVENTION being parsed here?
- [ ] In Exercise 3, why is `countByCompleted` more efficient than calling `findByCompleted(...).size()` - what's the difference in what SQL actually runs?
- [ ] Why does Exercise 5 prove something meaningful - what would it mean if the H2 console showed DIFFERENT data than the REST API?
- [ ] If two people ran this same Day 51 project's `mvn spring-boot:run` from two DIFFERENT folders on their own computers, would they see each other's tasks? Why or why not, given the `taskdb` file's location?

If you're unsure on any of these, revisit `notes.md` before moving to Day 52.
