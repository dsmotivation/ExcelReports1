package com.main.pages;


import java.util.Set;
import org.openqa.selenium.WebDriver;

public class GoToPage {
	   private WebDriver driver;
	   private static String parenthandle;
	   
       public GoToPage(WebDriver driver) {
    	   this.driver=driver;
    	   
       }
       
       public static WebDriver SwitchWindow(WebDriver driver) {
    	   parenthandle=driver.getWindowHandle();
    	   Set<String> handles=driver.getWindowHandles();
    	   for(String i:handles) {
    		   if(!i.equalsIgnoreCase(parenthandle)) {
    			   driver.switchTo().window(i);
    		   }
    	   }
    	   System.out.println(driver.getCurrentUrl());
    	  
    	   return driver;
       }
}
