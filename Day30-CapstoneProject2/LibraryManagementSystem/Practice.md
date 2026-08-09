# Day 30 - Practice Exercises: Extend the Library Management System

Like Day 20, these ask you to MODIFY the actual project files. No separate
Solutions.java - build it yourself.

---

### Exercise 1: Add a `Member` class (Easy-Medium)
Create a class `Member` with fields `name`, `memberId`, and a
`List<String> borrowedIsbns` (tracking which books they currently have).
Add methods `borrowBook(String isbn)` and `returnBook(String isbn)` that
just update the member's own list (the actual availability logic still
lives in `Library`).

---

### Exercise 2: Link borrowing to a specific Member (Medium)
Modify `Library.borrowBook()` to accept a `Member` parameter too:
```java
public void borrowBook(String isbn, Member member) throws BookNotFoundException, BookNotAvailableException
```
When successful, it should ALSO update the member's `borrowedIsbns` list
(call the Member's own `borrowBook()` method internally).

---

### Exercise 3: Report overdue-style tracking with LocalDate (Medium-Hard)
Add a field `LocalDate borrowedDate` to `Book`, set when a book is
borrowed (Day 23's Date API). Add a method in `Library`:
```java
public List<Book> findBooksOverdue(int daysAllowed)
```
Using streams, return all currently BORROWED books where
`ChronoUnit.DAYS.between(borrowedDate, LocalDate.now()) > daysAllowed`.

---

### Exercise 4: Mark a book as LOST and prevent re-borrowing (Medium)
Add a method `markAsLost(String isbn)` in `Library` that sets a book's
status to `BookStatus.LOST`. Confirm that `borrowBook()` correctly throws
`BookNotAvailableException` for a LOST book (it already should, if
`borrowBook()` checks `status != AVAILABLE` generically - verify this).

---

### Exercise 5: Full interactive menu (Harder)
Build a `Scanner`-based menu (like Day 20's Exercise 5) with options:
```
1. Add Book
2. Borrow Book
3. Return Book
4. Search by Title
5. View Report
6. Save and Exit
```
Loop until option 6, handling exceptions gracefully so a bad borrow
attempt doesn't crash the whole program.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 2's `borrowBook(isbn, member)` need to update TWO different objects (the Book's status AND the Member's list) for one borrow action?
- [ ] In Exercise 3, why is storing `LocalDate` (immutable) safer than storing a mutable date-like object for tracking borrow dates?
- [ ] Why does Exercise 5's menu loop need try-catch AROUND each risky operation, rather than one big try-catch around the entire loop?
- [ ] Looking back at the whole month: which single day's topic do you think you'll use MOST often in real projects going forward, and why?

Congratulations on completing 30 days of consistent Java practice. This
repository is proof of real, compounding progress - keep building on it.
