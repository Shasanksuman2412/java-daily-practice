# Day 14 - Abstraction

This completes the four pillars of OOP: Encapsulation (11), Inheritance
(12), Polymorphism (13), and now Abstraction.

## What I learned

### 1. What is abstraction?
Hiding HOW something works, exposing only WHAT it does. Define a contract -
"any class of this type MUST have these methods" - without necessarily
saying how each one works internally.

### 2. Abstract classes
Cannot be instantiated directly (`new Shape()` is illegal) - exists only to
be extended.
```java
public abstract class Shape {
    abstract double area(); // no body - subclasses MUST implement this

    void display() {         // regular method, CAN have a body
        System.out.println("Area: " + area());
    }
}
```

### 3. Extending an abstract class
```java
public class Circle extends Shape {
    @Override
    double area() { // MUST provide this, or Circle becomes abstract too
        return Math.PI * radius * radius;
    }
}
```

### 4. Interfaces - a pure contract
Defines ONLY what methods must exist, no implementation. A class
IMPLEMENTS an interface instead of extending it:
```java
public interface Drawable {
    void draw(); // no body - every implementing class MUST define this
}

public class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
```

### 5. Abstract class vs Interface - when to use which
- **Abstract class**: classes share SOME common code plus things that must
  differ. Supports fields, constructors, regular methods. A class can
  extend only ONE abstract class.
- **Interface**: pure "must have this behavior" contract, often shared
  across UNRELATED classes. A class can implement MULTIPLE interfaces.

### 6. A class can do both
```java
public class Circle extends Shape implements Drawable {
    // must implement area() (from Shape) AND draw() (from Drawable)
}
```

## Commands I ran
```bash
javac Shape.java Drawable.java Circle.java Square.java AbstractionDemo.java
java AbstractionDemo
```

## Questions / things to revisit
- Why can't you create `new Shape()` directly, but you CAN create `new Circle()` even though Circle inherited an abstract method?
- Why can a class implement MULTIPLE interfaces but extend only ONE class/abstract class - what problem does this avoid?
- If Shape's `display()` method isn't abstract, why does it still work correctly for both Circle and Square (calling the right `area()` each time)?
