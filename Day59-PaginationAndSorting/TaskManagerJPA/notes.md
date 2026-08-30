# Day 59 - Pagination & Sorting

`GET /tasks` returns EVERY task at once - fine with 5 tasks, a real
problem with 50,000. Today adds proper pagination and sorting, the Spring
Data way.

## What I learned

### 1. The problem
```java
List<Task> getAllTasks() {
    return taskRepository.findAll(); // loads EVERYTHING into memory, every time
}
```
No real API does this at scale.

### 2. Pageable and Page<T> - built into JpaRepository
```java
Page<Task> findAll(Pageable pageable); // ALREADY inherited, no code needed!
```

### 3. Accepting pagination params in the controller
```java
@GetMapping
public Page<Task> getAllTasks(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
    return taskRepository.findAll(pageable);
}
```
Spring automatically parses `?page=0&size=5&sort=title,desc` into a
`Pageable` object - no manual parsing at all.

### 4. What's inside a Page<T>
```java
page.getContent();       // the actual List<T> for this page
page.getTotalElements(); // total count across ALL pages
page.getTotalPages();
page.getNumber();        // current page index (0-based)
```

### 5. Mapping a Page<Task> to a Page<TaskDTO>
```java
Page<Task> taskPage = taskRepository.findAll(pageable);
Page<TaskDTO> dtoPage = taskPage.map(TaskMapper::toDTO); // same idea as Day 19's stream .map()
```

### 6. A cleaner custom response shape
Spring's raw Page JSON is verbose (pageable, sort, first, empty, etc).
```java
public record PageResponse<T>(List<T> content, int currentPage, int totalItems, int totalPages) {
    public static <T> PageResponse<T> from(Page<T> page) { ... }
}
```

### 7. Combining pagination with a custom query
```java
Page<Task> findByCompleted(boolean completed, Pageable pageable); // Day 51's naming convention, now paginated
```

### 8. Testing with curl
```bash
curl "http://localhost:8080/tasks?page=0&size=2" -u admin:admin123
curl "http://localhost:8080/tasks?page=0&size=2&sort=title,desc" -u admin:admin123
```

## How to actually run this and see pagination in action

```bash
cd Day59-PaginationAndSorting/TaskManagerJPA
mvn spring-boot:run
```

**Create several tasks first (repeat with different titles):**
```bash
curl -X POST http://localhost:8080/tasks -u admin:admin123 -H "Content-Type: application/json" -d '{"title":"Task Charlie"}'
curl -X POST http://localhost:8080/tasks -u admin:admin123 -H "Content-Type: application/json" -d '{"title":"Task Alpha"}'
curl -X POST http://localhost:8080/tasks -u admin:admin123 -H "Content-Type: application/json" -d '{"title":"Task Bravo"}'
```

**Get the default page (sorted by title, size 10):**
```bash
curl -u admin:admin123 http://localhost:8080/tasks
```

**Get a smaller page:**
```bash
curl -u admin:admin123 "http://localhost:8080/tasks?size=2"
```

**Get page 2:**
```bash
curl -u admin:admin123 "http://localhost:8080/tasks?page=1&size=2"
```

**Sort descending:**
```bash
curl -u admin:admin123 "http://localhost:8080/tasks?sort=title,desc"
```

**Run the automated pagination tests:**
```bash
mvn test -Dtest=PaginationTest
```

## Commands I ran
```bash
mvn spring-boot:run
mvn test
```

## Questions / things to revisit
- Why does `TaskRepository` need ZERO extra code to support `findAll(Pageable)`, when a paginated `findByCompleted` DID need an explicit method declaration?
- Why does `PageResponse.from(page)` use a generic type `<T>`, rather than being written specifically for `TaskDTO` - what does this let you reuse it for?
- Why does `?page=1` mean the SECOND page, not the first - what would happen if you requested `?page=-1` or a page number far beyond the actual data?
