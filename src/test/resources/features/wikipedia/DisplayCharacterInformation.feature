# Data tables are used ti pass complex data sets to test step
# Data table can take many forms:
#   List<E>
#   List<List<E>>
#   List<Map<K,V>>
#   Map<K,V>
#   Map<K, List<V>>
# or it could be DataTable object that is parsed within the step
# If data table is used together with normal step parameters it is last parameter in the method
  
Feature: Verify Star Wars character information

  Scenario: Search Wikipedia
    Given Wikipedia page is opened
    When user search for 'han solo' phrase
    And user should see 'han solo' character information
      | First appearance | Star Wars (1977)               |
      | Last appearance  | Solo: A Star Wars Story (2018) |
      | Created by       | George Lucas                   |