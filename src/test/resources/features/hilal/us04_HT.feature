
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page HT
    And the user navigates to "Books" page HT
    When the user searches for "Clean Code" book HT
    And  the user clicks edit book button HT
    Then book information must match the Database HT