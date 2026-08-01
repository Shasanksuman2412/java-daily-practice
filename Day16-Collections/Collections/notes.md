# Day 16 - Collections Framework

## What I learned

### 1. The Collections hierarchy (big picture)
Java's `java.util` package gives flexible containers, better than plain
arrays:
- **List** - ordered, allows duplicates (`ArrayList`, `LinkedList`)
- **Set** - no duplicates allowed (`HashSet`, `TreeSet`)
- **Map** - key-value pairs (`HashMap`, `TreeMap`)

### 2. List
```java
List<String> names = new ArrayList<>();
names.add("Shasank");
names.add("Shasank"); // duplicates ARE allowed, both stay
names.get(0);          // access by index
```

### 3. Set - no duplicates
```java
Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("Shasank");
uniqueNames.add("Shasank"); // ignored silently
```
**Gotcha:** `HashSet` doesn't guarantee any order. Use `TreeSet` for
automatic sorted order.

### 4. Map - key-value pairs
```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Shasank", 21);
ages.get("Shasank");           // 21
ages.containsKey("Shasank");   // true
```
Putting a value with an EXISTING key overwrites the old value, it doesn't
add a duplicate entry.

### 5. Iterating
```java
for (String name : names) { }                 // List/Set - direct for-each

for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    entry.getKey();
    entry.getValue();
}
```

### 6. Collections utility class
```java
Collections.sort(list);      // sorts in place
Collections.reverse(list);   // reverses in place
Collections.max(list);
Collections.min(list);
```

## Commands I ran
```bash
javac CollectionsDemo.java
java CollectionsDemo
```

## Questions / things to revisit
- Why does a `List` allow duplicates but a `Set` doesn't - what's the actual reason behind this design choice?
- What determines the order elements appear in when printing a `HashSet` - is it insertion order, sorted order, or something else entirely?
- What happens if I `put()` a value using a key that already exists in a `HashMap` - does it error, add a second entry, or overwrite?
- When would I choose `ArrayList` over `LinkedList`, or vice versa?
