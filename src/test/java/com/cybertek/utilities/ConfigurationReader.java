package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        String path = "configuration.properties";

        //get the path and store in String, or directly pass into fileInputStream obj
        try {
            FileInputStream file = new FileInputStream(path);
            properties.load(file); // load the file to properties object
            file.close(); // close.file
        } catch (IOException e) {
            System.out.println("Properties File not found");
        }


    }

    //own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);
    }
}
