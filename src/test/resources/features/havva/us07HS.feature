
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page HS
    And the user navigates to "Books" page HS
    And the user searches for "Self Confidence" book HS
    When the user clicks Borrow Book HS
    Then verify that book is shown in "Borrowing Books" page HS
    And  verify logged student has same book in database HS