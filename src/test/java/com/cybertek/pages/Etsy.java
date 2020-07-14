package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Etsy {

    public Etsy(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id ='global-enhancements-search-query']")
    public WebElement searchBar;

    @FindBy (xpath = "(//button[@type = 'submit'])[1]")
    public WebElement searchButton;

}
