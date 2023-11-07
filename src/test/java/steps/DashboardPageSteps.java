package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utils.PageInitializer;

public class DashboardPageSteps {
    @When("user hovers on Pim option")
    public void user_hovers_on_Pim_option() {
        // Utilizing the hoverOverPimTab method from the DashboardPage to hover over the PIM option
        PageInitializer.getDashboardPage().hoverOverPimTab();
    }

    @And("clicks on EmployeeList option")
    public void clicks_on_EmployeeList_option() {
        // After hovering, clicking on the employee list option using the clickEmployeeListOption method from DashboardPage
        PageInitializer.getDashboardPage().clickEmployeeListOption();
    }

}
