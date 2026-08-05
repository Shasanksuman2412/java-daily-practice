# Day 24 - Practice Exercises: Regular Expressions

Try to solve these YOURSELF first, without looking at RegularExpressionsDemo.java
or Solutions.java.

---

### Exercise 1: Password strength checker (Easy-Medium)
Write a method `isStrongPassword(String password)` that returns `true`
only if the password:
- Is at least 8 characters long
- Contains at least one digit
- Contains at least one uppercase letter

Test with `"Password1"` (should pass) and `"weak"` (should fail).
(Hint: you may need MULTIPLE separate checks combined with `&&`, rather
than one giant regex - that's completely fine and often clearer.)

---

### Exercise 2: Extract all email addresses from text (Easy-Medium)
Declare:
```java
String text = "Contact us at support@example.com or sales@company.org for help.";
```
Use `Pattern`/`Matcher` to find and print ALL email addresses in the text.

---

### Exercise 3: Validate an Indian PIN code (Medium)
Write a method `isValidPinCode(String code)` that checks if a string is
EXACTLY 6 digits (Indian postal PIN codes are always 6 digits, no letters).
Test with `"400001"` (valid) and `"4000A1"` (invalid).

---

### Exercise 4: Remove all extra whitespace (Medium)
Declare `String messy = "This   has     way    too much   spacing.";`
Use `replaceAll()` to collapse all multiple spaces into a SINGLE space,
so the result is `"This has way too much spacing."`

---

### Exercise 5: Extract and sum all numbers in a sentence (Harder)
Declare:
```java
String sentence = "I bought 3 apples, 12 bananas, and 7 mangoes for a total of 22 fruits.";
```
Use `Pattern`/`Matcher` to find ALL numbers in the sentence, convert each
matched String to an int, and print their SUM.
(Hint: `Integer.parseInt(matcher.group())` converts a matched String to an int.)

---

## Self-check before moving to Day 25
You should be able to answer these without looking anything up:
- [ ] Why might it be CLEARER to use several simple `.contains()`/`.matches()` checks combined with `&&` (like Exercise 1) instead of one giant complicated regex?
- [ ] What's the difference between `Pattern.compile(...)` once, reused many times, vs calling `.matches()` directly on a String each time - does it matter for performance?
- [ ] Why does `\\s+` (one or more) work better than `\\s` (exactly one) for Exercise 4's whitespace collapsing?
- [ ] What would `matcher.group()` return if called before `matcher.find()` was ever called successfully? (Try it and see what happens!)

If you're unsure on any of these, revisit `notes.md` before moving to Day 25.
