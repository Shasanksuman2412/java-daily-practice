import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesDemo {
    public static void main(String[] args) {

        // ---- Recap: try-with-resources with a built-in class (Day 18) ----
        try (FileWriter writer = new FileWriter("temp.txt")) {
            writer.write("Hello from try-with-resources!");
            System.out.println("Wrote to temp.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---");

        // ---- Custom AutoCloseable: single resource ----
        try (DatabaseConnection conn = new DatabaseConnection("MainDB")) {
            conn.query("SELECT * FROM users");
        }
        // "Closing connection: MainDB" printed automatically after the block
        System.out.println("---");

        // ---- Multiple resources: closed in REVERSE order ----
        try (DatabaseConnection conn1 = new DatabaseConnection("DB1");
             DatabaseConnection conn2 = new DatabaseConnection("DB2")) {
            conn1.query("SELECT * FROM orders");
            conn2.query("SELECT * FROM products");
        }
        // notice: DB2 closes BEFORE DB1, even though DB1 opened first
        System.out.println("---");

        // ---- close() still happens even when an exception is thrown ----
        try (DatabaseConnection conn = new DatabaseConnection("RiskyDB")) {
            conn.query("SELECT * FROM users");
            throw new RuntimeException("Something went wrong!");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        // "Closing connection: RiskyDB" STILL printed, despite the exception
        System.out.println("---");

        // ---- Suppressed exceptions: when BOTH the block AND close() fail ----
        try (UnreliableResource resource = new UnreliableResource("Flaky")) {
            resource.doWork();
            throw new RuntimeException("Main problem in the try block");
        } catch (Exception e) {
            System.out.println("Main exception caught: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("  Suppressed exception: " + suppressed.getMessage());
            }
        }
    }
}
