package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;
import utils.CommonMethods; // Import to use static methods

public class LoginPage {

    // Object repository with private access
    @FindBy(id="txtUsername")
    private WebElement usernameField;

    @FindBy(id="txtPassword")
    private WebElement passwordField;

    @FindBy(id="btnLogin")
    private WebElement loginButton;

    @FindBy(id="spanMessage")
    private WebElement errorMessageField;

    // Constructor
    public LoginPage() {
        // Initialize WebElements with DriverManager's WebDriver instance
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // Public methods to interact with the elements, utilizing static methods from CommonMethods
    public LoginPage enterUsername(String username) {
        CommonMethods.sendText(usernameField, username);
        return this; // Enables method chaining
    }

    public LoginPage enterPassword(String password) {
        CommonMethods.sendText(passwordField, password);
        return this; // Enables method chaining
    }

    public DashboardPage clickLoginButton() {
        CommonMethods.click(loginButton);
        return new DashboardPage(); //  navigation to the DashboardPage
    }

    public String getErrorMessage() {
        return CommonMethods.getText(errorMessageField);
    }


}
