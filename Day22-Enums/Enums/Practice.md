# Day 22 - Practice Exercises: Enums

Try to solve these YOURSELF first, without looking at Day.java, Planet.java,
EnumsDemo.java, or Solutions.java.

---

### Exercise 1: Traffic light enum (Easy-Medium)
Create an enum `TrafficLight` with constants `RED`, `YELLOW`, `GREEN`.
Write a method (can be a separate static method, or inside main) that uses
a `switch` to print what action to take for each color:
- RED -> "Stop"
- YELLOW -> "Slow down"
- GREEN -> "Go"

Test it by looping through `TrafficLight.values()` and printing the action
for each.

---

### Exercise 2: Enum with a field and method (Easy-Medium)
Create an enum `Season` with constants `WINTER`, `SPRING`, `SUMMER`, `FALL`,
each with an associated average temperature (a `double` field, e.g. WINTER
= 5.0, SUMMER = 30.0). Add a method `isWarm()` that returns `true` if the
average temperature is above 15.0.
Print each season with its temperature and whether it's warm.

---

### Exercise 3: Enum implementing an interface (Medium)
Create an interface `Describable` with method `String describe();`
Make your `Season` enum implement it, with each constant returning a
description like `"Cold and snowy"` for WINTER.
(Hint: you can override `describe()` differently PER CONSTANT using a
constant-specific class body - look this up if the syntax is unfamiliar,
it looks like `WINTER { public String describe() {...} }`.)

---

### Exercise 4: Using ordinal() and values() together (Medium-Hard)
Using your `TrafficLight` enum, write a method `next()` that returns the
NEXT light in the cycle (RED -> YELLOW -> GREEN -> RED, looping back
around). Use `ordinal()` and `values()` together - do NOT hardcode the
sequence with if-statements.
(Hint: `(currentOrdinal + 1) % values().length` gives you the next index.)

---

### Exercise 5: Enum-based state machine (Harder - conceptual)
Create an enum `OrderStatus` with `PLACED`, `SHIPPED`, `DELIVERED`,
`CANCELLED`. Write a method `canTransitionTo(OrderStatus newStatus)` that
returns `true` only for valid transitions (e.g. PLACED -> SHIPPED is
valid, DELIVERED -> PLACED is NOT valid). Test a few valid and invalid
transitions.

---

## Self-check before moving to Day 23
You should be able to answer these without looking anything up:
- [ ] Why can enum constants have DIFFERENT behavior for the same method (like in Exercise 3), even though they're all the same enum type?
- [ ] What does `ordinal()` actually represent, and why is it risky to rely on it for anything beyond simple ordering (hint: what happens if someone reorders the enum constants later)?
- [ ] Why is an enum a better choice than a plain `int` (like `0 = RED, 1 = YELLOW, 2 = GREEN`) for representing a fixed set of states?
- [ ] In Exercise 5, why does modeling valid state TRANSITIONS explicitly (rather than just having 4 separate boolean flags) make the code safer?

If you're unsure on any of these, revisit `notes.md` before moving to Day 23.
