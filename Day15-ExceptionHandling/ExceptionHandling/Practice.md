# Day 15 - Practice Exercises: Exception Handling

Try to solve these YOURSELF first, without looking at ExceptionHandlingDemo.java,
InvalidAgeException.java, or Solutions.java.

---

### Exercise 1: Safe division method (Easy-Medium)
Write a method `safeDivide(int a, int b)` that:
- Tries to divide `a` by `b`
- Catches `ArithmeticException` if `b` is 0, printing a friendly message
  instead of crashing
- Returns 0 if division fails, otherwise returns the actual result

Test it with `safeDivide(10, 2)` and `safeDivide(10, 0)`.

---

### Exercise 2: Array bounds checker with multiple catches (Easy-Medium)
Write a method that takes an `int[]` array and an index, and:
- Tries to print `array[index]`
- Catches `ArrayIndexOutOfBoundsException` with a message like
  `"Index X is out of bounds for this array"`
- Has a `finally` block that always prints `"Access attempt finished."`

Test it with a valid index and an invalid one (like index 100).

---

### Exercise 3: Custom `InsufficientFundsException` (Medium)
Create a custom checked exception `InsufficientFundsException` (similar to
`InvalidAgeException`).
Write a method `withdraw(double balance, double amount)` that throws this
exception if `amount > balance`, otherwise returns `balance - amount`.
Call it with a valid withdrawal and an invalid one, handling the exception
with try-catch.

---

### Exercise 4: Validate user input with multiple custom checks (Medium-Hard)
Write a method `registerUser(String username, int age)` that throws:
- `IllegalArgumentException` if `username` is empty or null
- Your `InvalidAgeException` if `age < 13`

Call it with THREE different test cases: valid input, empty username,
and age 10 - catching and printing each error appropriately. (Hint:
you'll need two separate catch blocks, or one general one, since these
are two different exception types.)

---

### Exercise 5: Try-catch-finally with a return value (Harder - conceptual)
Write a method:
```java
static int testFinally() {
    try {
        return 1;
    } finally {
        System.out.println("finally block ran");
    }
}
```
Before running it, predict: does `"finally block ran"` print? What value
does the method actually return? Run it and confirm your prediction.

---

## Self-check before moving to Day 16
You should be able to answer these without looking anything up:
- [ ] Why must a custom checked exception's method declare `throws SomeException` in its signature?
- [ ] What's the practical difference between catching `Exception` (a broad type) vs a specific type like `ArithmeticException`?
- [ ] In Exercise 5, does `finally` run even when there's a `return` in the `try` block? Why does this make `finally` useful for cleanup code (like closing a file) even when a method returns early?
- [ ] If you throw an exception but never catch it anywhere, what happens to the program?

If you're unsure on any of these, revisit `notes.md` before moving to Day 16.
