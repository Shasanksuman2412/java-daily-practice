# Day 46 - Packaging a Runnable JAR File

Every project so far needed `javac` + `java` run manually. Today we
package a project into ONE distributable file anyone can run with just
`java -jar`.

## What I learned

### 1. What's a JAR file?
"Java ARchive" - basically a `.zip` file containing compiled `.class`
files, plus a manifest describing how to run it.

### 2. The manual way - compile, then package with `jar`
```bash
javac Main.java Greeter.java Calculator.java
jar cfe MyApp.jar Main *.class
```
- `c` = create a new archive
- `f` = specify the output filename
- `e` = specify the entry point (the class with main())

```bash
java -jar MyApp.jar
```

### 3. What's actually inside a JAR
```bash
jar tf MyApp.jar   # list contents
```
Contains `.class` files PLUS a `META-INF/MANIFEST.MF` text file telling
Java which class has the entry point:
```
Manifest-Version: 1.0
Main-Class: Main
```

### 4. The Maven way - for real projects with dependencies
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <mainClass>com.example.Main</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```
```bash
mvn package
java -jar target/myapp-1.0.jar
```

### 5. Fat/Uber JARs - bundling dependencies INSIDE the JAR
A plain `mvn package` JAR still needs dependencies available separately.
For a self-contained JAR (like Day 45's SQLite driver bundled in), use the
Shade plugin - produces ONE JAR containing code AND every dependency.

### 6. Why this matters
Every real Java application eventually ships this way - the difference
between "here's my source code, good luck compiling it" and "here's one
file, just run it."

## How to actually try this

### Option A - Manual way (no Maven needed)
```bash
cd Day46-JARPackaging/JARPackaging
javac Main.java Greeter.java Calculator.java
jar cfe day46-manual.jar Main Main.class Greeter.class Calculator.class
java -jar day46-manual.jar
```

### Option B - Maven way (in maven-project/ subfolder)
```bash
cd Day46-JARPackaging/JARPackaging/maven-project
mvn package
java -jar target/day46-app.jar
```
This produces a JAR whose manifest already points to `com.javadailypractice.Main`,
so `java -jar` finds the entry point automatically - no need to specify
the class name again.

### Bonus: inspect what's inside
```bash
jar tf target/day46-app.jar
```
You'll see the compiled `.class` files organized by package folder
(`com/javadailypractice/Main.class`) plus `META-INF/MANIFEST.MF`.

## Commands I ran
See above - this day is entirely about running commands rather than just
executing a single `java` call like previous days.

## Questions / things to revisit
- Why does the manual `jar cfe` command need the Main class name specified TWICE in effect (once as the entry point argument, once implicitly via the `.class` file) - what's each part actually doing?
- Why does a package-based project (`com.javadailypractice.Main`) need its `.class` files organized into matching folder structure INSIDE the JAR (`com/javadailypractice/Main.class`)?
- Why would a fat/uber JAR (Shade plugin) matter enormously for Day 45's SQLite project, but not really matter for THIS project (which has zero external dependencies)?
