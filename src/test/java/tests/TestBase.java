package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import GUI_Devices.DeviceName;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class TestBase {

public  static     AppiumDriver<WebElement> driver;
    protected static String mobileAgentPath = System.getProperty("user.dir") + "\\Apps\\ApiDemos.apk";
   protected   static   String platformName="Android";
 //protected static String deviceName=DeviceName.un;
/*@BeforeSuite
public static  void SetDeciceName()throws InterruptedException
{
     //DeviceName deviceName1 =new DeviceName();
}*/
   static String Appium_Node_Path="C:\\Program Files\\nodejs\\node.exe";
   static String Appium_JS_Path="C:\\Users\\ThinkPad\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
   static AppiumDriverLocalService service;
   static String service_url;
@BeforeSuite
   public static void appiumStart() throws Exception{
       service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
               usingPort(2856).usingDriverExecutable(new File(Appium_Node_Path)).
               withAppiumJS(new File(Appium_JS_Path)));
       service.start();
       Thread.sleep(25000);
       service_url = service.getUrl().toString();
   }
   
   
   
    @BeforeClass
    public  static void InitializeTest() throws MalformedURLException  {


        // Thread.sleep(20000);
        DesiredCapabilities cap=new  DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"OPPO Reno Z");

        cap.setCapability(MobileCapabilityType.APP, mobileAgentPath);

        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);

        driver =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:2856/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterSuite
    public  static void FinishTest() throws MalformedURLException, InterruptedException {

       
    	 service.stop();



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
