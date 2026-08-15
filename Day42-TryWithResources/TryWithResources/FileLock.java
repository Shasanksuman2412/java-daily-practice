public class FileLock implements AutoCloseable {
    private String fileName;

    FileLock(String fileName) {
        this.fileName = fileName;
        System.out.println("Lock acquired: " + fileName);
    }

    @Override
    public void close() {
        System.out.println("Lock released: " + fileName);
    }
}
