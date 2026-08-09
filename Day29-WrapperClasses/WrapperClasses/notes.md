# Day 29 - Wrapper Classes & Autoboxing

## What I learned

### 1. What are wrapper classes?
Every primitive type has a corresponding OBJECT version:

| Primitive | Wrapper Class |
|---|---|
| int | Integer |
| double | Double |
| char | Character |
| boolean | Boolean |
| long | Long |
| float | Float |
| byte | Byte |
| short | Short |

### 2. Why do wrapper classes exist?
Primitives CAN'T be used where Java needs an actual object, like generics:
```java
List<int> numbers = new ArrayList<>();     // ERROR
List<Integer> numbers = new ArrayList<>(); // works
```
Also add useful methods primitives don't have:
```java
Integer.parseInt("42");
Integer.MAX_VALUE;
Integer.toBinaryString(10);
```

### 3. Autoboxing - primitive -> wrapper, automatically
```java
int x = 10;
Integer boxed = x; // Java converts int -> Integer behind the scenes
```

### 4. Unboxing - wrapper -> primitive, automatically
```java
Integer boxed = 50;
int unboxed = boxed; // Java converts Integer -> int
```
This is why `list.add(5)` on a `List<Integer>` "just works".

### 5. The Integer caching gotcha
```java
Integer a = 100;
Integer b = 100;
a == b; // true - small values (-128 to 127) are CACHED and reused

Integer c = 200;
Integer d = 200;
c == d; // false - outside cache range, these are DIFFERENT objects
```
CLASSIC Java trap. Always use `.equals()` to compare wrapper values, never
`==`.

### 6. NullPointerException risk with unboxing
```java
Integer value = null;
int result = value; // throws NullPointerException! Can't unbox null
```

### 7. Comparing and parsing
```java
Integer.compare(5, 10);       // negative, since 5 < 10
Double.parseDouble("3.14");
Boolean.parseBoolean("true");
```

## Commands I ran
```bash
javac WrapperClassesDemo.java
java WrapperClassesDemo
```

## Questions / things to revisit
- Why does Java cache Integer values from -128 to 127 specifically - what's the practical reasoning behind that particular range?
- Why does `int result = value;` throw a NullPointerException when `value` is a null `Integer`, but `Integer result = value;` (no unboxing) would NOT throw anything?
- If I compare two `Integer` objects with `==` and get `true`, does that GUARANTEE they hold the same value, or could it just be luck from caching?
