package com.library.steps.stefDef_TI;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class StepDefs_us01_TI {

    String actualUserCount;

    List<String> allColumnNames = new ArrayList<>();

    @When("Execute query to get all IDs from users TI")
    public void execute_query_to_get_all_i_ds_from_users_ti() {

        String query="select count(id) from users";
        DB_Util.runQuery(query);

        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);

    }
    @Then("verify all users has unique ID TI")
    public void verify_all_users_has_unique_id_ti() {

        String query="select  count(distinct id) from users";
        DB_Util.runQuery(query);

        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        Assert.assertEquals(expectedUserCount,actualUserCount);
    }

    @When("Execute query to get all columns TI")
    public void execute_query_to_get_all_columns_ti() {

        String query="select * from users";
        DB_Util.runQuery(query);
        allColumnNames = DB_Util.getAllColumnNamesAsList();
        System.out.println("allColumnNames = " + allColumnNames);


    }


    @Then("verify the below columns are listed in result TI")
    public void verify_the_below_columns_are_listed_in_result_ti(List<String> expectedColumnsNames) {

        System.out.println("expectedColumnsTable = " + expectedColumnsNames);
        Assert.assertEquals(expectedColumnsNames,allColumnNames);
    }

}
