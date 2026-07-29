# Day 09 - Practice Exercises: Methods

Try to solve these YOURSELF first, without looking at MethodsDemo.java or
Solutions.java.

---

### Exercise 1: isPrime as a reusable method (Easy-Medium)
Write a method `public static boolean isPrime(int number)` that returns
`true` or `false`. Then call it in `main` for the numbers 7, 15, and 29,
printing each result.
(You solved this logic back on Day 05 - now wrap it in a proper method.)

---

### Exercise 2: Overloaded `max` method (Easy-Medium)
Write THREE overloaded versions of a method called `max`:
- `max(int a, int b)` - returns the larger of two ints
- `max(int a, int b, int c)` - returns the largest of three ints
- `max(double a, double b)` - returns the larger of two doubles

Call all three from `main` with sample values.

---

### Exercise 3: Recursive sum of digits (Medium)
Write a method `public static int sumOfDigits(int n)` that uses RECURSION
(not a loop) to add up all the digits of a number.
Example: `sumOfDigits(1234)` should return `1+2+3+4 = 10`.
(Hint: base case is when n becomes 0. Recursive case: last digit + recurse
on the rest of the number.)

---

### Exercise 4: Method that reverses a String recursively (Medium-Hard)
Write `public static String reverseString(String s)` using RECURSION (no
loops allowed). Test it with `"hello"` and confirm it returns `"olleh"`.
(Hint: base case is an empty string or single character. Recursive case:
last character + reverse of the rest.)

---

### Exercise 5: Recursive power function (Harder)
Write `public static int power(int base, int exponent)` using RECURSION to
calculate `base^exponent` (without using `Math.pow()`).
Example: `power(2, 5)` should return `32`.
(Hint: base case is exponent == 0, which returns 1. Recursive case:
base * power(base, exponent - 1).)

---

## Self-check before moving to Day 10
You should be able to answer these without looking anything up:
- [ ] What's the difference between a method's PARAMETERS and the ARGUMENTS you pass when calling it?
- [ ] How does Java decide WHICH overloaded version of a method to call?
- [ ] What happens if a recursive method never reaches its base case?
- [ ] In `sumOfDigits`, what's the base case, and what's the recursive case?

If you're unsure on any of these, revisit `notes.md` before moving to Day 10.
