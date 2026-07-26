# Day 04 - Practice Exercises: Conditionals

Try to solve these YOURSELF first, without looking at ConditionalsDemo.java
or Solutions.java.

---

### Exercise 1: Leap Year Checker (Easy-Medium)
Declare `int year = 2024;`
A year is a leap year if:
- it's divisible by 4, AND
- (it's NOT divisible by 100, OR it IS divisible by 400)

Print `"Leap year"` or `"Not a leap year"` using if/else and logical operators.

---

### Exercise 2: Largest of Three Numbers (Easy-Medium)
Declare three ints: `a = 45, b = 89, c = 67`.
Using only if/else if/else (no built-in Math.max), print the largest one.

---

### Exercise 3: Simple Grading System (Medium)
Declare `int marks = 68;`
Print the grade using these bands:
- 90+ → A
- 75-89 → B
- 60-74 → C
- 40-59 → D
- below 40 → F

---

### Exercise 4: Day Name using switch (Medium)
Declare `int day = 6;`
Use a `switch` statement to print the day name (1=Monday ... 7=Sunday).
Make sure Saturday and Sunday BOTH print `"Weekend!"` — think about how
fall-through could actually help you here instead of hurt you.

---

### Exercise 5: Predict the output (Harder - do this on paper first!)
```java
int x = 10;
if (x > 5)
    if (x > 20)
        System.out.println("A");
    else
        System.out.println("B");
else
    System.out.println("C");
```
Write down what YOU think this prints, and more importantly, WHY — pay
attention to which `if` the `else` actually belongs to (this is called the
"dangling else" problem).

---

## Self-check before moving to Day 05
You should be able to answer these without looking anything up:
- [ ] Why does Java only run the FIRST matching branch in an if-else-if chain?
- [ ] What's the "dangling else" problem, and how does indentation trick you into misreading it?
- [ ] When is switch fall-through a bug, and when is it a deliberate useful pattern?
- [ ] When would you use a ternary operator instead of a full if/else, and when should you NOT?

If you're unsure on any of these, revisit `notes.md` before moving to Day 05.
