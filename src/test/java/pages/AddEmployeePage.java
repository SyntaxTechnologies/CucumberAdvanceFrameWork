package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.DriverManager;

public class AddEmployeePage {

    @FindBy(id="firstName")
    private WebElement firstNameField;

    @FindBy(id="lastName")
    private WebElement lastNameField;

    @FindBy(id="middleName")
    private WebElement middleNameField;

    @FindBy(id="btnSave")
    private WebElement saveButton;

    @FindBy(id="photofile")
    private WebElement photograph;

    @FindBy(id="employeeId")
    private WebElement employeeIdField;

    @FindBy(id="chkLogin")
    private WebElement checkBoxLocator;

    @FindBy(id="user_name")
    private WebElement usernameTextFieldBox;

    @FindBy(id="user_password")
    private WebElement passwordTextFieldBox;

    @FindBy(id="re_password")
    private WebElement confirmPasswordBox;

    // Constructor to initialize the WebElements
    public AddEmployeePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // Public methods to interact with the elements
    public AddEmployeePage enterFirstName(String firstName) {
        CommonMethods.sendText(firstNameField, firstName);
        return this;
    }

    public AddEmployeePage enterLastName(String lastName) {
        CommonMethods.sendText(lastNameField, lastName);
        return this;
    }

    // Add methods for interacting with other elements as necessary
    // ...

    public AddEmployeePage uploadPhoto(String filePath) {
        CommonMethods.uploadFile(photograph, filePath);
        return this;
    }

    public AddEmployeePage checkCreateLoginDetails() {
        if (!checkBoxLocator.isSelected()) {
            CommonMethods.click(checkBoxLocator);
        }
        return this;
    }

    public AddEmployeePage enterUsername(String username) {
        CommonMethods.sendText(usernameTextFieldBox, username);
        return this;
    }

    public AddEmployeePage enterPassword(String password) {
        CommonMethods.sendText(passwordTextFieldBox, password);
        return this;
    }

    public AddEmployeePage confirmPasword(String password) {
        CommonMethods.sendText(confirmPasswordBox, password);
        return this;
    }



    // Add any additional required methods for interacting with the page
}
