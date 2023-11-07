package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.DriverManager;

public class JobPage {

    @FindBy(id="btnAdd")
    private WebElement addButton;

    @FindBy(id="jobTitle_jobTitle")
    private WebElement jobTitleField;

    @FindBy(id="jobTitle_jobDescription")
    private WebElement jobDescriptionField;

    @FindBy(id="jobTitle_note")
    private WebElement jobNoteField;

    @FindBy(id="btnSave")
    private WebElement saveButton;

    public JobPage(){
        // Initialize WebElements with DriverManager's WebDriver instance
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // Public methods to interact with the elements using CommonMethods
    public JobPage clickAdd() {
        CommonMethods.click(addButton);
        return this;
    }

    public JobPage enterJobTitle(String title) {
        CommonMethods.sendText(jobTitleField, title);
        return this;
    }

    public JobPage enterJobDescription(String description) {
        CommonMethods.sendText(jobDescriptionField, description);
        return this;
    }

    public JobPage enterJobNote(String note) {
        CommonMethods.sendText(jobNoteField, note);
        return this;
    }

    public JobPage clickSave() {
        CommonMethods.click(saveButton);
        return this;
    }

    // Additional methods as needed
}
