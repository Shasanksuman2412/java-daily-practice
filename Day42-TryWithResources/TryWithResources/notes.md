# Day 42 - try-with-resources & Custom AutoCloseable

We used try-with-resources with FileWriter/Scanner back on Day 18 - today
we build our OWN closeable resources.

## What I learned

### 1. Recap: what try-with-resources does
```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Hello");
} // writer.close() called AUTOMATICALLY, even if an exception occurs
```

### 2. The AutoCloseable interface
```java
public interface AutoCloseable {
    void close() throws Exception;
}
```
Just ONE method to implement - `close()`.

### 3. Building a custom AutoCloseable resource
```java
public class DatabaseConnection implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Closing connection"); // cleanup logic here
    }
}
```
```java
try (DatabaseConnection conn = new DatabaseConnection("MainDB")) {
    conn.query("...");
} // close() called automatically, guaranteed
```

### 4. Multiple resources in one try-with-resources
```java
try (DatabaseConnection conn1 = new DatabaseConnection("DB1");
     DatabaseConnection conn2 = new DatabaseConnection("DB2")) {
    // ...
} // closed in REVERSE order: conn2 first, then conn1
```

### 5. Close still happens even when an exception is thrown
Even if the try block throws, `close()` STILL runs before the exception
propagates up to the catch block.

### 6. Suppressed exceptions
If BOTH the try block AND `close()` throw exceptions, the try block's
exception is the "main" one, and the close() exception gets attached as a
SUPPRESSED exception (not lost, just secondary):
```java
for (Throwable suppressed : e.getSuppressed()) {
    // access exceptions that happened during close() but got "suppressed"
}
```

### 7. Why build custom AutoCloseable resources?
Anything needing GUARANTEED cleanup - network connections, file handles,
locks, thread pools - benefits from this instead of manually remembering
`close()` in a `finally` block (Day 15/18's older approach).

## Commands I ran
```bash
javac DatabaseConnection.java UnreliableResource.java TryWithResourcesDemo.java
java TryWithResourcesDemo
```

## Questions / things to revisit
- Why does the SECOND resource in a multi-resource try-with-resources block get closed FIRST (reverse order) - what problem does this ordering avoid?
- Why doesn't the "main" exception from the try block get REPLACED by the exception thrown during close() - why is one "suppressed" instead of just being lost or overriding the other?
- Why is `close()` allowed to declare `throws Exception` in the interface, but our `DatabaseConnection.close()` doesn't declare any exception at all - is that allowed?
