# Day 39 - Text Blocks (Modern Java)

## What I learned

### 1. The problem with multi-line strings before Java 15
```java
String html = "<html>\n" +
              "  <body>\n" +
              "</html>";
```
Messy - constant `\n`, `+` concatenation, escaped quotes everywhere.

### 2. Text blocks - `"""`
```java
String html = """
              <html>
                <body>
                </body>
              </html>
              """;
```
Clean, multi-line, no `\n`, no `+`, no escaping needed for most characters.

### 3. Rules of the opening `"""`
The opening `"""` must be followed immediately by a newline - nothing else
on that line. Content starts on the NEXT line.

### 4. Indentation - Java strips "incidental" whitespace automatically
Java looks at the CLOSING `"""`'s indentation to figure out the common
leading whitespace, and strips that same amount from EVERY line. This lets
source code stay nicely indented without extra spaces leaking into the
actual string content.

### 5. Embedded quotes - no more escaping madness
```java
String json = """
              {
                "name": "Shasank"
              }
              """;
```
Double quotes inside a text block do NOT need escaping (unlike regular
strings, where `"` needs `\"`).

### 6. Trailing newline control
```java
"""
Hello""";     // closing """ on the SAME line as text = NO trailing newline

"""
Hello
""";          // closing """ on its OWN line = INCLUDES a trailing newline
```

### 7. Combining with .formatted() for variable substitution
```java
String message = """
                  Hello, %s!
                  You are %d years old.
                  """.formatted(name, age);
```
Text blocks don't have built-in interpolation, but `.formatted()` fills
the gap nicely.

### 8. Escape sequences still work when needed
```java
"""
Line one \
continues here (no actual newline)
""";
```
A `\` at the end of a line suppresses that line break - useful for
wrapping long lines in source without adding a real newline to the value.

## Commands I ran
```bash
javac TextBlocksDemo.java
java TextBlocksDemo
```

## Questions / things to revisit
- Why does Java use the CLOSING `"""`'s position to determine how much leading whitespace to strip, rather than the opening `"""`'s position?
- Why doesn't a `"` character need escaping inside a text block, but a `"""` sequence WOULD need special handling if it appeared in the actual content?
- What's the practical difference between putting the closing `"""` on its own line vs right after the last character of text - what does each mean for the resulting String's trailing newline?
