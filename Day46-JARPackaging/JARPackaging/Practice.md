# Day 46 - Practice Exercises: JAR Packaging

Try these hands-on - this is a "do it yourself" day more than a
"write new code" day.

---

### Exercise 1: Package Main.java manually into a JAR (Easy-Medium)
Using the `Main.java`, `Greeter.java`, `Calculator.java` files in this
folder, compile them and package into a JAR called `myfirstjar.jar` using
the manual `javac` + `jar cfe` commands. Run it with `java -jar` and
confirm it prints the expected output.

---

### Exercise 2: Inspect the JAR's contents (Easy-Medium)
Run `jar tf myfirstjar.jar` and look at the output. Then extract the
`META-INF/MANIFEST.MF` file specifically (hint: `jar xf myfirstjar.jar
META-INF/MANIFEST.MF`) and open it in a text editor. Confirm it lists the
correct `Main-Class`.

---

### Exercise 3: Build and run the Maven version (Medium)
Navigate into `maven-project/`, run `mvn package`, then run the resulting
JAR from the `target/` folder. Confirm the output matches what you'd
expect from `Main.java` in that folder.

---

### Exercise 4: Add your own class and rebuild (Medium-Hard)
Add a new class `Farewell.java` (in the `com.javadailypractice` package,
inside `maven-project/src/main/java/com/javadailypractice/`) with a method
`sayBye(String name)`. Call it from `Main.java`. Rebuild with `mvn package`
and confirm your new output appears when you run the JAR again.

---

### Exercise 5: Try running the JAR from a DIFFERENT folder (Harder - conceptual)
Copy the built JAR (from Exercise 3 or 4) to a completely different folder
on your computer (like your Desktop), navigate there in the terminal, and
run `java -jar day46-app.jar` from THAT location. Confirm it still works
without needing the original source code nearby. Explain in a sentence why
this proves the JAR is truly self-contained.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] Why does Exercise 5 prove something meaningful about JARs - what would have been DIFFERENT if you'd tried running `java Main.class` (not a JAR) from a different folder instead?
- [ ] In Exercise 4, why did rebuilding with `mvn package` require recompiling EVERYTHING, not just your new `Farewell.java` file (or did it - check the Maven output)?
- [ ] Why does `jar tf` show class files organized into folders like `com/javadailypractice/` - what determines that folder structure?
- [ ] If you wanted to share your program with a friend who has Java installed but no IDE or Maven, which artifact would you send them - the source `.java` files, or the built `.jar` file? Why?

This is a genuinely practical skill - the difference between "code that
runs on my machine" and "a program I can actually share" comes down to
exactly what you practiced today.
