package com.library.steps.stepDef_EK;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepDefs_us04_EK {

    BookPage bookpage = new BookPage();

    @When("the user searches for {string} book EK")
    public void the_user_searches_for_book_ek(String book) {

        bookpage.search.sendKeys(book);

    }


    @When("the user clicks edit book button EK")
    public void the_user_clicks_edit_book_button_ek() {

        bookpage.editBook.click();

    }


    @Then("book information must match the Database EK")
    public void book_information_must_match_the_database_ek() {


        List<String> uiData = new ArrayList<>();
        uiData.add(bookpage.bookName.getAttribute("value"));
        uiData.add(bookpage.author.getAttribute("value"));
        uiData.add(bookpage.year.getAttribute("value"));
        uiData.add(bookpage.isbn.getAttribute("value"));
        uiData.add(bookpage.categoryDropdown.getAttribute("value"));


        String query = "SELECT name, author, year, isbn, book_category_id  FROM books WHERE name = 'Clean Code'";
        DB_Util.runQuery(query);

        List<String> dbData = DB_Util.getRowDataAsList(1);

        // Compare both lists
        Assert.assertEquals("Book information does not match", dbData, uiData);

        System.out.println("UI book information matches the Database.");






    }
}
