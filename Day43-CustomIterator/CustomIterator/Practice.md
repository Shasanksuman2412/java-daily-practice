# Day 43 - Practice Exercises: Custom Iterator & Iterable

Try to solve these YOURSELF first, without looking at Playlist.java,
CustomIteratorDemo.java, or Solutions.java.

---

### Exercise 1: Make a `Range` class Iterable (Easy-Medium)
Create a class `Range implements Iterable<Integer>` that represents a
range of numbers from `start` to `end` (inclusive). Implement `iterator()`
so a for-each loop over `new Range(1, 5)` prints 1, 2, 3, 4, 5.

---

### Exercise 2: Step-based Range iterator (Easy-Medium)
Add a THIRD constructor parameter `step` to `Range` (e.g.
`new Range(0, 10, 2)` should iterate 0, 2, 4, 6, 8, 10). Update
`iterator()` to respect the step value.

---

### Exercise 3: Custom `EvenOnlyIterator` for an existing array (Medium)
Create a class `NumberCollection` wrapping an `int[]`, implementing
`Iterable<Integer>` so a NORMAL for-each gives every number, but ALSO
provide a separate method `evenOnlyIterator()` that only returns the even
numbers. Test both on the same collection.

---

### Exercise 4: Two independent iterators on the same object (Medium-Hard)
Using your `Range` class from Exercise 1, create TWO SEPARATE iterators
from the SAME `Range` instance (`range.iterator()` called twice). Advance
one further than the other using `.next()` manually, and confirm they
track SEPARATE positions (proving each `iterator()` call creates a fresh,
independent Iterator object).

---

### Exercise 5: Iterator that throws NoSuchElementException correctly (Harder)
Using ANY of your Iterable classes above, write code that deliberately
calls `.next()` more times than there are elements, WITHOUT checking
`hasNext()` first. Catch the resulting `NoSuchElementException` and print
a friendly message. Confirm your `hasNext()`/`next()` implementation
actually throws this correctly (not just returning null or crashing some
other way).

---

## Self-check before moving to Day 44
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 4 prove that each call to `.iterator()` must return a BRAND NEW Iterator object, rather than reusing one shared instance?
- [ ] In Exercise 2, why does adding a `step` parameter change the LOGIC inside `next()` and `hasNext()`, but NOT change the fact that `Range` still implements the same `Iterable<Integer>` interface?
- [ ] Why is it considered a BUG if a custom Iterator's `next()` method doesn't throw `NoSuchElementException` when called after exhaustion (e.g., if it just returns 0 or null instead)?
- [ ] What's the actual relationship between `Iterable` and `Iterator` - why are they TWO separate interfaces instead of just one?

If you're unsure on any of these, revisit `notes.md` before moving to Day 44.
