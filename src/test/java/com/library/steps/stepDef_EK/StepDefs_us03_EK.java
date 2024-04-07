package com.library.steps.stepDef_EK;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
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

public class StepDefs_us03_EK {

    DashBoardPage dashBoard = new DashBoardPage();
    BookPage bookPage = new BookPage();
    List<String> actualCategoryList = new ArrayList<>();


    @When("the user navigates to {string} page EK")
    public void the_user_navigates_to_page_ek(String books) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(dashBoard.borrowedBooksNumber));

       dashBoard.navigateModule(books);

    }


    @When("the user clicks book categories EK")
    public void the_user_clicks_book_categories_ek() {

        bookPage.mainCategoryElement.click();
        actualCategoryList= BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);

    }


    @Then("verify book categories must match book_categories table from db EK")
    public void verify_book_categories_must_match_book_categories_table_from_db_ek() {

        String query="SELECT name FROM book_categories";
        DB_Util.runQuery(query);

        List<String> expectedCategoryList = DB_Util.getColumnDataAsList("name");

        System.out.println("expectedCategoryList = " + expectedCategoryList);

        Assert.assertEquals("Book categories do not match",expectedCategoryList,actualCategoryList);


    }
}
