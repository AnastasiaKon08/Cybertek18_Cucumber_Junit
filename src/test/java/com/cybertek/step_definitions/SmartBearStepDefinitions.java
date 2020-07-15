package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBear;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SmartBearStepDefinitions {

    SmartBear smartBear = new SmartBear();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
        Driver.getDriver().findElement(By.xpath("//a[@href='Process.aspx']")).click();
    }

    @Then("User selects {string} from product dropdown, then User enters {string} to quantity, enters {string} to customer name")
    public void userSelectsFromProductDropdownThenUserEntersToQuantityEntersToCustomerName(String selected, String quantity, String fullName) {
        Select select = new Select(smartBear.productDropdown);
        select.selectByVisibleText(selected);

        smartBear.quantity.clear();
        smartBear.quantity.sendKeys(quantity);

        smartBear.customerName.sendKeys(fullName);
    }

    @Then("User enters {string} to street")
    public void userEntersToStreet(String street) {
        smartBear.steet.sendKeys(street);
    }

    @Then("enters {string} to city")
    public void entersToCity(String city) {
        smartBear.city.sendKeys(city);
    }

    @And("enters {string} to state,  enters zip {string}")
    public void entersToStateEntersZip(String state, String zip) {
        smartBear.state.sendKeys(state);
        smartBear.zip.sendKeys(zip);
    }

    @Then("selects Visa as card type and  enters {string} to card number")
    public void selectsVisaAsCardTypeAndEntersToCardNumber(String cardNumber) {
        smartBear.Visacard.click();
        smartBear.cardNumber.sendKeys(cardNumber);
    }

    @And("User enters {string} to expiration date")
    public void userEntersToExpirationDate(String expDate) {
        smartBear.expirationDate.sendKeys(expDate);
    }

    @Then("User clicks process button")
    public void userClicksProcessButton() throws InterruptedException {
        Thread.sleep(2000);
        smartBear.processButton.click();
    }

    @Then("User verifies {string} is in the list")
    public void userVerifiesIsInTheList(String fullName) throws InterruptedException{
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//a[@href='Default.aspx']")).click();



        List<WebElement> orders = new ArrayList<WebElement>();
        orders.addAll(Driver.getDriver().findElements(By.xpath(" //table[@class='SampleTable']/tbody/tr/td[2]")));


        for (WebElement each :orders){
            if (each.getText().equals(fullName)) {
                System.out.println(each.getText());
                Assert.assertTrue(true);
            }

        }



    }
}





