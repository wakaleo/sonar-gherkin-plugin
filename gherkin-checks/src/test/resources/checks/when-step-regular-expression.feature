Feature: My feature When step regular expression

  Scenario: Scenario 1 When step regular expression
    Given I am a customer
    # Noncompliant [[sc=10;ec=25]] {{Update the sentence to match the following regular expression: ^I .*$}}
    When Page is catalog
    And I am a customer
    # Noncompliant [[sc=9;ec=12]] {{Update the sentence to match the following regular expression: ^I .*$}}
    But IOC
    Then I am a customer