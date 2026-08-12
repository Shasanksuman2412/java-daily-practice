# Day 35 - Practice Exercises: Records

Try to solve these YOURSELF first, without looking at Point.java,
ValidatedPoint.java, ComparablePoint.java, RecordsDemo.java, or
Solutions.java.

---

### Exercise 1: Create a `Movie` record (Easy-Medium)
Create a record `Movie(String title, String director, int year, double rating)`.
Create 3 Movie objects and print each one (using the auto-generated
toString()). Confirm two movies with identical data are `.equals()`.

---

### Exercise 2: Compact constructor validation (Easy-Medium)
Add a compact constructor to `Movie` that throws
`IllegalArgumentException` if `rating` is not between 0 and 10. Test with
a valid movie and an invalid one (rating = 15), catching the exception.

---

### Exercise 3: Record with an extra method (Medium)
Add a method to `Movie`: `boolean isHighlyRated()` that returns `true` if
`rating >= 8.0`. Create a list of several movies and use a stream (Day 19)
to filter and print only the highly-rated ones.

---

### Exercise 4: Record implementing Comparable (Medium-Hard)
Make `Movie implements Comparable<Movie>`, sorting by `rating` descending
(highest rated first). Create a `List<Movie>`, sort it with
`Collections.sort()`, and print the sorted list.

---

### Exercise 5: Record vs class - convert an existing class (Harder - conceptual)
Take the `Student` class from Day 27 (name, age fields, with manual
equals/hashCode/toString) and rewrite it as a record called
`StudentRecord`. Compare the line count and readability. Are there any
FEATURES the original class had that the record version can't replicate
(hint: think about mutability - could the original Student ever have a
setter for age? Can a record?).

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 2's validation logic run BEFORE the fields are actually assigned, in a compact constructor?
- [ ] In Exercise 4, why does implementing `Comparable` on a record work exactly the same way as it did for a regular class back on Day 25?
- [ ] In Exercise 5, what's the fundamental limitation that makes some classes UNSUITABLE to be converted into records (hint: think about what records can never have)?
- [ ] Why might a team choose records for DTOs (data transfer objects) specifically, even if they use regular classes everywhere else in their codebase?

If you're unsure on any of these, revisit `notes.md` before moving to Day 36.
