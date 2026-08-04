public class MultithreadingDemo {
    public static void main(String[] args) throws InterruptedException {

        // ---- Way 1: extending Thread ----
        System.out.println("Main thread: " + Thread.currentThread().getName());
        MyThread t1 = new MyThread("TaskA");
        t1.start(); // starts a NEW thread - never call run() directly!
        System.out.println("---");

        // ---- Way 2: implementing Runnable (more common, more flexible) ----
        Thread t2 = new Thread(new MyTask("TaskB"));
        t2.start();
        System.out.println("---");

        // ---- Using a lambda since Runnable is a functional interface ----
        Thread t3 = new Thread(() -> System.out.println("Running from a lambda: " + Thread.currentThread().getName()));
        t3.start();
        System.out.println("---");

        // ---- Thread.sleep(): pausing a thread ----
        Thread sleepyThread = new Thread(() -> {
            System.out.println("Sleepy thread starting...");
            try {
                Thread.sleep(1000); // pause for 1000 ms = 1 second
            } catch (InterruptedException e) {
                System.out.println("Sleep was interrupted!");
            }
            System.out.println("Sleepy thread woke up after 1 second.");
        });
        sleepyThread.start();
        System.out.println("---");

        // ---- join(): waiting for a thread to finish before continuing ----
        Thread importantTask = new Thread(() -> {
            System.out.println("Important task running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
            System.out.println("Important task done.");
        });
        importantTask.start();
        importantTask.join(); // main thread WAITS here until importantTask finishes
        System.out.println("This line only prints AFTER importantTask completes.");
        System.out.println("---");

        // ---- Unpredictable order demo ----
        System.out.println("Starting two threads - notice output order can vary between runs:");
        Thread order1 = new Thread(() -> System.out.println("Order thread 1"));
        Thread order2 = new Thread(() -> System.out.println("Order thread 2"));
        order1.start();
        order2.start();
    }
}
