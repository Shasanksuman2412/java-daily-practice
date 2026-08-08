# Day 27 - Practice Exercises: Object Class Methods

Try to solve these YOURSELF first, without looking at StudentWithoutOverrides.java,
Student.java, ObjectMethodsDemo.java, or Solutions.java.

---

### Exercise 1: Override toString() for a `Book` class (Easy-Medium)
Create a class `Book` with fields `title`, `author`, `year` (int).
Override `toString()` to print something readable like:
`"1984 by George Orwell (1949)"`
Create 2 Book objects and print them directly (via `System.out.println`).

---

### Exercise 2: Override equals() for `Book` (Easy-Medium)
Add a proper `equals()` override to `Book` - two books are equal if their
`title` AND `author` match (ignore `year` for equality).
Test with two books that have the same title/author but DIFFERENT years -
confirm they're still considered equal.

---

### Exercise 3: Override hashCode() to match equals() (Medium)
Add a matching `hashCode()` override to `Book`, based on the SAME fields
used in `equals()` (title and author, NOT year).
Put several Book objects (including duplicates by title+author) into a
`HashSet<Book>` and print the resulting size to confirm duplicates are
correctly removed.

---

### Exercise 4: Broken hashCode/equals contract (Medium-Hard - conceptual)
Create a BROKEN version of a class `BadBook` where `equals()` is
overridden properly, but `hashCode()` is NOT overridden at all (left as
Object's default). Add "duplicate" BadBook objects (same title/author) to
a HashSet and observe the size - it will incorrectly show them as
different, proving why the contract matters.

---

### Exercise 5: equals() with inheritance pitfalls (Harder - conceptual)
Create `Ebook extends Book` with an extra field `fileSizeMB`.
Try comparing a `Book` object and an `Ebook` object that have the SAME
title/author using your `Book.equals()` method from Exercise 2. Does it
consider them equal? Why or why not, given the `getClass() != obj.getClass()`
check? Print the result and explain what you observe in a comment.

---

## Self-check before moving to Day 28
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 4's `BadBook` show incorrect HashSet behavior even though `equals()` alone was implemented correctly?
- [ ] In Exercise 5, why does `getClass() != obj.getClass()` cause a `Book` and an `Ebook` with identical title/author to be considered NOT equal?
- [ ] What's the real-world consequence of forgetting to override `equals()`/`hashCode()` when storing custom objects in a `HashSet` or as `HashMap` keys?
- [ ] Why is it recommended to base `equals()` and `hashCode()` on the SAME set of fields, never different ones?

If you're unsure on any of these, revisit `notes.md` before moving to Day 28.
