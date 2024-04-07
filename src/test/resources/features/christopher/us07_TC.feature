
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book TC
    Given the "student" on the home page_TC
    And the user navigates to "Books" page_TC
    And the user searches for "Self Confidence" book_TC
    When the user clicks Borrow Book_TC
    Then verify that book is shown in "Borrowing Books" page_TC
    And  verify logged student has same book in database_TC