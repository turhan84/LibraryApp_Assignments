
Feature: As a data consumer, I want UI and DB book categories are match. TI

  Scenario: verify book categories with DB TI
    Given the "librarian" on the home page TI
    When the user navigates to "Books" page TI
    And the user clicks book categories TI
    Then verify book categories must match book_categories table from db TI