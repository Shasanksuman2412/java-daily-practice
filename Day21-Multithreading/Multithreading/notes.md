# Day 21 - Multithreading

## What I learned

### 1. What is a thread?
A separate path of execution within a program. By default, code runs on
ONE thread (the main thread), sequentially. Multithreading lets multiple
tasks run CONCURRENTLY.

### 2. Creating a thread - two ways

**Way 1: extend Thread**
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running: " + Thread.currentThread().getName());
    }
}
```
```java
MyThread t = new MyThread();
t.start(); // starts a NEW thread - NEVER call run() directly, that just runs it normally on the current thread!
```

**Way 2: implement Runnable (more common, more flexible)**
```java
public class MyTask implements Runnable {
    @Override
    public void run() { ... }
}
```
```java
Thread t = new Thread(new MyTask());
t.start();
```

### 3. Using a lambda
Since `Runnable` is a functional interface (one abstract method - `run()`):
```java
Thread t = new Thread(() -> System.out.println("Running from a lambda!"));
t.start();
```

### 4. The problem: unpredictable order
```java
t1.start();
t2.start();
// output order is NOT guaranteed between runs!
```

### 5. Thread.sleep() - pausing a thread
```java
Thread.sleep(1000); // pauses for 1000 milliseconds
```
**Gotcha:** throws a CHECKED `InterruptedException`, needs try-catch.

### 6. join() - waiting for a thread to finish
```java
t.start();
t.join(); // main thread WAITS here until t finishes before continuing
```

### 7. Race conditions (preview)
When multiple threads modify shared data at the same time, results become
unpredictable/wrong - this is why real concurrent programming needs
SYNCHRONIZATION (a deeper topic for another day).

## Commands I ran
```bash
javac MyThread.java MyTask.java MultithreadingDemo.java
java MultithreadingDemo
```
(Note: run this MULTIPLE times - notice how the order of some print
statements changes between runs, especially the "unpredictable order" demo
at the end!)

## Questions / things to revisit
- Why does calling `t.run()` directly NOT actually create a new thread, while `t.start()` does?
- Why does `Thread.sleep()` need to be wrapped in try-catch, but a normal method call doesn't?
- What's a race condition, in my own simple words, and why does it only become a problem when multiple threads touch the SAME shared data?
