
Feature: Books module
  As a students, I should be able to borrow book
  @wip_EK7 @db @ui
  Scenario: Student borrow new book
    Given the "student" on the home page EK
    And the user navigates to "Books" page EK
    And the user searches for "Self Confidence" book EK
    When the user clicks Borrow Book "Self Confidence" EK
    Then verify that "Self Confidence" is shown in "Borrowing Books" page EK
    And  verify logged student has same "Self Confidence" in database EK