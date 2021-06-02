package net.one97;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import tests.TestBase4;

public class paytmtest  extends TestBase4{
	
	@Test(priority = 1)
    public  void Find_SWipeScreen_Test() throws Exception {
		Thread.sleep(10000);
     // For right to left: swipeHorizontal((AppiumDriver) driver,0.9,0.01,0.5,3000);
	swipeHorizontal((AppiumDriver) driver,0.9,0.01,0.5,3000);
	//For left to right: swipeHorizontal((AppiumDriver) driver,0.01,0.9,0.5,3000);
	swipeHorizontal((AppiumDriver) driver,0.09,0.9,0.5,3000);
  
	//For scroll up: swipeVertical((AppiumDriver)driver,0.9,0.1,0.5,3000);
	// For scroll down: swipeVertical((AppiumDriver)driver,0.1,0.9,0.5,3000);
	
	
    }

}
