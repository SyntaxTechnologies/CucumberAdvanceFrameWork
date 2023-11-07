# DriverManager Class Overview

## Purpose

The `DriverManager` class is designed to manage the WebDriver lifecycle in Selenium automation tests.
It ensures that only one instance of WebDriver is instantiated and reused throughout the lifecycle
of the application's execution, adhering to the Singleton design pattern.

## Qualities and Functionalities

### Singleton Design Pattern

- **Enforcement**: The class employs a private static instance of `WebDriver` and a private
- constructor to enforce the Singleton pattern.
- **Lazy Initialization**: `getDriver()` implements lazy initialization,
- creating the WebDriver instance upon the first request if it is null.

### Configuration Management

- **Static Initialization Block**: Uses a static block to load configurations once when the
- class is loaded into the JVM memory.
- **ConfigReader Utility**: Relies on a `ConfigReader` utility to read browser preferences
- from a configuration file, ensuring a single source of truth for configurations.

### Support for Multiple Browsers

- **Browser Flexibility**: The `initializeDriver()` method facilitates initializing different browsers
- based on configuration. It includes cases for Chrome and Firefox and can be extended to support
- more browsers.

### Exception Handling

- **Error Reporting**: Throws a clear and explicit `IllegalStateException` if a browser type is not
- supported, aiding in quick identification and rectification of configuration issues.

### Resource Management

- **Clean Termination**: Includes a `quitDriver()` method to properly close the WebDriver
- and release all resources, which is crucial for preventing memory leaks and orphaned processes.

### Prevention of Instantiation

- **Construction Restriction**: The private constructor throws an `AssertionError` to prevent
- instantiation of the utility class, reinforcing the design choice that `DriverManager` should never
- be instantiated.

### Maintainability

- **Separation of Concerns**: By separating driver initialization and configuration reading
- into distinct methods, the class adheres to the principle of single responsibility,
- enhancing readability and maintainability.

### Extendability

- **Scalability for Additional Browsers**: The `initializeDriver()` method can easily be expanded to
- include additional browsers, making the class future-proof.

