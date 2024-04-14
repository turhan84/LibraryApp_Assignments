
Feature: As a librarian, I want to know borrowed books number

  @wip_NY @ui @db
  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page NY
    When the librarian gets borrowed books number NY
    Then borrowed books number information must match with DB NY