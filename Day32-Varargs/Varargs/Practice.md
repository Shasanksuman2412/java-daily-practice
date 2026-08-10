# Day 32 - Practice Exercises: Varargs

Try to solve these YOURSELF first, without looking at VarargsDemo.java or
Solutions.java.

---

### Exercise 1: Find the max of any number of ints (Easy-Medium)
Write a method `static int max(int... numbers)` that returns the largest
value passed in. Handle the edge case of ZERO arguments by throwing an
`IllegalArgumentException` with a clear message.
Test with `max(5)`, `max(3, 9, 1)`, and `max()` (should throw).

---

### Exercise 2: Concatenate any number of Strings with a separator (Easy-Medium)
Write a method `static String joinWithSeparator(String separator, String... words)`
that joins all words with the given separator between them (but NOT at the
start or end). Test with `joinWithSeparator("-", "a", "b", "c")` should
give `"a-b-c"`.

---

### Exercise 3: Average of numbers, handling empty input gracefully (Medium)
Write a method `static double average(double... numbers)` that returns the
average, or `0.0` if no numbers were passed (instead of crashing with
division by zero). Test with several calls including zero arguments.

---

### Exercise 4: Varargs with a regular parameter for validation (Medium-Hard)
Write a method:
```java
static boolean allAboveThreshold(int threshold, int... numbers)
```
that returns `true` only if EVERY number passed is greater than the
threshold (return `true` for zero numbers too - vacuously true). Test with
several different threshold/number combinations.

---

### Exercise 5: Overloaded methods with and without varargs (Harder)
Create TWO overloaded methods:
```java
static void describe(int a, int b)       // specific 2-arg version
static void describe(int... numbers)      // varargs version
```
Each should print a DIFFERENT message so you can tell which one got
called. Call `describe(1, 2)` and `describe(1, 2, 3)` - confirm which
overload handles each call, and explain in a comment WHY.

---

## Self-check before moving to Day 33
You should be able to answer these without looking anything up:
- [ ] Why does `max()` (Exercise 1) with ZERO arguments need special handling, rather than just letting the loop run zero times silently?
- [ ] In Exercise 2, why does joining need EXTRA logic to avoid a separator at the very start or end - what's the naive approach that would get this wrong?
- [ ] In Exercise 5, why does `describe(1, 2)` call the specific 2-arg version instead of the varargs version, even though the varargs version COULD also technically handle 2 arguments?
- [ ] What would happen if you tried to declare a method with TWO varargs parameters, like `void bad(int... a, String... b)` - would it even compile?

If you're unsure on any of these, revisit `notes.md` before moving to Day 33.
