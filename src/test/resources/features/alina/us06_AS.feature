
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page AS
    And the user navigates to "Books" page AS
    When the librarian click to add book AS
    And the librarian enter book name "<Book Name>" AS
    When the librarian enter ISBN "<ISBN>" AS
    And the librarian enter year "<Year>" AS
    When the librarian enter author "<Author>" AS
    And the librarian choose the book category "<Book Category>" AS
    And the librarian click to save changes AS
    Then verify "The book has been created" message is displayed AS
    And verify "<Book Name>" information must match with DB AS
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |