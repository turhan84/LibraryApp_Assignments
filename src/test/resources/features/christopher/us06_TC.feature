
Feature: Books module
  As a librarian, I should be able to add new book into library

  Scenario Outline: Verify added book is matching with TC
    Given the "librarian" on the home page_TC
    And the user navigates to "Books" page_TC
    When the librarian click to add book_TC
    And the librarian enter book name "<Book Name>"_TC
    When the librarian enter ISBN "<ISBN>"_TC
    And the librarian enter year "<Year>"_TC
    When the librarian enter author "<Author>"_TC
    And the librarian choose the book category "<Book Category>"_TC
    And the librarian click to save changes_TC
    Then verify "The book has been created" message is displayed_TC
    And verify "<Book Name>" information must match with_TC
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |