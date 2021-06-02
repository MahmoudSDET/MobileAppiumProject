package com.socialnmobile.dictapps.notepad.color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.offset.PointOption;
import tests.TestBase2;
import tests.TestBase3;

public class comsocialmobiledictapps extends TestBase3 {
	
	@Test(priority = 1)
    public  void Find_Elements_PressAndLongPress_Test() throws InterruptedException {

		//press and long press
	driver.findElementById("com.socialnmobile.dictapps.notepad.color.note:id/img_add").click();
	
	Thread.sleep(3000);
	driver.findElementByXPath("//android.widget.TextView[@text='Text']").click();	
	
	driver.findElementById("com.socialnmobile.dictapps.notepad.color.note:id/edit_note").sendKeys("Test");
      Thread.sleep(3000);
      
	//driver.pressKeyCode(4);
    //  driver.pressKeyCode(AndroidKeyCode.BACK);
     // driver.pressKeyCode(AndroidKeyCode.BACK);
	//driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
     // driver.pressKey(new KeyEvent(AndroidKey.BACK));
     // driver.navigate().back();
      driver.hideKeyboard();
      Thread.sleep(3000);
      driver.navigate().back();
      driver.navigate().back();
      //driver.navigate().back();
      Thread.sleep(5000);
      


     
	WebElement longpress=	driver.findElementById("com.socialnmobile.dictapps.notepad.color.note:id/title");
	
	 MobileElement actions = (MobileElement) new WebDriverWait(driver, 30).
             until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.socialnmobile.dictapps.notepad.color.note:id/title")));
     new Actions(driver).clickAndHold(longpress).perform();
     Thread.sleep(3000);
     // scroll down to text
     MobileElement listItem=  (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
             "new UiScrollable(new UiSelector()).scrollIntoView(" +"new UiSelector().text(\"Delete\"));"

     ));
     listItem.click();
     
     driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
    
  
    }

}
