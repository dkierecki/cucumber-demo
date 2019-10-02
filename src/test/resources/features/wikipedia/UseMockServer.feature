Feature: Use MockServer to fake external system response

  @UseMockServer
  Scenario: Check mocked Star Wars planets
    When list of all SW planets is obtained
    Then planet list should contain following values
      | Mock IX |

  Scenario: Check real Star Wars planets
    When list of all SW planets is obtained
    Then planet list should contain following values
      | Alderaan | Yavin IV | Hoth | Dagobah | Bespin | Endor | Naboo | Coruscant | Kamino | Geonosis |