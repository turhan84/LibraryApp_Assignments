
Feature: As a data consumer, I want UI and DB book information are match. TI
  @wip_us04_TI @ui @db
  Scenario: Verify book information with DB TI
    Given the "librarian" on the home page TI
    And the user navigates to "Books" page TI
    When the user searches for "Istanbul" book TI
    And  the user clicks edit book button TI
    Then book information must match the Database TI