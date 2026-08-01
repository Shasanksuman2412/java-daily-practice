# Day 16 - Practice Exercises: Collections Framework

Try to solve these YOURSELF first, without looking at CollectionsDemo.java
or Solutions.java.

---

### Exercise 1: Remove duplicates from a List using a Set (Easy-Medium)
Declare:
```java
List<Integer> numbers = new ArrayList<>(List.of(1, 3, 2, 3, 4, 1, 5, 2));
```
Convert it into a `Set` to remove duplicates, then print the unique values
(order doesn't matter).

---

### Exercise 2: Word frequency counter using a Map (Easy-Medium)
Declare `String text = "the cat sat on the mat the cat ran";`
Split it into words and use a `HashMap<String, Integer>` to count how many
times each word appears. Print each word with its count.
(You did something similar back on Day 08 - now do it properly with a real
HashMap and `.getOrDefault()`.)

---

### Exercise 3: Find common elements between two Lists (Medium)
Declare:
```java
List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
List<Integer> list2 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
```
Find and print the elements that appear in BOTH lists.
(Hint: look up `retainAll()` - or do it manually with a loop and `.contains()`.)

---

### Exercise 4: Sort a Map by its values (Medium-Hard)
Declare:
```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 85);
scores.put("Bob", 92);
scores.put("Charlie", 78);
```
Print the names in order from HIGHEST score to LOWEST.
(Hint: this is tricky with plain HashMap - you may need to convert entries
into a List and sort that, or research `Comparator` if you want a
challenge.)

---

### Exercise 5: Student records with a List of Maps (Harder)
Create a `List<Map<String, Object>>` where each Map represents a student
with keys `"name"` and `"marks"`. Add 3 students. Loop through and print
each student's name and marks, then find and print the student with the
HIGHEST marks.

---

## Self-check before moving to Day 17
You should be able to answer these without looking anything up:
- [ ] Why is converting a `List` to a `Set` a quick way to remove duplicates?
- [ ] What does `.getOrDefault(key, 0)` actually do, and why is it useful for counting things in a Map?
- [ ] Why can't you directly "sort a Map" the way you sort a List - what do you need to convert it to first?
- [ ] When would you choose `HashMap` vs `TreeMap` for storing key-value data?

If you're unsure on any of these, revisit `notes.md` before moving to Day 17.
