package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.DriverManager;

public class EmployeeListPage {

    @FindBy(id="empsearch_id")
    private WebElement idTextField;

    @FindBy(id="empsearch_employee_name_empName")
    private WebElement nameTextField;

    @FindBy(id="searchBtn")
    private WebElement searchButton;

    public EmployeeListPage(){
        // Initialize WebElements with DriverManager's WebDriver instance
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // Public methods to interact with the elements using CommonMethods
    public EmployeeListPage enterId(String id) {
        CommonMethods.sendText(idTextField, id);
        return this;
    }

    public EmployeeListPage enterName(String name) {
        CommonMethods.sendText(nameTextField, name);
        return this;
    }

    public EmployeeListPage clickSearch() {
        CommonMethods.click(searchButton);
        return this;
    }

    // Additional interaction methods can be added here
}
