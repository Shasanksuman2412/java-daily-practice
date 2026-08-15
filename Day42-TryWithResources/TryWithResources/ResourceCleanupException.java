public class ResourceCleanupException extends Exception {
    public ResourceCleanupException(String message) {
        super(message);
    }
}

class RiskyResource implements AutoCloseable {
    private String name;

    RiskyResource(String name) {
        this.name = name;
        System.out.println("Opening: " + name);
    }

    void doWork() {
        System.out.println(name + " working...");
    }

    @Override
    public void close() throws ResourceCleanupException {
        throw new ResourceCleanupException("Failed to clean up: " + name);
    }
}
