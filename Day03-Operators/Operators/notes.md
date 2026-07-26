# Day 03 - Operators

## What I learned

### 1. Arithmetic operators
```java
int a = 10, b = 3;
a + b   // 13
a - b   // 7
a * b   // 30
a / b   // 3   <- integer division, decimal dropped
a % b   // 1   <- modulus, gives the remainder
```
**Gotcha:** dividing two `int`s truncates the decimal. To get a real decimal
result, cast at least one operand to `double`:
```java
double result = (double) a / b; // 3.333...
```

### 2. Relational operators
Always return a `boolean`:
```java
a == b, a != b, a > b, a < b, a >= b, a <= b
```

### 3. Logical operators
Combine boolean conditions:
```java
x && y   // AND - both must be true
x || y   // OR  - at least one must be true
!x       // NOT - flips the value
```

### 4. Increment / Decrement - pre vs post
```java
int i = 5;
i++   // POST: use current value first (5), THEN increment -> i becomes 6
++i   // PRE: increment FIRST -> i becomes 6, THEN use the new value (6)
```
This is one of the most common interview "predict the output" traps.

### 5. Compound assignment operators
Shorthand for updating a variable based on its own value:
```java
x += 5  // x = x + 5
x -= 2  // x = x - 2
x *= 3  // x = x * 3
x /= 4  // x = x / 4  (still integer division if x is int!)
```

## Commands I ran
```bash
javac OperatorsDemo.java
java OperatorsDemo
```

## Questions / things to revisit
- Why does `a / b` behave differently for `int` vs `double`?
- Where would pre vs post increment actually change program behavior (e.g. inside a loop or array index)?
- What's the difference between `&&` and `&` (short-circuit vs non-short-circuit)?
