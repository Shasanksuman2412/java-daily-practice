# Day 31 - Practice Exercises: Scanner & User Input Handling

Try to solve these YOURSELF first, without looking at
ScannerAndUserInputDemo.java or Solutions.java.

Note: ALL of these require actually running the program and typing input -
you can't just read the code, you need to interact with it!

---

### Exercise 1: Simple calculator using input (Easy-Medium)
Prompt the user for two numbers and an operator (+, -, *, /) as separate
inputs. Perform the calculation and print the result. Handle division by
zero gracefully with a try-catch (from Day 15).

---

### Exercise 2: Fix the nextInt/nextLine trap yourself (Easy-Medium)
Write a program that asks for:
1. Age (int)
2. Full name (String, using nextLine - can contain spaces)

Get this working correctly WITHOUT the empty-string bug. Print both back
to confirm they were read correctly.

---

### Exercise 3: Input validation loop for a menu choice (Medium)
Create a loop that repeatedly asks the user to "Enter a choice (1-3):"
until they enter a valid integer between 1 and 3 (inclusive). Reject
non-numbers AND numbers outside the range, with a clear message for each
case. Print "Valid choice!" once they succeed.

---

### Exercise 4: Build a simple interactive quiz (Medium-Hard)
Ask the user 3 True/False questions (hardcoded questions, but read their
answer with `nextBoolean()` or by reading a String and checking for
"true"/"false"). Keep score and print how many they got right at the end.

---

### Exercise 5: Accumulate numbers until the user types "done" (Harder)
Read numbers ONE AT A TIME from the user (as Strings, since you need to
check for "done" too), summing them as you go, until they type "done"
(case-insensitive). Handle the case where they type something that isn't
a number and isn't "done" - skip it with a warning instead of crashing.
Print the final sum when they're finished.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 2 specifically fail without the extra `scanner.nextLine()` call after reading the age - trace through exactly what's left in the buffer.
- [ ] In Exercise 3, why does entering a valid number OUTSIDE the range (like `99`) need DIFFERENT handling than entering something that isn't a number at all (like `"abc"`)?
- [ ] In Exercise 5, why does reading input as a String (instead of directly as an int) make it easier to check for the "done" sentinel value?
- [ ] Why is it generally considered better practice to validate BEFORE reading (`hasNextInt()`) rather than reading and catching an exception AFTER, when you expect bad input to be common (like in a menu loop)?

Scanner-based interaction is genuinely useful for building real CLI tools
- take your time getting comfortable with the nextInt/nextLine trap, since
it catches almost every Java learner at least once.
