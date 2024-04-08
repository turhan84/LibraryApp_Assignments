
Feature: As a data consumer, I want to know genre of books are being borrowed the most_AL

  Scenario: verify the the common book genre that’s being borrowed_AL
    Given Establish the database connection AL
    When I execute query to find most popular book genre AL
    Then verify "Humor" is the most popular book genre. AL