
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with TC
    Given the "librarian" on the home page_TC
    And the user navigates to "Books" page_TC
    When the user searches for "Clean Code" book_TC
    And  the user clicks edit book button_TC
    Then book information must match the Database_TC