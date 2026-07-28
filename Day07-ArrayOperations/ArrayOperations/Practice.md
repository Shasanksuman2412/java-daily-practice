# Day 07 - Practice Exercises: Array Operations

Try to solve these YOURSELF first, without looking at ArrayOperationsDemo.java
or Solutions.java.

---

### Exercise 1: Sort in descending order (Easy)
Declare `int[] nums = {34, 7, 23, 89, 12};`
Sort it in DESCENDING order (largest first). `Arrays.sort()` only sorts
ascending by default — you'll need to either sort then reverse, or write
your own comparison loop.

---

### Exercise 2: Bubble sort with a pass counter (Easy-Medium)
Take the bubble sort algorithm from notes.md and modify it to also print
how many SWAPS happened in total. Use `int[] nums = {5, 1, 4, 2, 8};`

---

### Exercise 3: Linear search returning ALL matching indexes (Medium)
Declare `int[] nums = {3, 7, 3, 9, 3, 5};`
Find and print ALL indexes where the value `3` appears (not just the
first one).

---

### Exercise 4: Binary search implemented manually (Medium-Hard)
Without using `Arrays.binarySearch()`, implement binary search yourself
using a `while` loop on a sorted array:
```java
int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
int target = 23;
```
(Hint: keep `low` and `high` pointers, check the middle element, and narrow
the search range based on whether the middle is too big or too small.)

---

### Exercise 5: ArrayList of names (Medium)
Create an `ArrayList<String>` and:
- Add 5 names to it
- Remove one name BY VALUE (not by index) using `.remove("SomeName")`
- Print the final list and its size
- Check if a specific name exists using `.contains()`

---

## Self-check before moving to Day 08
You should be able to answer these without looking anything up:
- [ ] Why must an array be sorted before you can use binary search on it?
- [ ] What's the difference between `list.remove(0)` and `list.remove(Integer.valueOf(0))` for an ArrayList<Integer>? (Tricky one — look this up if unsure!)
- [ ] Why is bubble sort considered inefficient for large arrays compared to binary search for lookups?
- [ ] What happens if you call `Arrays.binarySearch()` on an UNSORTED array — does it error, or just give a wrong answer silently?

If you're unsure on any of these, revisit `notes.md` before moving to Day 08.
