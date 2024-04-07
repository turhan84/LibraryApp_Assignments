
Feature: As a data consumer, I want UI and DB book categories are match._AL

  Scenario: verify book categories with DB_AL
    Given the "librarian" on the home page AL
    When the user navigates to "Books" page AL
    And the user clicks book categories AL
    Then verify book categories must match book_categories table from db AL