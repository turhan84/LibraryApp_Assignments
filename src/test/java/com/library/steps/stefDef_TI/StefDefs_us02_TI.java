package com.library.steps.stefDef_TI;

import com.library.pages.BorrowedBooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
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

public class StefDefs_us02_TI {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
    LoginPage login = new LoginPage();
    BorrowedBooksPage borrowedBooks = new BorrowedBooksPage();
    DashBoardPage dashBoard = new DashBoardPage();
    String actualBorrowedBooksNumber;

    @Given("the {string} on the home page TI")
    public void the_on_the_home_page_ti(String librarian) {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        login.login(librarian);

    }

    @When("the librarian gets borrowed books number TI")
    public void the_librarian_gets_borrowed_books_number_ti() {

        // Wait until the borrowed books number is visible
        wait.until(ExpectedConditions.visibilityOf(dashBoard.borrowedBooksNumber));

        actualBorrowedBooksNumber = dashBoard.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);

    }

    @Then("borrowed books number information must match with DB TI")
    public void borrowed_books_number_information_must_match_with_db_ti() {

        String query = "select count(id) from book_borrow where is_returned =0";
        DB_Util.runQuery(query);

        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(expectedBorrowedBooksNumber, actualBorrowedBooksNumber);

        System.out.println("All actual borrowed books numbers are verified successfully.");
    }

}
