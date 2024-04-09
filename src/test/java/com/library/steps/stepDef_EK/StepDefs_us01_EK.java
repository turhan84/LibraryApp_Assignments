package com.library.steps.stepDef_EK;

import io.cucumber.datatable.DataTable;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class StepDefs_us01_EK {

    String actualUserCount;
    List<String> allColumnNames = new ArrayList<>();

    @Given("Establish the database connection EK")
    public void establish_the_database_connection_ek() {
        System.out.println("------    DB CONN IS DONE BY HOOK -------");
    }


    @When("Execute query to get all IDs from users EK")
    public void execute_query_to_get_all_i_ds_from_users_ek() {

        String query="select count(id) from users";
        DB_Util.runQuery(query);

        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);

    }

    @Then("verify all users has unique ID EK")
    public void verify_all_users_has_unique_id_ek() {
        String query="select  count(distinct id) from users";
        DB_Util.runQuery(query);

        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        Assert.assertEquals(expectedUserCount,actualUserCount);
    }


    @When("Execute query to get all columns EK")
    public void execute_query_to_get_all_columns_ek() {

        String query="SELECT * FROM users";
        DB_Util.runQuery(query);

        allColumnNames = DB_Util.getAllColumnNamesAsList();
        System.out.println("allColumnNames = " + allColumnNames);


    }


    @Then("verify the below columns are listed in result EK")
    public void verify_the_below_columns_are_listed_in_result_ek(DataTable expectedColumnsTable) {

        List<String> expectedColumns = expectedColumnsTable.asList(String.class);

        for (String expectedColumn : expectedColumns) {
            if (!allColumnNames.contains(expectedColumn)) {
                throw new AssertionError("Expected column not found: " + expectedColumn);
            }
        }

        System.out.println("All expected columns are verified successfully.");



    }


}
