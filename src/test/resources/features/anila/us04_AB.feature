
Feature: As a data consumer, I want UI and DB book information are match._AL

  Scenario: Verify book information with DB_AL
    Given the "librarian" on the home page AL
    And the user navigates to "Books" page AL
    When the user searches for "Clean Code" book AL
    And  the user clicks edit book button AL
    Then book information must match the Database AL