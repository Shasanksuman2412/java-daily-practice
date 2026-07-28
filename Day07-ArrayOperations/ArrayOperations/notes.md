# Day 07 - Array Operations

## What I learned

### 1. Built-in sort
```java
import java.util.Arrays;

int[] nums = {5, 2, 8, 1, 9};
Arrays.sort(nums); // sorts in place, ascending
Arrays.toString(nums); // prints the actual values, e.g. [1, 2, 5, 8, 9]
```
Printing an array directly (`System.out.println(nums)`) shows a memory
address, not the values — always use `Arrays.toString()` for readable output.

### 2. Manual sort - Bubble Sort
Repeatedly compares neighboring elements and swaps them if out of order.
The largest unsorted value "bubbles" to the end with each full pass.
```java
for (int i = 0; i < nums.length - 1; i++) {
    for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
            // swap nums[j] and nums[j+1]
        }
    }
}
```
Not the fastest algorithm, but a good one to understand sorting mechanics.

### 3. Searching
**Linear search** — check every element one at a time. Works on ANY array,
sorted or not, but is O(n) — slow for large arrays.

**Binary search** — much faster (O(log n)), but the array MUST be sorted
first:
```java
Arrays.binarySearch(sortedArray, target);
```

### 4. ArrayList - a resizable array
Regular arrays have a FIXED size forever. `ArrayList` can grow and shrink.
```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.remove(0); // removes by INDEX, not by value (careful with this)
list.size();
```
**Gotcha:** ArrayList only works with objects (`Integer`, `String`), not
primitives (`int`, `char`) directly.

### 5. Arrays utility methods
```java
Arrays.fill(nums, 0);                          // fill every slot with 0
int[] copy = Arrays.copyOf(nums, nums.length); // clone the array
```

## Commands I ran
```bash
javac ArrayOperationsDemo.java
java ArrayOperationsDemo
```

## Questions / things to revisit
- Why does binary search fail (give wrong results) if the array isn't sorted first?
- What's the actual time complexity difference between linear search and binary search, and why does it matter for large datasets?
- `list.remove(0)` removes by index — how would I remove by VALUE instead (e.g. remove the number 10, wherever it is)?
