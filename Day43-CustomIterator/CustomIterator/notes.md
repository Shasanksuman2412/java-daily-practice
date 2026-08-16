# Day 43 - Custom Iterator & Iterable

Every for-each loop over a List or array has been using Iterable/Iterator
without you knowing it - today we build our own.

## What I learned

### 1. Why does for-each even work on a List?
```java
for (String s : someList) { }
```
Only works because `List` implements `Iterable<String>`. for-each is just
syntactic sugar - Java rewrites it into Iterator calls behind the scenes.

### 2. The Iterable and Iterator interfaces
```java
public interface Iterable<T> {
    Iterator<T> iterator(); // must provide a way to GET an iterator
}

public interface Iterator<T> {
    boolean hasNext(); // is there another element?
    T next();           // get the next element, advance the position
}
```

### 3. Building a custom Iterable class
```java
public class Playlist implements Iterable<String> {
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() { return index < songs.length; }
            public String next() { return songs[index++]; }
        };
    }
}
```
```java
for (String song : playlist) { } // works! for-each calls .iterator() automatically
```

### 4. What for-each actually compiles down to
```java
Iterator<String> it = playlist.iterator();
while (it.hasNext()) {
    String song = it.next();
    // loop body
}
```

### 5. NoSuchElementException - calling next() too many times
Always check `hasNext()` BEFORE calling `next()` - that's the entire
contract. Ignoring it eventually throws `NoSuchElementException`.

### 6. Custom iteration order - the real power
Since YOU control `iterator()`, you can define ANY traversal order -
reverse, filtered, every-other-element, etc. - not just front-to-back.

### 7. Filtering during iteration
The trick: `hasNext()` can SKIP ahead internally to find the next valid
element before reporting whether one exists.

## Commands I ran
```bash
javac Playlist.java CustomIteratorDemo.java
java CustomIteratorDemo
```

## Questions / things to revisit
- Why does the anonymous `Iterator` implementation need its OWN `index` field, separate from anything in the outer `Playlist` class - what would break if multiple iterators shared one index?
- Why does the filtered iterator's `hasNext()` need a `while` loop internally, rather than just checking the CURRENT index once?
- Could you have TWO separate iterators active on the SAME Playlist at the same time, each at a different position? Why or why not, given how `iterator()` is implemented?
