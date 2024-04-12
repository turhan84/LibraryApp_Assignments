package com.library.steps.StepDef_NM;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefs_us02_NM {

    LoginPage login = new LoginPage();
    DashBoardPage dashBoard = new DashBoardPage();
    String actualBorrowedBooksNumber;

    String borrowedBooksNumberUI;


    @Given("the {string} on the home page NM")
    public void the_on_the_home_page_nm(String librarian) {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        login.login(librarian);
    }
    @When("the librarian gets borrowed books number NM")
    public void the_librarian_gets_borrowed_books_number_nm() {
        BrowserUtil.waitFor(5);
        borrowedBooksNumberUI = dashBoard.borrowedBooksNumber.getText();
        actualBorrowedBooksNumber = borrowedBooksNumberUI;

    }
    @Then("borrowed books number information must match with DB NM")
    public void borrowed_books_number_information_must_match_with_db_nm() {

        String query="select count(id) from book_borrow where is_returned =0";
        DB_Util.runQuery(query);

        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooksNumber,actualBorrowedBooksNumber);

        System.out.println("All actual borrowed books numbers are verified successfully.");

    }

}
