Feature: Search Wikipedia for Star Wars planets

  Scenario: Search Wikipedia for Star Wars planets
    Given list of all SW planets is obtained
    And user opens Wikipedia page
    When user searches for planets in Wikipedia
    Then user should see content page for every planet