package com.library.steps.stepDef_EK;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.DashBoardPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class StepDefs_us07_EK {

    BookPage book = new BookPage();

    @When("the user clicks Borrow Book {string} EK")
    public void the_user_clicks_borrow_book_ek(String bookToBorrow) {
        book.borrowBook(bookToBorrow).click();

    }

    @Then("verify that {string} is shown in {string} page EK")
    public void verify_that_is_shown_in_page_ek(String bookToBorrow, String module) {

        BorrowedBooksPage borrowed = new BorrowedBooksPage();
        new DashBoardPage().navigateModule(module);

        List<String> allBorrowedBooks = BrowserUtil.getElementsText(borrowed.allBorrowedBooksName);
        boolean result = allBorrowedBooks.contains(bookToBorrow);
        Assert.assertTrue(result);

    }

    @Then("verify logged student has same {string} in database EK")
    public void verify_logged_student_has_same_in_database_ek(String bookToBorrow) {
        String query = "select name from books b join book_borrow bb on b.id = bb.book_id join users u on bb.user_id = u.id where name = '"+bookToBorrow+"' and full_name = 'Test Student 5';";

        DB_Util.runQuery(query);

        List<String> actualList = DB_Util.getColumnDataAsList(1);
        Assert.assertTrue(actualList.contains(bookToBorrow));
    }


}
