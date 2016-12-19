Feature: Smoke Test

  Scenario: Check "About us" routing
    Given User is on home page
    When User go to About us
    Then User is on About us page

  Scenario: Fail test
    Given User is on home page
    Then Expected address is wrong