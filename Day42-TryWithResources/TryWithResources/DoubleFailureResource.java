public class DoubleFailureResource implements AutoCloseable {
    private String name;

    DoubleFailureResource(String name) {
        this.name = name;
        System.out.println("Opening: " + name);
    }

    void doRiskyWork() {
        System.out.println(name + " attempting risky work...");
    }

    @Override
    public void close() throws Exception {
        throw new Exception("Cleanup problem: could not release " + name);
    }
}
