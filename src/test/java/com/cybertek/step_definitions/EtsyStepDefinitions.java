package com.cybertek.step_definitions;

import com.cybertek.pages.Etsy;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class EtsyStepDefinitions {

    @Given("User is on https://www.etsy.com")
    public void user_is_on_https_www_etsy_com() {
        Driver.getDriver().get("https://www.etsy.com");
    }


    @Then("User sees title as expected")
    public void user_sees_title_as_expected() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Then("User types {string} in the search box and hits enter")
    public void userTypesInTheSearchBoxAndHitsEnter(String searchItem) {
        Etsy etsy = new Etsy();
        etsy.searchBar.sendKeys(searchItem);
        etsy.searchButton.click();
    }

    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String searchItem) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = searchItem + " | Etsy";

        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
