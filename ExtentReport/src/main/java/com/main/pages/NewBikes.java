package com.main.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewBikes {
	private WebDriver driver;
	private WebDriverWait wait;
	private By SwitchToNewBikes=By.xpath("//a[text()='NEW BIKES']");
	private By SwitchToUpcoming=By.xpath("//li[text()='Upcoming']");
    private By AdvanceSearch=By.xpath("//a[text()='Advanced Search ']");
    private By ViewAllBrand=By.xpath("//ul[@class=\"zw-sr-sortLevelFst zm-cmn-colorBlack\"]//div[2]/div/a");
    private By Brand=By.xpath("//ul[@class='zw-sr-secLev mt-10 popupheight']/li");
    private By SearchBrand=By.id("searchMake_submit");
    private By MaxPrice=By.id("maxPrice");
    private By BikeName=By.xpath("//li[@class=\"col-lg-4 txt-c rel modelItem\"]/div[1]/div[2]/a/strong");
    private By BikePrice=By.xpath("//li[@class=\"col-lg-4 txt-c rel modelItem\"]/div[1]/div[2]/div[1]");
    
    private By LoginButton=By.xpath("//*[@id='forum_login_title_lg']");
    private By FacebookButton=By.xpath("//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[4]/div[1]/span[2]");
    private By Email=By.xpath("//input[@id='email']");
    private By Password=By.xpath("//input[@id='pass']");
    private By SubmitLoginButton=By.xpath("//input[@type='submit']");
    private By ErrorBox=By.xpath("//*[@id=\"error_box\"]");
    private String homehandle;
    
    
    
	 public NewBikes(WebDriver driver) {
		 this.driver=driver;
		 homehandle=driver.getCurrentUrl();
		 PageFactory.initElements(driver, this);
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
	 }
	 
	 private void slowDown(int secs) {
    	 (new Actions(driver)).pause(Duration.ofSeconds(secs)).perform();
 	}
     
     private void pause(int secs) {
         try {
             Thread.sleep(secs * 1000L);
         } catch (InterruptedException ignored) { }
     }
	 
     public void FilterMethod() throws InterruptedException{
//    1)click the NewBikes link in header
    	 
      wait.until(ExpectedConditions.visibilityOfElementLocated(SwitchToNewBikes)).click();
   	  driver=GoToPage.SwitchWindow(driver); //switch window
   	  
//    2)click the upcomingBikes link
   	  
   	  wait.until(ExpectedConditions.visibilityOfElementLocated(SwitchToUpcoming)).click();
   	  
// 	  3)move to element advanceSearch and click it
   	  
   	  WebElement advanceSearchEle =wait.until(ExpectedConditions.visibilityOfElementLocated(AdvanceSearch));
   	  (new Actions(driver)).moveToElement(advanceSearchEle).perform();
   	   advanceSearchEle.click();
   	  driver=GoToPage.SwitchWindow(driver); //switch window
   	  
//    3)click the element viewAll 
   	  
   	  WebElement viewall=wait.until(ExpectedConditions.visibilityOfElementLocated(ViewAllBrand));
   	 (new Actions(driver)).moveToElement(viewall).perform();
   	  viewall.click();
   	  
// 	  4)select the Honda option
   	  
   	  List<WebElement> brand=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Brand));
   	  for(WebElement b:brand) {
   		 WebElement brandele=b.findElement(By.xpath(".//label"));
   		 String BrandName=brandele.getText().trim();
   		    if(BrandName.equalsIgnoreCase("honda")) {
   		    	brandele.click();
   		    	break;
   		    }
   	  }
   
//   5)click the search button after selecting the Honda button
   	  
   	 wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBrand)).click();
     System.out.println("here->> "+driver.getCurrentUrl());
     
//   6)click on the maxPrice dropDown and select the 4lakhs option
     
     WebElement maxpriceele=wait.until(ExpectedConditions.visibilityOfElementLocated(MaxPrice));
   	 Select select=new Select(maxpriceele);
   	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'start'});",maxpriceele);
   	 slowDown(1);
   	 select.selectByValue("400000");
   	 slowDown(1);
     System.out.println("here1->> "+driver.getCurrentUrl());
     
//   7)display the bike details
              
              System.out.println("Fetching bike details...");
              List<WebElement> name=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BikeName));
              List<WebElement> Price=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BikePrice));
              Thread.sleep(50000);
       	      for(int i=0;i<name.size();i++) {
       	    	  System.out.println(i+"->> "+name.get(i).getText()+"->>"+Price.get(i).getText());
       	      }
       	 slowDown(1);
       	 
     }
  
      
