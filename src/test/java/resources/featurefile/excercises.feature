Feature: SmartClient technical test

  Scenario: Check featured tile functions are working fine
    Given User is on the featured tile filtering page
    When User set animal using letter "a"
    And set max life span to 40
    And sort order by "Life Span"
    And select checkbox to ascending
    Then User assert that results contain more than 12 items

