# Day 28 - Design Patterns (Singleton & Builder)

## What I learned

### 1. What's a design pattern?
A reusable, well-known solution to a common software design problem - a
proven APPROACH, not code to copy-paste.

### 2. Singleton Pattern - ensure only ONE instance ever exists
Useful for config managers, logging, database connection pools.
```java
public class ConfigManager {
    private static ConfigManager instance;

    private ConfigManager() { } // PRIVATE - nobody outside can call "new"

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager(); // created only ONCE
        }
        return instance;
    }
}
```
```java
ConfigManager c1 = ConfigManager.getInstance();
ConfigManager c2 = ConfigManager.getInstance();
c1 == c2; // true - the SAME object
```

### 3. Thread-safe Singleton
```java
public static synchronized ConfigManager getInstance() {
    if (instance == null) {
        instance = new ConfigManager();
    }
    return instance;
}
```
`synchronized` prevents two threads from BOTH seeing `instance == null` at
the exact same moment and accidentally creating two separate instances.

### 4. Builder Pattern - constructing complex objects step by step
Useful when a class has MANY optional fields, avoiding an unreadable
multi-parameter constructor.
```java
public class Pizza {
    private Pizza(Builder builder) { ... } // PRIVATE - only Builder can create one

    public static class Builder {
        public Builder addCheese() {
            this.cheese = true;
            return this; // returning "this" allows CHAINING
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
```
```java
Pizza myPizza = new Pizza.Builder("Large")
        .addCheese()
        .addPepperoni()
        .build();
```

### 5. Why these patterns matter
Both solve real, recurring problems - Singleton controls INSTANCE COUNT,
Builder controls CONSTRUCTION COMPLEXITY. Recognizable everywhere once known.

## Commands I ran
```bash
javac ConfigManager.java Pizza.java DesignPatternsDemo.java
java DesignPatternsDemo
```

## Questions / things to revisit
- Why does the Singleton's constructor need to be `private` - what would break if it were public?
- Why does each `Builder` method (`addCheese()`, `addPepperoni()`) `return this;` - what would happen to chaining if it didn't?
- What real problem would happen with a NON-thread-safe Singleton if two threads called `getInstance()` at literally the same instant, for the first time?
