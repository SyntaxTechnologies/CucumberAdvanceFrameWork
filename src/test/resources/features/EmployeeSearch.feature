Feature: Search an employee

  Background:

    When user enters valid admin username "Admin" and password "Hum@nhrm123"
    And user clicks on login button
    Then user is successfully logged in the application
    When user hovers on Pim option
    And clicks on EmployeeList option

  @smoke @regression @sprint3 @background
  Scenario: Search employee by id
    And user enters valid employee id "2012611"
    And user clicks on search button
    Then user is able to see employee information

