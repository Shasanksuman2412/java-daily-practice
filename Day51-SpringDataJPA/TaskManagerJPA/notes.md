# Day 51 - Spring Data JPA (Real Database Persistence)

Day 50 flagged it ourselves - tasks lived in an ArrayList and vanished on
restart. Today fixes that properly, the idiomatic Spring way - no manual
SQL like Day 45's JDBC, just annotations and an interface.

## What I learned

### 1. What is JPA / Hibernate?
JPA is a specification for mapping Java objects to database tables - an
ORM (Object-Relational Mapping). Hibernate is the actual implementation
Spring Boot uses. Annotations describe the data; Spring generates SQL.

### 2. @Entity - marking a class as a database table
```java
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private int id;

    private String title;
    private boolean completed;
}
```
No `CREATE TABLE` SQL - Hibernate reads these annotations and creates the
table automatically on startup.

### 3. JpaRepository - CRUD methods for free
```java
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // that's the WHOLE file - no implementation needed!
}
```
```java
taskRepository.save(task);
taskRepository.findById(1);   // Optional<Task> - Day 38!
taskRepository.findAll();
taskRepository.deleteById(1);
```
Compare to Day 45's JDBC, where every one of these needed hand-written SQL
and a PreparedStatement.

### 4. Custom queries - just name the method correctly
```java
List<Task> findByCompleted(boolean completed);
```
Spring parses the METHOD NAME and builds the SQL automatically - no SQL,
no annotations needed.

### 5. Updating the Service to use the repository
```java
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) { // Day 49's DI
        this.taskRepository = taskRepository;
    }
}
```

### 6. Configuring the database - application.properties
```properties
spring.datasource.url=jdbc:h2:file:./taskdb
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```
H2 - lightweight, file-based (similar spirit to Day 45's SQLite), data
genuinely persists between restarts.

### 7. The payoff
Restart the server, hit `GET /tasks` - the data is STILL THERE. That's
the entire point of today.

## How to actually run this and verify persistence

```bash
cd Day51-SpringDataJPA/TaskManagerJPA
mvn spring-boot:run
```

**In a second terminal, create some tasks:**
```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Learn JPA","completed":false}'
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title":"Build an API","completed":true}'
curl http://localhost:8080/tasks
```

**Now stop the server (Ctrl+C in the first terminal), then start it again:**
```bash
mvn spring-boot:run
```

**Check the tasks again:**
```bash
curl http://localhost:8080/tasks
```
Both tasks should STILL be there - proof the H2 file-based database
genuinely persisted the data across a full restart, unlike Day 50's
ArrayList version.

**Bonus: view the database visually**
Visit `http://localhost:8080/h2-console` in a browser. For the JDBC URL
field, enter exactly: `jdbc:h2:file:./taskdb` (matching application.properties),
username `sa`, blank password, then click Connect. Run `SELECT * FROM TASK;`
to see your data in a real table view.

## Commands I ran
```bash
mvn spring-boot:run
```

## Questions / things to revisit
- Why does `TaskRepository` have ZERO implementation code, yet `taskRepository.save(task)` genuinely works - what is Spring doing behind the scenes at startup?
- Why does `findByCompleted(boolean completed)` work with NO manual SQL, just from the method name - what would happen if you named it `getTasksWhereDone` instead?
- Why does `spring.jpa.hibernate.ddl-auto=update` matter - what would happen to your existing data if this were set to `create-drop` instead?
