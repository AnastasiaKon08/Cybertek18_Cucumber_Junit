package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions {

    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("User is on login page");
    }


    @Then("User provides librarian credentials and logs in")
    public void user_provides_librarian_credentials_and_logs_in() {
        System.out.println("User provides librarian credentials and logs in");
    }


    @Then("User should be able to see dashboard")
    public void user_should_be_able_to_see_dashboard() {
        System.out.println("User should be able to see dashboard");
    }

    @Then("User provides student credentials and logs in")
    public void user_provides_student_credentials_and_logs_in() {
        System.out.println("User provides student credentials and logs in");
    }


    @Then("User provides admin credentials and logs in")
    public void user_provides_admin_credentials_and_logs_in() {
        System.out.println("User provides admin credentials and logs in");
    }
}
