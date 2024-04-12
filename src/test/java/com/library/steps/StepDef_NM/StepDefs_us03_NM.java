package com.library.steps.StepDef_NM;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StepDefs_us03_NM {

    BasePage basePage;
    List<String> categoriesFromUI;
    BookPage bookPage = new BookPage();


    @When("the user navigates to {string} page NM")
    public void the_user_navigates_to_page_nm(String module) {
        basePage =new BookPage();
        basePage.navigateModule(module);

    }
    @When("the user clicks book categories NM")
    public void the_user_clicks_book_categories_nm() {
        Select select = new Select (((BookPage)basePage).mainCategoryElement);
        List<WebElement> options = select.getOptions();
        categoriesFromUI = BrowserUtil.getElementsText(options);

        categoriesFromUI.remove("ALL");
        System.out.println("categoriesFromUI = " + categoriesFromUI);
    }
    @Then("verify book categories must match book_categories table from db NM")
    public void verify_book_categories_must_match_book_categories_table_from_db_nm() {
        String query="SELECT name FROM book_categories";
        DB_Util.runQuery(query);
        List<String> categoriesFromDB = DB_Util.getColumnDataAsList("name");
        System.out.println("categoriesFromDB = " + categoriesFromDB);

        Assert.assertEquals(categoriesFromUI, categoriesFromDB);
    }


}
