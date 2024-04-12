
Feature: As a data consumer, I want to know genre of books are being borrowed the most
  @wip_EK5 @db
  Scenario: verify the the common book genre that’s being borrowed
    Given Establish the database connection EK
    When I execute query to verify "Essay" is the most popular book genre EK
