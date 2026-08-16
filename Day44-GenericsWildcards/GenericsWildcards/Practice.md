# Day 44 - Practice Exercises: Generics Wildcards

Try to solve these YOURSELF first, without looking at
GenericsWildcardsDemo.java or Solutions.java.

---

### Exercise 1: Write a method using ? extends (Easy-Medium)
Write a method `static double average(List<? extends Number> list)` that
calculates the average of any numeric list. Test with a `List<Integer>`
and a `List<Double>`, confirming both work with the SAME method.

---

### Exercise 2: Write a method using ? super (Easy-Medium)
Write a method `static void fillWithZeros(List<? super Integer> list, int count)`
that adds `count` zeros to the list. Test with `List<Integer>`,
`List<Number>`, and `List<Object>` as the target.

---

### Exercise 3: Apply PECS to a copy method (Medium)
Write your own generic method
`static <T> void copyMatching(List<? extends T> src, List<? super T> dest, T filterValue)`
that copies only elements from `src` EQUAL to `filterValue` into `dest`.
Test with a `List<String>` source, filtering for one specific value, into
a `List<Object>` destination.

---

### Exercise 4: Explain why a wildcard fails to compile (Medium-Hard)
Given `static void addFive(List<? extends Number> list) { list.add(5); }`
- this will NOT compile. Explain in a comment WHY (think about what
COULD be inside a `List<? extends Number>` - could it secretly be a
`List<Double>`? What would adding an Integer to that do?). Then fix the
method signature so it DOES compile and correctly adds 5.

---

### Exercise 5: Build a generic "max finder" using bounded wildcards (Harder)
Write `static <T extends Comparable<? super T>> T findMax(List<? extends T> list)`
that finds the maximum element using `compareTo()`. This is a genuinely
advanced signature - break down in a comment what EACH wildcard/bound is
doing and why it's needed. Test with a `List<Integer>` and a `List<String>`.

---

## Self-check before moving to Day 45
You should be able to answer these without looking anything up:
- [ ] In Exercise 4, if `List<? extends Number> list` could secretly be a `List<Double>` behind the scenes, why would `list.add(5)` (an Integer) be dangerous to allow?
- [ ] Why does Exercise 3's method need BOTH `? extends T` (for src) AND `? super T` (for dest) in the SAME method signature - what would break if both were the same direction?
- [ ] In Exercise 5, why does the bound need to be `Comparable<? super T>` instead of just `Comparable<T>` - what extra flexibility does the `? super` add here?
- [ ] When would you choose an UNBOUNDED wildcard `<?>` over a specific bounded one like `<? extends Number>`?

If you're unsure on any of these, revisit `notes.md` before moving to Day 45.
