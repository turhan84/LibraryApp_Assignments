
Feature: As a librarian, I want to know borrowed books number

  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page NM
    When the librarian gets borrowed books number NM
    Then borrowed books number information must match with DB NM