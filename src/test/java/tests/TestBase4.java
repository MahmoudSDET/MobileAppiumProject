package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestBase4 {
	
	public  static     AndroidDriver<WebElement> driver;
    protected static String mobileAgentPath = System.getProperty("user.dir") + "\\Apps\\net.one97.paytm.apk";
   protected   static   String platformName="Android";
 //protected static String deviceName=DeviceName.un;
	
	 @BeforeSuite
	    public  static void InitializeTest() throws MalformedURLException  {


	        // Thread.sleep(20000);
	        DesiredCapabilities cap=new  DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"CAM-L21");

	        cap.setCapability(MobileCapabilityType.APP, mobileAgentPath);
	        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);

	        driver =new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    }
	    @AfterSuite
	    public  static void FinishTest() throws MalformedURLException, InterruptedException {

	       //  driver.quit();



	    }


	    public static  void HideKeyBoard()
	{
	    driver.hideKeyboard();
	}

	    public void ScrollDown() throws InterruptedException {
	        int pressX = driver.manage().window().getSize().width/2 ;
	        // 4/5 of the screen as the bottom finger-press point
	        int bottomY = driver.manage().window().getSize().height * 5/6 ;
	        // just non zero point, as it didn't scroll to zero normally
	        int topY = driver.manage().window().getSize().height / 7;
	        //scroll with TouchAction by itself
	        TouchAction action = new TouchAction(driver);

	        action.longPress(PointOption.point(pressX,bottomY)).moveTo(PointOption.point(pressX,topY)).release().perform();
	    }
	    //scroll into egypt
	    public  void ScrollToElement()
	    {
	        MobileElement listItem=  (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector()).scrollIntoView(" +"new UiSelector().text(\"Egypt\"));"

	        ));
	        listItem.click();
	    }
	    
	    public static void swipeHorizontal(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	        Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.height * anchorPercentage);
	        int startPoint = (int) (size.width * startPercentage);
	        int endPoint = (int) (size.width * finalPercentage);
	        new TouchAction(driver).press(PointOption.point(startPoint, anchor)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endPoint, anchor)).release().perform();
	    }


	    public static void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	        Dimension size = driver.manage().window().getSize();
	        int anchor = (int) (size.width * anchorPercentage);
	        int startPoint = (int) (size.height * startPercentage);
	        int endPoint = (int) (size.height * finalPercentage);
	       // new TouchAction(driver).press(anchor, startPoint).waitAction(Duration.ofMillis(duration)).moveTo(anchor, endPoint).release().perform();
	        new TouchAction(driver).press(PointOption.point(startPoint, anchor)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration))).moveTo(PointOption.point(endPoint, anchor)).release().perform();
	    }

}
