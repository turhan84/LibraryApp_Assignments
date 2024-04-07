
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page NM
    And the user navigates to "Books" page NM
    When the librarian click to add book NM
    And the librarian enter book name "<Book Name>" NM
    When the librarian enter ISBN "<ISBN>" NM
    And the librarian enter year "<Year>" NM
    When the librarian enter author "<Author>" NM
    And the librarian choose the book category "<Book Category>" NM
    And the librarian click to save changes NM
    Then verify "The book has been created" message is displayed NM
    And verify "<Book Name>" information must match with DB NM
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |