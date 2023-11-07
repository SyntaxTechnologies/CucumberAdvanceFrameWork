package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PageInitializer;
public class EmployeeSearchSteps {
    @When("user enters valid employee id {string}")
    public void user_enters_valid_employee_id(String id) {

        PageInitializer.getEmployeeListPage().enterId(id);
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {

        PageInitializer.getEmployeeListPage().clickSearch();
    }
    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
//we can implement a function that returns the expected result in the page

    }

}
