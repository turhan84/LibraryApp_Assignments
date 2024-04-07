
Feature: As a librarian, I want to know borrowed books number HS

  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page HS
    When the librarian gets borrowed books number HS
    Then borrowed books number information must match with DB HS