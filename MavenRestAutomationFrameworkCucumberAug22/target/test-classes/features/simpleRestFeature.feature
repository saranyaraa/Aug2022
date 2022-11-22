
Feature: Test JSON Server data
Scenario: find the total number of users data exists
    Given the endpoint is up
    When i send get request with the endpoint as ""
    Then i should get the list of userdata in the response
    And print the number of user data exists to the console

