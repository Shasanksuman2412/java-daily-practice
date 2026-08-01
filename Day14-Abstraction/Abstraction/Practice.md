# Day 14 - Practice Exercises: Abstraction

Try to solve these YOURSELF first, without looking at Shape.java,
Drawable.java, Circle.java, Square.java, AbstractionDemo.java, or
Solutions.java.

---

### Exercise 1: Abstract `Employee` class (Easy-Medium)
Create an abstract class `Employee` with:
- Fields: `name` (String), `baseSalary` (double)
- A constructor setting both
- An ABSTRACT method `double calculateSalary();`
- A regular (non-abstract) method `displayInfo()` that prints name and
  calls `calculateSalary()`

---

### Exercise 2: Two concrete subclasses (Medium)
Create `Manager extends Employee` - `calculateSalary()` returns
`baseSalary + 5000` (fixed bonus).
Create `Developer extends Employee` - `calculateSalary()` returns
`baseSalary + (baseSalary * 0.10)` (10% bonus).

Create one of each and call `displayInfo()` on both.

---

### Exercise 3: A `Payable` interface (Medium)
Create an interface `Payable` with one method: `void processPayment();`
Make BOTH `Manager` and `Developer` implement `Payable`, printing something
like `"Processing payment for [name]"` in each class's implementation.

---

### Exercise 4: Polymorphic array using the abstract class type (Medium-Hard)
Create an `Employee[]` array with 2 Managers and 2 Developers (different
salaries). Loop through calling `displayInfo()` on each - notice the
correct `calculateSalary()` runs automatically for each type.

---

### Exercise 5: Total payroll using only abstraction (Harder)
Using the same array from Exercise 4, calculate and print the TOTAL salary
of all employees combined, using ONLY the abstract `calculateSalary()`
method - no `instanceof` needed at all, since every Employee (whatever
subclass) is guaranteed to have this method.

---

## Self-check before moving to Day 15
You should be able to answer these without looking anything up:
- [ ] Why can't you create `new Employee(...)` directly, but you CAN create `new Manager(...)`?
- [ ] What's the real difference between `Employee` (abstract class) and `Payable` (interface) in this exercise - why use one vs the other here?
- [ ] Could a class implement `Payable` WITHOUT extending `Employee` at all? Why might that be useful (think of an unrelated class like `Vendor` that also needs to be paid)?
- [ ] Why does Exercise 5's total-payroll loop need NO instanceof checks, unlike some polymorphism exercises from Day 13?

If you're unsure on any of these, revisit `notes.md` before moving to Day 15.
