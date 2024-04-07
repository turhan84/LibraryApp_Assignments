Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table._AL
  Background:
    Given Establish the database connection AL
  @wip @db
  Scenario: verify users has unique IDs AL
    When Execute query to get all IDs from users AL
    Then verify all users has unique ID AL


  Scenario: verify users table columns_AL
    When Execute query to get all columns AL
    Then verify the below columns are listed in result AL

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
