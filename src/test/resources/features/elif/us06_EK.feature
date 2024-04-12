
Feature: Books module
  As a librarian, I should be able to add new book into library
  @wip_EK6 @db @ui
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page EK
    And the user navigates to "Books" page EK
    When the librarian click to add book EK
    And the librarian enter book name "<Book Name>" EK
    When the librarian enter ISBN "<ISBN>" EK
    And the librarian enter year "<Year>" EK
    When the librarian enter author "<Author>" EK
    And the librarian choose the book category "<Book Category>" EK
    And the librarian click to save changes EK
    Then verify "The book has been created." message is displayed EK
    And verify "<Book Name>" information must match with DB EK
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |