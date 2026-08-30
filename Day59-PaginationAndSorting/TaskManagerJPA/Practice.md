# Day 59 - Practice Exercises: Pagination & Sorting

Try to solve these YOURSELF first, without looking at PageResponse.java,
the updated TaskController/TaskService/TaskRepository, or PaginationTest.java.

All require running the app and testing with curl, or writing MockMvc tests.

---

### Exercise 1: Paginate the Projects endpoint (Easy-Medium)
Add pagination to `GET /projects` the same way `GET /tasks` was updated -
add a `Pageable` parameter, return a `PageResponse<ProjectDTO>`. Test with
several projects created, using `?page=0&size=2`.

---

### Exercise 2: Multi-field sorting (Easy-Medium)
Test sorting by MULTIPLE fields at once:
```bash
curl -u admin:admin123 "http://localhost:8080/tasks?sort=completed,asc&sort=title,asc"
```
Confirm incomplete tasks (false) come before completed ones (true), and
within each group, tasks are alphabetically sorted by title.

---

### Exercise 3: A maximum page size guard (Medium)
Currently a client could request `?size=100000` and get everything
anyway, defeating the purpose of pagination. Add logic in
`TaskController.getAllTasks()` that caps the page size at 50, regardless
of what the client requests (hint: check `pageable.getPageSize()` and
build a new `PageRequest` if it exceeds the limit).

---

### Exercise 4: Search + pagination combined (Medium-Hard)
Add `Page<Task> findByTitleContainingIgnoreCase(String keyword, Pageable pageable)`
to `TaskRepository`. Add an endpoint `GET /tasks/search?keyword=...` that
accepts BOTH a search keyword AND pagination params together. Test
searching with a keyword that matches several tasks, paginated 2 at a time.

---

### Exercise 5: Write a test proving the max-page-size guard works (Harder)
Write a MockMvc test for Exercise 3's cap: request `?size=1000` and assert
that `$.content.length()` never exceeds 50, even if fewer than 50 tasks
actually exist that would make the assertion trivially pass - seed at
least 55 tasks in a `@BeforeEach` to make the test MEANINGFUL.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does listing `sort` TWICE in the query string (`sort=completed,asc&sort=title,asc`) work as MULTI-field sorting, rather than the second one just overriding the first?
- [ ] In Exercise 3, why is capping page size a genuine SECURITY/performance concern, not just a nitpick - what could an unbounded `size` parameter allow a malicious or careless client to do?
- [ ] In Exercise 4, why does combining a WHERE-style filter (title contains keyword) with pagination require the query method to accept BOTH the keyword AND the Pageable as separate parameters?
- [ ] Why does `PageResponse` deliberately NOT expose Spring's internal `Pageable`/`Sort` objects directly - what does this protect, echoing Day 54's DTO lesson?

If you're unsure on any of these, revisit `notes.md` before moving to Day 60.
