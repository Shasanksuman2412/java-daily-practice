# Day 04 - Conditionals

## What I learned

### 1. if / else if / else
Lets the program make decisions. Java checks conditions top to bottom and
runs the FIRST one that's true — the rest are skipped even if they'd also
be true.
```java
if (marks >= 90) {
    // Grade A
} else if (marks >= 75) {
    // Grade B
} else {
    // Fail
}
```

### 2. Nested conditionals
An `if` inside another `if`, used when a decision depends on more than one
condition:
```java
if (age >= 18) {
    if (hasID) {
        // allowed
    } else {
        // need ID
    }
} else {
    // too young
}
```

### 3. Ternary operator
A shortcut for a simple if/else that returns a value:
```java
String result = (marks >= 40) ? "Pass" : "Fail";
```
Reads as: *condition ? value-if-true : value-if-false*.
Good for simple one-value decisions — avoid nesting these, it gets unreadable fast.

### 4. switch statement
Cleaner than a long if-else chain when checking ONE variable against many
exact values:
```java
switch (day) {
    case 1:
        // Monday
        break;
    default:
        // invalid
}
```

### 5. The `break` gotcha (fall-through)
Without `break`, execution "falls through" into the NEXT case even if it
doesn't match:
```java
switch (2) {
    case 1: System.out.println("one");
    case 2: System.out.println("two");   // matches, no break
    case 3: System.out.println("three"); break; // falls through here too
    case 4: System.out.println("four");
}
// prints "two" AND "three"
```

## Commands I ran
```bash
javac ConditionalsDemo.java
java ConditionalsDemo
```

## Questions / things to revisit
- When is fall-through actually USEFUL (e.g. grouping multiple cases with shared logic) instead of a bug?
- How does Java's newer switch expression (`->` syntax) avoid the fall-through problem entirely?
- At what point does nested if/else become hard to read, and how would I refactor it?
