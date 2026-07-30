# Day 12 - Inheritance

## What I learned

### 1. Why inheritance?
When multiple classes share common fields/methods, put the shared stuff in
one PARENT (super) class, and let CHILD (sub) classes inherit from it -
avoids repeating code.

### 2. Basic syntax - extends
```java
public class Animal {
    String name;
    void eat() { ... }
}

public class Dog extends Animal {
    void bark() { ... }
}
```
`Dog` gets everything `Animal` has (fields + methods), PLUS its own
additions like `bark()`.

### 3. The super keyword
Refers to the PARENT class. Used to:
- Call the parent's constructor: `super(name);`
- Call the parent's version of a method: `super.makeSound();`

### 4. Method overriding
A child class can REDEFINE a parent's method to behave differently:
```java
@Override
void makeSound() {
    System.out.println("Woof!");
}
```
`@Override` isn't strictly required, but it's good practice - Java warns you
if it doesn't actually match a parent method (catches typos).

### 5. Calling the parent's version from inside an override
```java
@Override
void makeSound() {
    super.makeSound(); // still runs the parent's version first
    System.out.println("Woof!"); // then adds its own behavior
}
```

### 6. Single inheritance only
A Java class can only `extends` ONE parent class - keeps the hierarchy
simple, avoids ambiguity that multiple inheritance can cause.

### 7. Polymorphism preview
```java
Animal a = new Dog("Buddy"); // an Animal REFERENCE pointing to a Dog OBJECT
a.makeSound(); // still calls Dog's overridden version, not Animal's!
```
Java looks at the ACTUAL object type at runtime to decide which overridden
method to run, not the reference type. We'll go deeper into this soon.

## Commands I ran
```bash
javac Animal.java Dog.java Cat.java InheritanceDemo.java
java InheritanceDemo
```

## Questions / things to revisit
- Why does `Animal a = new Dog("Buddy"); a.makeSound();` call Dog's version, not Animal's - what's actually happening at runtime?
- What's the difference between `protected` and `private` for the `name` field - why did Animal use `protected` this time instead of `private`?
- Can a subclass override a method and make it MORE restrictive in visibility (e.g. public -> private)? Why or why not?
