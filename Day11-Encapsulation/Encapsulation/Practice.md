# Day 11 - Practice Exercises: Encapsulation

Try to solve these YOURSELF first, without looking at Student.java,
EncapsulationDemo.java, or Solutions.java.

---

### Exercise 1: Encapsulate the `BankAccount` class (Easy-Medium)
Create a class `BankAccount` with a PRIVATE field `balance` (double).
Add:
- A constructor that sets an initial balance (validate: must be >= 0,
  otherwise default to 0)
- `getBalance()` - a getter
- NO setter for balance directly (we don't want anyone setting balance to
  any random number - deposits/withdrawals should be the only way to change it)

---

### Exercise 2: Add deposit and withdraw methods (Medium)
To your `BankAccount` class, add:
```java
void deposit(double amount) {
    // only allow if amount > 0, otherwise print an error
}

void withdraw(double amount) {
    // only allow if amount > 0 AND amount <= balance, otherwise print an error
}
```
Test depositing, withdrawing more than the balance (should fail), and
withdrawing a valid amount.

---

### Exercise 3: Read-only ID field (Easy-Medium, conceptual)
Add a PRIVATE field `accountId` (String) to `BankAccount`, set once in the
constructor. Add ONLY a getter for it (`getAccountId()`), no setter -
proving that once an account is created, its ID can never be changed from
outside the class.

---

### Exercise 4: Encapsulated `Employee` class with validation (Medium-Hard)
Create a class `Employee` with private fields: `name`, `salary` (double).
- Setter for salary should reject negative values
- Add a method `giveRaise(double percentage)` that increases salary by
  that percentage, but only if percentage is between 0 and 100
- Getter for both fields

Create 2 Employee objects, try an invalid raise (like 150%) and a valid one
(like 10%), and print salaries before/after.

---

### Exercise 5: Private helper method (Harder - conceptual)
To your `Employee` class, add a PRIVATE method:
```java
private boolean isValidPercentage(double percentage) {
    return percentage > 0 && percentage <= 100;
}
```
Use this private method INSIDE `giveRaise()` instead of repeating the
condition directly. This shows that private methods (not just private
fields) are also a form of encapsulation - hiding internal helper logic
that callers never need to know about.

---

## Self-check before moving to Day 12
You should be able to answer these without looking anything up:
- [ ] Why does `BankAccount` intentionally have NO setter for `balance`?
- [ ] What's the difference between a private FIELD and a private METHOD, in terms of what they hide?
- [ ] If `accountId` only has a getter, can code OUTSIDE the class change it after creation? What about code INSIDE the class?
- [ ] Why validate inside `deposit()`/`withdraw()` instead of just trusting whoever calls them?

If you're unsure on any of these, revisit `notes.md` before moving to Day 12.
