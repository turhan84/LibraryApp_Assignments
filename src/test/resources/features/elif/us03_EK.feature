@wip_EK @ui @db
Feature: As a data consumer, I want UI and DB book categories are match.
  @wip_EK @ui @db
  Scenario: verify book categories with DB
    Given the "librarian" on the home page EK
    When the user navigates to "Books" page EK
    And the user clicks book categories EK
    Then verify book categories must match book_categories table from db EK