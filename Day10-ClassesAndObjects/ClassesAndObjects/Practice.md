# Day 10 - Practice Exercises: Classes & Objects

Try to solve these YOURSELF first, without looking at Student.java,
ClassesAndObjectsDemo.java, or Solutions.java.

---

### Exercise 1: Create a `Book` class (Easy-Medium)
Create a class `Book` with fields: `title` (String), `author` (String),
`price` (double), and `pages` (int).
Add a constructor that sets all four fields using `this`.
Add a method `displayInfo()` that prints all the book's details in a
readable sentence.

In a separate main class, create 2 `Book` objects with different data and
call `displayInfo()` on each.

---

### Exercise 2: Add a method with logic (Easy-Medium)
To your `Book` class, add a method:
```java
boolean isExpensive() {
    // returns true if price > 500
}
```
Call it for both books you created and print the result.

---

### Exercise 3: Create a `Rectangle` class (Medium)
Create a class `Rectangle` with fields `length` and `width` (both double).
Add a constructor, and two methods:
- `calculateArea()` - returns length * width
- `calculatePerimeter()` - returns 2 * (length + width)

Create 3 different Rectangle objects and print their area and perimeter.

---

### Exercise 4: Array of custom objects (Medium-Hard)
Create an array of 4 `Book` objects (reuse your class from Exercise 1).
Loop through and find/print the book with the HIGHEST price.

---

### Exercise 5: A class that tracks its own count (Harder - conceptual)
Add a `static` field to your `Book` class called `totalBooksCreated`.
Increment it inside the constructor every time a new Book is made.
After creating several Book objects, print `Book.totalBooksCreated` to see
the total.
(This introduces `static` fields - shared across ALL objects of a class,
rather than each object having its own copy. Look this up if it's unclear!)

---

## Self-check before moving to Day 11
You should be able to answer these without looking anything up:
- [ ] What's the difference between a field and a local variable inside a method?
- [ ] Why does each object get its own copy of `title`, `author`, etc., but a `static` field is shared across all objects?
- [ ] What does `this.title = title;` actually do, step by step?
- [ ] Could you have two `Book` objects with the exact same title and author? Are they the "same object"?

If you're unsure on any of these, revisit `notes.md` before moving to Day 11.
