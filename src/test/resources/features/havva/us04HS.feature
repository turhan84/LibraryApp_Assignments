
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page HS
    And the user navigates to "Books" page HS
    When the user searches for "Clean Code" book HS
    And  the user clicks edit book button HS
    Then book information must match the Database HS