package com.cybertek.step_definitions;

import com.cybertek.pages.Wikipedia;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class WikipediaStepDefinitions {

    @Given("User is on home page")
    public void user_is_on_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }


    @Then("User types Steve Jobs in the wiki search box and clicks on wiki search button")
    public void user_types_steve_jobs_in_the_wiki_search_box_and_clicks_on_wiki_search_button() {
        Wikipedia wiki = new Wikipedia();
        wiki.searchBox.sendKeys("Steve Jobs");
        wiki.searchButton.click();
    }


    @Then("User sees Steve Jobs is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Steve Jobs - Wikipedia";
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Then("User sees Steve Jobs is in the main header")
    public void userSeesSteveJobsIsInTheMainHeader() {
        String actualHeader = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        String expectedHeader = "Steve Jobs";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Then("User sees Steve Jobs is in the image header")
    public void userSeesSteveJobsIsInTheImageHeader() {
        String actualImage = Driver.getDriver().findElement(By.xpath("//img[@alt = 'Steve Jobs Headshot 2010-CROP (cropped 2).jpg']")).getAttribute("alt");
        String expectedImage = "Steve Jobs";
        Assert.assertTrue(actualImage.contains(expectedImage));

    }
}
