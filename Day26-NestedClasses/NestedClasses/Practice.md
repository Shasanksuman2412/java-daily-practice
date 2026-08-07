# Day 26 - Practice Exercises: Nested & Inner Classes

Try to solve these YOURSELF first, without looking at Outer.java,
NestedClassesDemo.java, or Solutions.java.

---

### Exercise 1: Static nested `Calculator.Result` class (Easy-Medium)
Create a class `Calculator` with a STATIC NESTED class `Result` that has
two fields: `sum` and `product`. Add a static method in `Calculator`:
```java
static Result calculate(int a, int b) {
    // returns a new Result with sum = a+b, product = a*b
}
```
Call it from `main` and print both values from the returned `Result`.

---

### Exercise 2: Inner class accessing outer state (Easy-Medium)
Create a class `BankAccount` with a private field `balance`. Add a
non-static INNER class `TransactionLogger` with a method
`logTransaction(String type, double amount)` that prints something like
`"LOG: Withdrew 500, new balance: 1500"` - accessing the OUTER
`BankAccount`'s balance directly (no getter needed, since inner classes
can access private outer fields).

---

### Exercise 3: Two different Outer instances, two different Inner instances (Medium)
Using your `BankAccount`/`TransactionLogger` classes, create TWO separate
`BankAccount` objects with different balances, each with its own
`TransactionLogger`. Confirm each logger correctly reports its OWN
account's balance, not the other one's.

---

### Exercise 4: Local class inside a method (Medium)
Write a method `processOrder(double orderTotal)` that defines a LOCAL
class `DiscountCalculator` inside it, with a method `applyDiscount()` that
gives 10% off if `orderTotal > 1000`. Use the local class inside the
method and print the final price.

---

### Exercise 5: Anonymous class implementing a custom interface (Medium-Hard)
Create an interface `Validator` with method `boolean isValid(String input);`
Write a method `checkInputs(List<String> inputs, Validator validator)` that
loops through and prints which inputs pass/fail.
Call it TWICE with two DIFFERENT anonymous class implementations of
`Validator` - one checking "not empty", another checking "length > 5".

---

## Self-check before moving to Day 27
You should be able to answer these without looking anything up:
- [ ] Why does `Calculator.Result` (static nested) NOT need a `Calculator` instance to create, while `TransactionLogger` (inner) DOES need a `BankAccount` instance?
- [ ] In Exercise 3, why do two different `TransactionLogger` instances (from two different accounts) report DIFFERENT balances even though they're the same class?
- [ ] Why can a Local class (Exercise 4) access the ENCLOSING method's parameters and local variables, as long as they're effectively final?
- [ ] What's the practical benefit of an Anonymous class (Exercise 5) over creating a separate named class that implements `Validator`?

If you're unsure on any of these, revisit `notes.md` before moving to Day 27.
