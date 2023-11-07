package utils;

import org.openqa.selenium.support.PageFactory;
import pages.*;


public class PageInitializer {

    // Private constructor to prevent instantiation
    private PageInitializer() {
        throw new IllegalStateException("Utility class 'PageInitializer' should not be instantiated");
    }

    // Private static holder for each page object
    private static class LoginPageHolder {
        private static final LoginPage INSTANCE = initialize(LoginPage.class);
    }

    private static class DashboardPageHolder {
        private static final DashboardPage INSTANCE = initialize(DashboardPage.class);
    }
    private static class EmployeeListPageHolder {
        private static final EmployeeListPage INSTANCE = initialize(EmployeeListPage.class);
    }


    // Generic method to initialize a page object
    private static <T> T initialize(Class<T> pageClass) {
        return PageFactory.initElements(DriverManager.getDriver(), pageClass);
    }

    // Public static getters for page objects with lazy initialization
    public static LoginPage getLoginPage() {
        return LoginPageHolder.INSTANCE;
    }

    public static DashboardPage getDashboardPage() {
        return DashboardPageHolder.INSTANCE;
    }

    public static EmployeeListPage getEmployeeListPage() {
        return EmployeeListPageHolder.INSTANCE;
    }

    // Optional: Initialize all page objects at once, if needed
    public static void initializePageObjects() {
        // The methods will lazily initialize the page objects if they haven't been already.
        getLoginPage();
        getDashboardPage();

        // ... initialize other pages ...
    }
}
