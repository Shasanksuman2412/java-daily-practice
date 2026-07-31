# Day 13 - Polymorphism

## What I learned

"Poly" = many, "morph" = forms. The same method call behaves differently
depending on the ACTUAL object type, even through a common parent reference.

### 1. Two types of polymorphism

**Compile-time (static) = method overloading** (from Day 09):
```java
add(int a, int b)
add(double a, double b)
```
Java decides which version to call AT COMPILE TIME, based on argument types.

**Runtime (dynamic) = method overriding** (from Day 12):
```java
Animal a = new Dog("Rex");
a.makeSound(); // decided AT RUNTIME, based on the ACTUAL object (Dog)
```
This is the more powerful, more important kind.

### 2. Upcasting and downcasting
**Upcasting** - treating a child object as its parent type. Always safe,
happens automatically:
```java
Animal a = new Dog("Rex"); // Dog "upcast" to an Animal reference
```

**Downcasting** - going back from a parent reference to the specific child
type. Must be explicit, and risky if the actual object isn't really that type:
```java
if (a instanceof Dog) {
    Dog d = (Dog) a; // safe, since we checked first
    d.fetch();       // now Dog-specific methods are available
}
```
**Gotcha:** downcasting without checking `instanceof` first can throw a
`ClassCastException` at runtime if the object isn't actually that type.

### 3. Why polymorphism actually matters
Write flexible code that works with a whole FAMILY of related objects,
without knowing their exact type:
```java
Animal[] animals = { new Dog("Rex"), new Cat("Milo") };
for (Animal a : animals) {
    a.makeSound(); // works correctly for ANY subclass, current or future
}
```
Adding a new subclass later (like `Bird`) means this loop still works with
ZERO changes - that's the real power of polymorphism.

### 4. instanceof operator
Checks if an object is of a specific type at runtime:
```java
a instanceof Dog    // true if a is actually a Dog
a instanceof Animal // true - Dog IS-A Animal (inheritance relationship)
```

## Commands I ran
```bash
javac Animal.java Dog.java Cat.java PolymorphismDemo.java
java PolymorphismDemo
```

## Questions / things to revisit
- Why is method overloading decided at COMPILE time but overriding at RUNTIME - what's actually different about how Java handles each?
- What specific error does an unsafe downcast throw, and when would you actually WANT to risk it without checking `instanceof` first?
- If a method exists in BOTH Animal and Dog (overridden), and I have `Animal a = new Dog(...)`, can I ever call Animal's original version through `a`? (Hint: think about `super` from inside Dog vs from outside.)
