# Day 19 - Practice Exercises: Lambda Expressions & Streams

Try to solve these YOURSELF first, without looking at Greet.java,
LambdasAndStreamsDemo.java, or Solutions.java.

---

### Exercise 1: Custom functional interface (Easy-Medium)
Create a functional interface `Calculator` with one method:
```java
int operate(int a, int b);
```
Create THREE different lambdas implementing it: one for addition, one for
subtraction, one for multiplication. Test all three with `(10, 5)`.

---

### Exercise 2: Filter and collect names (Easy-Medium)
Declare:
```java
List<String> names = List.of("Shasank", "Amit", "Priya", "Al", "Neha", "Bo");
```
Use a stream to filter names with length > 3, then collect and print the
result as a new List.

---

### Exercise 3: Transform and sum with streams (Medium)
Declare `List<Integer> prices = List.of(100, 250, 75, 300, 50);`
Using streams: filter prices above 100, apply a 10% discount to each
(multiply by 0.9), then sum the discounted total. Do this all in ONE
stream pipeline (filter -> map -> reduce, or use `.sum()` with
`.mapToDouble()`).

---

### Exercise 4: Sort a List of custom objects using a lambda Comparator (Medium-Hard)
Reuse (or recreate) a simple `Student` class with `name` and `marks`.
Create a `List<Student>` with 4 students. Sort them by `marks` in
DESCENDING order using `list.sort((a, b) -> ...)` with a lambda, then
print names in sorted order.

---

### Exercise 5: Word length statistics using streams (Harder)
Declare:
```java
List<String> words = List.of("java", "is", "a", "powerful", "programming", "language");
```
Using streams, find:
- The longest word (hint: `.max()` with a Comparator based on length)
- The average word length (hint: `.mapToInt(String::length).average()`)
- All words longer than 5 characters, collected into a new List

---

## Self-check before moving to Day 20
You should be able to answer these without looking anything up:
- [ ] Why does a lambda need a functional interface with exactly one method to "attach" to?
- [ ] What's the difference between `.filter()` and `.map()` in a stream - which one changes VALUES and which one REMOVES items?
- [ ] Why does `list.sort((a, b) -> ...)` need to return a negative, zero, or positive number - what does each mean?
- [ ] What's the actual benefit of writing `numbers.stream().filter(...).map(...).collect(...)` over a plain for loop with if-statements - readability, or something more?

If you're unsure on any of these, revisit `notes.md` before moving to Day 20.
