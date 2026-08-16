# Day 44 - Generics Wildcards (? extends, ? super)

Day 17 covered basic generics - today tackles the part that confuses
almost everyone at first: wildcards.

## What I learned

### 1. The problem wildcards solve
```java
List<Integer> integers = List.of(1, 2, 3);
List<Number> numbers = integers; // ERROR - won't compile!
```
Even though `Integer` IS-A `Number`, `List<Integer>` is NOT considered a
`List<Number>` in Java's type system.

### 2. ? extends T - "read-only", accepts T or any subtype
```java
static double sumOfList(List<? extends Number> list) {
    for (Number n : list) { // safe to READ as Number
        sum += n.doubleValue();
    }
    // list.add(5); // NOT allowed - can't safely ADD
}
```
Means: "a list of SOME unknown type that IS-A Number." Safe to READ,
cannot ADD (Java can't guarantee the exact type).

### 3. ? super T - "write-only", accepts T or any supertype
```java
static void addNumbers(List<? super Integer> list) {
    list.add(1); // safe to ADD Integers
    // Number n = list.get(0); // only Object is guaranteed when reading
}
```
Means: "a list of Integer OR any broader type." Safe to ADD Integers,
reading only guarantees `Object`.

### 4. The mnemonic: PECS
**P**roducer **E**xtends, **C**onsumer **S**uper.
- Structure PRODUCES (gives you) values to read -> use `? extends`
- Structure CONSUMES (accepts) values you're adding -> use `? super`

### 5. Unbounded wildcard `?`
```java
static void printSize(List<?> list) {
    list.size(); // fine - type-independent operation
}
```
Used when the type genuinely doesn't matter.

### 6. Why this matters in practice
```java
Collections.copy(List<? super T> dest, List<? extends T> src)
```
The ACTUAL signature of `Collections.copy()` - reads from `src` (extends),
writes into `dest` (super). Once PECS clicks, signatures like this stop
looking cryptic.

## Commands I ran
```bash
javac GenericsWildcardsDemo.java
java GenericsWildcardsDemo
```

## Questions / things to revisit
- Why does `List<Integer>` fail to be treated as `List<Number>` directly, even though every Integer genuinely IS a Number - what could go WRONG if Java allowed this without wildcards?
- Using PECS: if I'm writing a method that only READS from a collection, which wildcard should I reach for, and why?
- Why does `? super Integer` only guarantee you can read items back as `Object`, not as `Integer` or `Number`?
