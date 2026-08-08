# Day 28 - Practice Exercises: Design Patterns

Try to solve these YOURSELF first, without looking at ConfigManager.java,
Pizza.java, DesignPatternsDemo.java, or Solutions.java.

---

### Exercise 1: Singleton `Logger` class (Easy-Medium)
Create a Singleton class `Logger` with:
- A private static instance
- A private constructor
- A public static `getInstance()` method
- A method `log(String message)` that prints `"[LOG]: " + message`

Get the instance TWICE in `main`, confirm both references are the SAME
object using `==`, and call `log()` on each.

---

### Exercise 2: Singleton with a counter (Easy-Medium)
Add a field `int logCount` to your `Logger`. Increment it every time
`log()` is called. Call `log()` several times through DIFFERENT
`getInstance()` calls, and confirm `logCount` keeps accumulating correctly
(proving it's really the same object being reused each time).

---

### Exercise 3: Builder for a `Car` class (Medium)
Create a `Car` class with fields: `model` (required), `color` (optional,
default "White"), `sunroof` (optional, default false), `automatic`
(optional, default true).
Build a `Builder` with chainable methods for each optional field. Build 2
different Car objects with different combinations of options and print
both using a `toString()` override.

---

### Exercise 4: Builder with validation (Medium-Hard)
Add a check in your `Car.Builder`'s `build()` method: if `model` is null
or empty, throw an `IllegalStateException` with a clear message. Test
building a valid car (should work) and building one with no model set
(should throw and be caught).

---

### Exercise 5: Combine both patterns (Harder - conceptual)
Create a Singleton `CarFactory` class that has a method
`createCar(String model)` returning a `Car` built with sensible defaults
using your `Car.Builder`. Get the `CarFactory` instance and use it to
create 2 different cars, confirming the factory itself is a true Singleton
(same instance both times) while still producing DIFFERENT Car objects
each time.

---

## Self-check before moving to Day 29
You should be able to answer these without looking anything up:
- [ ] Why does a Singleton's constructor need to be `private`, but a Builder's constructor is usually `public`?
- [ ] In Exercise 5, why can a Singleton (`CarFactory`) still produce MANY different objects (`Car` instances), even though the factory itself only ever has ONE instance?
- [ ] What's the actual risk of a Builder pattern's `build()` method NOT validating required fields, as shown in Exercise 4?
- [ ] Why does returning `this` from each Builder method (method chaining) make the code more readable than calling separate setter methods one at a time?

If you're unsure on any of these, revisit `notes.md` before moving to Day 29.
