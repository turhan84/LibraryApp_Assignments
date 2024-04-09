@wip_EK @db
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection EK
  @wip_EK @db
  Scenario: verify users has unique IDs EK
    When Execute query to get all IDs from users EK
    Then verify all users has unique ID EK

  @wip_EK @db
  Scenario: verify users table columns
    When Execute query to get all columns EK
    Then verify the below columns are listed in result EK

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
