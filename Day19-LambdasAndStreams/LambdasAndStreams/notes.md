# Day 19 - Lambda Expressions & Streams

## What I learned

### 1. What's a lambda expression?
A short, anonymous way to write a function inline - no class, no method
name, just the logic. Introduced in Java 8.
```java
// old way
Runnable oldWay = new Runnable() {
    public void run() { System.out.println("Running!"); }
};

// lambda way
Runnable newWay = () -> System.out.println("Running!");
```

### 2. Functional interfaces
A lambda works because it matches an interface with EXACTLY ONE abstract
method:
```java
interface Greet {
    void sayHello(String name);
}

Greet g = (name) -> System.out.println("Hello, " + name);
```

### 3. Built-in functional interfaces (java.util.function)
Rarely need to write your own - Java provides common ones:
```java
Function<Integer, Integer> square = x -> x * x;
square.apply(5); // 25

Predicate<Integer> isEven = x -> x % 2 == 0;
isEven.test(4); // true

Consumer<String> printer = s -> System.out.println("Value: " + s);
printer.accept("hello");
```

### 4. Streams - processing collections functionally
Chain operations (filter, transform, collect) on a collection in a
readable pipeline:
```java
List<Integer> evenSquares = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * n)
        .collect(Collectors.toList());
```

### 5. Common stream operations
```java
numbers.stream().filter(n -> n > 5).count();           // how many match
numbers.stream().anyMatch(n -> n > 8);                   // any match at all?
numbers.stream().sorted().forEach(System.out::println);  // sort + print
numbers.stream().reduce(0, (a, b) -> a + b);             // combine into one value
```
**Gotcha:** streams are ONE-TIME USE - once a terminal operation like
`.collect()` or `.forEach()` runs, that stream is done and can't be reused.

### 6. Method references (::)
Shorthand for a lambda that just calls an existing method:
```java
numbers.stream().forEach(System.out::println);
// equivalent to: numbers.stream().forEach(n -> System.out.println(n));
```

## Commands I ran
```bash
javac Greet.java LambdasAndStreamsDemo.java
java LambdasAndStreamsDemo
```

## Questions / things to revisit
- Why must a functional interface have EXACTLY ONE abstract method - what would happen if it had two?
- What's the practical difference between `.map()` and `.filter()` in a stream pipeline - one transforms, one selects, but why does the order I chain them in matter?
- Why can't I reuse the same stream twice after calling `.collect()` on it once - what happens if I try?
