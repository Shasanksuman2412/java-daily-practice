public class Timer implements AutoCloseable {
    private long startTime;

    Timer() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void close() {
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Timer closed - elapsed: " + elapsed + "ms");
    }
}
