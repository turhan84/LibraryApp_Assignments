
Feature: As a librarian, I want to know borrowed books number
  @wip_EK2 @ui @db
  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page EK
    When the librarian gets borrowed books number EK
    Then borrowed books number information must match with DB EK