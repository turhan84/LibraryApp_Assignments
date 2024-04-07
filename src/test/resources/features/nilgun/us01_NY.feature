Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection NY
  @wip @db
  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users NY
    Then verify all users has unique ID NY


  Scenario: verify users table columns
    When Execute query to get all columns NY
    Then verify the below columns are listed in result NY

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |
