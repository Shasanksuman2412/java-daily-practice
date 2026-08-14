# Day 38 - Optional Deep Dive

We've used `Optional<Student>` a few times before (Day 20, Day 30) without
fully explaining it - today goes deep.

## What I learned

### 1. The problem Optional solves
```java
Student student = findStudentById(999); // doesn't exist
student.getName(); // NullPointerException!
```
`null` is dangerous - nothing in the method signature warns you it might
happen, you only find out when it crashes.

### 2. Creating an Optional
```java
Optional<String> present = Optional.of("Hello");         // wraps a KNOWN non-null value
Optional<String> empty = Optional.empty();                 // explicitly "nothing"
Optional<String> maybeNull = Optional.ofNullable(getValue()); // safe - handles null automatically
```
**Gotcha:** `Optional.of(null)` throws NullPointerException immediately -
use `ofNullable()` when unsure.

### 3. Checking and safely retrieving values
```java
opt.isPresent();  // true if a value exists
opt.isEmpty();    // opposite check

if (opt.isPresent()) {
    opt.get(); // only call .get() AFTER checking!
}
```
**Gotcha:** `.get()` on an empty Optional throws `NoSuchElementException` -
it doesn't prevent the crash, just makes the risk explicit.

### 4. The better way - avoid .get() entirely
```java
opt.ifPresent(name -> ...);              // only runs if present
opt.orElse("Default Name");               // fallback value if empty
opt.orElseGet(() -> computeDefault());     // fallback computed LAZILY, only if needed
opt.orElseThrow(() -> new IllegalStateException("..."));
```

### 5. Chaining transformations - map() and filter()
```java
Optional<String> upper = name.map(String::toUpperCase); // transforms IF present
Optional<String> longName = name.filter(n -> n.length() > 10); // empty if condition fails
```

### 6. Using Optional as a return type - the real intended use
```java
Optional<Student> findByRollNumber(int rollNumber) {
    // ...
    return Optional.empty(); // forces the caller to handle "not found"
}
```
```java
findByRollNumber(101).ifPresentOrElse(
    s -> System.out.println("Found: " + s),
    () -> System.out.println("Not found")
);
```

### 7. What NOT to do with Optional
- Don't use it as a FIELD type in a class
- Don't use it as a METHOD PARAMETER type
- Don't call `.get()` without checking first - defeats the whole purpose

## Commands I ran
```bash
javac Student.java OptionalDeepDiveDemo.java
java OptionalDeepDiveDemo
```

## Questions / things to revisit
- Why does `orElseGet()` take a LAMBDA (computed lazily) while `orElse()` takes a plain value (computed immediately, even if unused) - when would this difference actually matter for performance?
- Why is `Optional` considered bad practice as a class FIELD type, even though it works fine as a RETURN type?
- What's the real difference between checking `isPresent()` first vs just calling `.orElse()`/`.orElseThrow()` directly - which approach is generally preferred, and why?
