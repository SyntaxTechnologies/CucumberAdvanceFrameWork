
# Page Classes Overview

## Purpose

Page classes in the Selenium automation framework serve as a blueprint for every page in the application under test. They define the elements on the page and the actions that can be performed on those elements, following the Page Object Model (POM) pattern.

## Structure and Design

Each page class is carefully structured with the following:

- **Private WebElements**: All the WebElements are encapsulated within the class using private visibility and the `@FindBy` annotation to specify the locator strategy.
- **Constructor**: Utilizes `PageFactory.initElements()` method to initialize WebElements without exposing the creation logic.
- **Interaction Methods**: Defined public methods to interact with the page which facilitates actions like clicking and sending keys to the elements.

### Example: LoginPage

```java
package pages;

// ... other imports ...
import utils.DriverManager;

public class LoginPage {
    // WebElements
    @FindBy(id="txtUsername") private WebElement usernameField;
    @FindBy(id="txtPassword") private WebElement passwordField;
    // ... other fields ...

    // Constructor
    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // Interaction methods
    public LoginPage enterUsername(String username) {
        // Implementation details...
    }
    // ... other methods ...
}
```

## Qualities and Advantages

### Encapsulation

- **Private Elements**: Encapsulating WebElement fields to prevent direct access and modification.
- **Method-Level Interaction**: Providing methods for interactions ensures the internal state and representation of the page are not exposed.

### Reusability and Readability

- **Common Methods**: Leveraging utility methods from `CommonMethods` class across all pages for common actions to avoid redundancy.
- **Clear Method Names**: Naming methods clearly for readability and understandability, allowing for straightforward test case development.

### Consistent Initialization

- **PageFactory Pattern**: Employing `PageFactory.initElements()` ensures a consistent strategy for initializing WebElements, promoting uniformity across all page classes.

### Method Chaining

- **Fluent Interface**: Returning the page object from methods allows for method chaining which results in more readable test scripts.

### Ease of Maintenance

- **Single Responsibility**: Each page class has a single responsibility, managing the elements on their respective pages which simplifies updates and maintenance.
- **Centralized Changes**: UI changes in the application require updates in a single location, reducing the risk of errors during maintenance.

### Separation of Concerns

- **Decoupled Design**: By separating the WebDriver management (via `DriverManager`) and WebElement interactions, the framework adheres to the principle of separation of concerns.
- **Independent Tests**: Page classes and test classes are kept independent, allowing tests to be written or updated with minimal knowledge of page class internals.

### Future-proofing

- **Scalable**: New pages and elements can be added to the framework by creating new page classes or extending existing ones, supporting the growth of the application.

## Conclusion

By adhering to these design principles, our page classes foster a robust, maintainable, and scalable automation framework that can handle the evolving needs of the application testing lifecycle.