# Day 45 - JDBC (Java Database Connectivity)

Using SQLite - a lightweight, file-based database with no server setup
needed, perfect for learning JDBC without extra infrastructure.

## What I learned

### 1. What is JDBC?
An API letting Java programs talk to relational databases (MySQL,
PostgreSQL, SQLite, etc.) using SQL - the same core API works across
different databases, just swap the driver.

### 2. The core JDBC workflow
```java
try (Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db")) {
    // database work here
} catch (SQLException e) {
    System.out.println("Database error: " + e.getMessage());
}
```
`Connection` implements `AutoCloseable` (Day 42) - try-with-resources
closes it automatically.

### 3. Creating a table
```java
String createTable = """
        CREATE TABLE IF NOT EXISTS students (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            marks REAL
        )
        """; // text block from Day 39

try (Statement stmt = conn.createStatement()) {
    stmt.execute(createTable);
}
```

### 4. Inserting data - ALWAYS use PreparedStatement
```java
String sql = "INSERT INTO students (name, marks) VALUES (?, ?)";
try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, "Shasank");
    pstmt.setDouble(2, 85.5);
    pstmt.executeUpdate();
}
```
NEVER build SQL with string concatenation - that's a SQL injection risk.
`?` placeholders with PreparedStatement are always the safe way.

### 5. Reading data - ResultSet
```java
try (Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

    while (rs.next()) { // advances to next row, false when done
        int id = rs.getInt("id");
        String name = rs.getString("name");
    }
}
```

### 6. Updating and deleting
```java
String update = "UPDATE students SET marks = ? WHERE name = ?";
try (PreparedStatement pstmt = conn.prepareStatement(update)) {
    pstmt.setDouble(1, 90.0);
    pstmt.setString(2, "Shasank");
    int rowsAffected = pstmt.executeUpdate();
}
```

### 7. Handling SQLException
A CHECKED exception (Day 15) - every JDBC operation forces handling,
since database calls can fail many ways (connection lost, bad SQL,
constraint violations).

## How to actually run this

This needs Maven, since the SQLite JDBC driver isn't part of the core JDK.

```bash
mvn compile exec:java
```
Run this from inside the folder containing `pom.xml`. Maven downloads the
SQLite driver automatically, compiles, and runs `JDBCDemo`.

This creates a real file `students.db` in the same folder - open it with
a tool like "DB Browser for SQLite" (free, GUI) if you want to actually
SEE the table and data visually.

If Maven isn't set up yet, reading through `JDBCDemo.java` and
understanding the workflow (connect -> create table -> insert -> select
-> update -> delete, all wrapped in try-with-resources) is the main goal.

## Commands I ran
```bash
mvn compile exec:java
```

## Questions / things to revisit
- Why is `PreparedStatement` with `?` placeholders considered safe against SQL injection, while building SQL strings with `+` concatenation is dangerous?
- Why does `rs.next()` need to be called even BEFORE reading the first row - what would happen if you tried `rs.getString("name")` without calling `next()` first?
- Why does `Connection`, `Statement`, `PreparedStatement`, and `ResultSet` all implement `AutoCloseable` - what's the practical benefit of being able to try-with-resources ALL of them?
