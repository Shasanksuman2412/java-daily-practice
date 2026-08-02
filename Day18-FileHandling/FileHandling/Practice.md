# Day 18 - Practice Exercises: File Handling

Try to solve these YOURSELF first, without looking at FileHandlingDemo.java
or Solutions.java.

---

### Exercise 1: Write a list of names to a file (Easy-Medium)
Create a `List<String>` of 5 names. Write each name to a file called
`names.txt`, one name per line, using a loop and `FileWriter`.

---

### Exercise 2: Read the file back and count lines (Easy-Medium)
Read `names.txt` back using `Scanner`, print each line, and count how many
lines (names) were in the file total.

---

### Exercise 3: Append a new name without overwriting (Medium)
Open `names.txt` in APPEND mode and add one more name to the end. Read the
file again afterward to confirm all the original names are still there,
plus the new one.

---

### Exercise 4: Word count from a file (Medium-Hard)
Write a paragraph of at least 3 sentences into a file `paragraph.txt`.
Read it back, split by spaces, and count the total number of words.
(Hint: reading the WHOLE file as one line vs multiple lines matters here -
think about how `Scanner`'s `hasNextLine()`/`nextLine()` behaves with a
multi-line file.)

---

### Exercise 5: Copy contents from one file to another (Harder)
Using `names.txt` from Exercise 1, read all its lines and write them into
a NEW file called `names_copy.txt` using try-with-resources for both the
reader and writer. Confirm both files have identical content by printing
both.

---

## Self-check before moving to Day 19
You should be able to answer these without looking anything up:
- [ ] Why does `FileWriter("names.txt")` (no second argument) erase the file's previous content, while `FileWriter("names.txt", true)` doesn't?
- [ ] What happens if you try to read a file that doesn't exist - which exception is thrown, and where does it need to be caught?
- [ ] Why is `try-with-resources` safer than manually calling `.close()` in a `finally` block, especially if an exception happens mid-write?
- [ ] In Exercise 4, why can't you just use `.split(" ")` on a `Scanner`'s output directly without first getting the actual line text?

If you're unsure on any of these, revisit `notes.md` before moving to Day 19.
