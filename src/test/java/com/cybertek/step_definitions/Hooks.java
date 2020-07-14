package com.cybertek.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

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
    public void tearDownScenario(){
        System.out.println("-----> After annotation: Closing browser");

    }

    @After ("@db")
    public void tearDownDatabaseConnection(){
        System.out.println("----> After Annotation: DB connection closed <-----");
    }


    @BeforeStep
    public void setUpStep(){
        System.out.println("=====> BeforeStep: Taking screenshot <=====");
    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("=====> AfterStep: Taking screenshot <=====");
    }


}
