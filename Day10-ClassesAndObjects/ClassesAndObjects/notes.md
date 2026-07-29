# Day 10 - Classes & Objects (OOP Basics)

## What I learned

This is a big shift - everything before this was inside one `main` method.
Today starts real Object-Oriented Programming (OOP).

### 1. What's a class?
A blueprint for creating objects - defines what data (fields) and behavior
(methods) something has.
```java
public class Student {
    String name;
    int age;
    double marks;

    void displayInfo() {
        System.out.println(name + " is " + age + " years old.");
    }
}
```

### 2. Creating objects
An object is an actual INSTANCE of a class - the real thing built from the
blueprint, using the `new` keyword:
```java
Student s1 = new Student();
s1.name = "Shasank";
```
Each object created from the same class has its OWN separate copy of the
fields - changing one object's data never affects another.

### 3. Constructors
A special method that runs automatically when an object is created with
`new`. It has the SAME NAME as the class and NO return type (not even void):
```java
Student(String name, int age, double marks) {
    this.name = name;
    this.age = age;
    this.marks = marks;
}
```
```java
Student s1 = new Student("Shasank", 21, 85.5); // sets values immediately
```

### 4. The `this` keyword
Refers to the CURRENT object. Needed when a parameter name matches a field
name, so Java knows which one you mean:
```java
Student(String name, int age) {
    this.name = name; // this.name = the FIELD, name = the PARAMETER
}
```

### 5. Array of objects
You can have an array where each element is an object, just like an array
of ints:
```java
Student[] students = {
    new Student("Amit", 20, 45.0),
    new Student("Neha", 23, 78.0)
};
for (Student s : students) {
    s.displayInfo();
}
```

## Commands I ran
```bash
javac Student.java ClassesAndObjectsDemo.java
java ClassesAndObjectsDemo
```
(Note: two files this time - Student.java defines the class, and
ClassesAndObjectsDemo.java uses it. Both must be compiled together, or
compile ClassesAndObjectsDemo.java alone and javac will auto-compile
Student.java since it's in the same folder.)

## Questions / things to revisit
- What's the difference between a CLASS and an OBJECT, in my own simple words?
- Why does a constructor have no return type, not even `void`?
- What would happen if I tried to create a Student WITHOUT using `new` - is that even possible?
- What does "each object has its own copy of the fields" actually mean in terms of memory?
