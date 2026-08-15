public class UnreliableResource implements AutoCloseable {
    private String name;

    UnreliableResource(String name) {
        this.name = name;
        System.out.println("Opening unreliable resource: " + name);
    }

    void doWork() {
        System.out.println(name + " doing work...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Attempting to close: " + name + " (this will fail!)");
        throw new Exception("Failed to close " + name + " cleanly");
    }
}
