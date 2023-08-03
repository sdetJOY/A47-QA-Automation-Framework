Feature: Login feature

  Scenario: Login Success
    Given I open Login page
    When I enter email "tesfaye.abagaz@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in
