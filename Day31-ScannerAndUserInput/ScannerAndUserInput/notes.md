# Day 31 - Scanner & User Input Handling

We've used Scanner for reading FILES before - today it's for reading
INTERACTIVE keyboard input.

## What I learned

### 1. Reading input from the keyboard
```java
Scanner scanner = new Scanner(System.in); // System.in = keyboard input
String name = scanner.nextLine();
```

### 2. Reading different data types
```java
int age = scanner.nextInt();
double height = scanner.nextDouble();
boolean isStudent = scanner.nextBoolean();
```

### 3. THE CLASSIC TRAP: nextInt() + nextLine()
```java
int age = scanner.nextInt();      // reads the number, leaves "\n" in the buffer
String name = scanner.nextLine(); // immediately grabs that leftover "\n" - EMPTY string!
```
**Fix:**
```java
int age = scanner.nextInt();
scanner.nextLine(); // consumes the leftover newline
String name = scanner.nextLine(); // NOW this works correctly
```
This trips up almost everyone the first time they mix `nextInt()`/`nextDouble()`
with `nextLine()`.

### 4. Validating input safely
```java
if (scanner.hasNextInt()) {
    int num = scanner.nextInt();
} else {
    System.out.println("Invalid!");
    scanner.next(); // consume the bad token, or it loops forever
}
```

### 5. Looping until valid input
```java
while (true) {
    if (scanner.hasNextInt()) {
        int num = scanner.nextInt();
        if (num > 0) break;
    } else {
        scanner.next(); // discard invalid token
    }
}
```

### 6. InputMismatchException
```java
try {
    int num = scanner.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Not a valid number!");
    scanner.next(); // clear the bad token
}
```

### 7. Always close the Scanner when done
```java
scanner.close();
```

## Commands I ran
```bash
javac ScannerAndUserInputDemo.java
java ScannerAndUserInputDemo
```
(Note: this program WAITS for you to type things at each prompt - it won't
just run to completion on its own like previous days' demos!)

## Questions / things to revisit
- Why does `nextInt()` leave a leftover newline character in the buffer, but `nextLine()` doesn't have this problem when used consistently on its own?
- What's the difference between `hasNextInt()` (checking BEFORE reading) and catching `InputMismatchException` (handling AFTER a failed read)? Which is generally the better approach, and why?
- Why does `scanner.next()` (not `nextLine()`) get used specifically to discard a bad token after a failed `hasNextInt()` check?
