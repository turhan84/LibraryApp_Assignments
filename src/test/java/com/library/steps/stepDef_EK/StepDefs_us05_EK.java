package com.library.steps.stepDef_EK;

import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;

import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefs_us05_EK {

    @When("I execute query to verify {string} is the most popular book genre EK")
    public void i_execute_query_to_verify_is_the_most_popular_book_genre_ek(String expectedPopularBookGenre) {

        String query = "SELECT bc.name, COUNT(*) as count FROM book_borrow bb INNER JOIN books b ON bb.book_id = b.id INNER JOIN book_categories bc ON b.book_category_id = bc.id GROUP BY bc.name ORDER BY count DESC limit 1";
        DB_Util.runQuery(query);

        BrowserUtil.waitFor(5);
        String actualPopularBookGenre = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualPopularBookGenre = " + actualPopularBookGenre);
        BrowserUtil.waitFor(5);


            Assert.assertEquals("The expected popular book genre does not match the actual.",
                    expectedPopularBookGenre,
                    actualPopularBookGenre);

        }
    }


