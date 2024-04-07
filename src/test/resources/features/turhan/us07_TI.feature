
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page TI
    And the user navigates to "Books" page TI
    And the user searches for "Self Confidence" book TI
    When the user clicks Borrow Book TI
    Then verify that book is shown in "Borrowing Books" page TI
    And  verify logged student has same book in database TI