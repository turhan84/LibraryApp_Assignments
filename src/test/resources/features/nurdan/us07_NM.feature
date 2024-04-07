
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page NM
    And the user navigates to "Books" page NM
    And the user searches for "Self Confidence" book NM
    When the user clicks Borrow Book NM
    Then verify that book is shown in "Borrowing Books" page NM
    And  verify logged student has same book in database NM