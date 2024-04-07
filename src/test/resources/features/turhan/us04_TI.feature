
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page TI
    And the user navigates to "Books" page TI
    When the user searches for "Clean Code" book TI
    And  the user clicks edit book button TI
    Then book information must match the Database TI