# Day 30 - Capstone Project #2: Library Management System

A FULL MONTH of daily Java practice, and this project uses almost
everything learned along the way.

## What this project demonstrates

| Concept | Day learned | Where it's used |
|---|---|---|
| Classes & Objects | Day 10 | `Book`, `Library` |
| Encapsulation | Day 11 | Private fields, getters, controlled setters |
| Exceptions | Day 15 | `BookNotFoundException`, `BookNotAvailableException` |
| Collections | Day 16 | `List<Book>` inside `Library` |
| Generics | Day 17 | `Optional<Book>`, `List<Book>` |
| Lambdas & Streams | Day 19 | `.filter()`, `.count()`, `.collect()` in `Library` |
| Enums | Day 22 | `BookStatus` (AVAILABLE, BORROWED, LOST) |
| File Handling | Day 18 | `saveToFile()` / `loadFromFile()` |
| Comparable/Comparator | Day 25 | `Book implements Comparable` (by title), `Comparator` (by author) |
| Object methods | Day 27 | `equals()`/`hashCode()` on ISBN, `toString()` |
| Design Patterns | Day 28 | `Library` is a Singleton, `Book` uses the Builder pattern |

## Project structure

- `BookStatus.java` - enum for a book's current state
- `BookNotFoundException.java` / `BookNotAvailableException.java` - custom
  checked exceptions for invalid operations
- `Book.java` - the data model: Builder pattern for construction,
  Comparable for natural sort order, proper equals/hashCode/toString
- `Library.java` - the Singleton that manages the whole collection: add,
  borrow, return, search, sort, report, save, load
- `LibraryManagementSystem.java` - the main class demonstrating every
  feature end to end

## How data flows

1. On startup, `loadFromFile()` restores any previously saved library.
2. Books get added through the Builder pattern - `new Book.Builder(...).build()`.
3. Borrowing/returning goes through validated methods that throw specific
   exceptions for specific problems (book missing vs book unavailable).
4. Sorting demonstrates BOTH approaches: `Comparable` (built into `Book`,
   used by `Collections.sort()`) and `Comparator` (external, used for
   sorting by author instead).
5. Searching and reporting use streams instead of manual loops.
6. `saveToFile()` persists everything at the end, so next time you run it,
   your changes (borrowed books, new additions) are still there.

## Commands I ran
```bash
javac BookStatus.java BookNotFoundException.java BookNotAvailableException.java Book.java Library.java LibraryManagementSystem.java
java LibraryManagementSystem
```
Run it TWICE - the second run loads the saved `library.txt`, including any
status changes (borrowed/returned) from the first run!

## Questions / things to revisit
- Why does `Book` use ISBN (not title) for `equals()`/`hashCode()` - what would break if two DIFFERENT books happened to share the same title?
- Why does `Library` throw TWO different exception types (`BookNotFoundException` vs `BookNotAvailableException`) instead of just one generic one - what does this let calling code do differently?
- How would you extend this to support MULTIPLE copies of the same book (e.g. 3 copies of "1984")? What would need to change in `Book` and `Library`?
- Why is `Library` a Singleton here - what would actually go wrong if the program accidentally created two separate `Library` instances?

## What a full month of daily practice built
Day 1 was `HelloWorld.java` printing a single line. Day 30 is a
multi-file application with proper error handling, design patterns,
persistence, and clean architecture. That's the compounding effect of
showing up daily, even when the file was small.
