package com.library.steps.stepDef_EK;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class StepDefs_us06_EK {

    BookPage book = new BookPage();

    @When("the librarian click to add book EK")
    public void the_librarian_click_to_add_book_ek() {

        book.addBook.click();

    }

    @When("the librarian enter book name {string} EK")
    public void the_librarian_enter_book_name_ek(String name) {

        book.bookName.sendKeys(name);

    }

    @When("the librarian enter ISBN {string} EK")
    public void the_librarian_enter_isbn_ek(String isbn) {

        book.isbn.sendKeys(isbn);

    }

    @When("the librarian enter year {string} EK")
    public void the_librarian_enter_year_ek(String year) {

        book.year.sendKeys(year);

    }

    @When("the librarian enter author {string} EK")
    public void the_librarian_enter_author_ek(String author) {

        book.author.sendKeys(author);

    }

    @When("the librarian choose the book category {string} EK")
    public void the_librarian_choose_the_book_category_ek(String category) {

        BrowserUtil.selectOptionDropdown(book.categoryDropdown,category);

    }

    @When("the librarian click to save changes EK")
    public void the_librarian_click_to_save_changes_ek() {

        book.saveChanges.click();

    }

    @Then("verify {string} message is displayed EK")
    public void verify_message_is_displayed_ek(String expectedMessage) {

        String actualMessage = book.toastMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Then("verify {string} information must match with DB EK")
    public void verify_information_must_match_with_db_ek(String expectedBookName) {

        String query = "select name, author, isbn from books where name = '"+expectedBookName+"'";

        DB_Util.runQuery(query);

        Map<String, String> rowMap = DB_Util.getRowMap(1);

        String actualBookName = rowMap.get("name");

        Assert.assertEquals(expectedBookName,actualBookName);

    }

}
