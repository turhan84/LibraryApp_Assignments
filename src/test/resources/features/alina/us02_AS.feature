
Feature: As a librarian, I want to know borrowed books number

  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page AS
    When the librarian gets borrowed books number AS
    Then borrowed books number information must match with DB AS