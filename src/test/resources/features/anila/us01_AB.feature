Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection
  @wip @db
  Scenario: verify users has unique IDs AB
    When Execute query to get all IDs from users AB
    Then verify all users has unique ID AB


  Scenario: verify users table columns
    When Execute query to get all columns AB
    Then verify the below columns are listed in result AB

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
