@wip_EK1 @ui @db
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page EK
    And the user navigates to "Books" page EK
    When the user searches for "CodeCraft" book EK
    And  the user clicks edit book button EK
    Then book information must match the Database EK