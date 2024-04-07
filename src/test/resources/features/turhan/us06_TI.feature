
Feature: Books module TI
  As a librarian, I should be able to add new book into library TI

  Scenario Outline: Verify added book is matching with DB TI
    Given the "librarian" on the home page TI
    And the user navigates to "Books" page TI
    When the librarian click to add book TI
    And the librarian enter book name "<Book Name>" TI
    When the librarian enter ISBN "<ISBN>" TI
    And the librarian enter year "<Year>" TI
    When the librarian enter author "<Author>" TI
    And the librarian choose the book category "<Book Category>" TI
    And the librarian click to save changes TI
    Then verify "The book has been created" message is displayed TI
    And verify "<Book Name>" information must match with DB TI
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |