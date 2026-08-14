# Day 39 - Practice Exercises: Text Blocks

Try to solve these YOURSELF first, without looking at TextBlocksDemo.java
or Solutions.java.

---

### Exercise 1: Convert a messy concatenated String to a text block (Easy-Medium)
Given this old-style String:
```java
String poem = "Roses are red,\n" +
              "Violets are blue,\n" +
              "Java is fun,\n" +
              "And so are you.";
```
Rewrite it as a text block. Print both versions and confirm they produce
IDENTICAL output using `.equals()`.

---

### Exercise 2: Build a SQL query using a text block (Easy-Medium)
Write a multi-line SQL-style query as a text block:
```sql
SELECT name, age, marks
FROM students
WHERE marks > 75
ORDER BY marks DESC
```
Print it, then confirm no unwanted leading whitespace appears on any line
(check by printing each line's length, or just visually inspect it).

---

### Exercise 3: Generate a formatted receipt using formatted() (Medium)
Create a text block template for a simple receipt with placeholders (`%s`
for item name, `%d` for quantity, `%.2f` for price), and use `.formatted()`
to fill in real values for 2 different "receipts". Print both.

---

### Exercise 4: Embedded JSON with nested quotes (Medium-Hard)
Build a text block representing a small JSON object with a NESTED object
inside it (e.g. a person with an address field that's itself an object).
Confirm none of the quotes needed escaping, and print the result.

---

### Exercise 5: Trailing newline behavior comparison (Harder - conceptual)
Create THREE text blocks with the exact same visible text ("Sample text")
but with the closing `"""` placed in three different ways:
1. Same line as the text (no trailing newline)
2. On its own line (one trailing newline)
3. With an extra blank line before the closing `"""` (two trailing newlines)

Print the `.length()` of each String to prove they're actually different,
even though they LOOK almost identical in your source code.

---

## Self-check before moving to Day 40
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 1's rewritten text block need to be checked with `.equals()` rather than just visually comparing - what subtle difference could exist even if it LOOKS the same?
- [ ] In Exercise 2, how does Java decide how much leading whitespace to strip from a heavily-indented text block inside a method?
- [ ] Why does `.formatted()` (Exercise 3) work the exact same way on a text block as it does on a regular String - what does this tell you about what a text block actually IS after compilation?
- [ ] In Exercise 5, why does the position of the closing `"""` change the String's actual `.length()`, even when the "visible" text looks unchanged?

If you're unsure on any of these, revisit `notes.md` before moving to Day 40.
