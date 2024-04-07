
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page HS
    And the user navigates to "Books" page HS
    When the librarian click to add book HS
    And the librarian enter book name "<Book Name>" HS
    When the librarian enter ISBN "<ISBN>" HS
    And the librarian enter year "<Year>" HS
    When the librarian enter author "<Author>" HS
    And the librarian choose the book category "<Book Category>" HS
    And the librarian click to save changes HS
    Then verify "The book has been created" message is displayed HS
    And verify "<Book Name>" information must match with DB HS
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |