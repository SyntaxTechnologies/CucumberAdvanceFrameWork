Feature: Login related scenarios


  @sprint1 @regression @smoke @newTestcase @newFeature @sprint2 @login1
  Scenario: Valid admin login
    When user enters valid admin username "Admin" and password "Hum@nhrm123"
    And user clicks on login button
    Then user is successfully logged in the application



  @invalid  @sprint1
  Scenario: invalid admin login
    When user enters invalid admin username and password
    And user clicks on login button
    Then error message is displayed "Invalid credentials"

  @negative
  Scenario Outline: negative login test
    When user enters valid admin username "<username>" and password "<password>"
    And user clicks on login button
    Then error message is displayed "<error>"
    Examples:
      | username | password | error |
      |admin     |fkfkkkj   |Invalid credentials|
      |admin1    |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password cannot be empty|







