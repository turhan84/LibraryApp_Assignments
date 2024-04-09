package com.library.steps.stepDef_MO;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStepDefs_us01_MO {
    String actualUserCount;

    @Given("Establish the database connection MO")
    public void establish_the_database_connection_mo() {
        System.out.println("-----------DB CONN IS DONE BY HOOK-----------");

    }

    @When("Execute query to get all IDs from users MO")
    public void execute_query_to_get_all_i_ds_from_users_mo() {
        String query = "select id from users";
        DB_Util.runQuery(query);
        actualUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCount);


    }

    @Then("verify all users has unique ID MO")
    public void verify_all_users_has_unique_id_mo() {



    }

    @When("Execute query to get all columns MO")
    public void execute_query_to_get_all_columns_mo() {

    }

    @Then("verify the below columns are listed in result MO")
    public void verify_the_below_columns_are_listed_in_result_mo() {

    }

}
