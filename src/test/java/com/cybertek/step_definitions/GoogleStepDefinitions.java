package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }


  //  Some other steps were also undefined:

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {

        String title = Driver.getDriver().getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals("Actual Title does not match the expected Title", title, expectedTitle);

    }

    @When("User searches apple")
    public void userSearchesApple() {
        //creating page object
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();

        //sending value into search box using page object
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("User searches {string}")
    public void userSearches(String searchValue) {
        //creating page object
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();

        //sending value into search box using page object
        googleSearchPage.searchBox.sendKeys(searchValue + Keys.ENTER);
    }

    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchValue) {
        String expectedTitle = searchValue +" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }



    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {
        String expectedTitle = "Google - About Google, Our Culture & Company News";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Then("User should see About link and clicks on it")
    public void userShouldSeeAboutLinkAndClicksOnIt() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.aboutLink.click();
    }
}
