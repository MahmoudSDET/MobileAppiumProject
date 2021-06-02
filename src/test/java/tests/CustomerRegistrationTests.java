package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RandomTestData;

public class CustomerRegistrationTests extends TestBase {


    public  String TestEmail="RCTest_"+ RandomTestData.GenerateRandomStringAndNumbers(5).toString()+"@rentcentric.com";
    public  String TestPassword="Rent4545";
    public String FirstName="bill";
    public String LastName="smith"+ RandomTestData.GenerateRandomString(6).toString();

    @Test(priority = 1)
    public  void Test_GoToSighUP() throws InterruptedException {

     driver.findElementById("com.rentcentric.smilerent:id/login_tv_signup").click();
     WebElement ExpectedResult=driver.findElementById("com.rentcentric.smilerent:id/Header");
        Assert.assertTrue(ExpectedResult.isDisplayed());


    }

    @Test(priority = 2,dependsOnMethods = {"Test_GoToSighUP"})
    public  void FillLoginInfo_ToRegister() throws InterruptedException {

        driver.findElementById("com.rentcentric.smilerent:id/loginInfo_et_email").sendKeys(TestEmail);
        String ExpectedResult=driver.findElementById("com.rentcentric.smilerent:id/loginInfo_et_email").getText();
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/loginInfo_et_ConfirmEmail").sendKeys(TestEmail);
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/loginInfo_et_password").sendKeys(TestPassword);
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/loginInfo_et_ConfirmPassword").sendKeys(TestPassword);
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/loginInfo_btn_next").click();
       Thread.sleep(5000);

        driver.findElementById("com.rentcentric.smilerent:id/iv_back").click();
        Assert.assertEquals(ExpectedResult,TestEmail);



    }

    @Test(priority = 3,dependsOnMethods = {"Test_GoToSighUP","FillLoginInfo_ToRegister"})
    public  void FillPersonalInfo_ToRegister() throws InterruptedException {
        driver.findElementById("com.rentcentric.smilerent:id/loginInfo_btn_next").click();
        Thread.sleep(3000);
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_Spinner_gender").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Mr']").click();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_firstName").sendKeys(FirstName);

        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_lastName").sendKeys(LastName);
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_Address").sendKeys("TestAddress");
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_city").sendKeys("TestCity");
        driver.hideKeyboard();
        ScrollDown();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_postalCode").sendKeys("1234");
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_Spinner_country").click();
        AndroidElement list=(AndroidElement)driver.findElementById("android:id/text1");
          ScrollToElement();

        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_mobileNumber").sendKeys("1211049808");
        driver.hideKeyboard();

        ScrollDown();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_dateOfBirth").click();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_et_cityOfBirth").sendKeys("BirthCity");
        driver.hideKeyboard();
        driver.findElementById("com.rentcentric.smilerent:id/personalInfo_btn_next").click();
        Thread.sleep(10000);

        driver.findElementById("com.rentcentric.smilerent:id/DialogVerifyPhone_SPF_Code").sendKeys("123456");
        Thread.sleep(2000);
        try {

            WebElement ExpectedResult=driver.findElementById("com.android.packageinstaller:id/permission_deny_button");
            Assert.assertTrue(ExpectedResult.isDisplayed());
            driver.findElementById("com.android.packageinstaller:id/permission_deny_button").click();
        }catch(Exception ex){

        }

    }
    @Test(priority = 4,dependsOnMethods = {"Test_GoToSighUP","FillLoginInfo_ToRegister","FillPersonalInfo_ToRegister"})
    public  void FillDriverInfo_ToRegister() throws InterruptedException {
        driver.findElementById("com.rentcentric.smilerent:id/driverInfo_iv_idPicture_idInformation").click();
        Thread.sleep(5000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonBackground").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Passport']").click();
        Thread.sleep(1000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonBackground").click();
        Thread.sleep(1000);
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        Thread.sleep(1000);
        driver.findElementById("com.rentcentric.smilerent:id/onfidoInflatedCaptureButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonBackground").click();
        try{
           WebElement  ExpectedResult= driver.findElementById("com.rentcentric.smilerent:id/bubbleContainer");
            Assert.assertTrue(ExpectedResult.isDisplayed());
        }catch (Exception ex)
        {

        }
        driver.findElementById("com.rentcentric.smilerent:id/buttonBackground").click();
        driver.findElementById("com.rentcentric.smilerent:id/onfidoInflatedCaptureButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonText").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonText").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/onfidoInflatedCaptureButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonText").click();
        Thread.sleep(2000);
        try{
            WebElement  ExpectedResult= driver.findElementById("com.rentcentric.smilerent:id/bubbleContainer");
            Assert.assertTrue(ExpectedResult.isDisplayed());
        }catch (Exception ex)
        {

        }
        driver.findElementById("com.rentcentric.smilerent:id/buttonText").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/onfidoInflatedCaptureButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonText").click();
        Thread.sleep(2000);
        driver.findElementById("com.rentcentric.smilerent:id/buttonText").click();
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();

    }


}
