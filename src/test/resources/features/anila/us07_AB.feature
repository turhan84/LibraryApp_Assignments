
Feature: Books module_AL
  As a students, I should be able to borrow book_AL

  Scenario: Student borrow new book_AL
    Given the "student" on the home page AL
    And the user navigates to "Books" page AL
    And the user searches for "Self Confidence" book AL
    When the user clicks Borrow Book AL
    Then verify that book is shown in "Borrowing Books" page AL
    And  verify logged student has same book in database AL