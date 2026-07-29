# Day 09 - Methods (Functions)

## What I learned

### 1. Why methods?
Wrap reusable logic into a named block instead of repeating code:
```java
public static int add(int a, int b) {
    return a + b;
}
```
`public static` = access + no object needed to call it (yet - more on this
when we cover classes/objects), `int` = return type, `add` = name,
`(int a, int b)` = parameters.

### 2. Calling a method
```java
int result = add(5, 3); // 8
```

### 3. Void methods (no return value)
```java
public static void greet(String name) {
    System.out.println("Hello, " + name);
}
```
`void` means the method just DOES something, it doesn't send a value back.

### 4. Method overloading
Same method name, different parameter lists - Java picks the correct
version based on what you pass in (number/type of arguments):
```java
add(int a, int b)
add(double a, double b)
add(int a, int b, int c)
```

### 5. Parameters vs arguments
- **Parameters** = placeholders in the method definition (`int a, int b`)
- **Arguments** = actual values passed when calling (`add(5, 3)` -> 5 and 3
  are the arguments)

### 6. Recursion
A method calling itself. Every recursive method needs a BASE CASE that
stops the recursion, or it calls itself forever until it crashes with a
`StackOverflowError`.
```java
public static int factorial(int n) {
    if (n == 0) return 1;        // base case
    return n * factorial(n - 1); // recursive case
}
```

## Commands I ran
```bash
javac MethodsDemo.java
java MethodsDemo
```

## Questions / things to revisit
- What actually happens in memory (the "call stack") each time a recursive method calls itself?
- Why is the naive recursive Fibonacci (like in the demo) very inefficient for large n - what's being recalculated over and over?
- When would I choose recursion over a simple loop, and when is a loop clearly the better choice?
