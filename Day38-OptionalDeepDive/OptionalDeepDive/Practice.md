# Day 38 - Practice Exercises: Optional Deep Dive

Try to solve these YOURSELF first, without looking at Student.java,
OptionalDeepDiveDemo.java, or Solutions.java.

---

### Exercise 1: Safe division returning Optional (Easy-Medium)
Write a method `Optional<Integer> safeDivide(int a, int b)` that returns
`Optional.empty()` if `b == 0`, otherwise `Optional.of(a / b)`.
Test with a valid division and a division by zero, using `ifPresentOrElse`
to print the result or an error message.

---

### Exercise 2: Chain map() and filter() together (Easy-Medium)
Given `Optional<String> input = Optional.of("  hello world  ");`
Chain THREE operations: `.map()` to trim it, `.map()` to uppercase it, and
`.filter()` to keep it only if it contains "WORLD". Print the final result
using `orElse("Not found")`.

---

### Exercise 3: Find a user by email in a List (Medium)
Given `List<String> emails = List.of("a@x.com", "b@x.com", "c@x.com");`
Write a method `Optional<String> findEmail(List<String> emails, String target)`
using streams (Day 19) with `.filter()` and `.findFirst()` (which itself
returns an Optional!). Test with an email that exists and one that doesn't.

---

### Exercise 4: Optional chaining with flatMap (Medium-Hard)
Imagine a method `Optional<Student> findStudent(int id)` and another
`Optional<String> getEmail(Student s)` (simulate this - not every student
has an email, so some return `Optional.empty()`).
Use `.flatMap()` to chain them: given a student ID, get their email if
BOTH the student exists AND they have an email on file. Test with a
student who has an email and one who doesn't.
(Look up the difference between `.map()` and `.flatMap()` if you get stuck -
`.map()` would give you an `Optional<Optional<String>>`, which isn't useful!)

---

### Exercise 5: Refactor Day 20's StudentManager to avoid .get() (Harder)
Go back to Day 20's `findByRollNumber()` method (or recreate a simple
version). Make sure EVERY place that uses the returned `Optional<Student>`
avoids calling `.get()` directly - use `ifPresent()`, `orElse()`, or
`orElseThrow()` instead. Rewrite at least 2 call sites this way.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does chaining `.map()` after `.map()` after `.filter()` (Exercise 2) still work correctly even if an EARLIER step returns an empty Optional - what happens to the later steps in that case?
- [ ] In Exercise 4, what's the actual difference between `.map()` and `.flatMap()` when the mapping function itself returns an `Optional`?
- [ ] Why does `List.of(...).stream().filter(...).findFirst()` already return an `Optional`, without you needing to wrap it yourself?
- [ ] In Exercise 5, what's the practical benefit of NEVER calling `.get()` directly in your codebase, even in places where you're pretty sure the Optional will be present?

If you're unsure on any of these, revisit `notes.md` before moving to Day 39.
