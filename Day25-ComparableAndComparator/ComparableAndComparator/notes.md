# Day 25 - Comparable vs Comparator

We've used `Collections.sort()` and lambda comparators before - today we
properly understand how sorting custom objects actually works.

## What I learned

### 1. The problem
```java
Collections.sort(students); // ERROR without more info -
// Java has no idea what "greater than" means for a custom class
```

### 2. Comparable - defining a class's "natural" sort order
Implemented INSIDE the class, for one obvious default way to sort:
```java
public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks; // ascending by marks
    }
}
```
```java
Collections.sort(students); // now works, uses compareTo()
```
**Return value convention:**
- Negative -> `this` comes before `other`
- Zero -> considered equal for sorting
- Positive -> `this` comes after `other`

### 3. Comparator - external, flexible sorting logic
Use when you need MULTIPLE different sort orders, or can't modify the class:
```java
Comparator<Student> byName = (a, b) -> a.name.compareTo(b.name);
students.sort(byName);
```

### 4. Comparator.comparing() - cleaner built-in helper
```java
students.sort(Comparator.comparing(s -> s.name));
students.sort(Comparator.comparing((Student s) -> s.marks).reversed());
```

### 5. Chaining comparators - sort by multiple fields
```java
students.sort(
    Comparator.comparing((Student s) -> s.marks)
              .thenComparing(s -> s.name)
);
// sorts by marks first, ties broken by name
```

### 6. Comparable vs Comparator - when to use which
- **Comparable**: ONE natural default order, built INTO the class
- **Comparator**: MULTIPLE custom orders, defined EXTERNALLY, doesn't touch
  the class at all - useful when you can't/shouldn't modify the class

## Commands I ran
```bash
javac Student.java ComparableAndComparatorDemo.java
java ComparableAndComparatorDemo
```

## Questions / things to revisit
- Why can a class only implement `Comparable` ONE way (one `compareTo()` method), but have UNLIMITED different `Comparator`s defined externally?
- What does `thenComparing()` actually do if the FIRST comparator already finds a clear winner (non-zero result) - does it even get called?
- Why might you prefer `Comparator` over `Comparable` even for a class you DO have access to modify?
