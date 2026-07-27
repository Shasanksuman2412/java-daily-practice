# Day 06 - Arrays

## What I learned

### 1. What is an array?
A fixed-size container holding multiple values of the SAME type, accessed
by index starting at **0**.
```java
int[] numbers = new int[5]; // 5 ints, all default to 0
numbers[0] = 10;
```

### 2. Initialization shortcut
```java
int[] marks = {85, 90, 78, 92, 88}; // declare + fill in one line
```

### 3. Accessing and modifying elements
```java
marks[0]     // first element
marks[2] = 100; // change third element
```
**Gotcha:** an array of size 5 has valid indexes 0-4. Accessing `marks[5]`
throws `ArrayIndexOutOfBoundsException` — there is no 5th index slot.

### 4. Looping through arrays
Regular indexed loop (use when you need the index too):
```java
for (int i = 0; i < marks.length; i++) {
    marks[i];
}
```
Note: `.length` is a property (no parentheses) for arrays.

Enhanced for-each loop (cleaner when you just need the values):
```java
for (int mark : marks) {
    // use mark directly
}
```

### 5. Common operations
- **Sum/average:** loop and accumulate into a running total.
- **Max/min:** loop and compare against the best value found so far.
- **2D arrays** (rows and columns, like a grid/table):
```java
int[][] grid = {
    {1, 2, 3},
    {4, 5, 6}
};
grid[1][2] // row 1, column 2 -> 6
```

## Commands I ran
```bash
javac ArraysDemo.java
java ArraysDemo
```

## Questions / things to revisit
- Why can't array size change after creation — what would I use instead if I need a growable list (ArrayList)?
- What actually happens in memory when I create `new int[5]` vs `new int[100]`?
- How would I loop through a 2D array using a for-each loop instead of nested indexed loops?
