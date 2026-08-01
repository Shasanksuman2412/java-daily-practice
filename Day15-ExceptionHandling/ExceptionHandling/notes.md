# Day 15 - Exception Handling

## What I learned

### 1. What's an exception?
An unexpected event that disrupts normal program flow (divide by zero,
invalid array index, null reference, etc.). Without handling, it CRASHES
the program.

### 2. try-catch
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Can't divide by zero: " + e.getMessage());
}
// program continues normally after the catch block
```

### 3. Multiple catch blocks
Different exception types handled differently. ORDER MATTERS - specific
exception types must come BEFORE general ones (`Exception` last), or the
code won't compile (unreachable catch block error).
```java
try {
    // risky code
} catch (ArithmeticException e) {
    // specific handling
} catch (ArrayIndexOutOfBoundsException e) {
    // specific handling
} catch (Exception e) {
    // catches anything else - must be LAST
}
```

### 4. finally - always runs
Runs whether an exception was thrown or not, and whether it was caught or
not. Used for cleanup code (closing files, releasing resources, etc.):
```java
try {
    // risky code
} catch (Exception e) {
    // handle it
} finally {
    // ALWAYS executes
}
```

### 5. throw - triggering your own exception
```java
if (age < 18) {
    throw new IllegalArgumentException("Age must be 18 or older");
}
```

### 6. Custom exceptions
Create your own exception type by extending `Exception` (or
`RuntimeException`):
```java
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

### 7. Checked vs unchecked exceptions
- **Checked** (extends `Exception`): compiler FORCES you to either catch it
  or declare `throws` on the method signature. Our `InvalidAgeException` is
  checked.
- **Unchecked** (extends `RuntimeException`, e.g. `ArithmeticException`,
  `NullPointerException`): compiler doesn't force handling, but they can
  still crash the program if left uncaught.

## Commands I ran
```bash
javac InvalidAgeException.java ExceptionHandlingDemo.java
java ExceptionHandlingDemo
```

## Questions / things to revisit
- Why does Java force you to handle CHECKED exceptions (like our custom one) but not UNCHECKED ones like ArithmeticException?
- What would happen if I put the general `catch (Exception e)` block FIRST, before the specific ones - why does Java refuse to compile that?
- Does `finally` run even if the `try` block has a `return` statement inside it? (Worth testing this yourself!)
