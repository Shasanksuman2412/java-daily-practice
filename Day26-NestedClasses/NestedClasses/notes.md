# Day 26 - Nested & Inner Classes

## What I learned

### 1. What's a nested class?
A class defined INSIDE another class. Useful when a class only makes sense
in the context of its outer class, or needs tight access to the outer
class's private members.

### 2. Static nested class
Doesn't need an instance of the outer class - can only access the outer
class's STATIC members:
```java
public class Outer {
    static class StaticNested {
        void display() { ... }
    }
}
```
```java
Outer.StaticNested nested = new Outer.StaticNested(); // no Outer instance needed
```

### 3. Inner class (non-static)
Requires an ACTUAL instance of the outer class - tied to a SPECIFIC outer
object, and can access that object's instance fields directly:
```java
public class Outer {
    class Inner {
        void display() { ... }
    }
}
```
```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner(); // unusual syntax - needs an Outer instance!
```

### 4. Local class - defined inside a method
```java
void someMethod() {
    class LocalHelper {
        void help() { ... }
    }
    LocalHelper helper = new LocalHelper();
}
```
Only exists within that method's scope.

### 5. Anonymous class - no name, one-time use
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Anonymous implementation");
    }
};
```
Used for a quick, one-off implementation without creating a whole separate
named class - we actually used this back on Day 19 without naming it.

### 6. Static nested vs Inner - the key difference
- **Static nested**: independent of any outer instance, can only access
  outer STATIC members
- **Inner (non-static)**: tied to a SPECIFIC outer instance, can access
  outer INSTANCE members too

## Commands I ran
```bash
javac Outer.java NestedClassesDemo.java
java NestedClassesDemo
```

## Questions / things to revisit
- Why can't a `static class StaticNested` access `outerInstanceField` directly - what would it even mean to access an instance field with no instance?
- Why does creating an Inner class need the unusual `outer.new Inner()` syntax instead of just `new Inner()`?
- When would I actually reach for a Local class or Anonymous class instead of just writing a separate top-level class?
