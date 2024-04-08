
Feature: Books module_AL
  As a librarian, I should be able to add new book into library_AL

  Scenario Outline: Verify added book is matching with DB_AL
    Given the "librarian" on the home page AL
    And the user navigates to "Books" page AL
    When the librarian click to add book AL
    And the librarian enter book name "<Book Name>" AL
    When the librarian enter ISBN "<ISBN>" AL
    And the librarian enter year "<Year>" AL
    When the librarian enter author "<Author>" AL
    And the librarian choose the book category "<Book Category>" AL
    And the librarian click to save changes AL
    Then verify "The book has been created" message is displayed AL
    And verify "<Book Name>" information must match with DB AL
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |