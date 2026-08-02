# Day 17 - Generics

We've been using `List<String>`, `Map<String, Integer>` for days without
explaining the `<>` part - today we fix that.

## What I learned

### 1. Why generics exist
Without generics, collections stored `Object` (anything), forcing casts
back, and mistakes only showed up at RUNTIME:
```java
List oldList = new ArrayList(); // pre-generics, unsafe
oldList.add("hello");
oldList.add(42); // no error allowed here!
String s = (String) oldList.get(1); // crashes at RUNTIME
```
Generics let you specify the type UP FRONT - the compiler catches mistakes
immediately, before the program even runs:
```java
List<String> names = new ArrayList<>();
names.add(42); // COMPILE ERROR - caught immediately
```

### 2. Generic classes
```java
public class Box<T> {  // T = placeholder type, chosen when Box is created
    private T content;
    void set(T content) { this.content = content; }
    T get() { return content; }
}
```
```java
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String value = stringBox.get(); // NO casting needed
```

### 3. Generic methods
```java
public static <T> void printArray(T[] array) {
    for (T item : array) {
        System.out.println(item);
    }
}
```
Same method works for `Integer[]`, `String[]`, or any other type.

### 4. Multiple type parameters
```java
public class Pair<K, V> {
    private K key;
    private V value;
    // constructor, getKey(), getValue()
}
```
```java
Pair<String, Integer> p = new Pair<>("age", 21);
```

### 5. Bounded type parameters
Restrict T to only certain types using `extends`:
```java
public static <T extends Number> double sum(T a, T b) {
    return a.doubleValue() + b.doubleValue(); // guaranteed to work, T IS a Number
}
```
This means `sum(5, 10)` and `sum(3.5, 2.1)` both work, but `sum("a", "b")`
won't even compile.

## Commands I ran
```bash
javac Box.java Pair.java GenericsDemo.java
java GenericsDemo
```

## Questions / things to revisit
- Why couldn't the old pre-generics code catch the `String`/`Integer` mixup until RUNTIME, but generics catch it at COMPILE time?
- What does `<T extends Number>` actually restrict - can T be a String? Can it be an Integer or Double?
- Why is `Box<String>` and `Box<Integer>` still considered the "same class" (Box) even though they behave differently - what's actually happening at compile time vs runtime (type erasure)?
