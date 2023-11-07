package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    private static WebDriver driver;

    static {
        loadDriverConfig();
    }

    private static void loadDriverConfig() {
        // Load the config file here. This is a static block that will only run once when the class is loaded.
        ConfigReader.loadProperties(Constants.CONFIG_READER_PATH);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        // Initialize the driver based on the property read from the config
        String browserType = ConfigReader.getPropertyValue("browser");
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            // Include cases for other browsers if needed
            default:
                throw new IllegalStateException("Browser type not supported: " + browserType);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private DriverManager() {
        throw new AssertionError("Utility class 'DriverManager' should not be instantiated");
    }

}
