# Day 36 - Pattern Matching (Modern Java)

## What I learned

### 1. The old way: instanceof + manual casting (Day 13 style)
```java
if (shape instanceof Circle) {
    Circle c = (Circle) shape; // separate cast line
}
```

### 2. Pattern matching for instanceof - combines check and cast
```java
if (shape instanceof Circle c) { // "c" is automatically available, already cast
    System.out.println(c.getRadius()); // no separate cast needed!
}
```
The variable `c` only exists inside the `if` block where the check
succeeded - Java handles the scoping.

### 3. Combining with additional conditions
```java
if (shape instanceof Circle c && c.getRadius() > 10) {
    // c is usable here too
}
```

### 4. Switch expressions - cleaner than switch statements
```java
String dayType = switch (day) {
    case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
    case SATURDAY, SUNDAY -> "Weekend";
};
```
No `break` needed, no fall-through risk, and it directly PRODUCES a value.

### 5. Pattern matching for switch - matching on type
```java
String result = switch (obj) {
    case Integer i -> "An integer: " + i;
    case String s -> "A string of length " + s.length();
    default -> "Something else";
};
```
Replaces long instanceof/if-else chains for type-based branching.

### 6. Combining with a "when" guard clause
```java
switch (obj) {
    case Integer i when i < 0 -> "Negative integer";
    case Integer i when i == 0 -> "Zero";
    case Integer i -> "Positive integer";
    default -> "Not an integer";
};
```

### 7. Why this matters
Less boilerplate, fewer casting mistakes, and the compiler can help verify
cases are covered - this is where modern Java is actively heading.

## Commands I ran
```bash
javac Shape.java Circle.java Square.java Weekday.java PatternMatchingDemo.java
java PatternMatchingDemo
```

## Questions / things to revisit
- Why does the pattern-matched variable (like `c` in `shape instanceof Circle c`) only exist WITHIN the scope where the check succeeded, and not outside the `if` block?
- Why does a `switch` EXPRESSION (using `->`) not need `break` statements, while the old `switch` STATEMENT (using `:`) does?
- What's the difference between `case Integer i ->` and `case Integer i when i < 0 ->` - what extra power does the `when` clause add?
