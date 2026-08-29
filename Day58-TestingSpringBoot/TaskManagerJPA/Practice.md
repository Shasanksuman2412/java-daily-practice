# Day 58 - Practice Exercises: Testing Spring Boot Applications

Try to solve these YOURSELF first, without looking at TaskServiceTest.java,
TaskRepositoryTest.java, TaskControllerTest.java, or AuthControllerTest.java.

All require running `mvn test` to verify your work.

---

### Exercise 1: Unit test ProjectService with Mockito (Easy-Medium)
Write `ProjectServiceTest` using `@Mock`/`@InjectMocks` (like
`TaskServiceTest`). Test: `findById` throws `ProjectNotFoundException`
when missing, `addProject` saves and returns the project, `deleteProject`
throws when the project doesn't exist.

---

### Exercise 2: Repository test for Project (Easy-Medium)
Write `ProjectRepositoryTest` using `@DataJpaTest`. Test that saving a
project with tasks attached (via `project.getTasks().add(...)` and
`cascade = CascadeType.ALL` from Day 53) actually persists those tasks
too when the project is saved.

---

### Exercise 3: Test the full CRUD lifecycle for Projects (Medium)
Write a `ProjectControllerTest` using `@SpringBootTest` + `MockMvc`,
covering: creating a project (ADMIN), reading it back, adding a task to
it, and deleting it (confirming a 404 on the now-missing project
afterward). Use `@WithMockUser` appropriately for each step.

---

### Exercise 4: Test that a USER token really can't access ADMIN routes (Medium-Hard)
Instead of `@WithMockUser`, write a test that does the FULL real flow:
register a user via MockMvc, log in via MockMvc to get a real JWT from
the response body, then use that ACTUAL token in the `Authorization`
header of a POST request (hint: `.header("Authorization", "Bearer " + token)`).
Confirm it's still rejected with 403 - proving the REAL JWT flow enforces
the same rules as the `@WithMockUser` shortcut.

---

### Exercise 5: Achieve a specific test coverage goal (Harder - conceptual)
Look up how to run Maven with a coverage tool (e.g., add the JaCoCo
plugin to `pom.xml`, then run `mvn test jacoco:report`). Generate a
coverage report and open it in a browser. Identify ONE class or method
with LOW coverage, write a new test for it, and confirm coverage
improves on the next report.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why does testing `ProjectService` with mocks NOT actually prove the JPA cascade behavior works - what layer would you need to test differently (hint: Exercise 2) to verify that?
- [ ] In Exercise 4, why is testing with a REAL generated JWT more thorough than `@WithMockUser`, even though both ultimately test the same security rule?
- [ ] Why does a test suite passing 100% NOT guarantee a bug-free application - what KINDS of bugs would tests like these NOT catch?
- [ ] Looking back at this whole month of Spring Boot work (Days 49-58): which single day's topic do you think tests protect you from breaking MOST, if you came back and modified this project in 6 months?

If you're unsure on any of these, revisit `notes.md`.

Fifty-eight days in, and this project now has both a working feature set
AND an automated safety net protecting it - that combination is what
separates a demo from something genuinely maintainable.
