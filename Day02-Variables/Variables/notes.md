# Day 02 - Variables & Data Types

## What I learned

### 1. What is a variable?
A named box in memory that holds a value. Java is **statically typed** — every
variable must have a declared type, fixed at compile time, and it can't change
later.

```java
int age = 21;
```
`int` = type, `age` = name, `21` = value.

### 2. Java's 8 primitive types

| Type      | Size    | Holds                          | Example                          |
|-----------|---------|---------------------------------|-----------------------------------|
| byte      | 1 byte  | small whole numbers (-128–127) | `byte b = 100;`                  |
| short     | 2 bytes | bigger whole numbers           | `short s = 30000;`               |
| int       | 4 bytes | whole numbers (most common)    | `int x = 42;`                    |
| long      | 8 bytes | very large whole numbers       | `long l = 15000000000L;` (note `L`) |
| float     | 4 bytes | decimals, less precision       | `float f = 3.14f;` (note `f`)    |
| double    | 8 bytes | decimals, more precision (default) | `double d = 3.14159;`        |
| char      | 2 bytes | a single character              | `char c = 'A';`                  |
| boolean   | 1 bit   | true/false                      | `boolean flag = true;`           |

### 3. Reference types
`String`, arrays, and objects hold a **reference** to an object in memory,
not the raw value directly.
```java
String name = "Shasank";
```

### 4. Type casting
- **Widening (implicit, safe):** `int` → `long` → `double` happens automatically.
- **Narrowing (explicit, risky):** `double` → `int` needs a manual cast and can
  lose data (truncates, doesn't round).
```java
double d = 9.7;
int i = (int) d;   // i = 9, decimal part dropped
```

### 5. `final` keyword
Used to declare constants — once assigned, the value cannot be changed.
```java
final double PI = 3.14159;
```

## Commands I ran
```bash
javac VariablesDemo.java
java VariablesDemo
```

## Questions / things to revisit
- Why does `float` need an `f` suffix but `double` doesn't need anything?
- What actually happens in memory during narrowing (bit truncation)?
- When would I actually choose `float` over `double` in real code?
