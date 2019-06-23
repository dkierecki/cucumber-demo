Feature: Search Wikipedia

  @smoke
  Scenario: Search Wikipedia
    Given Wikipedia page is opened
    When user search for 'jedi' phrase
    Then user should see content page for 'jedi' phrase

  Scenario Outline: Search Wikipedia
    Given Wikipedia page is opened
    When user search for '<searchPhrase>' phrase
    Then user should see content page for '<contentHeading>' phrase

    Examples:
      | searchPhrase | contentHeading   |
      | Lord Vader   | Darth VAder      |
      | Skywalker    | Skywalker family |