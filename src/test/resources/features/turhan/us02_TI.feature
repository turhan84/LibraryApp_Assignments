
Feature: As a librarian, I want to know borrowed books number

  Scenario: verify the total amount of borrowed books TI
    Given the "librarian" on the home page TI
    When the librarian gets borrowed books number TI
    Then borrowed books number information must match with DB TI