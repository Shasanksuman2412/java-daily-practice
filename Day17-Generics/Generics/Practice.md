# Day 17 - Practice Exercises: Generics

Try to solve these YOURSELF first, without looking at Box.java, Pair.java,
GenericsDemo.java, or Solutions.java.

---

### Exercise 1: Generic `Stack` class (Easy-Medium)
Create a generic class `Stack<T>` with:
- A `List<T> items` field (use `ArrayList` internally)
- `void push(T item)` - adds an item to the end
- `T pop()` - removes and returns the LAST item added
- `boolean isEmpty()` - returns true if no items remain

Test it with a `Stack<Integer>` and a `Stack<String>`.

---

### Exercise 2: Generic method to find the max of an array (Medium)
Write a generic method:
```java
public static <T extends Comparable<T>> T findMax(T[] array) {
    // ...
}
```
It should work for `Integer[]`, `Double[]`, and `String[]` arrays (Strings
compare alphabetically). Test with all three types.
(Hint: `Comparable<T>` gives you `.compareTo()` to compare two T values.)

---

### Exercise 3: Generic `Pair` swap method (Easy-Medium)
Using the `Pair<K, V>` class from today, write a method:
```java
public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
    // returns a NEW Pair with key and value swapped
}
```
Test it with `Pair<String, Integer>` and confirm the result is a
`Pair<Integer, String>`.

---

### Exercise 4: Generic class with a bounded type (Medium-Hard)
Create a class `NumberBox<T extends Number>` with:
- A field `T value`
- A method `double doubled()` that returns `value.doubleValue() * 2`

Test it with `NumberBox<Integer>` and `NumberBox<Double>`.
(This shows why bounding matters - without `extends Number`, you couldn't
call `.doubleValue()` on just any T.)

---

### Exercise 5: Generic `Box<T>` holding a `List<T>` (Harder)
Modify (or create a new version of) `Box<T>` so instead of holding ONE
item, it holds a `List<T>` of multiple items:
- `void add(T item)` - adds to the list
- `T getFirst()` - returns the first item
- `int count()` - returns how many items are stored

Test it with a `Box<String>` holding 3 names.

---

## Self-check before moving to Day 18
You should be able to answer these without looking anything up:
- [ ] Why does `findMax` need `<T extends Comparable<T>>` instead of just `<T>` - what would break without that bound?
- [ ] In Exercise 3, why does `swap()` return `Pair<V, K>` instead of `Pair<K, V>`?
- [ ] Why can't `NumberBox<String>` compile, given the class is `NumberBox<T extends Number>`?
- [ ] What's the practical difference between a generic CLASS (`Box<T>`) and a generic METHOD (`<T> void printArray(T[] arr)`) - when would you use one over the other?

If you're unsure on any of these, revisit `notes.md` before moving to Day 18.
