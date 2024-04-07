
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page MO
    And the user navigates to "Books" page MO
    And the user searches for "Self Confidence" book MO
    When the user clicks Borrow Book MO
    Then verify that book is shown in "Borrowing Books" page MO
    And  verify logged student has same book in database MO