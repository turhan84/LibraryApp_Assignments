
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page HT
    And the user navigates to "Books" page HT
    And the user searches for "Self Confidence" book HT
    When the user clicks Borrow Book HT
    Then verify that book is shown in "Borrowing Books" page HT
    And  verify logged student has same book in database HT