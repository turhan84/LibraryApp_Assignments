
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page NY
    And the user navigates to "Books" page NY
    When the librarian click to add book NY
    And the librarian enter book name "<Book Name>" NY
    When the librarian enter ISBN "<ISBN>" NY
    And the librarian enter year "<Year>" NY
    When the librarian enter author "<Author>" NY
    And the librarian choose the book category "<Book Category>" NY
    And the librarian click to save changes NY
    Then verify "The book has been created" message is displayed NY
    And verify "<Book Name>" information must match with DB NY
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |