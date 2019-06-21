# Test scenario is described using Gherkin syntax (more on https://cucumber.io/docs/gherkin/) 

Feature: Basic Wikipedia tests

  Scenario: Open Wikipedia page
    When user opens Wikipedia page
    Then user should see Wikipedia logo