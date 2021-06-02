package zooming;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import tests.TestBase5;

public class ZoomingandPinching extends TestBase5 {
	
	
	@Test(priority = 1)
    public  void Find_ZoomingAndPinching_Test() throws Exception {
		
		driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
WebElement image=	driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));


int center_X=image.getLocation().getX()+(image.getSize().width/2);
int center_Y=image.getLocation().getY()+(image.getSize().height/2);

MultiTouchAction multiTouchAction = new MultiTouchAction(driver);

TouchAction zoomOut = new TouchAction(driver);
zoomOut.press(PointOption.point(center_X,center_Y-10)).moveTo(PointOption.point(center_X,center_Y-200)).release();

TouchAction zoomIn = new TouchAction(driver);
zoomIn.press(PointOption.point(center_X,center_Y+10)).moveTo(PointOption.point(center_X,center_Y+200)).release();

multiTouchAction.add(zoomOut).add(zoomIn).perform();
System.out.println("zoom Done");
TouchAction finger3= new TouchAction(driver);
finger3.press(ElementOption.element(image, center_X, center_Y-20)).moveTo(ElementOption.element(image,center_X,center_Y-10));

TouchAction finger4= new TouchAction(driver);
finger4.press(ElementOption.element(image, center_X, center_Y+20)).moveTo(ElementOption.element(image, center_X, center_Y+10));


MultiTouchAction action2= new MultiTouchAction(driver);
action2.add(finger3).add(finger4).perform();

System.out.println("Pinch Done");
Thread.sleep(10000);



		


	
	
    }
	
	
	public void zoomingandpinch()
	{
		
		/*WebElement Image = driver.findElementById(“com.davemorrissey.labs.subscaleview.sample:id/imageView”);

        Thread.sleep(5000);
        int x=Image.getLocation().getX()+Image.getSize().getWidth()/2;
        int y= Image.getLocation().getY()+Image.getSize().getHeight()/2;
                
        //Zoom out
        TouchAction finger1= new TouchAction(driver);
        finger1.press(Image, x, y-20).moveTo(Image,x,y-50);
        
        TouchAction finger2= new TouchAction(driver);
        finger2.press(Image, x, y+20).moveTo(Image, x, y+50);
        
        
        
        MultiTouchAction action= new MultiTouchAction(driver);
        action.add(finger1).add(finger2).perform();
        System.out.println("Zoom Done");
        Thread.sleep(10000);
        
        
        TouchAction finger3= new TouchAction(driver);
        finger3.press(Image, x, y-20).moveTo(Image, x, y-10);
        
        TouchAction finger4= new TouchAction(driver);
        finger4.press(Image, x, y+20).moveTo(Image, x, y+10);
        MultiTouchAction action2= new MultiTouchAction(driver);
        action2.add(finger3).add(finger4).perform();
        
        System.out.println("Pinch Done");
        Thread.sleep(10000);*/
	}
	
	@Test(priority = 1)
    public  void Find_ScreenOrientation_Test() throws Exception {
		
		
		ScreenOrientation orientation;
		orientation = ScreenOrientation.LANDSCAPE;
		driver.execute(DriverCommand.SET_SCREEN_ORIENTATION,
		ImmutableMap.of("orientation",orientation.value().toUpperCase()));

		
		orientation = ScreenOrientation.PORTRAIT;
		driver.execute(DriverCommand.SET_SCREEN_ORIENTATION,
		ImmutableMap.of("orientation",orientation.value().toUpperCase()));

	
	
    }
	
	@Test(priority = 2)
    public  void Find_Screenshot_Test() throws Exception {
		
		
		File errorScreenShot = null;
		errorScreenShot = new File(System.getProperty("user.dir") +
		"\\screenshot\\error.png");
		File file = null;
		file = driver.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, errorScreenShot);

	
	
    }
	
	@Test(priority = 2)
    public  void Find_AndroidEvents_Test() throws Exception {
		
		driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.pressKey(new KeyEvent(AndroidKey.SETTINGS));
		
		//driver.pressKey(new KeyEvent(AndroidKey.));
		/*new KeyEvent(AndroidKey.BACK)
		.withMetaModifier(KeyEventMetaModifier.SHIFT_ON);*/
		
	   

		

	
	
    }
	
	
	
	
	
	
	

}
