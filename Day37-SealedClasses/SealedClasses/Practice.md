# Day 37 - Practice Exercises: Sealed Classes

Try to solve these YOURSELF first, without looking at Shape.java, Circle.java,
Square.java, Triangle.java, PaymentMethod.java, SealedClassesDemo.java, or
Solutions.java.

---

### Exercise 1: Create a sealed `Vehicle` hierarchy (Easy-Medium)
Create a sealed interface `Vehicle permits Car, Motorcycle, Truck`, with a
method `int wheelCount()`. Create three `record` implementations, each
returning the correct wheel count (Car=4, Motorcycle=2, Truck=6).
Print each one's wheel count.

---

### Exercise 2: Exhaustive switch, no default needed (Easy-Medium)
Write a method `String describeVehicle(Vehicle v)` using a pattern
matching switch over your sealed `Vehicle` hierarchy from Exercise 1 - NO
`default` case. Confirm it compiles successfully without one.

---

### Exercise 3: Try removing `sealed` and see what breaks (Medium - conceptual)
Temporarily change `Vehicle` from `sealed interface` to a regular
`interface` (remove `sealed` and `permits`). Try compiling
`describeVehicle()` again WITHOUT a default case - it should now FAIL to
compile. Add the `default` case back to fix it, then explain in a comment
WHY removing `sealed` broke the exhaustiveness check.

---

### Exercise 4: A sealed class with a non-sealed branch (Medium-Hard)
Create a sealed abstract class `Employee permits Manager, Contractor`.
Make `Manager` `final`, but make `Contractor` `non-sealed`. Create a
subclass `RemoteContractor extends Contractor` to prove the reopening
works. Confirm `RemoteContractor` does NOT need `permits`/`final`/`sealed`
itself, since it's extending a `non-sealed` class.

---

### Exercise 5: Sealed hierarchy for a simple expression evaluator (Harder)
Create a sealed interface `Expr permits Number, Add, Multiply`:
- `record Number(double value) implements Expr`
- `record Add(Expr left, Expr right) implements Expr`
- `record Multiply(Expr left, Expr right) implements Expr`

Write a RECURSIVE method `double evaluate(Expr e)` using a pattern
matching switch that evaluates the expression tree (Number returns its
value, Add adds the evaluated left+right, Multiply multiplies them).
Test with something like `Add(Number(3), Multiply(Number(4), Number(5)))`
which should evaluate to `23`.

---

## Self-check before moving to Day 38
You should be able to answer these without looking anything up:
- [ ] In Exercise 3, why does removing `sealed` specifically break the COMPILER's ability to verify exhaustiveness, even though the actual subclasses (Car, Motorcycle, Truck) still exist and haven't changed?
- [ ] In Exercise 4, why does `RemoteContractor` NOT need to declare `final`/`sealed`/`non-sealed`, unlike `Manager` and `Contractor` did?
- [ ] In Exercise 5, why does `evaluate()` need to be RECURSIVE - what does an `Add` or `Multiply` expression actually contain that requires recursion to fully resolve?
- [ ] Why is the sealed+records combination (Exercise 5) considered a good fit for representing expression trees or other "closed" data structures specifically?

If you're unsure on any of these, revisit `notes.md` before moving to Day 38.
