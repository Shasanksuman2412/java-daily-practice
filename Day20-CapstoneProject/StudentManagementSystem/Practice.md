# Day 20 - Practice Exercises: Extend the Capstone Project

Unlike previous days, there's no separate Solutions.java for this one -
these exercises ask you to MODIFY the actual project files directly. Try
each one yourself; a suggested approach is described (not full code) so
you build it rather than copy it.

---

### Exercise 1: Add an `updateMarks` method (Easy-Medium)
In `StudentManager`, add:
```java
public boolean updateMarks(int rollNumber, double newMarks) throws InvalidMarksException
```
It should find the student by roll number, call their `setMarks(newMarks)`
(which validates automatically), and return `true` if found and updated,
`false` if no student with that roll number exists.
Test it in `main` by updating an existing student's marks.

---

### Exercise 2: Add a grade calculation using streams (Easy-Medium)
Add a method to `StudentManager`:
```java
public long countPassingStudents() // marks >= 40
```
Use `.stream().filter(...).count()` to implement it. Print the result in
`main`.

---

### Exercise 3: Sort students by marks before displaying (Medium)
Modify `displayAll()` so it prints students sorted by marks, HIGHEST
first. (Hint: you'll need to sort a COPY of the list, or use
`.stream().sorted(...)` and iterate over that instead of the original
list, so the original order for saving to file isn't disturbed.)

---

### Exercise 4: Prevent duplicate roll numbers (Medium-Hard)
Modify `addStudent()` so it checks if a student with the same roll number
already exists (using `findByRollNumber`) BEFORE adding. If a duplicate is
found, print an error message and don't add the new student.
Test by trying to add two students with roll number 101.

---

### Exercise 5: Add a simple text-based menu using Scanner (Harder)
Replace the hardcoded `main` method logic with an actual interactive menu:
```
1. Add Student
2. View All Students
3. Search by Roll Number
4. Delete Student
5. Show Class Average and Top Scorer
6. Save and Exit
```
Use a `Scanner` to read the user's menu choice in a loop, calling the
appropriate `StudentManager` method for each option, until they choose
option 6 (which saves to file and exits).

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does `updateMarks` reuse `setMarks()` instead of directly setting the field - what would be lost if it didn't?
- [ ] In Exercise 3, why does sorting a COPY (not the original list) matter for keeping file-saving behavior consistent?
- [ ] Why is checking for duplicates BEFORE adding safer than checking and removing duplicates AFTER?
- [ ] In Exercise 5, why does the menu loop need a way to break out (option 6) - what would happen without one?

This project is a good one to keep coming back to and extending as you
learn more - real applications grow exactly like this, one feature at a
time.
