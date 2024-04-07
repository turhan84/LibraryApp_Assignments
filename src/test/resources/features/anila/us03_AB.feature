
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given the "librarian" on the home page AB
    When the user navigates to "Books" page AB
    And the user clicks book categories AB
    Then verify book categories must match book_categories table from db AB