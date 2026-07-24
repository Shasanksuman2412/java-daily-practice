# Day 02 - Practice Exercises: Variables & Data Types

Try to solve these YOURSELF first, without looking at VariablesDemo.java or
Solutions.java. Struggling a bit is where the actual learning happens.

---

### Exercise 1: Declare and print (Easy)
Declare variables for:
- your name (String)
- your age (int)
- your height in meters (double)
- whether you like Java (boolean)

Print all four in one sentence using string concatenation, e.g.:
`"Shasank is 21 years old, 1.75m tall, and likes Java: true"`

---

### Exercise 2: Simple Interest Calculator (Easy-Medium)
Declare:
- `double principal = 10000;`
- `double rate = 7.5;`
- `int time = 3;`

Calculate simple interest using the formula:
```
SI = (principal * rate * time) / 100
```
Print the result.

---

### Exercise 3: Celsius to Fahrenheit (Medium)
Declare a `double celsius = 37.0;`
Convert it to Fahrenheit using:
```
F = (C * 9/5) + 32
```
**Gotcha to watch for:** in Java, `9/5` using two `int`s gives `1` (integer
division), not `1.8`! Figure out how to write the formula so it computes
correctly. (Hint: think about what happens if you write `9.0/5` instead.)

---

### Exercise 4: Swap two numbers WITHOUT a third variable (Harder)
Declare:
```java
int a = 5;
int b = 10;
```
Swap their values using only arithmetic (no `temp` variable allowed).
Print `a` and `b` before and after swapping.

(Hint: think about addition and subtraction, or research the XOR trick if
you want a challenge.)

---

### Exercise 5: Narrowing cast prediction (Conceptual)
Before running any code, write down on paper what you THINK each line prints.
Then write the code, run it, and check if you were right.

```java
double d1 = 9.99;
double d2 = -9.99;
char c = 65;         // what character is this?
int i = 'Z';         // what number is this?

System.out.println((int) d1);
System.out.println((int) d2);
System.out.println(c);
System.out.println(i);
```

---

## Self-check before moving to Day 03
You should be able to answer these without looking anything up:
- [ ] What's the difference between `float` and `double`, and when would each matter?
- [ ] Why does `int result = 9/5;` give `1` instead of `1.8`?
- [ ] What does a narrowing cast do to a decimal like `9.99` when cast to `int`?
- [ ] Why can't you reassign a `final` variable?

If you can't answer one confidently, that's your cue to re-read that section
of notes.md before moving on — not a failure, just a signal of where to spend
5 more minutes.
