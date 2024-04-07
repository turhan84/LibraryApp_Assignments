
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page MO
    And the user navigates to "Books" page MO
    When the librarian click to add book MO
    And the librarian enter book name "<Book Name>" MO
    When the librarian enter ISBN "<ISBN>" MO
    And the librarian enter year "<Year>" MO
    When the librarian enter author "<Author>" MO
    And the librarian choose the book category "<Book Category>" MO
    And the librarian click to save changes MO
    Then verify "The book has been created" message is displayed MO
    And verify "<Book Name>" information must match with DB MO
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |