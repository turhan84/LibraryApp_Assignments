package com.library.steps.stepDef_NY;

import com.library.utility.DB_Util;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class StepDefs_us01_NY {

    String actualUserCount;
    List<String> allColumnNames = new ArrayList<>();

    @Given("Establish the database connection NY")
    public void establish_the_database_connection_ny() {
       System.out.println("-------- DB CONN IS DONE BY HOOK -------");
    }


    @When("Execute query to get all IDs from users NY")
    public void execute_query_to_get_all_i_ds_from_users_ny() {

        DB_Util.runQuery("select count(id) from users");
        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);
    }

    @Then("verify all users has unique ID NY")
        public void verify_all_users_has_unique_id() {


        DB_Util.runQuery("select  count(distinct id) from users");
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);
        Assert.assertEquals(expectedUserCount,actualUserCount);
        System.out.println("-----DB CONN IS CLOSED BY HOOK -------");
    }


    @When("Execute query to get all columns NY")
    public void executeQueryToGetAllColumnsNY() {

        DB_Util.runQuery("SELECT * FROM users");
        allColumnNames = DB_Util.getAllColumnNamesAsList();
        System.out.println("allColumnNames = " + allColumnNames);
    }

    @Then("verify the below columns are listed in result NY")
    public void verifyTheBelowColumnsAreListedInResultNY(List<String> expectedColumnsTable) {

        System.out.println(expectedColumnsTable);
        Assert.assertEquals(expectedColumnsTable, allColumnNames);


    }
}
