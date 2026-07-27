# Day 05 - Practice Exercises: Loops

Try to solve these YOURSELF first, without looking at LoopsDemo.java or
Solutions.java.

---

### Exercise 1: Sum of first N natural numbers (Easy)
Declare `int n = 10;`
Use a `for` loop to calculate and print the sum of numbers from 1 to n
(1+2+3+...+10).

---

### Exercise 2: Multiplication Table (Easy-Medium)
Declare `int num = 7;`
Print the multiplication table of 7, from 7x1 to 7x10, one line each,
formatted like: `7 x 1 = 7`

---

### Exercise 3: Reverse a number using while (Medium)
Declare `int number = 1234;`
Using a `while` loop and the `%` and `/` operators (no strings, no arrays),
reverse the digits so the output is `4321`.

(Hint: repeatedly take the last digit with `% 10`, build up the reversed
number, then remove the last digit with `/ 10`.)

---

### Exercise 4: Number Pyramid Pattern (Medium-Hard)
Using nested loops, print this exact pattern for 5 rows:
```
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

---

### Exercise 5: Prime number checker (Harder)
Declare `int number = 29;`
Using a `for` loop, check if the number is prime (only divisible by 1 and
itself). Print `"Prime"` or `"Not Prime"`.

(Hint: try dividing by every number from 2 up to number-1, or optimize by
stopping at number/2 — see if you can figure out why that optimization
still works correctly.)

---

## Self-check before moving to Day 06
You should be able to answer these without looking anything up:
- [ ] What's the exact order of operations in a `for` loop: init, condition, body, update — in what sequence do they actually run?
- [ ] Why would you ever pick `do-while` over `while`?
- [ ] In a nested loop, if the outer loop runs 3 times and inner runs 4 times, how many total times does the inner loop's body execute?
- [ ] What's the difference between `break` stopping a loop vs `continue` skipping an iteration?

If you're unsure on any of these, revisit `notes.md` before moving to Day 06.
