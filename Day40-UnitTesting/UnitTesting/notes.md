# Day 40 - Unit Testing with JUnit

## What I learned

### 1. Why unit testing matters
Every day so far has been verified by READING printed output manually.
That doesn't scale - and it's easy to accidentally break old code while
adding new features. Unit tests AUTOMATE that checking.

### 2. JUnit 5 - the standard Java testing framework
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void testAddition() {
        assertEquals(5, calc.add(2, 3)); // expected, then actual
    }
}
```
`@Test` marks a method as a test case. JUnit runs every `@Test` method
automatically and reports pass/fail.

### 3. Common assertion methods
```java
assertEquals(expected, actual);
assertTrue(condition);
assertFalse(condition);
assertNull(value);
assertNotNull(value);
assertThrows(SomeException.class, () -> riskyMethod());
```

### 4. Organizing tests - one method per behavior
Each `@Test` method should test ONE specific behavior, with a descriptive
name explaining what it verifies (e.g. `divisionByZeroThrowsException`).

### 5. @BeforeEach - setup that runs before every test
```java
@BeforeEach
void setUp() {
    calc = new Calculator(); // fresh instance before EVERY test method
}
```
Prevents test methods from accidentally affecting each other through
shared state.

### 6. Testing edge cases - where tests really earn their value
```java
@Test
void addingLargeNumbers() {
    assertEquals(Integer.MAX_VALUE, calc.add(Integer.MAX_VALUE, 0));
}
```
Edge cases (zero, negative numbers, boundaries, exceptions) are exactly
the things manual testing tends to skip.

### 7. Setting up JUnit - Maven (this project uses this)
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

## How to actually run this

Unlike previous days, this needs Maven installed (or an IDE like IntelliJ
that has built-in JUnit support), since JUnit isn't part of the core JDK.

**Option A - Maven (if installed):**
```bash
mvn test
```
Run this from inside the folder containing `pom.xml`. It downloads JUnit
automatically and runs every `@Test` method, printing a pass/fail summary.

**Option B - IntelliJ IDEA (easiest for beginners):**
1. Open this folder as a project in IntelliJ
2. IntelliJ detects the `pom.xml` and downloads JUnit automatically
3. Right-click `CalculatorTest.java` -> "Run 'CalculatorTest'"
4. See green checkmarks (pass) or red X's (fail) per test method

**Option C - VS Code with Java extensions:**
Install the "Extension Pack for Java" and "Test Runner for Java" -
VS Code will show a "Run Test" button above each `@Test` method.

If you don't have Maven set up yet, that's completely fine - reading
through `CalculatorTest.java` and understanding WHAT each test verifies is
the main goal for today. Setting up a build tool is a one-time investment
worth doing when you're ready.

## Questions / things to revisit
- Why does `@BeforeEach` create a FRESH `Calculator` object before every single test, instead of just creating one Calculator and reusing it for all tests?
- What's the actual difference between a test FAILING (an assertion didn't match) and a test ERRORING (an unexpected exception was thrown that wasn't expected via assertThrows)?
- Why is testing edge cases (zero, negative numbers, exceptions) considered MORE valuable than testing only the "happy path" (normal expected inputs)?
