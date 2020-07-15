package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBear {
    public SmartBear(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement steet;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationDate;

    @FindBy (xpath = "//input[@value = 'Visa']")
    public WebElement Visacard;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;


    @FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton ;


}
