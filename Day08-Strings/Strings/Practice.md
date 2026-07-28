# Day 08 - Practice Exercises: Strings

Try to solve these YOURSELF first, without looking at StringsDemo.java or
Solutions.java.

---

### Exercise 1: Palindrome Checker (Easy-Medium)
Declare `String word = "madam";`
Check if it reads the same forwards and backwards. Print `true` or `false`.
(Don't use any built-in reverse method - build the reversed version
yourself using a loop and `charAt()`.)

---

### Exercise 2: Count vowels and consonants (Easy-Medium)
Declare `String sentence = "Java is a fun language";`
Loop through character by character and count how many vowels (a, e, i, o, u
- both cases) and consonants there are. Ignore spaces.

---

### Exercise 3: Reverse each word in a sentence (Medium)
Declare `String sentence = "Java is fun";`
Reverse EACH WORD individually but keep the word order the same, so the
output should be: `avaJ si nuf`
(Hint: `.split(" ")` to get words, reverse each one, then join them back.)

---

### Exercise 4: Check if two strings are anagrams (Medium-Hard)
Declare `String s1 = "listen";` and `String s2 = "silent";`
Check if they're anagrams of each other (same letters, different order,
same frequency of each letter). Print `true` or `false`.
(Hint: sort the characters of both strings and compare, OR count character
frequencies manually.)

---

### Exercise 5: Word frequency counter (Harder)
Declare `String text = "the cat sat on the mat the cat ran";`
Count how many times EACH word appears, and print each unique word with
its count. (You'll likely want a `HashMap<String, Integer>` for this -
look up how `.getOrDefault()` works if you haven't used HashMap yet.)

---

## Self-check before moving to Day 09
You should be able to answer these without looking anything up:
- [ ] Why can't you reverse a String in place the way you did with an array (hint: immutability)?
- [ ] What's the actual difference between `.equals()` and `==` for Strings, in your own words?
- [ ] Why is building a String with `+=` inside a loop considered bad practice for large loops?
- [ ] What does `.split(" ")` actually return - a String, an array, or something else?

If you're unsure on any of these, revisit `notes.md` before moving to Day 09.
