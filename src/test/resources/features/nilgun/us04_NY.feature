
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page NY
    And the user navigates to "Books" page NY
    When the user searches for "Clean Code" book NY
    And  the user clicks edit book button NY
    Then book information must match the Database NY