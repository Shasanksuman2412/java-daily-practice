# Day 21 - Practice Exercises: Multithreading

Try to solve these YOURSELF first, without looking at MyThread.java,
MyTask.java, MultithreadingDemo.java, or Solutions.java.

---

### Exercise 1: Create a counting thread (Easy-Medium)
Create a `Runnable` (using a lambda or a class) that counts from 1 to 5,
printing each number with a `Thread.sleep(300)` between each print. Start
it and observe the numbers appearing with a small delay between them.

---

### Exercise 2: Two threads counting simultaneously (Easy-Medium)
Create TWO separate threads, each counting from 1 to 5 with a short sleep
between numbers, but give them different names/labels (e.g. "Thread A: 1",
"Thread B: 1"). Start both and observe how their output INTERLEAVES rather
than running one fully before the other.

---

### Exercise 3: Using join() to enforce order (Medium)
Create two threads: one that prints "Step 1 done" after a 500ms sleep, and
a second that prints "Step 2 done" immediately. Use `join()` correctly so
that "Step 1 done" ALWAYS prints before "Step 2 done" is started, even
though thread scheduling is normally unpredictable.

---

### Exercise 4: Simulate a race condition (Medium-Hard)
Create a shared `int counter = 0;` (use an array `int[] counter = {0};` or
a simple class field so it can be modified from inside a lambda).
Create TWO threads, each incrementing the counter 1000 times in a loop
(`counter[0]++`). Start both, `join()` both, then print the final counter
value. Run it a few times - notice the result is NOT always 2000, even
though 1000+1000 should always equal 2000! This is a race condition.

---

### Exercise 5: Fix the race condition with synchronized (Harder - conceptual)
Look up the `synchronized` keyword. Wrap the counter increment operation
in a `synchronized` block (or make a `synchronized` method that does the
increment) so that only ONE thread can modify the counter at a time. Rerun
Exercise 4 with this fix and confirm the result is reliably 2000 every time.

---

## Self-check before moving to Day 22
You should be able to answer these without looking anything up:
- [ ] Why does calling `.start()` on multiple threads NOT guarantee any particular execution order between them?
- [ ] In Exercise 3, what would happen if you called `join()` in the WRONG place (e.g., before starting the second thread)?
- [ ] Why does Exercise 4 sometimes give a result LESS than 2000 - what's actually happening when two threads read/modify the counter at nearly the same instant?
- [ ] What does `synchronized` actually prevent, in your own words?

If you're unsure on any of these, revisit `notes.md` before moving to Day 22.
