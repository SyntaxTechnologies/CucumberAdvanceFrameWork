package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop = new Properties();
    private static boolean isPropertiesLoaded = false;

    /**
     * Reads properties only once from the given file path.
     *
     * @param filePath Path to the properties file.
     */
    public static void loadProperties(String filePath){
        if (!isPropertiesLoaded) {
            try (FileInputStream fis = new FileInputStream(filePath)) {
                prop.load(fis);
                isPropertiesLoaded = true;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load properties file: " + filePath);
            }
        }
    }

    /**
     * Gets a property value based on its key.
     *
     * @param key The property key.
     * @return The property value.
     */
    public static String getPropertyValue(String key){
        if (!isPropertiesLoaded) {
            throw new IllegalStateException("Properties are not loaded. Call loadProperties() first.");
        }
        String value = prop.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Key not found in properties: " + key);
        }
        return value;
    }
}
