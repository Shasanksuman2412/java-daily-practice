# Day 33 - Practice Exercises: StringBuilder & StringBuffer Deep Dive

Try to solve these YOURSELF first, without looking at
StringBuilderDeepDiveDemo.java or Solutions.java.

---

### Exercise 1: Build a CSV row with StringBuilder (Easy-Medium)
Given `String[] fields = {"Shasank", "21", "Java Developer"};`
Use a `StringBuilder` and a loop to build a comma-separated line like
`"Shasank,21,Java Developer"` (no trailing comma). Print the result.

---

### Exercise 2: Palindrome check using StringBuilder.reverse() (Easy-Medium)
Write a method `boolean isPalindrome(String s)` that uses
`new StringBuilder(s).reverse()` to check if a string reads the same
forwards and backwards. Test with `"madam"` and `"hello"`.
(You solved this manually with a loop back on Day 08 - now do it the easy
way using StringBuilder's built-in reverse.)

---

### Exercise 3: Remove all vowels using delete methods (Medium)
Given `String text = "Programming is powerful";`
Use a `StringBuilder` and loop BACKWARDS through it (important - deleting
while iterating forward skips characters!), using `deleteCharAt()` to
remove every vowel. Print the result.

---

### Exercise 4: Insert formatting into a running total (Medium-Hard)
Build a `StringBuilder` that represents a running commentary, like:
start with `"Total: 0"`, then use `.replace()` to update the number each
time you "add" to a total (e.g. after adding 50, it should read
`"Total: 50"`, after adding 30 more, `"Total: 80"`). Do this for 3 updates
using `indexOf()` to find where the number starts.

---

### Exercise 5: Compare performance - StringBuilder vs String concatenation (Harder)
Write a loop that builds a string of 50,000 characters using PLAIN String
concatenation (`+=`), timing it with `System.currentTimeMillis()`. Then do
the SAME thing using `StringBuilder.append()`, timing that too. Print both
times and compare - which is dramatically faster, and why (think back to
Day 8's immutability lesson)?

---

## Self-check before moving to Day 34
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 3 specifically need to loop BACKWARDS when deleting characters - what goes wrong if you loop forward instead while deleting?
- [ ] Why is `new StringBuilder(s).reverse()` a genuinely clean way to check palindromes, compared to manually writing a reversal loop yourself?
- [ ] In Exercise 5, roughly how much faster would you expect StringBuilder to be for 50,000 characters - orders of magnitude, or just slightly?
- [ ] Why does `sb.append(123)` (an int, not a String) work without any explicit conversion - what's happening automatically?

If you're unsure on any of these, revisit `notes.md` before moving to Day 34.
