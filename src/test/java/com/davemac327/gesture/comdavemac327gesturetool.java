package com.davemac327.gesture;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import tests.TestBase2;

public class comdavemac327gesturetool  extends TestBase2{
	
	
	
	@Test(priority = 1)
    public  void Find_Elements_1_Test() throws InterruptedException {

       // find locators
		
		/*  driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("Test2");
	     driver.findElement(By.id("com.davemac327.gesture.tool:id/done")).click();
	     		*/
	    
	  /*   WebElement button =driver.findElementById("com.davemac327.gesture.tool:id/addButton");
	     
	     System.out.println(button.getAttribute("text"));
	     System.out.println(button.getAttribute("checkable"));
	     System.out.println(button.getAttribute("checked"));
	     System.out.println(button.getAttribute("clickable"));//
	     driver.findElementByXPath("//android.widget.Button[@id='com.davemac327.gesture.tool:id/reloadButton']").click();
	     
	     driver.findElementByClassName("android.widget.Button").click();
	    

	*/
		//find elements by ui selector
     driver.findElementById("android:id/button1").click();
     Thread.sleep(5000);
     
     List<WebElement> buttons =driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().className(\"android.widget.Button\")"));
    		 
   
    		 System.out.println("Total buttons present : " + buttons.size());
    		 
    		 System.out.println("Total buttons present : " + buttons.get(1));
    		 for(WebElement button : buttons){
    			 
    			 
    			 System.out.println(button.getText());
    			 if(button.getText().equals("Test")){
    			 System.out.println(button.getText());
    			 button.click();
    			 }
    		 }
    		
    		//  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")")).click();	
    	    	//	 driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Te\")")).click();
    		 
    		// driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(2)"));
    		 
    		// System.out.println(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().checkable(true)")).size());
   
    }

	@Test(priority = 2)
    public  void Find_Elements_Tapping_Test() throws InterruptedException {

		//tapping
		driver.findElementById("android:id/button1").click();
		WebElement button =driver.findElementById("com.davemac327.gesture.tool:id/addButton");
	    System.out.println(button.getLocation().getX());
	    System.out.println(button.getLocation().getY());
	    
	    System.out.println(button.getSize().getHeight());
	    System.out.println(button.getSize().getWidth());
	    
	    int xCenter=button.getLocation().getX()+button.getSize().getWidth()/2;
	    int yCenter=button.getLocation().getY()+button.getSize().getHeight()/2;
	    System.out.println(xCenter);
	    System.out.println(yCenter);
	    TouchAction touchAction = new TouchAction(driver);
	    touchAction.tap(new PointOption().withCoordinates(xCenter, yCenter)).perform();
      
   
    }
	
	
	
	

}
