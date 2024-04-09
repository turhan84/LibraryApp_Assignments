
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with TC
    Given the "librarian" on the home page_TC
    When the user navigates to "Books" page_TC
    And the user clicks book categories_TC
    Then verify book categories must match book_categories table from_TC