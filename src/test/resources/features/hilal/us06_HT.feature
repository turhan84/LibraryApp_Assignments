
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page HT
    And the user navigates to "Books" page HT
    When the librarian click to add book HT
    And the librarian enter book name "<Book Name>" HT
    When the librarian enter ISBN "<ISBN>" HT
    And the librarian enter year "<Year>" HT
    When the librarian enter author "<Author>" HT
    And the librarian choose the book category "<Book Category>" HT
    And the librarian click to save changes HT
    Then verify "The book has been created" message is displayed HT
    And verify "<Book Name>" information must match with DB HT
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |