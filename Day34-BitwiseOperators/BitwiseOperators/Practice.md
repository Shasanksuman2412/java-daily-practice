# Day 34 - Practice Exercises: Bitwise Operators

Try to solve these YOURSELF first, without looking at
BitwiseOperatorsDemo.java or Solutions.java.

---

### Exercise 1: Check if a number is a power of 2 (Easy-Medium)
Write a method `boolean isPowerOfTwo(int n)` using a bitwise trick:
a power of 2 in binary has exactly ONE bit set (e.g. 8 = 1000). The trick:
`n > 0 && (n & (n - 1)) == 0`. Test with 16 (true), 18 (false), and 1 (true).
Explain in a comment WHY `n & (n-1)` clears the lowest set bit.

---

### Exercise 2: Count the number of set bits (Easy-Medium)
Write a method `int countSetBits(int n)` that counts how many bits are `1`
in the binary representation of `n`. Use a loop with `n & 1` and `n >>= 1`
(or use the built-in `Integer.bitCount()` to check your answer).
Test with 7 (should be 3, since 111 has three 1s).

---

### Exercise 3: Swap two array elements using XOR (Medium)
Given `int[] arr = {10, 20, 30, 40};`
Swap `arr[0]` and `arr[3]` using the XOR trick (no temp variable). Print
the array before and after.
(Careful: the XOR trick breaks if you try to swap an element with ITSELF -
think about why, and add a guard against that case.)

---

### Exercise 4: Toggle a bit flag (Medium)
Using the READ/WRITE/EXECUTE flag pattern from the demo, write a method
`int toggleFlag(int permissions, int flag)` that FLIPS a specific flag
(turns it on if off, off if on) using XOR. Test by toggling WRITE on a
permission set twice - it should end up back where it started.

---

### Exercise 5: Convert a number to binary WITHOUT Integer.toBinaryString() (Harder)
Write a method `String toBinary(int n)` that manually builds the binary
representation of a POSITIVE int using bitwise shifts and ANDs (no
built-in conversion methods allowed). Test with several numbers and
confirm your output matches `Integer.toBinaryString(n)`.

---

## Self-check before moving to Day 35
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why does `n & (n-1)` always clear the LOWEST set bit of n - trace through an example like n=8 (1000) and n-1=7 (0111).
- [ ] In Exercise 3, why does the XOR swap trick FAIL if you try to swap an element with itself (like `arr[0]` and `arr[0]`)?
- [ ] Why does toggling the SAME flag twice with XOR (Exercise 4) always return you to the original state?
- [ ] Why does `n >>= 1` (used in Exercise 2) eventually make `n` become 0, guaranteeing the loop terminates?

If you're unsure on any of these, revisit `notes.md` before moving to Day 35.
