# Day 58 - Testing Spring Boot Applications

We built a real, secured, persisted API since Day 49 - and haven't
written a single automated test for any of it since Day 40's plain JUnit.
Today properly tests all three layers: Service, Repository, and Controller.

## What I learned

### 1. Why Spring Boot testing is different from Day 40
Plain JUnit tests a class in isolation. `TaskService` depends on
`TaskRepository`, which depends on a real database, which the controller
depends on for HTTP handling. Spring gives dedicated tools for each layer.

### 2. Unit testing a Service - Mockito, no real database
```java
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository; // a FAKE repository

    @InjectMocks
    private TaskService taskService; // gets the mock injected automatically

    @Test
    void findByIdThrowsWhenTaskMissing() {
        when(taskRepository.findById(99)).thenReturn(Optional.empty());
        assertThrows(TaskNotFoundException.class, () -> taskService.findById(99));
    }
}
```
Fast - no Spring context loads at all, no database touched.

### 3. Testing the Repository layer - @DataJpaTest
```java
@DataJpaTest // spins up a REAL (in-memory) database, just for this class
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;
}
```
Exercises REAL SQL - verifying custom query methods (Day 51's
`findByCompleted`) genuinely work, not just that the mock returns what
you told it to.

### 4. Full integration testing - @SpringBootTest + MockMvc
```java
@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc; // simulates real HTTP requests, no real server started

    @Test
    @WithMockUser(roles = "ADMIN") // fakes an authenticated ADMIN for this test
    void createTaskReturns200() throws Exception {
        mockMvc.perform(post("/tasks")...)
            .andExpect(status().isOk());
    }
}
```

### 5. Testing security rules directly
```java
mockMvc.perform(get("/tasks")).andExpect(status().isUnauthorized()); // no auth at all

@WithMockUser(roles = "USER")
// ...POST request...  .andExpect(status().isForbidden()); // wrong role
```
Proves Day 55-57's security rules actually work, automatically, every
time - no manual curl testing needed.

### 6. Testing validation failures
```java
mockMvc.perform(post("/tasks")...content("{\"title\":\"\"}"))
    .andExpect(status().isBadRequest());
```

## Test files in this project

- `TaskServiceTest.java` - pure Mockito unit tests, no Spring context
- `TaskRepositoryTest.java` - `@DataJpaTest`, real SQL against in-memory H2
- `TaskControllerTest.java` - full `@SpringBootTest` + `MockMvc`, including security/validation
- `AuthControllerTest.java` - registration and login flow end to end
- `src/test/resources/application.properties` - a SEPARATE in-memory
  database just for tests, so running tests never touches your real
  `taskdb` file

## How to actually run the tests

```bash
cd Day58-TestingSpringBoot/TaskManagerJPA
mvn test
```

You'll see a summary like:
```
Tests run: XX, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Try deliberately breaking something - e.g., comment out the `@NotBlank`
annotation on `Task.title` - then rerun `mvn test` and watch
`createTaskWithBlankTitleReturnsBadRequest` FAIL. This is exactly the
safety net tests are supposed to provide: catching regressions
automatically, before you ever manually curl the endpoint again.

## Commands I ran
```bash
mvn test
```

## Questions / things to revisit
- Why does `TaskServiceTest` run dramatically faster than `TaskControllerTest` - what's actually different about what each one loads/starts?
- Why does `@DataJpaTest` use its OWN separate in-memory database configuration, rather than testing against the exact same file-based `taskdb` used when running the app normally?
- Why does `@WithMockUser(roles = "USER")` let us test a 403 Forbidden scenario WITHOUT actually registering a real user or generating a real JWT - what is it faking exactly?
