
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page NY
    And the user navigates to "Books" page NY
    And the user searches for "Self Confidence" book NY
    When the user clicks Borrow Book NY
    Then verify that book is shown in "Borrowing Books" page NY
    And  verify logged student has same book in database NY