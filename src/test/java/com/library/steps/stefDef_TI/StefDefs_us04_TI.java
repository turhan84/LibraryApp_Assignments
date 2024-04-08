package com.library.steps.stefDef_TI;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
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

public class StefDefs_us04_TI {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    BookPage bookPage = new BookPage();

    @When("the user searches for {string} book TI")
    public void the_user_searches_for_book_ti(String book) {

        BrowserUtil.waitFor(2);
        bookPage.search.sendKeys(book);
        BrowserUtil.waitFor(2);

    }

    @When("the user clicks edit book button TI")
    public void the_user_clicks_edit_book_button_ti() {

        bookPage.editBookDynamic.click();
        BrowserUtil.waitFor(3);
    }

    @Then("book information must match the Database TI")
    public void book_information_must_match_the_database_ti() {

        wait.until(ExpectedConditions.visibilityOf(bookPage.categoryDropdown));
        List<String> actualBookInfo = new ArrayList<>();
        actualBookInfo.add(bookPage.bookName.getAttribute("value"));
        actualBookInfo.add(bookPage.author.getAttribute("value"));
        actualBookInfo.add(bookPage.year.getAttribute("value"));
        actualBookInfo.add(bookPage.isbn.getAttribute("value"));
        actualBookInfo.add(bookPage.categoryDropdown.getAttribute("value"));

        String query = "SELECT books.name, author, year, isbn, bc.name\n" +
                "FROM books  join book_categories bc\n" +
                "    on books.book_category_id = bc.id\n" +
                "WHERE books.name ='"+bookPage.bookName+"'";

        DB_Util.runQuery(query);

        List<String> dbBookInfo = DB_Util.getColumnDataAsList(1);

        System.out.println("dbBookInfo = " + dbBookInfo);
        System.out.println("actualBookInfo = " + actualBookInfo);

        Assert.assertEquals("Book information does not match", dbBookInfo, actualBookInfo);

    }
}
