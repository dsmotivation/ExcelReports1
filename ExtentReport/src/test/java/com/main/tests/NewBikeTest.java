package com.main.tests;

import org.testng.annotations.Test;

import com.main.pages.NewBikes;
import com.main.utils.DriverSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class NewBikeTest {
	private WebDriver driver;
	private NewBikes bikes;

@Test(priority=1)
  public void Filter() throws InterruptedException {
	System.out.println("start Filter");
	bikes.FilterMethod();
	System.out.println("Filter done");
	
  }

@Test(priority=2)
public void DisplayChennaiBikes() throws InterruptedException {
	System.out.println("start Display");
	bikes.usedCars();
	System.out.println("Display done");
}


@Test(priority=3)
public void Authentication() {
	System.out.println("start Authentication");
	bikes.googleAuthentication();
	System.out.println("Authentication done");
}

//@Test(priority=4, dependsOnMethods = {"Authentication"})
@Test(priority=4)
public void Screenshot() {
	System.out.println("start screenshot");
	bikes.captureTestScreenshot();
	System.out.println("screenshot done");
}


@BeforeClass
@Parameters({"browser"})
public void initDriver(@Optional ("edge") String br) {
	driver=DriverSetup.getDriver(br);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.zigwheels.com");
	bikes=new NewBikes(driver);  
}


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
