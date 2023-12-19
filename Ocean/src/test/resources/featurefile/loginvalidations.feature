Feature: user validates the login functions in home page of learn more

  @TS001 @SmokeTest @TeamOcean
    #before
  Scenario: user validates the error message in learn more login page
    #beforestep
    Given user navigates to learnmore login page
    #afterstep
    #beforestep
    When user enter username "xyz" and password "123"
    #afterstep
    #beforestep
    And user clicks on login button
    #afterstep
    #beforestep
    Then user validate the error message
    #afterstep
    #after

    #before
  @SC02 @SmokeTest
  Scenario: login page title validation
    Given user navigate to leanmore login page
    Then user validates the title of homepage
    #after

  Scenario: login validation
    Given user navigates to learnmore login page
    When user enter username "LearnMore" and password "learnmore123"
    And user clicks on login button
    Then user validates whether navigates to event home page

  Scenario Outline: mutlip login validation
    Given user navigates to learnmore login page
    When user enter username "<UserName>" and password "<Password>"
    And user clicks on login button
    Then user validate the error message
    Examples:
      | UserName  | Password |
      | Learnmore | 123      |
      | Aravinth  | abc      |
      | apple     |eee       |
