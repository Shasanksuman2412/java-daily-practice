public class ConfigManager {
    private static ConfigManager instance; // holds the single instance
    private String appName;

    private ConfigManager() { // PRIVATE constructor - nobody outside can call "new"
        appName = "MyApp";
        System.out.println("ConfigManager instance created!"); // will only print ONCE
    }

    // synchronized: prevents two threads from both seeing instance == null
    // at the same time and creating two separate instances
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager(); // created only ONCE, the first time it's needed
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
