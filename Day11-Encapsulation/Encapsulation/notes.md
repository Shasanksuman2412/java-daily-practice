# Day 11 - Encapsulation (Getters & Setters)

## What I learned

### 1. The problem from Day 10
Fields were directly accessible from outside the class:
```java
s1.age = -50; // nonsense, but Java allowed it - no protection at all
```

### 2. Encapsulation - hide the data, control access
Make fields `private` so they're ONLY accessible from inside the class.
Provide public methods (getters/setters) to read/write them safely:
```java
private int age;

public int getAge() {
    return age;
}

public void setAge(int age) {
    if (age > 0 && age < 120) {
        this.age = age;
    } else {
        System.out.println("Invalid age, ignoring.");
    }
}
```

### 3. Using getters and setters
```java
s1.setAge(21);   // goes through validation, accepted
s1.setAge(-5);   // rejected, prints warning, age stays unchanged
s1.getAge();     // safely reads the current value
```

### 4. Why this matters
- **Validation** - invalid data gets caught before it corrupts the object.
- **Flexibility** - internal logic can change later without breaking code
  that uses `getAge()`/`setAge()`.
- **Read-only fields** - providing only a getter (no setter) makes a field
  effectively read-only from outside the class.

### 5. Naming convention
`getX()` to read, `setX(value)` to write, matching field `x` in camelCase.

### 6. Constructors can use setters too
Calling `setAge(age)` inside the constructor (instead of `this.age = age`
directly) means even object CREATION goes through validation.

## Commands I ran
```bash
javac Student.java EncapsulationDemo.java
java EncapsulationDemo
```

## Questions / things to revisit
- Why does making a field `private` and only exposing a getter (no setter) effectively make it "read-only" from outside the class?
- What actually happens if you try `s1.age = -5;` directly when `age` is private - compile error or runtime error?
- Is it ever okay to skip a setter and just make a getter-only field? When would that make sense (e.g. an ID that should never change after creation)?
