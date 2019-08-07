Feature: Search Wikipedia for Star Wars characters

  @UseDB
  Scenario: Search Wikipedia for Star Wars characters
    Given list of Star Wars characters is obtained
    And user opens Wikipedia page
    When user searches for people in Wikipedia
    Then user should see content page for every character