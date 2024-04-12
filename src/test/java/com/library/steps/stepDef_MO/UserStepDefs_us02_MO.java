package com.library.steps.stepDef_MO;

import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserStepDefs_us02_MO {


    LoginPage loginPage = new LoginPage();

    @Given("the {string} on the home page MO")
    public void the_on_the_home_page_mo(String librarian) {
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        loginPage.login(librarian);
    }
    @When("the librarian gets borrowed books number MO")
    public void the_librarian_gets_borrowed_books_number_mo() {



    }
    @Then("borrowed books number information must match with DB MO")
    public void borrowed_books_number_information_must_match_with_db_mo() {

    }

}
