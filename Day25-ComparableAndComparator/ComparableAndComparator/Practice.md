# Day 25 - Practice Exercises: Comparable vs Comparator

Try to solve these YOURSELF first, without looking at Student.java,
ComparableAndComparatorDemo.java, or Solutions.java.

---

### Exercise 1: Make a `Product` class Comparable (Easy-Medium)
Create a class `Product` with fields `name` (String) and `price` (double).
Implement `Comparable<Product>` so the natural order sorts by price,
ascending. Create a `List<Product>` with 4 products, sort it with
`Collections.sort()`, and print the result.

---

### Exercise 2: Sort the same list multiple different ways (Easy-Medium)
Using your `Product` list from Exercise 1, sort it THREE different ways
using `Comparator` lambdas (not touching the class itself):
- By name (alphabetical)
- By price descending
- By name length (shortest first)

Print the list after each sort.

---

### Exercise 3: Comparator.comparing() with reversed() (Medium)
Redo the "by price descending" sort from Exercise 2, but this time using
`Comparator.comparing(...).reversed()` instead of a custom lambda.
Confirm you get the same result both ways.

---

### Exercise 4: Chain comparators for a tie-breaker (Medium-Hard)
Create a `List<Product>` where at least TWO products have the exact same
price. Sort the list by price ascending, with name as a tie-breaker (use
`thenComparing`). Confirm products with equal prices appear in alphabetical
order relative to each other.

---

### Exercise 5: Sort a List of Lists using a custom Comparator (Harder)
Declare:
```java
List<List<Integer>> groups = new ArrayList<>();
groups.add(List.of(5, 2, 8));
groups.add(List.of(1));
groups.add(List.of(3, 3, 3, 3));
```
Sort `groups` by the SIZE of each inner list, smallest first, using a
Comparator. Print the sorted result.
(Hint: `Comparator.comparing(list -> list.size())` or a method reference
`Comparator.comparingInt(List::size)`.)

---

## Self-check before moving to Day 26
You should be able to answer these without looking anything up:
- [ ] Why does `Collections.sort(products)` fail to compile if `Product` doesn't implement `Comparable`, but `products.sort(someComparator)` works fine regardless?
- [ ] In Exercise 4, what would happen if you DIDN'T chain `thenComparing` - what order would equal-price products end up in?
- [ ] Why is `Comparator.comparingInt(List::size)` preferred over `Comparator.comparing(list -> list.size())` for primitives like int - is there an actual difference, or just style?
- [ ] Could a single class implement `Comparable` AND also be sorted with a completely different `Comparator` at the same time? Are these mutually exclusive?

If you're unsure on any of these, revisit `notes.md` before moving to Day 26.
