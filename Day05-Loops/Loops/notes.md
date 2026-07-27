# Day 05 - Loops

## What I learned

### 1. for loop
Best when you know exactly how many times to repeat:
```java
for (int i = 1; i <= 5; i++) {
    // body
}
```
Three parts: **initialization** (runs once) → **condition** (checked before
every iteration) → **update** (runs after every iteration). Loop continues
as long as the condition is true.

### 2. while loop
Best when the number of iterations isn't known in advance — keeps going
while a condition holds:
```java
int count = 1;
while (count <= 5) {
    // body
    count++;
}
```
**Gotcha:** forgetting to update the loop variable causes an infinite loop.

### 3. do-while loop
Same as `while`, but checks the condition AFTER running the body — so the
body always runs **at least once**, even if the condition is false from
the very start.
```java
do {
    // runs at least once
} while (condition);
```

### 4. break and continue
- `break` → exits the loop completely, skipping all remaining iterations.
- `continue` → skips just the REST of the current iteration, then moves to
  the next one (loop keeps going).

### 5. Nested loops
A loop inside another loop — the inner loop completes ALL its iterations
for every single iteration of the outer loop. Common for grids, patterns,
and multiplication tables.

## Commands I ran
```bash
javac LoopsDemo.java
java LoopsDemo
```

## Questions / things to revisit
- What's a real situation where `do-while` is clearly the right choice over `while` (e.g. menu systems that must show at least once)?
- How many times does the inner loop actually run in a nested loop with outer running N times and inner running M times?
- What happens if I put `continue` inside a nested loop — does it skip the inner loop's current iteration, or the outer one's?
