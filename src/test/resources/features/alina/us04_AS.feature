
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page AS
    And the user navigates to "Books" page AS
    When the user searches for "Clean Code" book AS
    And  the user clicks edit book button AS
    Then book information must match the Database AS