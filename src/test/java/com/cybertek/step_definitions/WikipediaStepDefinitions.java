package com.cybertek.step_definitions;

import com.cybertek.pages.Wikipedia;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class WikipediaStepDefinitions {

    @Given("User is on home page")
    public void user_is_on_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }



    @When("User searches {string} in the wiki search page")
    public void userSearchesInTheWikiSearchPage(String fullName) {
        System.out.println(fullName);
        Wikipedia wiki = new Wikipedia();
        wiki.searchBox.sendKeys(fullName);
        wiki.searchButton.click();

    }

    @Then("User should see {string} in the wiki title")
    public void userShouldSeeInTheWikiTitle(String expectedT) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = expectedT+ " - Wikipedia";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Then("User should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expectedMH) {
        String actualHeader = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        String expectedHeader = expectedMH;
        Assert.assertEquals(actualHeader, expectedHeader);

    }

    @Then("User should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String expectedIH) {
        String actualImageHeader = Driver.getDriver().findElement(By.xpath("//tbody//div[@class='fn']")).getText();
        System.out.println(actualImageHeader);
        String expectedImageHeader = expectedIH;

        Assert.assertEquals(actualImageHeader, expectedImageHeader);
    }
}
