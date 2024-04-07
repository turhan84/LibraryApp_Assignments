
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page NM
    And the user navigates to "Books" page NM
    When the user searches for "Clean Code" book NM
    And  the user clicks edit book button NM
    Then book information must match the Database NM