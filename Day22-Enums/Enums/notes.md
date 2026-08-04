# Day 22 - Enums

## What I learned

### 1. What's an enum?
A special type representing a FIXED set of constants, giving type safety
instead of error-prone Strings or ints.
```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

### 2. Why not just use Strings or ints?
```java
String status = "ACTIV"; // typo - compiler has NO idea this is wrong

Status status = Status.ACTIVE; // compiler catches typos immediately
```

### 3. Using enums in switch
```java
switch (today) {
    case MONDAY:
        // ...
        break;
    default:
        // ...
}
```
Note: no need to write `Day.MONDAY` inside the switch cases, just `MONDAY`.

### 4. Enums can have fields, constructors, and methods
Enums aren't just labels - they're actually full classes under the hood:
```java
public enum Planet {
    EARTH(5.97e24, 6371000);

    private final double mass;
    private final double radius;

    Planet(double mass, double radius) { // implicitly private constructor
        this.mass = mass;
        this.radius = radius;
    }

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
}
```

### 5. Useful built-in enum methods
```java
day.name();          // "WEDNESDAY" as a String
day.ordinal();        // position in the list, starting at 0
Day.values();          // array of ALL enum constants, for looping
Day.valueOf("FRIDAY"); // String -> matching enum constant
```

## Commands I ran
```bash
javac Day.java Planet.java EnumsDemo.java
java EnumsDemo
```

## Questions / things to revisit
- Why is an enum constructor always implicitly `private` - can you ever call `new Planet(...)` yourself from outside the enum?
- What would `Day.valueOf("Friday")` (lowercase) do - does it work, or throw an error? Why does case matter here?
- Why does using an enum in a `switch` statement not require writing `Day.MONDAY` in each case, just `MONDAY`?
