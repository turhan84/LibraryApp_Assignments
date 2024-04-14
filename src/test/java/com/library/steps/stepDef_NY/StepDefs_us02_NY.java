package com.library.steps.stepDef_NY;

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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefs_us02_NY {

    LoginPage login = new LoginPage();
    DashBoardPage dashBoard = new DashBoardPage();
    String actualBorrowedBooksNumber;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));


    @Given("the {string} on the home page NY")
    public void the_on_the_home_page_ny(String librarian) {

        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        login.login(librarian);

    }

    @When("the librarian gets borrowed books number NY")
    public void the_librarian_gets_borrowed_books_number_ny() {

        wait.until(ExpectedConditions.visibilityOf(dashBoard.borrowedBooksNumber));
        actualBorrowedBooksNumber = dashBoard.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);

    }

    @Then("borrowed books number information must match with DB NY")
    public void borrowed_books_number_information_must_match_with_db_ny(){


        DB_Util.runQuery("select count(id) from book_borrow where is_returned =0");
        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBooksNumber,actualBorrowedBooksNumber);


    }

}
