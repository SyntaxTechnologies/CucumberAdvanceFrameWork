package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks {

    @Before
    public void start() {
        CommonMethods.openBrowserAndNavigateToURL();
    }

    @After
    public void end(Scenario scenario) {
        // We need this variable because my screenshot method returns an array of bytes
        byte[] pic;
        // Here we are capturing the screenshot and attaching it to the report
        if (scenario.isFailed()) {
            pic = CommonMethods.takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = CommonMethods.takeScreenshot("passed/" + scenario.getName());
        }
        // Attach this screenshot in the report
        scenario.attach(pic, "image/png", scenario.getName());

        CommonMethods.closeBrowser();
    }
}
