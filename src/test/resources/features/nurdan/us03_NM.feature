
Feature: As a data consumer, I want UI and DB book categories are match.

  Scenario: verify book categories with DB
    Given the "librarian" on the home page NM
    When the user navigates to "Books" page NM
    And the user clicks book categories NM
    Then verify book categories must match book_categories table from db NM