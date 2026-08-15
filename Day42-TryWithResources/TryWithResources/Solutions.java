public class Solutions {
    public static void main(String[] args) throws InterruptedException {

        // ---- Exercise 1: Timer resource ----
        try (Timer timer = new Timer()) {
            System.out.println("Doing some dummy work...");
            Thread.sleep(300);
        }
        System.out.println("---");

        // ---- Exercise 2: FileLock, release happens even with an exception ----
        try (FileLock lock = new FileLock("data.txt")) {
            System.out.println("Working with the locked file...");
            throw new RuntimeException("Something went wrong mid-work");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        // "Lock released: data.txt" still printed before the catch block ran
        System.out.println("---");

        // ---- Exercise 3: multiple resources, reverse close order ----
        System.out.println("Before try block");
        try (DatabaseConnection c1 = new DatabaseConnection("First");
             DatabaseConnection c2 = new DatabaseConnection("Second");
             DatabaseConnection c3 = new DatabaseConnection("Third")) {
            System.out.println("Inside try block, all three open");
        }
        // closes in order: Third, Second, First - exact REVERSE of how they opened
        System.out.println("---");

        // ---- Exercise 4: custom checked exception thrown from close() ----
        try (RiskyResource resource = new RiskyResource("Risky1")) {
            resource.doWork();
        } catch (ResourceCleanupException e) {
            System.out.println("Caught custom cleanup exception: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Exercise 5: suppressed exceptions, both try block and close() fail ----
        try (DoubleFailureResource resource = new DoubleFailureResource("Flaky2")) {
            resource.doRiskyWork();
            throw new RuntimeException("Main problem: risky work failed");
        } catch (Exception e) {
            System.out.println("Main problem caught: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Cleanup problem (suppressed): " + suppressed.getMessage());
            }
        }
    }
}
