# Day 37 - Sealed Classes

Connects directly to Day 36 - remember how pattern-matching switches
always needed a `default` case, even after listing every subclass? Sealed
classes fix that.

## What I learned

### 1. The problem
```java
public abstract class Shape { }
public class Circle extends Shape { }
```
Nothing stops someone from writing a NEW `Triangle extends Shape` in
another file - Java has no way to know "these are ALL the subclasses." So
pattern-matching switches always needed a `default`, just in case.

### 2. Sealed classes - explicitly restrict who can extend you
```java
public sealed abstract class Shape permits Circle, Square, Triangle {
}
```
Says: ONLY Circle, Square, and Triangle are allowed to extend Shape -
nothing else, ever.

### 3. Permitted subclasses must be final, sealed, or non-sealed
Each subclass must explicitly declare how far the sealing continues:
- `final` - the end of the line, no further subclasses
- `sealed` - this subclass has its OWN restricted set of children
- `non-sealed` - this subclass REOPENS things, anyone can extend IT

### 4. The payoff: exhaustive pattern matching, no default needed
```java
static String describe(Shape s) {
    return switch (s) {
        case Circle c -> "...";
        case Square sq -> "...";
        case Triangle t -> "...";
        // NO default - compiler KNOWS these are the only options
    };
}
```
If a subclass is added later but a case is forgotten, the code WON'T EVEN
COMPILE - caught immediately instead of slipping through.

### 5. non-sealed - deliberately reopening a branch
```java
public non-sealed class Triangle extends Shape { } // ANYONE can extend Triangle now
```
Useful when most of a hierarchy should stay controlled, but one branch
genuinely needs external extension.

### 6. Sealed + records - a very common modern combo
```java
public sealed interface PaymentMethod permits CreditCard, Cash, Crypto { }
record CreditCard(...) implements PaymentMethod { }
```
Records are implicitly `final`, making this combination extremely popular
for clean, exhaustive, immutable data hierarchies.

## Commands I ran
```bash
javac Shape.java Circle.java Square.java Triangle.java RightTriangle.java PaymentMethod.java SealedClassesDemo.java
java SealedClassesDemo
```

## Questions / things to revisit
- Why does the compiler REQUIRE every permitted subclass to explicitly say `final`, `sealed`, or `non-sealed` - why isn't there a sensible default?
- In the demo, why does `describeShape()` NOT need a `default` case, but a switch over a NON-sealed type (like `Object`) always would?
- Why might a team choose `non-sealed` for ONE branch (like Triangle) while keeping the rest of the hierarchy fully sealed?
