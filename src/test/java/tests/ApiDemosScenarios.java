package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class ApiDemosScenarios extends TestBase {




    @Test(priority = 1)
    public  void Scenarion_1_Test() throws InterruptedException {
        String expectedFirstText="AutoTest1";
        String expectedSecondText="AutoTest2";
        driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Activity']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Custom Title']")).click();
        String wel=   driver.findElement(By.id("io.appium.android.apis:id/left_text")).getText();
      WebElement ConstLeftText=  driver.findElement(By.id("io.appium.android.apis:id/left_text_edit"));
        WebElement ConstRightText=  driver.findElement(By.id("io.appium.android.apis:id/right_text"));
      String constFirstText=ConstLeftText.getText();
        String constSecondText=ConstRightText.getText();
       driver.findElement(By.id("left_text_edit")).clear();

        driver.findElement(By.id("left_text_edit")).sendKeys(expectedFirstText);
        driver.findElement(By.id("left_text_button")).click();

        String actualFirstText=ConstLeftText.getText();
        driver.findElement(By.id("right_text_edit")).clear();
        driver.findElement(By.id("right_text_edit")).sendKeys(expectedSecondText);
        driver.findElement(By.id("io.appium.android.apis:id/right_text_button")).click();
        String actualSecondText=ConstRightText.getText();
        //validate between actual result and Expected Result
        Assert.assertNotEquals(actualFirstText,constFirstText);
        Assert.assertEquals(actualFirstText,expectedFirstText);
        Assert.assertNotEquals(actualSecondText,constSecondText);
        Assert.assertEquals(actualSecondText,expectedSecondText);



    }

    @Test(priority = 2)
    public  void Scenarion_2_Test() throws InterruptedException {

        driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Alert Dialogs']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='Single choice list']")).click();

        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Traffic']")).click();
        driver.findElement(By.id("android:id/button1")).click();



    }
    
    @Test(priority = 3)
    public  void Scenarion_DrageAndDrop_Test()throws Exception {

    	Thread.sleep(3000);
       //scroll down
      ScrollDown();
      driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
      
      driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
      // drag and drop
      
      WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
      		
      
      WebElement target=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
      
      TouchAction action=new TouchAction((MobileDriver)driver);
      
      //drag and drop
     
      action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
     
       System.out.println("Element has been droped at destination successfully.");
       
      
  }


    }
    
    
    


