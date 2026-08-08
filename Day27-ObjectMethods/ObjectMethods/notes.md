# Day 27 - Object Class Methods (equals, hashCode, toString)

## What I learned

### 1. Every class secretly extends Object
Even without writing `extends Object`, every class inherits a few default
methods automatically.

### 2. The default toString() - not very useful
```java
Student s = new Student();
System.out.println(s); // Student@1b6d3586 (class name + hashcode, not the data)
```

### 3. Overriding toString()
```java
@Override
public String toString() {
    return "Student{name='" + name + "', age=" + age + "}";
}
```
We've actually been doing this since Day 10 without fully explaining why
it works - it's overriding Object's `toString()`.

### 4. The default equals() - compares memory addresses, not content
```java
Student s1 = new Student("Shasank", 21);
Student s2 = new Student("Shasank", 21);
s1.equals(s2); // false! Different objects, even with identical data
```
Same trap as Strings on Day 8 - `==` and default `equals()` both just check
"are these the EXACT SAME object in memory?"

### 5. Overriding equals() - compare actual content
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true; // same reference - quick exit
    if (obj == null || getClass() != obj.getClass()) return false; // different type
    Student other = (Student) obj;
    return this.age == other.age && this.name.equals(other.name);
}
```

### 6. hashCode() - must be overridden alongside equals()
THE RULE: if two objects are `.equals()`, they MUST have the same
`hashCode()`. Breaking this rule causes bugs in HashSet/HashMap.
```java
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

### 7. Why this matters for collections
```java
Set<Student> students = new HashSet<>();
students.add(new Student("Shasank", 21));
students.add(new Student("Shasank", 21)); // should be a duplicate
```
- WITHOUT overriding equals()/hashCode(): size is 2 (wrongly treated as different)
- WITH proper overrides: size is 1 (correctly recognized as a duplicate)

## Commands I ran
```bash
javac StudentWithoutOverrides.java Student.java ObjectMethodsDemo.java
java ObjectMethodsDemo
```

## Questions / things to revisit
- Why does the "equals/hashCode contract" rule only go ONE direction - equal objects MUST have the same hashCode, but objects with the same hashCode DON'T necessarily have to be equal? Why is that okay?
- What would break specifically in a HashSet/HashMap if I overrode `equals()` but FORGOT to override `hashCode()`?
- Why does `getClass() != obj.getClass()` matter in `equals()` - what could go wrong if I used `instanceof` instead in some inheritance scenarios?
