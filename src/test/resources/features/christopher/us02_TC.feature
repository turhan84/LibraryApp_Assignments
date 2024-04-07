
Feature: As a librarian, I want to know borrowed books number

  Scenario: verify the total amount of borrowed books TC
    Given the "librarian" on the home page_TC
    When the librarian gets borrowed books number_TC
    Then borrowed books number information must match with_TC