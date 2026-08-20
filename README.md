# Java Daily Practice 🚀☕

Learning Java one day at a time — inspired by the "learn in public, commit every day" style of repos like `chai_aur_code`.

## 📌 Goal
- Learn Java from basics to advanced.
- Write and commit code **every single day**, even if it's small.
- Keep notes alongside code so future-me (and others) can revisit concepts easily.
- Actually **practice** each concept, not just read about it — so anyone
  learning from this repo builds real understanding, not just familiarity.

## 🗂️ Structure

Each day gets its own folder, and inside it, topic-based subfolders. Every
topic folder follows the same 4-file pattern:

```
Day01-Introduction/
  └── Basics/
      ├── HelloWorld.java     <- the concept, demonstrated in code
      └── notes.md            <- what was learned, explained in plain words

Day02-Variables/
  └── Variables/
      ├── VariablesDemo.java  <- the concept, demonstrated in code
      ├── notes.md            <- what was learned, explained in plain words
      ├── Practice.md         <- exercises to solve WITHOUT looking at answers
      └── Solutions.java      <- solutions, only check after attempting
```

- `DayXX-<TopicName>` → top-level folder for that day's session.
- `notes.md` → concept explained in plain language, with small code snippets.
- `<Topic>Demo.java` → a runnable file demonstrating the concept.
- `Practice.md` → exercises (easy → harder) to actually apply the concept.
- `Solutions.java` → answer key — solve first, check second.
- A "Self-check" checklist at the bottom of `Practice.md` — if you can't
  answer those questions confidently, revisit `notes.md` before moving on.

## ✅ Progress Log

| Day | Date | Topic | Notes |
|-----|------|-------|-------|
| 01  |      | Introduction & Hello World | |
| 02  |      | Variables & Data Types | |
| 03  |      | Operators              | |
| 04  |      | Conditionals           | | 
| 05  |      | Loops                  | |
| 06  |      | Arrays                 | |
| 07  |      | Array Operations       | | 
| 08  |      | Strings                | |
| 09  |      | Methods                | |
| 10  |      | Classes and Objects    | |
| 11  |      | Encapsulation          | |
| 12  |      | Inheritance            | |
| 13  |      | Polymorphism           | |
| 14  |      | Abstraction            | |
| 15  |      | Exception Handling     | |
| 16  |      | Collections Framework  | |
| 17  |      | Generics               | |
| 18  |      | File Handling          | |
| 19  |      | Lambda Expressions and Streams | |
| 20  |      | Capstone Project - Student Management System | |
| 21  |      |  Multithreading        | |
| 22  |      |  Enmus                 | |
| 23  |      | Data and Time API      | |
| 24  |      | Regular Expressions    | |
| 25  |      | Comparable and Comparator | |
| 26  |      | Nested and Inner Classes | |
| 27  |      | Object Class Methods (equals, hashCode, toString) | |
| 28  |      | Design Patterns (Singleton and Builder) | |
| 29  |      |  Wrapper Classes and Autoboxing | |
| 30  |      | Capstone Project 2 - Library Management System | |
| 31  |      |  Scanner and User Input Handling | |
| 32  |      | Varargs                | | 
| 33  |      | StringBuilder Deep Dive| |
| 34  |      | Bitwise Operators      | |
| 35  |      | Records                | |
| 36  |      | Pattern Matching       | |
| 37  |      | Sealed Classes         | |
| 38  |      |  Optional Deep Dive    | |
| 39  |      | Text Blocks            | |
| 40  |      | Unit Testing with JUnit | |
| 41  |      | Annotations            | |
| 42  |      |  try-with-resources and Custom AutoCloseable | |
| 43  |      | Custom Iterator and Iterable | |
| 44  |      | Generics Wildcards | |
| 45  |      | JDBC                  | |
| 46  |      | JAR Packaging      | |
| 47  |      | Networking Basics  | |
| 48  |      | Capstone Project 3 - Multi-Client Chat Server | |
| 49  |      | Introduction to Spring Boot | |
| 50  |      | REST CRUD API      | |
*(Update this table every time you commit — it becomes a nice changelog of your journey.)*

## 🔁 Daily Workflow

1. `git pull` (if working from multiple machines).
2. Create today's folder: `./new_day.sh <day-num> <TopicName> <MainClassName>`
3. Learn the concept, write it up in `notes.md`.
4. Write the demo `.java` file.
5. Write 3-5 practice exercises in `Practice.md` and attempt them yourself.
6. Write `Solutions.java` — only after you've actually tried the exercises.
7. Update the Progress Log table above.
8. Commit:
   ```bash
   git add .
   git commit -m "Day 03: Loops - for, while, do-while"
   git push
   ```

## 🛠️ Requirements
- JDK installed (`java -version` and `javac -version` to check)
- Any editor (VS Code / IntelliJ)

## 📚 Resources
- Official Docs: https://docs.oracle.com/en/java/
- Practice: LeetCode / HackerRank Java track

---
⭐ The real goal isn't a perfect repo — it's the **daily habit**, and making
sure each day's concept is actually understood, not just copy-pasted. Small
consistent commits > big rare ones.
