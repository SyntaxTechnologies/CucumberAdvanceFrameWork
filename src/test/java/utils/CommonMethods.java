package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods {

    /**
     * Opens a browser and navigates to the specified URL.
     */
    public static void openBrowserAndNavigateToURL() {

        DriverManager.getDriver().manage().window().maximize();
        String url = ConfigReader.getPropertyValue("url");
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    /**
     * Closes the browser and quits the WebDriver instance.
     */
    public static void closeBrowser() {
        DriverManager.quitDriver();
    }

    /**
     * Sends text to the specified WebElement.
     */
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Waits for an element to be clickable.
     */
    public static void waitForClickability(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clicks on a WebElement once it is clickable.
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * Selects an option from a dropdown by visible text.
     */
    public static void selectFromDropdownByText(WebElement dropDown, String visibleText) {
        new Select(dropDown).selectByVisibleText(visibleText);
    }

    /**
     * Selects an option from a dropdown by value.
     */
    public static void selectFromDropdownByValue(WebElement dropDown, String value) {
        new Select(dropDown).selectByValue(value);
    }

    /**
     * Selects an option from a dropdown by index.
     */
    public static void selectFromDropdownByIndex(WebElement dropDown, int index) {
        new Select(dropDown).selectByIndex(index);
    }

    /**
     * Takes a screenshot and returns it as a byte array.
     */
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File screenShot = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                    getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    /**
     * Gets the current timestamp in the specified format.
     */
    public static String getTimeStamp(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     * Gets the text
     */
    public static String getText(WebElement element) {
        return element.getText();
    }
    /**
     * uploads file
     */
    public static void uploadFile(WebElement element, String filePath) {
        if(element.isDisplayed() && element.isEnabled()) {
            // Set the file path onto the file-selector input
            element.sendKeys(filePath);
        } else {
            throw new IllegalArgumentException("The upload field is not displayed or not enabled.");
        }
    }

    // Private constructor to prevent instantiation
    private CommonMethods() {
        throw new AssertionError("Utility class 'CommonMethods' should not be instantiated");
    }



}
