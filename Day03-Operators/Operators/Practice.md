# Day 03 - Practice Exercises: Operators

Try to solve these YOURSELF first, without looking at OperatorsDemo.java or
Solutions.java.

---

### Exercise 1: Simple Calculator (Easy)
Declare two integers `num1 = 15` and `num2 = 4`.
Print the result of `+`, `-`, `*`, `/`, and `%` between them, each labeled
clearly (e.g. `"15 + 4 = 19"`).

---

### Exercise 2: Even or Odd (Easy-Medium)
Declare an `int number = 27;`
Using the `%` operator, print `true` if the number is even, `false` if odd.
(You don't need if/else yet — just print the boolean result directly.)

---

### Exercise 3: Swap using compound operators (Medium)
Declare:
```java
int a = 7;
int b = 12;
```
Using only `+=` and `-=` (no third variable, no plain `+`/`-`), swap the
values of `a` and `b`. Print before and after.

---

### Exercise 4: Predict the output (Harder - do this on paper first!)
Before running anything, write down what YOU think each line prints.
Then write the code and check.

```java
int x = 5;
System.out.println(x++ + ++x); // ??
System.out.println(x);         // ??

int y = 10;
boolean result = (y > 5) && (y++ < 15);
System.out.println(result); // ??
System.out.println(y);      // ??
```

---

### Exercise 5: Grade average without conditionals (Medium)
Declare three `double` marks: `85.5, 90.0, 78.5`.
Calculate their average using arithmetic operators only, and print it.
Then use `%` creatively to check if the average (rounded to an int) is
divisible by 5, printing the boolean result.

---

## Self-check before moving to Day 04
You should be able to answer these without looking anything up:
- [ ] Why does `7 / 2` give `3` but `7.0 / 2` gives `3.5`?
- [ ] What's the actual difference between `x++` and `++x` in terms of execution order?
- [ ] What does `%` actually compute, in plain English?
- [ ] Why did Exercise 4's `&&` line only partially increment `y` sometimes (short-circuit evaluation) — can you explain why?

If you're unsure on any of these, revisit `notes.md` before moving to Day 04.
