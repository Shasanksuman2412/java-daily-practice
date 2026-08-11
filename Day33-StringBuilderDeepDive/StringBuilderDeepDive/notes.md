# Day 33 - StringBuilder & StringBuffer Deep Dive

We touched StringBuilder briefly on Day 8 - today goes much deeper.

## What I learned

### 1. Recap: why StringBuilder exists
Strings are IMMUTABLE (Day 8) - every `+=` in a loop creates a new String
object. `StringBuilder` is MUTABLE, modifying the same object in place.

### 2. Core methods
```java
sb.append("text");        // add to the end, works with any type
sb.insert(5, ",");         // insert at a specific index
sb.delete(5, 6);            // remove characters, start (inclusive) to end (exclusive)
sb.deleteCharAt(0);         // remove a single character
sb.replace(0, 4, "HELLO"); // replace a range with new text
sb.reverse();               // reverse the entire content
```

### 3. Chaining - most methods return the StringBuilder itself
```java
sb.append("Java").append(" is").append(" fun").reverse();
```

### 4. Useful inspection methods
```java
sb.length();
sb.charAt(2);
sb.indexOf("fun");
sb.substring(2, 6); // returns a regular String, NOT a StringBuilder
```

### 5. Converting back to a String
```java
String result = sb.toString();
```

### 6. StringBuilder vs StringBuffer - the ONE real difference
`StringBuffer` is the older, THREAD-SAFE (synchronized) version - every
method is `synchronized`, safe across multiple threads but SLOWER.
```java
StringBuffer buffer = new StringBuffer(); // same API as StringBuilder
```
RULE OF THUMB: use `StringBuilder` by default. Only reach for
`StringBuffer` if multiple threads genuinely modify the same buffer
concurrently (connects back to Day 21's multithreading).

### 7. Capacity - a performance detail
```java
StringBuilder sb = new StringBuilder(50); // pre-allocates space for 50 chars
```
Avoids repeated internal resizing if you know roughly the final size -
minor optimization, rarely something to actively think about.

## Commands I ran
```bash
javac StringBuilderDeepDiveDemo.java
java StringBuilderDeepDiveDemo
```

## Questions / things to revisit
- Why does `sb.substring(2, 6)` return a regular `String`, not another `StringBuilder` - what would break if it returned a StringBuilder instead?
- Why is `StringBuffer` slower than `StringBuilder` even in single-threaded code that never actually needs the thread-safety?
- What actually happens internally when a StringBuilder's capacity is exceeded and more text is appended - does it crash, or resize automatically?
