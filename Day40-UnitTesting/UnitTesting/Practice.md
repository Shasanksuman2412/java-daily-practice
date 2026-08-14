# Day 40 - Practice Exercises: Unit Testing with JUnit

Try to solve these YOURSELF first, without looking at Calculator.java,
CalculatorTest.java, or Solutions.java.

Note: these exercises assume you have Maven or an IDE with JUnit support
set up. If not, write the test code anyway - understanding what SHOULD be
tested and why is the core skill, even before you can run it.

---

### Exercise 1: Write tests for a String utility class (Easy-Medium)
Create a class `StringUtils` with a method
`boolean isPalindrome(String s)` (reuse logic from Day 08/33).
Write AT LEAST 4 `@Test` methods covering:
- A clear palindrome ("madam")
- A clear non-palindrome ("hello")
- An empty string (should be considered a palindrome - it reads the same
  forwards and backwards trivially)
- A single character (also trivially a palindrome)

---

### Exercise 2: Test a method that throws exceptions (Easy-Medium)
Create a method `int parsePositiveInt(String s)` that parses a String to
an int, throwing `IllegalArgumentException` if the result is negative or
zero. Write tests using `assertThrows` for invalid input, and
`assertEquals` for valid input.

---

### Exercise 3: Use @BeforeEach for a stateful class (Medium)
Create a simple `Counter` class with `increment()`, `decrement()`, and
`getValue()`. Write a test class with `@BeforeEach` creating a fresh
Counter before each test. Write tests verifying: starting at 0,
incrementing increases by 1, decrementing decreases by 1, and multiple
increments accumulate correctly.

---

### Exercise 4: Test edge cases for an array method (Medium-Hard)
Create a method `int findMax(int[] arr)` that returns the largest value
(reuse Day 06 logic). Write tests for:
- A normal array with several values
- An array with ALL the same value
- An array with exactly ONE element
- An array with negative numbers only
- (Bonus) What should happen with an EMPTY array - decide, implement, and
  test that behavior deliberately (throw an exception? Return a sentinel
  value? Your choice, but test it explicitly.)

---

### Exercise 5: Test-Driven thinking - write the test FIRST (Harder - conceptual)
Before writing ANY implementation, write a test method
`isValidEmail_rejectsMissingAtSymbol()` that asserts
`EmailValidator.isValid("not-an-email")` returns `false`. THEN write the
minimal `EmailValidator` class and `isValid()` method needed to make that
test pass. This is the core idea behind Test-Driven Development (TDD) -
write the test first, then write just enough code to satisfy it.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 1 specifically test an EMPTY string and a SINGLE character - what makes these different from "normal" test cases?
- [ ] In Exercise 4, why does deciding what happens with an EMPTY array matter enough to write a dedicated test for it, rather than just leaving the behavior undefined?
- [ ] What's the actual workflow difference in Exercise 5 (test-first) compared to how you've written code every other day this month (implementation-first, then verify by running it)?
- [ ] Why might having a full suite of tests make you MORE confident about changing old code later, compared to a project with no tests at all?

If you're unsure on any of these, revisit `notes.md`.

Forty days of daily Java practice - unit testing is genuinely one of the
most valuable habits to build early, since it changes how confidently you
can grow and refactor a codebase over time.
