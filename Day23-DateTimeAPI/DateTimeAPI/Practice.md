# Day 23 - Practice Exercises: Date & Time API

Try to solve these YOURSELF first, without looking at DateTimeAPIDemo.java
or Solutions.java.

---

### Exercise 1: Age calculator (Easy-Medium)
Declare `LocalDate birthDate = LocalDate.of(2000, 3, 20);`
Calculate the person's current age in years using `Period.between()` and
`LocalDate.now()`. Print it as `"You are X years old"`.

---

### Exercise 2: Days until a future event (Easy-Medium)
Declare `LocalDate eventDate = LocalDate.of(2026, 12, 25);` (Christmas)
Calculate how many days remain until that date from today, using
`java.time.temporal.ChronoUnit.DAYS.between(date1, date2)`. Print the result.

---

### Exercise 3: Is it a weekend? (Medium)
Write a method `boolean isWeekend(LocalDate date)` that returns `true` if
the date falls on Saturday or Sunday. Test it with today's date and with a
manually created date you know is a weekend.
(Hint: `date.getDayOfWeek()` returns a `DayOfWeek` enum - compare it against
`DayOfWeek.SATURDAY` and `DayOfWeek.SUNDAY`.)

---

### Exercise 4: Format a date multiple ways (Medium)
Declare `LocalDate date = LocalDate.of(2026, 8, 5);`
Format it THREE different ways using different `DateTimeFormatter` patterns:
- `"dd/MM/yyyy"` (e.g. 05/08/2026)
- `"MMMM d, yyyy"` (e.g. August 5, 2026)
- `"EEEE"` (just the day name, e.g. Wednesday)

---

### Exercise 5: Countdown with days, months, AND years (Harder)
Declare two dates: `LocalDate start = LocalDate.of(2020, 1, 1);` and
`LocalDate end = LocalDate.of(2026, 8, 5);`
Using `Period.between()`, print the FULL difference in the format:
`"X years, Y months, Z days"` (all three components together, not just
total days).

---

## Self-check before moving to Day 24
You should be able to answer these without looking anything up:
- [ ] Why does `Period.between(date1, date2)` give a DIFFERENT result depending on the ORDER of date1 and date2 - what happens if you swap them?
- [ ] What's the difference between using `Period` and using `ChronoUnit.DAYS.between()` - when would you use each?
- [ ] Why can't you just use `==` to compare two `LocalDate` objects for equality - what should you use instead?
- [ ] What does immutability mean for `LocalDate.now().plusDays(1)` if you forget to store the result in a variable?

If you're unsure on any of these, revisit `notes.md` before moving to Day 24.
