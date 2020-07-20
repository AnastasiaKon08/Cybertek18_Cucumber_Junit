package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileageCalculatorPage {
    public GasMileageCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "uscodreading")
    public WebElement currentOdometer;

    @FindBy (id = "uspodreading")
    public WebElement previousOdometer;

    @FindBy (id = "usgasputin")
    public WebElement gallons;

    @FindBy (xpath = "(//input[@value='Calculate'])[1]")
    public WebElement calculate;

    @FindBy (xpath = "//b[contains(text(), 'mpg')]")
    public WebElement gasMileage;

}
