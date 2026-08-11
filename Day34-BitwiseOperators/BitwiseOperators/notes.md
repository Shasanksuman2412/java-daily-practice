# Day 34 - Bitwise Operators

## What I learned

### 1. What are bitwise operators?
Operators that work on the individual BITS of a number, rather than the
number as a whole. Used for low-level manipulation, flags, and
performance-sensitive code.

### 2. Core bitwise operators
```java
int a = 12; // 1100
int b = 10; // 1010

a & b   // AND: 1000 = 8   (1 only where BOTH bits are 1)
a | b   // OR:  1110 = 14  (1 where EITHER bit is 1)
a ^ b   // XOR: 0110 = 6   (1 where bits are DIFFERENT)
~a      // NOT: flips every bit, including the sign bit
```

### 3. Shift operators
```java
x << 1  // left shift: DOUBLES the value per shift
x >> 1  // right shift: HALVES the value per shift (rounds down)
```
Left shift by n = multiply by 2^n. Right shift by n = divide by 2^n.

### 4. Unsigned right shift >>>
```java
negative >> 2   // preserves the sign bit (fills with 1s for negative numbers)
negative >>> 2  // ignores sign, fills with 0s - VERY different result for negatives
```

### 5. Practical use: even/odd check
```java
if ((n & 1) == 0) {
    // even - the last bit is 0
}
```

### 6. Practical use: XOR swap without a temp variable
```java
a = a ^ b;
b = a ^ b;
a = a ^ b;
```

### 7. Practical use: bit flags
Pack several true/false options into a single int:
```java
final int READ = 1, WRITE = 2, EXECUTE = 4;
int permissions = READ | WRITE;          // combine with OR
(permissions & READ) != 0;                // check a flag with AND
permissions = permissions | EXECUTE;      // add a flag
permissions = permissions & ~WRITE;       // remove a flag (AND with inverted flag)
```

## Commands I ran
```bash
javac BitwiseOperatorsDemo.java
java BitwiseOperatorsDemo
```

## Questions / things to revisit
- Why does `>>` and `>>>` behave IDENTICALLY for positive numbers but DIFFERENTLY for negative numbers - what's actually different about how each fills in the new bits?
- Why does `permissions & ~WRITE` correctly REMOVE just the WRITE flag without touching READ or EXECUTE - trace through the actual bits to see why.
- Why does the XOR swap trick work mathematically - what property of XOR makes `a ^ b ^ b == a` true?
