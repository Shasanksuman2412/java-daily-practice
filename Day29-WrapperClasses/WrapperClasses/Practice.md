# Day 29 - Practice Exercises: Wrapper Classes & Autoboxing

Try to solve these YOURSELF first, without looking at WrapperClassesDemo.java
or Solutions.java.

---

### Exercise 1: Parse and sum Strings (Easy-Medium)
Declare `List<String> numberStrings = List.of("10", "25", "7", "42");`
Parse each String to an int using `Integer.parseInt()`, sum them all, and
print the total.

---

### Exercise 2: Prove the Integer cache gotcha yourself (Easy-Medium)
Write code that creates two `Integer` objects with the value `50` using
`Integer a = 50;` (not `new Integer(50)`), and two more with value `150`.
Print the result of `==` for both pairs, and explain in a comment WHY they
differ.

---

### Exercise 3: Safe unboxing with a null check (Medium)
Write a method `int safeUnbox(Integer value, int defaultValue)` that
returns the unboxed int if `value` is not null, otherwise returns
`defaultValue` WITHOUT throwing a NullPointerException.
Test it with a non-null Integer and with `null`.

---

### Exercise 4: Wrapper class utility methods (Medium)
Using various wrapper class static methods, do ALL of the following:
- Convert `"3.14159"` to a double
- Convert `255` to a hexadecimal String (`Integer.toHexString()`)
- Find the max of two Integer objects (`Integer.max()`)
- Check if a Character is a digit (`Character.isDigit()`)

Print each result.

---

### Exercise 5: Autoboxing performance pitfall (Harder - conceptual)
Write a loop that sums numbers 1 to 100000 into a variable declared as
`Integer sum = 0;` (NOT `int sum = 0;`). Time how long it takes using
`System.currentTimeMillis()` before and after.
Then do the SAME sum using a plain `int sum = 0;` and time that too.
Compare the two times in a printed statement - which is faster, and why
might there be a difference (think about all the boxing/unboxing happening
on every single `+=` with the Integer version)?

---

## Self-check before moving to Day 30
You should be able to answer these without looking anything up:
- [ ] Why does repeatedly doing `Integer sum = 0; sum += i;` inside a loop involve MORE work than `int sum = 0; sum += i;`, even though the code looks almost identical?
- [ ] In Exercise 3, why does checking `value != null` BEFORE unboxing prevent the NullPointerException entirely?
- [ ] Why does `Integer.parseInt("abc")` throw an exception - what TYPE of exception is it, and is it checked or unchecked?
- [ ] If you have a `List<Integer>` with values that might include `null`, what's the danger of using a for-each loop like `for (int n : list)` directly?

If you're unsure on any of these, revisit `notes.md` before moving to Day 30.
