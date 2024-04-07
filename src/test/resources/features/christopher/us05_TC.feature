
Feature: As a data consumer, I want to know genre of books are being borrowed the most

  Scenario: verify the the common book genre that’s being borrowed_TC
    Given Establish the database connection_TC
    When I execute query to find most popular book genre_TC
    Then verify "Humor" is the most popular book genre_TC