# Day 45 - Practice Exercises: JDBC

Try to solve these YOURSELF first, without looking at JDBCDemo.java or
Solutions.java.

Note: these all require Maven set up to actually run (see notes.md). If
you don't have it yet, write the code anyway - understanding the JDBC
workflow is the main goal.

---

### Exercise 1: Create a `books` table and insert records (Easy-Medium)
Create a table `books` with columns `id` (auto-increment primary key),
`title` (TEXT), `author` (TEXT), `year` (INTEGER). Insert 4 books using
`PreparedStatement`. Query and print all of them.

---

### Exercise 2: Query with a WHERE clause (Easy-Medium)
Write a method `findBooksByAuthor(Connection conn, String author)` that
uses a `PreparedStatement` with a `WHERE author = ?` clause, returning (or
printing) all matching books.

---

### Exercise 3: Count rows using an aggregate query (Medium)
Write a method `countBooks(Connection conn)` that runs
`SELECT COUNT(*) FROM books` and returns the count as an int. (Hint: the
result has ONE row, ONE column - `rs.next()` once, then `rs.getInt(1)`
using the column INDEX instead of name.)

---

### Exercise 4: Transaction-style multiple inserts (Medium-Hard)
Look up `conn.setAutoCommit(false)`, `conn.commit()`, and `conn.rollback()`.
Write a method that inserts 3 books, but if ANY insert fails partway
through, none of them should be saved (all-or-nothing). Deliberately
trigger a failure (like inserting a duplicate that violates a constraint,
or throwing manually) to test the rollback actually works.

---

### Exercise 5: A simple book search CLI using Scanner + JDBC (Harder)
Combine Day 31 (Scanner) with today's JDBC: build a small loop that asks
the user for an author name, queries the database, and prints matching
books - repeating until they type "exit".

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 3 use `rs.getInt(1)` (index-based) instead of `rs.getInt("count")` - what would you need to change in the SQL for the name-based version to work?
- [ ] In Exercise 4, why does `setAutoCommit(false)` matter - what happens by DEFAULT (autocommit true) if one insert in a sequence fails?
- [ ] Why is combining Scanner input DIRECTLY into a SQL string (instead of using PreparedStatement placeholders) dangerous in Exercise 5, even for a simple learning project?
- [ ] Why does closing a `Connection` early (before you're done querying) cause subsequent `ResultSet` operations to fail?

If you're unsure on any of these, revisit `notes.md` before moving to Day 46.
