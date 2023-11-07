package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.DriverManager;

public class DashboardPage {
   @FindBy(id="welcome")
   private WebElement welcomeMessage;
    @FindBy(id="menu_pim_viewPimModule")
    private WebElement pimTab;

    // Sub-menu options under the PIM tab
    @FindBy(id="menu_pim_Configuration")
    private WebElement pimConfigurationOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    private WebElement employeeListOption;

    @FindBy(id="menu_pim_addEmployee")
    private WebElement addEmployeeOption;
    @FindBy(id="menu_admin_viewAdminModule")
    private WebElement adminTab;

    // Other tabs and options...

    // Sub-menu options under the Admin tab
    @FindBy(id="menu_admin_UserManagement")
    private WebElement userManagementOption;

    @FindBy(id="menu_admin_Job")
    private WebElement jobOption;



    // Constructor to initialize the WebElements
    public DashboardPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
//************************Welcome Message********************
public String getWelcomeMessage() {
    return welcomeMessage.getText();
}
//    *************************PIM TAB*****************
// Hover over method for the PIM tab
public DashboardPage hoverOverPimTab() {
    Actions action = new Actions(DriverManager.getDriver());
    action.moveToElement(pimTab).build().perform();
    return this;
}

    // Click method for the PIM tab (if it leads directly to Employee List)
    public EmployeeListPage clickPimTab() {
        CommonMethods.click(pimTab);
        return new EmployeeListPage();
    }

    // Method to hover and reveal the Configuration sub-option under PIM
    public DashboardPage hoverOverPimConfigurationOption() {
        hoverOverPimTab(); // Hover over PIM tab first to reveal the sub-options
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(pimConfigurationOption).build().perform();
        return this;
    }

    // Methods for clicking on each of the PIM sub-options after hover
    public ConfigurationPage clickPimConfigurationOption() {
        hoverOverPimConfigurationOption();
        CommonMethods.click(pimConfigurationOption);
        return new ConfigurationPage();
    }

    public EmployeeListPage clickEmployeeListOption() {
        hoverOverPimTab(); // Ensure the sub-options are visible
        CommonMethods.click(employeeListOption);
        return new EmployeeListPage();
    }

    public AddEmployeePage clickAddEmployeeOption() {
        hoverOverPimTab(); // Ensure the sub-options are visible
        CommonMethods.click(addEmployeeOption);
        return new AddEmployeePage();
    }
//******************Admin TAB*******************************
    // Hover over method for the Admin tab
    public DashboardPage hoverOverAdminTab() {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(adminTab).build().perform();
        return this;
    }

    // Click method for the Admin tab (if it leads directly to User Management)
    public UserManagementPage clickAdminTab() {
        CommonMethods.click(adminTab);
        return new UserManagementPage();
    }

    // Method to hover and reveal the User Management sub-option
    public DashboardPage hoverOverUserManagementOption() {
        hoverOverAdminTab(); // Hover over Admin tab first to reveal the sub-options
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(userManagementOption).build().perform();
        return this;
    }

    // Method to click on the User Management option after hover
    public UserManagementPage clickUserManagementOption() {
        hoverOverUserManagementOption();
        CommonMethods.click(userManagementOption);
        return new UserManagementPage();
    }

    // Methods for other sub-options...

    // Additional methods as required to interact with the dashboard
}
