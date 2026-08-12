# Day 36 - Practice Exercises: Pattern Matching

Try to solve these YOURSELF first, without looking at Shape.java, Circle.java,
Square.java, Weekday.java, PatternMatchingDemo.java, or Solutions.java.

---

### Exercise 1: Rewrite an old instanceof chain (Easy-Medium)
Given a method that takes `Object obj` and uses OLD-style instanceof +
casting to check if it's a `String`, `Integer`, or `Double`, each printing
a different message - rewrite it using pattern matching for `instanceof`
(no separate cast lines). Test with a String, an Integer, and a Double.

---

### Exercise 2: Switch expression for a grading system (Easy-Medium)
Rewrite Day 04's grading switch STATEMENT as a switch EXPRESSION that
directly returns the letter grade:
```java
char grade = switch (...) {
    // your cases here, using ->
};
```
Test with marks 95, 82, 65, 45, 20.

---

### Exercise 3: Pattern matching switch on a Shape hierarchy (Medium)
Using the `Shape`/`Circle`/`Square` classes, write a method
`describeShape(Shape s)` that uses a pattern-matching switch to return a
description including the shape's specific measurement (radius for
Circle, side for Square) - NOT just the area.

---

### Exercise 4: Guard clauses for a number classifier (Medium-Hard)
Write a method `classify(Object obj)` using pattern matching switch with
`when` guards that returns:
- "Small positive int" for an Integer between 1-100
- "Large positive int" for an Integer > 100
- "Negative int" for any negative Integer
- "Zero" for Integer 0
- "Not an integer" for anything else

Test with several different values.

---

### Exercise 5: Combine instanceof pattern matching with a record (Harder)
Using a record `Rectangle(double width, double height)` (from Day 35),
write a method that takes `Object obj` and, if it's a `Rectangle` with
`width == height` (i.e., actually a square), prints "This is a square with
side X" - otherwise if it's just a Rectangle, prints its area. Use pattern
matching for `instanceof` combined with `&&` conditions.

---

## Self-check before moving to Day 37
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 1's pattern-matching version need FEWER lines than the old instanceof + cast version, even though they do the exact same thing?
- [ ] In Exercise 4, why does the ORDER of the `when` guard cases matter - what would happen if "Large positive int" were checked BEFORE "Small positive int"?
- [ ] Why does a pattern-matching switch on a non-sealed class hierarchy (like `Shape`) still require a `default` case, even if you've listed every known subclass?
- [ ] In Exercise 5, why can you combine `instanceof Rectangle r` with `&& r.width() == r.height()` on the same line - what does Java guarantee about `r` at that point?

If you're unsure on any of these, revisit `notes.md` before moving to Day 37.
