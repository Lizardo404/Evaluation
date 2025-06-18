@Google
Feature: Test Google search

  @SearchOnGoogle
  Scenario: User can search a text on google
    Given the user navigate to www.google.com
    When enter a search criterial
    And click on search button
   # And click on I'mGoingToBeLucky button
   # Then the result match with the criterial
   # Then verify new pages opened