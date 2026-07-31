# Day 13 - Practice Exercises: Polymorphism

Try to solve these YOURSELF first, without looking at Animal.java, Dog.java,
Cat.java, PolymorphismDemo.java, or Solutions.java.

---

### Exercise 1: Shape hierarchy with overriding (Easy-Medium)
Create a class `Shape` with a method `double area()` that returns `0`.
Create `Circle extends Shape` (field: `radius`) and `Square extends Shape`
(field: `side`), each overriding `area()` with the correct formula
(`π * r²` and `side * side`).
Create one of each and print their areas by calling `area()`.

---

### Exercise 2: Polymorphic array of Shapes (Medium)
Create a `Shape[]` array containing 2 `Circle` objects and 2 `Square`
objects with different sizes. Loop through and print each one's area -
notice the correct `area()` version runs for each, automatically.

---

### Exercise 3: instanceof + downcasting (Medium)
Using the array from Exercise 2, loop through it and:
- If the shape is a `Circle`, downcast it and print its `radius`
- If the shape is a `Square`, downcast it and print its `side`
(This requires a Circle-specific getter and a Square-specific getter that
DON'T exist on the parent Shape class.)

---

### Exercise 4: Total area calculator (Medium-Hard)
Using the same `Shape[]` array, write a loop that sums up the total area
of ALL shapes, regardless of their specific type, using ONLY the
polymorphic `area()` method (no instanceof needed here at all).

---

### Exercise 5: Add a NEW shape without touching existing code (Harder - conceptual)
Create a THIRD shape class, `Rectangle extends Shape` (fields: `length`,
`width`), overriding `area()`.
Add a `Rectangle` object into your existing `Shape[]` array from Exercise 2
and re-run your Exercise 4 total-area loop WITHOUT modifying that loop's
code at all. Confirm it still works correctly with zero changes needed.
(This is the real point of polymorphism - proving the loop doesn't care
what specific shape types exist.)

---

## Self-check before moving to Day 14
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 4's total-area loop work without ANY instanceof checks, while Exercise 3 NEEDS them?
- [ ] What would happen if you forgot to override `area()` in one of your Shape subclasses - what would it return?
- [ ] Why is Exercise 5 possible without changing the loop - what does this prove about polymorphism's real value?
- [ ] What's the actual runtime error if you downcast a `Circle` object to `Square` by mistake?

If you're unsure on any of these, revisit `notes.md` before moving to Day 14.
