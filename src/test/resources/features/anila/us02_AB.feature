
Feature: As a librarian, I want to know borrowed books number_AL

  Scenario: verify the total amount of borrowed books_AL
    Given the "librarian" on the home page AL
    When the librarian gets borrowed books number AL
    Then borrowed books number information must match with DB AL