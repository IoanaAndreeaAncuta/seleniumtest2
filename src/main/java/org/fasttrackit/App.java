package org.fasttrackit;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.IOException;
import java.io.InputStream;
import  java.util.Properties;


public class App 
{
    private static Properties properties = new Properties();

    static {
        InputStream inputStream = App.class.getClassLoader() .getResourceAsStream("production.properties");

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Could not read properties.");
        }
    }


    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String siteUrl = properties.getProperty("site.url");

    public static Properties getProperties() {
        return properties;
    }

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }
}
