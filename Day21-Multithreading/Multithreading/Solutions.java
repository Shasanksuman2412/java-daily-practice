public class Solutions {
    public static void main(String[] args) throws InterruptedException {

        // ---- Exercise 1: counting thread ----
        Thread counter1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Count: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
            }
        });
        counter1.start();
        counter1.join(); // wait so exercise 1's output doesn't mix with exercise 2's
        System.out.println("---");

        // ---- Exercise 2: two threads counting simultaneously ----
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread A: " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {}
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread B: " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {}
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join(); // wait for both before moving on
        System.out.println("---");

        // ---- Exercise 3: using join() to enforce order ----
        Thread step1 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            System.out.println("Step 1 done");
        });
        step1.start();
        step1.join(); // MAIN thread waits here until step1 finishes...

        Thread step2 = new Thread(() -> System.out.println("Step 2 done"));
        step2.start(); // ...so step2 only starts AFTER step1 has fully completed
        step2.join();
        System.out.println("---");

        // ---- Exercise 4: simulate a race condition ----
        int[] counter = {0}; // array trick so lambdas can modify it

        Thread incrementer1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter[0]++; // NOT thread-safe - read, increment, write is 3 separate steps
            }
        });
        Thread incrementer2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter[0]++;
            }
        });
        incrementer1.start();
        incrementer2.start();
        incrementer1.join();
        incrementer2.join();
        System.out.println("Final counter (race condition, unreliable): " + counter[0]);
        // may print less than 2000 - two threads can read the same value
        // before either writes back the incremented result, losing updates
        System.out.println("---");

        // ---- Exercise 5: fix with synchronized ----
        Counter safeCounter = new Counter();
        Thread safeIncrementer1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        });
        Thread safeIncrementer2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        });
        safeIncrementer1.start();
        safeIncrementer2.start();
        safeIncrementer1.join();
        safeIncrementer2.join();
        System.out.println("Final counter (synchronized, reliable): " + safeCounter.getValue());
    }

    // ---- Helper class with a synchronized method for Exercise 5 ----
    static class Counter {
        private int value = 0;

        synchronized void increment() { // only ONE thread can run this at a time
            value++;
        }

        int getValue() {
            return value;
        }
    }
}
