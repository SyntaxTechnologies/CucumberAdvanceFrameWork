package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.CommonMethods;
import utils.PageInitializer;

public class LoginSteps {


    @When("user enters valid admin username {string} and password {string}")
    public void user_enters_valid_admin_username_and_password(String username, String password) {
        PageInitializer.getLoginPage().enterUsername(username).enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {

        PageInitializer.getLoginPage().clickLoginButton();
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        String actualMessage = PageInitializer.getDashboardPage().getWelcomeMessage();
        String expectedMessage = "Welcome Admin";
        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        // It is a good idea to store these invalid credentials in your test data or configuration files.
        String invalidUsername = "invalidAdmin";
        String invalidPassword = "invalidPassword";

        // Enter invalid username and password using the LoginPage object
        PageInitializer.getLoginPage().enterUsername(invalidUsername).enterPassword(invalidPassword);
    }


    @Then("error message is displayed {string}")
    public void error_message_is_displayed(String expectedErrorMessage) {
        {

            String actualErrorMessage = PageInitializer.getLoginPage().getErrorMessage();

            Assert.assertEquals("The error message did not match the expected text.", expectedErrorMessage, actualErrorMessage);
        }


    }
}
