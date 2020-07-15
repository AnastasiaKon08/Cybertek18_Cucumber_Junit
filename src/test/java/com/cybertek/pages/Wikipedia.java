package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia {

    public Wikipedia(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "searchInput")
    public WebElement searchBox;


    @FindBy (xpath = "//button[@class = 'pure-button pure-button-primary-progressive']")
    public WebElement searchButton;
}
