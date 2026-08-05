# Day 23 - Date & Time API

## What I learned

### 1. Why not just use Date (the old class)?
`java.util.Date` was confusing and MUTABLE (values could change
unexpectedly). Since Java 8, `java.time` gives clean, IMMUTABLE date/time
classes.

### 2. LocalDate - just a date, no time
```java
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(2003, 5, 15); // year, month, day
```

### 3. LocalTime and LocalDateTime
```java
LocalTime now = LocalTime.now();
LocalDateTime meeting = LocalDateTime.of(2026, 8, 10, 14, 30); // date + time
```

### 4. Date arithmetic - immutable, returns a NEW object
```java
LocalDate nextWeek = today.plusDays(7);
LocalDate lastMonth = today.minusMonths(1);
```
**Gotcha:** `today.plusDays(7)` does NOT change `today` - it returns a NEW
LocalDate. Forgetting to capture the result is a very common mistake.

### 5. Comparing dates
```java
date1.isBefore(date2);
date1.isAfter(date2);
date1.isEqual(date2);
```

### 6. Calculating the difference between dates
```java
Period period = Period.between(date1, date2);
period.getMonths();
period.getDays();
```

### 7. Formatting dates
```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
String formatted = today.format(formatter); // e.g. "05-08-2026"
```

### 8. Getting parts of a date
```java
today.getYear();
today.getMonth();       // enum, e.g. AUGUST
today.getDayOfWeek();   // enum, e.g. WEDNESDAY
today.getDayOfMonth();
```

## Commands I ran
```bash
javac DateTimeAPIDemo.java
java DateTimeAPIDemo
```

## Questions / things to revisit
- Why does `today.plusDays(7);` (without reassigning) leave `today` completely unchanged - what does "immutable" actually guarantee here?
- What's the difference between `LocalDate`, `LocalTime`, and `LocalDateTime` - when would I use each?
- Why does `Period.between()` give months AND days separately instead of just total days - when would that separation actually matter?
