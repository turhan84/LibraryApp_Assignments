
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page MO
    And the user navigates to "Books" page MO
    When the user searches for "Clean Code" book MO
    And  the user clicks edit book button MO
    Then book information must match the Database MO