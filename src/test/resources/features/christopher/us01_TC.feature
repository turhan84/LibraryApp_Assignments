Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection_TC
  @wip @db
  Scenario: verify users has unique IDs_TC
    When Execute query to get all IDs from users_TC
    Then verify all users has unique ID_TC


  Scenario: verify users table columns TC
    When Execute query to get all columns_TC
    Then verify the below columns are listed in result_TC

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
