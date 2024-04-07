
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page AB
    And the user navigates to "Books" page AB
    And the user searches for "Self Confidence" book AB
    When the user clicks Borrow Book AB
    Then verify that book is shown in "Borrowing Books" page AB
    And  verify logged student has same book in database AB