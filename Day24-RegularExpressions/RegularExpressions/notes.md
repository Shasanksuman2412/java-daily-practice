# Day 24 - Regular Expressions (Regex)

## What I learned

### 1. What's regex?
A pattern language for matching text - validating formats, searching, and
replacing based on patterns rather than exact strings.

### 2. Basic matching
```java
text.matches("[a-zA-Z]+\\d+"); // letters followed by digits
```

### 3. Common regex building blocks

| Pattern | Meaning |
|---|---|
| `\d` | any digit (0-9) |
| `\D` | any NON-digit |
| `\w` | any word character (letter, digit, underscore) |
| `\s` | any whitespace |
| `.` | any single character |
| `+` | one or more of the previous |
| `*` | zero or more of the previous |
| `?` | zero or one of the previous |
| `{n}` | exactly n times |
| `{n,m}` | between n and m times |
| `[abc]` | any one of a, b, c |
| `^` / `$` | start / end of the string |

**Gotcha:** in Java strings, `\` must be escaped as `\\`, so `\d` becomes
`"\\d"` in actual code.

### 4. Validating input
```java
String emailPattern = "^[\\w.]+@[\\w]+\\.[a-z]{2,}$";
email.matches(emailPattern);
```

### 5. Pattern and Matcher - for more control
```java
Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher("some text with 5 and 12 numbers");

while (matcher.find()) {
    matcher.group(); // the actual matched text, one at a time
}
```

### 6. Replacing text with regex
```java
text.replaceAll("\\d{3}-\\d{3}-\\d{4}", "XXX-XXX-XXXX");
```

### 7. Splitting with regex
```java
"apple, banana,  cherry".split("\\s*,\\s*"); // splits on comma, trims spaces
```

## Commands I ran
```bash
javac RegularExpressionsDemo.java
java RegularExpressionsDemo
```

## Questions / things to revisit
- Why does `\d` need to be written as `\\d` inside a Java String literal - what's actually being escaped?
- What's the difference between `.matches()` (checks the WHOLE string) and `Matcher.find()` (finds matches ANYWHERE within the string)?
- Why does the email pattern use `{2,}` for the domain extension part instead of just `+` - what extra constraint does that add?
