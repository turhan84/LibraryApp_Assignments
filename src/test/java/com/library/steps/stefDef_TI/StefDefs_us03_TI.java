package com.library.steps.stefDef_TI;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StefDefs_us03_TI {

    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    List<String> actualCategories;



    @When("the user navigates to {string} page TI")
    public void the_user_navigates_to_page_ti(String options) {

        dashBoardPage.navigateModule(options);

    }

    @When("the user clicks book categories TI")
    public void the_user_clicks_book_categories_ti() {
        bookPage.mainCategoryElement.click();

        Select select = new Select(bookPage.mainCategoryElement);

        actualCategories = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);

        actualCategories.remove(0);




    }


    @Then("verify book categories must match book_categories table from db TI")
    public void verify_book_categories_must_match_book_categories_table_from_db_ti() {

        String query = "select name from book_categories";

        DB_Util.runQuery(query);

        List<String> expectedCategories = DB_Util.getColumnDataAsList("name");

        System.out.println("actualCategories = " + actualCategories);
        System.out.println("expectedCategories = " + expectedCategories);

        Assert.assertEquals("Book categories do not match",expectedCategories, actualCategories);




    }
}
