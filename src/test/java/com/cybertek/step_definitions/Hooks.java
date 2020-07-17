package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before (order = 2)
    public void setUpScenario(){
        System.out.println("-----> Before annotation: Setting up browser");
    }

    @Before(value = "@db", order = 1)
    public void setUpDatabaseConnection(){
        System.out.println("-----> DB Connection Created < -------");
    }



    @After
    public void tearDownScenario(Scenario scenario){
       // System.out.println("scenario.getName() = " + scenario.getName());
        //System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        //System.out.println("scenario.isFailed() = " + scenario.isFailed());

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }






    }

    @After ("@db")
    public void tearDownDatabaseConnection(){
        System.out.println("----> After Annotation: DB connection closed <-----");
    }


    /*
    @BeforeStep
    public void setUpStep(){
        System.out.println("=====> BeforeStep: Taking screenshot <=====");
    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("=====> AfterStep: Taking screenshot <=====");
    }


     */

}
