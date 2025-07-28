package com.main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
private static WebDriver driver;

    public static WebDriver getDriver(String br) {
        if (driver == null && br.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(driver == null && br.equals("edge"))
        {

             //System.setProperty("webdriver.edge.driver", "\"C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Microsoft Edge.lnk\"");
        	 driver = new EdgeDriver();
             driver.manage().window().maximize();
        }
        else
        {
        	driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
