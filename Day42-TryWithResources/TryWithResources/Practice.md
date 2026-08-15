# Day 42 - Practice Exercises: try-with-resources & Custom AutoCloseable

Try to solve these YOURSELF first, without looking at DatabaseConnection.java,
UnreliableResource.java, TryWithResourcesDemo.java, or Solutions.java.

---

### Exercise 1: Create a `Timer` resource (Easy-Medium)
Create a class `Timer implements AutoCloseable` that records the start
time (`System.currentTimeMillis()`) in its constructor, and in `close()`
prints how many milliseconds elapsed since it was created. Use it in a
try-with-resources block around some dummy work (like a loop or
`Thread.sleep(500)`), and confirm the elapsed time prints correctly.

---

### Exercise 2: Create a `FileLock` resource that prevents double-locking (Easy-Medium)
Create a class `FileLock implements AutoCloseable` with a constructor that
prints `"Lock acquired: " + fileName` and a `close()` that prints
`"Lock released: " + fileName`. Use it in a try-with-resources block, and
confirm the release message prints even if you throw an exception inside
the block (catch it outside).

---

### Exercise 3: Multiple resources, observe close order (Medium)
Create THREE different named `DatabaseConnection`-style resources (reuse
the class or make your own) and open all three in ONE try-with-resources
statement. Print a message before the try block, inside it, and confirm
by reading the output that they close in REVERSE order from how they
opened.

---

### Exercise 4: A resource whose close() throws, wrapped safely (Medium-Hard)
Create a resource similar to `UnreliableResource` but make YOUR OWN
version - `close()` should throw a custom checked exception (create one)
instead of a generic `Exception`. Use it in try-with-resources, catch the
custom exception type specifically, and print its message.

---

### Exercise 5: Combine try-with-resources with suppressed exceptions (Harder)
Create a resource where BOTH the try block's code AND the resource's
`close()` method throw DIFFERENT exceptions. Catch the main exception,
loop through `getSuppressed()`, and print details of both exceptions
clearly labeled ("Main problem" vs "Cleanup problem"). Confirm neither
exception's information is lost.

---

## Self-check before moving to Day 43
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why does declaring `Timer` as `AutoCloseable` (rather than just calling a `stop()` method manually) guarantee the elapsed time gets printed even if the work inside throws an exception?
- [ ] In Exercise 3, trace through the exact order resources open and close - why does this ordering make sense for resources that might DEPEND on each other (like a database connection needing a network connection to already be open)?
- [ ] In Exercise 4, why is it good practice to throw a SPECIFIC custom exception type from `close()` rather than a generic `Exception`?
- [ ] In Exercise 5, why would silently swallowing the "cleanup problem" exception (instead of attaching it as suppressed) be a worse design choice?

If you're unsure on any of these, revisit `notes.md` before moving to Day 43.
