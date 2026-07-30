# Day 12 - Practice Exercises: Inheritance

Try to solve these YOURSELF first, without looking at Animal.java, Dog.java,
Cat.java, InheritanceDemo.java, or Solutions.java.

---

### Exercise 1: Create a `Vehicle` parent class (Easy-Medium)
Create a class `Vehicle` with:
- Fields: `brand` (String), `speed` (int)
- A constructor setting both
- A method `displayInfo()` printing brand and speed
- A method `honk()` printing `"Generic honking sound"`

---

### Exercise 2: Create `Car` and `Bike` subclasses (Medium)
Create `Car extends Vehicle` and `Bike extends Vehicle`.
- Each should have a constructor that calls `super(brand, speed)`
- Override `honk()` in `Car` to print `"Beep beep!"`
- Override `honk()` in `Bike` to print `"Tring tring!"`
- Add one UNIQUE method to each (e.g. `Car` has `openTrunk()`, `Bike` has
  `pedalStand()`)

Create one object of each and call `displayInfo()`, `honk()`, and their
unique method.

---

### Exercise 3: Use `super` to extend a method, not just replace it (Medium)
In `Car`, override `displayInfo()` so it calls `super.displayInfo()` FIRST
(to print the inherited brand/speed), then ADDS an extra line like
`"This is a four-wheeler."` Do the same for `Bike` with
`"This is a two-wheeler."`

---

### Exercise 4: Polymorphism with an array of parent-type references (Medium-Hard)
Create an array of type `Vehicle[]` containing both `Car` and `Bike`
objects. Loop through it calling `honk()` on each - notice how each one
correctly calls ITS OWN overridden version, even though the array's type
is `Vehicle`.

---

### Exercise 5: Three-level inheritance (Harder)
Create a class `SportsCar extends Car`. Add a method `turboBoost()`.
Override `honk()` again in `SportsCar` to print `"VROOOOM honk!"`.
Create a `SportsCar` object and call `displayInfo()` (inherited from
Vehicle through Car), `honk()` (SportsCar's own override), and
`turboBoost()` (SportsCar's own method).

---

## Self-check before moving to Day 13
You should be able to answer these without looking anything up:
- [ ] What's the difference between `super(brand, speed)` and `super.displayInfo()` - one calls a constructor, the other calls a method. Why does each need different syntax?
- [ ] In Exercise 4, why does `vehicle.honk()` call the CORRECT subclass version even though `vehicle` is declared as type `Vehicle`?
- [ ] Can `SportsCar` access fields/methods from `Vehicle` directly, even though it only directly extends `Car`? Why or why not?
- [ ] What happens if you DON'T override `honk()` in `Bike` at all - what gets called when you call `bike.honk()`?

If you're unsure on any of these, revisit `notes.md` before moving to Day 13.
