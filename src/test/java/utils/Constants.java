package utils;

public class Constants {

    // Configuration Paths
    public static final String CONFIG_READER_PATH = System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public static final String EXCEL_READER_PATH = System.getProperty("user.dir")+"/src/test/resources/testdata/batch16ExcelFile.xlsx";

    // Screenshot Paths
    public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir")+"/screenshots/";


    // Timeouts
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;



    private Constants() {
        // Private constructor to prevent instantiation
        throw new UnsupportedOperationException("Constants class cannot be instantiated");
    }
}
