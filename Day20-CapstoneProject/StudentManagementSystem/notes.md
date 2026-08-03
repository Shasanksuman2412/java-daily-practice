# Day 20 - Capstone Project: Student Management System

20 days in - time to build something real instead of an isolated topic.
This project pulls together everything covered from Day 1 to Day 19.

## What this project demonstrates

| Concept | Where it's used |
|---|---|
| Classes & Objects (Day 10) | `Student` class |
| Encapsulation (Day 11) | Private fields, getters, validating `setMarks()` |
| Exceptions (Day 15) | Custom `InvalidMarksException`, try-catch throughout |
| Collections (Day 16) | `ArrayList<Student>` inside `StudentManager` |
| Generics (Day 17) | `List<Student>`, `Optional<Student>` |
| File Handling (Day 18) | `saveToFile()` / `loadFromFile()` using `FileWriter`/`Scanner` |
| Lambdas & Streams (Day 19) | `removeIf()`, `.stream().filter()`, `.mapToDouble()`, `.max()` |

## Project structure

- `Student.java` - the data model, with validation baked into the setter
  and constructor
- `InvalidMarksException.java` - a custom checked exception for invalid
  marks (must be 0-100)
- `StudentManager.java` - holds the `List<Student>`, and provides all the
  operations: add, delete, search, average, top scorer, save, load
- `StudentManagementSystem.java` - the main class that ties it all
  together and demonstrates every feature

## How data flows

1. On startup, `loadFromFile()` checks if `students.txt` already exists
   from a previous run and loads it back in.
2. New students get added through `addStudent()` - if marks are invalid,
   the constructor throws `InvalidMarksException`, caught in `main`.
3. `classAverage()` and `topScorer()` use streams instead of manual loops.
4. `saveToFile()` writes everything back to `students.txt` at the end, so
   the data persists for the NEXT time you run the program.

## Commands I ran
```bash
javac Student.java InvalidMarksException.java StudentManager.java StudentManagementSystem.java
java StudentManagementSystem
```
Run it TWICE - the second time, notice it loads the saved students from
`students.txt` instead of starting empty!

## Questions / things to revisit
- Why does `Student`'s constructor call `setMarks()` internally instead of setting the field directly - what does this guarantee?
- Why is `findByRollNumber()` returning `Optional<Student>` instead of just `Student` (which could be null)? What problem does `Optional` solve?
- What would happen if `students.txt` had a corrupted line (like missing a comma) - trace through `loadFromFile()` and `fromFileFormat()` to see how that's handled.
- How would you extend this to support UPDATING a student's marks after creation, given there's currently no `updateMarks(rollNumber, newMarks)` method?
