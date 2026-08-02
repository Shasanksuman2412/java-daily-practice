# Day 18 - File Handling (I/O)

## What I learned

### 1. Why file handling matters
Until now, all data vanished the moment the program ended. File I/O lets
you READ from and WRITE to actual files on disk - for saving data
permanently.

### 2. Writing to a file
```java
import java.io.FileWriter;
import java.io.IOException;

try {
    FileWriter writer = new FileWriter("output.txt");
    writer.write("Hello, file!\n");
    writer.close(); // IMPORTANT - always close, or data may not save
} catch (IOException e) {
    System.out.println("Error writing file: " + e.getMessage());
}
```
`IOException` is a CHECKED exception (from Day 15) - must be handled with
try-catch or declared with `throws IOException`.

### 3. Reading from a file
```java
import java.io.File;
import java.util.Scanner;

File file = new File("output.txt");
Scanner reader = new Scanner(file);
while (reader.hasNextLine()) {
    String line = reader.nextLine();
}
reader.close();
```

### 4. Appending vs overwriting
```java
new FileWriter("output.txt");        // OVERWRITES the entire file
new FileWriter("output.txt", true);  // APPENDS to the end instead
```

### 5. try-with-resources - auto-closing
```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Auto-closed!");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```
The resource automatically closes when the try block ends, even if an
exception happens partway through - safer than manually calling `.close()`.

### 6. Checking if a file exists
```java
File file = new File("output.txt");
file.exists();  // true/false
file.length();  // size in bytes
```

## Commands I ran
```bash
javac FileHandlingDemo.java
java FileHandlingDemo
```
(Note: this creates actual `output.txt` and `autoclosed.txt` files in the
same folder where you run it - check your file explorer or run `ls` after
to see them!)

## Questions / things to revisit
- What actually happens if you forget to call `.close()` on a FileWriter - does the data get lost, or just delayed?
- Why is `try-with-resources` considered safer than manually closing in a `finally` block?
- What's the difference between `FileNotFoundException` and `IOException` - is one a subtype of the other?
