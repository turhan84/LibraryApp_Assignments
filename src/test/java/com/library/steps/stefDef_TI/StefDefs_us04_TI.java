package com.library.steps.stefDef_TI;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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


        String bookCategoryValue = bookPage.selectedBookCategory.getAttribute("value");

        BrowserUtil.waitFor(4);
        String xpath = "(//option[@value='" + bookCategoryValue + "'])[2]";
        String selectedBookCategoryText = Driver.getDriver().findElement(By.xpath(xpath)).getText();

        actualBookInfo.add(selectedBookCategoryText);

        String query = "SELECT books.name, author, year, isbn, bc.name FROM books  join book_categories bc on books.book_category_id = bc.id WHERE books.name ='Istanbul'";
//"+bookPage.bookName+"
        DB_Util.runQuery(query);

        List<String> dbBookInfo = DB_Util.getRowDataAsList(1);

        System.out.println("dbBookInfo = " + dbBookInfo);
        System.out.println("actualBookInfo = " + actualBookInfo);

        Assert.assertEquals("Book information does not match", dbBookInfo, actualBookInfo);

    }
}
