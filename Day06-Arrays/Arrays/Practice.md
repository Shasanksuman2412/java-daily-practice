# Day 06 - Practice Exercises: Arrays

Try to solve these YOURSELF first, without looking at ArraysDemo.java or
Solutions.java.

---

### Exercise 1: Print in reverse (Easy)
Declare `int[] nums = {10, 20, 30, 40, 50};`
Print the elements in REVERSE order using a regular for loop (don't just
retype them — loop backwards through the array using the index).

---

### Exercise 2: Count even and odd numbers (Easy-Medium)
Declare `int[] nums = {12, 7, 22, 9, 4, 15, 30};`
Loop through and count how many numbers are even vs odd. Print both counts.

---

### Exercise 3: Second largest element (Medium)
Declare `int[] nums = {45, 89, 23, 67, 89, 12};`
Find and print the SECOND largest DISTINCT value in the array (not just the
second position — think about what happens with duplicates like the two 89s
here).

---

### Exercise 4: Reverse an array in place (Medium-Hard)
Declare `int[] nums = {1, 2, 3, 4, 5};`
Reverse the array IN PLACE (modify the same array, don't create a new one)
by swapping elements from both ends toward the middle. Print the array
before and after.

(Hint: swap index 0 with the last index, index 1 with second-to-last, and
so on, stopping at the middle.)

---

### Exercise 5: 2D array row and column sums (Harder)
Declare:
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```
Print the sum of each ROW, and separately the sum of each COLUMN.

---

## Self-check before moving to Day 07
You should be able to answer these without looking anything up:
- [ ] Why does looping to `i < array.length` (not `<=`) avoid an ArrayIndexOutOfBoundsException?
- [ ] How would you loop through an array backwards — what does the loop header look like?
- [ ] In a 2D array, what does `matrix[row].length` actually give you vs `matrix.length`?
- [ ] Why can't a for-each loop easily reverse an array in place?

If you're unsure on any of these, revisit `notes.md` before moving to Day 07.
