
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given the "librarian" on the home page HT
    When the user navigates to "Books" page HT
    And the user clicks book categories HT
    Then verify book categories must match book_categories table from db HT