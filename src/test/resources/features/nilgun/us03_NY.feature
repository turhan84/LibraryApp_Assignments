
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given the "librarian" on the home page NY
    When the user navigates to "Books" page NY
    And the user clicks book categories NY
    Then verify book categories must match book_categories table from db NY