
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given the "librarian" on the home page AS
    When the user navigates to "Books" page AS
    And the user clicks book categories AS
    Then verify book categories must match book_categories table from db AS