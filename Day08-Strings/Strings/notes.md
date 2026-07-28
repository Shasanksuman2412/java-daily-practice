# Day 08 - Strings

## What I learned

### 1. Strings are objects, and they're immutable
`String` is NOT a primitive - it's an object. And it's immutable: once
created, its content can never change. Every "modification" method
actually returns a brand NEW String.
```java
String s = "hello";
s.concat(" world"); // does NOT change s!
s = s.concat(" world"); // must reassign to capture the new String
```

### 2. Common String methods
```java
text.length();          // number of characters
text.trim();             // removes leading/trailing whitespace
text.toUpperCase();      // ALL CAPS
text.toLowerCase();      // all lowercase
text.charAt(2);          // character at a specific index
text.indexOf("Java");    // position where a substring starts (-1 if not found)
text.substring(2, 7);    // characters from index 2 up to (NOT including) 7
```

### 3. equals() vs == (the classic Java trap)
```java
String a = new String("hi");
String b = new String("hi");
a == b        // false - compares memory addresses (are they the SAME object?)
a.equals(b)   // true - compares actual content
```
**Rule: always use `.equals()` to compare String content, never `==`.**

### 4. Concatenation vs StringBuilder
`+=` in a loop is inefficient - every iteration creates a brand new String
object in memory (because Strings are immutable). For repeated building,
use `StringBuilder`:
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("World");
String result = sb.toString();
```

### 5. Splitting and joining
```java
String[] parts = "apple,banana,cherry".split(","); // splits into an array
String joined = String.join("-", parts);            // joins array back into one String
```

## Commands I ran
```bash
javac StringsDemo.java
java StringsDemo
```

## Questions / things to revisit
- Why does Java keep Strings immutable at all - what's the actual benefit (hint: think about String pooling and thread safety)?
- What does the String Pool / String constant pool actually do, and how does it relate to why `"hi" == "hi"` might behave differently than `new String("hi") == new String("hi")`?
- At what point (how many concatenations) does StringBuilder actually start mattering performance-wise vs plain `+=`?
