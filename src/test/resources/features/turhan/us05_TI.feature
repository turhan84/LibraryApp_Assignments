
Feature: As a data consumer, I want to know genre of books are being borrowed the most TI
  @wip_us05_TI @ui @db
  Scenario: verify the the common book genre that’s being borrowed TI
    Given Establish the database connection TI
    When I execute query to find most popular book genre TI
    Then verify "Humor" is the most popular book genre. TI