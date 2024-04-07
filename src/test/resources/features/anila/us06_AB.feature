
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page AB
    And the user navigates to "Books" page AB
    When the librarian click to add book AB
    And the librarian enter book name "<Book Name>" AB
    When the librarian enter ISBN "<ISBN>" AB
    And the librarian enter year "<Year>" AB
    When the librarian enter author "<Author>" AB
    And the librarian choose the book category "<Book Category>" AB
    And the librarian click to save changes AB
    Then verify "The book has been created" message is displayed AB
    And verify "<Book Name>" information must match with DB AB
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |