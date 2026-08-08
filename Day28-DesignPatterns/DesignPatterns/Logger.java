public class Logger {
    private static Logger instance;
    private int logCount = 0;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.println("[LOG]: " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
