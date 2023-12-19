Feature: Function of spicejet

  @StaticDropdown
  Scenario: user handles the currency dropdown
   # Given user navigate to spicejet
    When user selects the value from currency dropdown

  #Before
  @DynamicDropdown
  Scenario: user validate the dynamic dropdown values
    Given user selects the dropdown value in From & To dropdowns

    @wiki
  Scenario: Wiki table
    Given User handles the wiki table