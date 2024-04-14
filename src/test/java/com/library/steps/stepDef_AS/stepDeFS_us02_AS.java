package com.library.steps.stepDef_AS;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class stepDeFS_us02_AS {

LoginPage loginPage;
DashBoardPage dashBoardPage;
String globalBorrowedBooksNumberUi;
    @Given("the {string} on the home page AS")
    public void the_on_the_home_page_as(String userType) {
loginPage = new LoginPage();
loginPage.login(userType);

    }
    @When("the librarian gets borrowed books number AS")
    public void the_librarian_gets_borrowed_books_number_as() {
        dashBoardPage = new DashBoardPage();
        BrowserUtil.waitFor(5);
        String borrowedBooksNumberUI = dashBoardPage.borrowedBooksNumber.getText();
        globalBorrowedBooksNumberUi = borrowedBooksNumberUI;

    }
    @Then("borrowed books number information must match with DB ASs")
    public void borrowed_books_number_information_must_match_with_db() {
        String query = "select count(id) from book_borrow where is_returned =0";
        DB_Util.runQuery(query);

        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooksNumber,  globalBorrowedBooksNumberUi);
        System.out.println("All actual borrowed books numbers are verified successfully.");
    }
    }



