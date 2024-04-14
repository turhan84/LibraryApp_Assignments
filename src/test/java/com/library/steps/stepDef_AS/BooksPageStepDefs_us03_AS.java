package com.library.steps.stepDef_AS;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BooksPageStepDefs_us03_AS {

    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    List<String> actualCategories;

    @When("the user navigates to {string} page AS")
    public void the_user_navigates_to_page_as(String options) {
        dashBoardPage.navigateModule(options);
    }
    @When("the user clicks book categories AS")
    public void the_user_clicks_book_categories_as() {
        bookPage.mainCategoryElement.click();

        Select select = new Select(bookPage.mainCategoryElement);

        actualCategories = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);

        actualCategories.remove(0);
    }
    @Then("verify book categories must match book_categories table from db AS")
    public void verify_book_categories_must_match_book_categories_table_from_db_as() {
        String query = "select name from book_categories";

        DB_Util.runQuery(query);

        List<String> expectedCategories = DB_Util.getColumnDataAsList("name");

        System.out.println("actualCategories = " + actualCategories);
        System.out.println("expectedCategories = " + expectedCategories);

        Assert.assertEquals("Book categories do not match",expectedCategories, actualCategories);

    }
}
