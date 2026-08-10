# Day 32 - Varargs (Variable Arguments)

## What I learned

### 1. What's the problem varargs solves?
Without varargs, accepting a flexible number of arguments needs endless
overloads:
```java
int sum(int a, int b) { }
int sum(int a, int b, int c) { } // doesn't scale!
```

### 2. Varargs syntax - `...`
```java
public static int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) {
        total += n;
    }
    return total;
}
```
```java
sum();              // 0 - zero arguments is valid
sum(1, 2, 3);        // 6
sum(1, 2, 3, 4, 5); // 15
```
Behind the scenes, `numbers` is just treated as a regular ARRAY (`int[]`)
inside the method.

### 3. Passing an actual array instead
```java
int[] values = {10, 20, 30};
sum(values); // works the same as sum(10, 20, 30)
```

### 4. Varargs combined with regular parameters
Regular parameters must come BEFORE the varargs parameter:
```java
public static void printAll(String prefix, int... numbers) { }
```
**Gotcha:** a method can only have ONE varargs parameter, and it MUST be
the LAST parameter.

### 5. Varargs and overload resolution
Java prefers an EXACT-MATCH overload over a varargs version when both exist:
```java
greet(String name)      // exact match wins for greet("Shasank")
greet(String... names)  // used only when the exact match doesn't fit
```

### 6. Practical built-in varargs examples already used
```java
String.format("Name: %s, Age: %d", name, age); // format args ARE varargs
List.of(1, 2, 3, 4); // List.of() itself is a varargs method
```

## Commands I ran
```bash
javac VarargsDemo.java
java VarargsDemo
```

## Questions / things to revisit
- Why can a method have only ONE varargs parameter, and why must it always be LAST in the parameter list?
- Why does calling `sum(values)` with an actual `int[]` work the exact same way as `sum(1, 2, 3)` - what's actually happening under the hood?
- If BOTH `greet(String name)` and `greet(String... names)` exist and I call `greet("Shasank")`, why does Java pick the specific one instead of the varargs one, even though both COULD technically handle the call?
