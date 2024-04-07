
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page EK
    And the user navigates to "Books" page EK
    And the user searches for "Self Confidence" book EK
    When the user clicks Borrow Book EK
    Then verify that book is shown in "Borrowing Books" page EK
    And  verify logged student has same book in database EK