//     public void usedCars() {
//    	 
//         // 1) Go to the homePage
//    	 
//         driver.navigate().to(homehandle);
//         System.out.println("navigatedToHomepage for displayChennaiLocation"+driver.getCurrentUrl());
//  
//         // 2) Wait for and locate the arrow icon (handles multiple classes)
//         WebElement dropdown = wait.until(
//             ExpectedConditions.visibilityOfElementLocated(
//                 By.cssSelector("span.c-p.icon-down-arrow")
//             )
//         );
//  
//         // 3) Hover over that arrow so the “Used Cars” link appears
//         (new Actions(driver))
//           .moveToElement(dropdown)
//           .pause(Duration.ofMillis(100))
//           .perform();
//  
//         // 4) Now wait for and click the “Used Cars” submenu item
//         WebElement usedCarsLink = wait.until(
//             ExpectedConditions.elementToBeClickable(
//                 By.xpath("//a[@title='Used Cars']")
//             )
//         );
//         usedCarsLink.click();
//         
////         driver.findElement(By.xpath("//input[@id='gs_input5']")).sendKeys("Chennai");
////         actions.sendKeys(Keys.ENTER);
//     
//         driver.findElement(By.xpath("//a[@data-city_id='280']")).click();
//          slowDown(1);
//      // 1) Find the scroll container once
//         WebElement scrollContainer = driver.findElement(
//             By.className("gsc_thin_scroll")
//            
//         );
//         slowDown(1);
//         
//         ((JavascriptExecutor) driver)
//         .executeScript(
//             "arguments[0].scrollIntoView({behavior: 'smooth', block: 'start'});",
//             scrollContainer
//     );
//  
//         // 2) Grab each <li> inside it
//         List<WebElement> models = scrollContainer.findElements(
//             By.tagName("li")
//         );
//         slowDown(1);
//  
//         // 3) Loop and print each model’s text
//         int i=1;
//         for (WebElement model : models) {
//             System.out.println(i+"-->>Popular Models In Chennai: " + model.getText());
//             i++;
//         }
//         slowDown(1);
//  
//     }
//     
     
     public void usedCars() throws InterruptedException {
    	    // 1) Go to the homepage
    	 driver.navigate().to(homehandle);

    	    // 2) Prepare your waits and actions
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    Actions actions = new Actions(driver);

    	    // 3) Hover on the dropdown arrow and click “Used Cars”
    	    WebElement dropdown = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(
    	            By.cssSelector("span.c-p.icon-down-arrow")
    	        )
    	    );
    	    actions.moveToElement(dropdown)
    	           .pause(Duration.ofMillis(100))
    	           .perform();

    	    WebElement usedCarsLink = wait.until(
    	        ExpectedConditions.elementToBeClickable(
    	            By.xpath("//a[@title='Used Cars']")
    	        )
    	    );
    	    usedCarsLink.click();

    	    // 4) Select Chennai (city_id=280)
    	    WebElement chennaiLink = wait.until(
    	        ExpectedConditions.elementToBeClickable(
    	            By.xpath("//a[@data-city_id='280']")
    	        )
    	    );
    	    chennaiLink.click();
    	    slowDown(1);

    	    // 5) Wait for the outer scroll container to appear
    	    WebElement scrollContainer = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(
    	            By.className("gsc_thin_scroll")
    	        )
    	    );
    	    slowDown(1);

    	    // 6) Bring the container into view (80px above header)
    	    int headerOffset = 80;
    	    ((JavascriptExecutor) driver).executeScript(
    	        "var elem = arguments[0], offset = arguments[1];" +
    	        "var y = elem.getBoundingClientRect().top + window.pageYOffset - offset;" +
    	        "window.scrollTo({ top: y, behavior: 'smooth' });",
    	        scrollContainer, headerOffset
    	    );
    	    slowDown(1);

    	    // 7) Now scroll *inside* that container, one <li> at a time
    	    List<WebElement> innerModels = scrollContainer.findElements(By.tagName("li"));
    	    for (WebElement modelItem : innerModels) {
    	        // scroll the container so this item is centered
    	        ((JavascriptExecutor) driver).executeScript(
    	            "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
    	            modelItem
    	        );
    	        System.out.println("Popular Model In Chennai: " + modelItem.getText());
    	        slowDown(1);
    	    }
    	}

     
     
     public void googleAuthentication() {
    	 // 1) Go to the homePage
    	
    	 driver.navigate().to(homehandle);
         System.out.println("navigatedToHomepage for authentication->>"+driver.getCurrentUrl());
    	wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton)).click();
     	
//    	2)click loogin&More Button
    	wait.until(ExpectedConditions.visibilityOfElementLocated(FacebookButton)).click();//     	driver.findElement(By.xpath("//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[4]/div[1]/span[2]")).click();
     	pause(2);
     	
     	driver=GoToPage.SwitchWindow(driver);
     	
//     	3)send Input for Email
     	wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys("hjsdhsbmn");//     	driver.findElement(Email).sendKeys("hjsdhsbmn");
     	
//     	4)send Input for Password
     	wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("mnkbj");

     	
//     	5)click the submitButton
     	wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitLoginButton)).click();//     	driver.findElement(SubmitButton).click();
     	
//     	6)Capture ErrorMessage
     	String ErrorMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorBox)).getText();//     	String ErrorMessage=driver.findElement(ErrorBox).getText();
     	
//     	7)print the error Message
     	System.out.println("ErrorMessage->>>"+ErrorMessage);
     
     }
     
     
     public  void captureTestScreenshot(){
    	WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pam login_error_box _9ay3 uiBoxRed']")));
    	TakesScreenshot screenshot=(TakesScreenshot) driver;
    	File src=screenshot.getScreenshotAs(OutputType.FILE);
     	File dest=new File("./Screenshots/error.png");
     	try {
     		FileUtils.copyFile(src, dest);
     		System.out.println("Screenshot captured");
     	}catch(IOException e) {
     		System.out.println(e.getMessage());
     	}
 	}
     
}
