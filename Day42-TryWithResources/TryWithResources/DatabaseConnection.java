public class DatabaseConnection implements AutoCloseable {
    private String name;

    public DatabaseConnection(String name) {
        this.name = name;
        System.out.println("Opening connection: " + name);
    }

    public void query(String sql) {
        System.out.println("Running query on " + name + ": " + sql);
    }

    @Override
    public void close() {
        System.out.println("Closing connection: " + name); // cleanup logic goes here
    }
}
