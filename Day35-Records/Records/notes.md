# Day 35 - Records (Modern Java)

## What I learned

### 1. The problem records solve
Day 27's `Book` class needed a manual constructor, getters, equals(),
hashCode(), and toString() - all boilerplate for a simple data holder.

### 2. Records - all of that in one line
```java
public record Point(int x, int y) {
}
```
Java automatically generates:
- A constructor
- Getters called `x()` and `y()` (NOT `getX()`/`getY()` - no "get" prefix)
- `equals()`, `hashCode()`, and `toString()`, all based on the fields

```java
Point p1 = new Point(3, 4);
p1.x();        // 3
p1;            // Point[x=3, y=4]
p1.equals(new Point(3, 4)); // true - proper content comparison, for free
```

### 3. Records are immutable by design
```java
Point p = new Point(3, 4);
// p.x = 10; // ERROR - no such thing exists, no setters at all
```
No way to change a record's fields after creation - intentional.

### 4. Custom validation with a compact constructor
```java
public record Point(int x, int y) {
    public Point { // "compact" constructor - no parameter list repeated
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates cannot be negative");
        }
    }
}
```

### 5. Records can have additional methods
```java
public record Point(int x, int y) {
    double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
```

### 6. Records can implement interfaces
```java
public record Point(int x, int y) implements Comparable<Point> {
    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.x, other.x);
    }
}
```

### 7. When to use a record vs a regular class
- **Record**: simple, immutable data carriers - coordinates, DTOs, result tuples
- **Regular class**: mutable state needed, inheritance needed (records
  can't `extends` another class), or complex internal behavior

## Commands I ran
```bash
javac Point.java ValidatedPoint.java ComparablePoint.java OldStylePoint.java RecordsDemo.java
java RecordsDemo
```

## Questions / things to revisit
- Why are record getters named `x()` instead of `getX()` - is this just a style choice, or does it signal something about records being different from regular classes?
- Why can't a record `extends` another class - what design decision is Java making by disallowing this?
- In the compact constructor, why don't you need to write `this.x = x;` yourself - what does Java do automatically after the validation code runs?
