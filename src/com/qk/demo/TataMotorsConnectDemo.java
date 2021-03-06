package com.qk.demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.android.appium.VerifyPopup;
//import com.cxg.btm.BtmGatewayClientCXG;
//import com.qk.monitoring.BtmWebServiceProxy;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TataMotorsConnectDemo {

	private static AndroidDriver driver;
	private static String url = "http://127.0.0.1:4723/wd/hub";
	  

//	private static BtmWebServiceProxy pushRA = new BtmWebServiceProxy();
	private static LogQADatabase logqa = new LogQADatabase();
	//	private static BtmGatewayClientCXG pushRACXG = new BtmGatewayClientCXG("http://btmwebservice1.appspot.com/rest/BtmWebService");

	private String location_name = "Mumbai-QK-Mobile";
	private static byte [] bytearray = null;
	private String pageName;
	private static String runStartTime;

	private static String custcode = "Tata_Motors_Connect";
	private static String appcode = "Tata_Motors_Connect";

	private static String custcodeRA = "Tata Motors";
	private static String appcodeRA = "Tata Motors Connect";

	private int mFrequency = 60;
	private static boolean flagone = false;

	@Rule
	public TestName name = new TestName();

	
	@BeforeClass
	public static void setUpTest() throws Exception
	{

		try
			{
			
				TaskKill.startappium();                   
				Thread.sleep(5000);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", "Moto");
				capabilities.setCapability("udid", "emulator-5554");
				capabilities.setCapability("platformVersion", "5.0");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("appPackage", "com.tatamotors.tatatouch");
				capabilities.setCapability("appActivity","com.tatamotors.tatatouch.MainActivity");
				capabilities.setCapability("newCommandTimeout", "300");
				driver = new AndroidDriver(new URL(url), capabilities);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			//	VerifyPopup.Popup(show);
			}	

	}
	
	

/*	@Test
	public void test01Home_Page() throws Exception
	{

		driver.findElement(By.xpath("//*[@index='1'and @class='android.widget.ImageView' and resource-id='com.tatamotors.tatatouch:id/imageclose']")).click();
		try {
			(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.name("Dealer Locator"))).isDisplayed();		
		} catch (Exception e) {
			System.exit(1);
		}


	}*/

	/*@Test

	public void test02Select_Country_Page() throws Exception

	{
		Thread.sleep(5000);	
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.tatamotors.tatatouch:id/imgcntry"))).click();
		//			driver.findElement(By.id("com.tatamotors.tatatouch:id/imgcntry")).click();
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("Select your country")));
		} catch (Exception e) {
			System.exit(1);
		}



	}

	@Test
	public void test03Country_Main_Page() throws Exception

	{

		Thread.sleep(2000);
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.name("Bangladesh"))).click();
		//				driver.findElement(By.name("Bangladesh")).click();
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("Service Booking")));
		} catch (Exception e) {
			System.exit(1);
		}


	}

	@Test

	public void test04Dealer_Locator_Page() throws Exception

	{
		Thread.sleep(5000);
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.tatamotors.tatatouch:id/imgDealerLocator"))).click();
		//			driver.findElement(By.id("com.tatamotors.tatatouch:id/imgDealerLocator")).click();

	}	

	@Test
	public void test05Dealer_Location_Details_Page() throws Exception

	{

		Thread.sleep(5000);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("Nitol Motors Ltd. "))).click();

	//	driver.findElement(By.name("Nitol Motors Ltd. ")).click();
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("Find Route")));
		} catch (Exception e) {
			System.exit(1);
		}


	}

	@Test
	public void test06Reminders_Page() throws Exception


	{
		Thread.sleep(5000);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("Ok"))).click();
	//	driver.findElementByName("Ok").click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.id("com.tatamotors.tatatouch:id/imgInsuranceReminder")).click();
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.tatamotors.tatatouch:id/btnAddReminder")));
		} catch (Exception e) {
			System.exit(1);
		}


	}

	@Test
	public void test07Add_Reminder_Page() throws Exception


	{
		
		Thread.sleep(5000);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("com.tatamotors.tatatouch:id/btnAddReminder"))).click();
//		driver.findElement(By.id("com.tatamotors.tatatouch:id/btnAddReminder")).click();
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.tatamotors.tatatouch:id/btnSubmit")));
		} catch (Exception e) {
			System.exit(1);
		}


	}

	@Test
	public void test08Reminder_Added_Page() throws Exception

	{

		Thread.sleep(5000);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("com.tatamotors.tatatouch:id/edtEnterInsuraceDescription"))).sendKeys("1234");
		//driver.findElement(By.id("com.tatamotors.tatatouch:id/edtEnterInsuraceDescription")).sendKeys("1234");
		driver.findElement(By.id("com.tatamotors.tatatouch:id/edtDateValue")).click();
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		driver.tap(1, 210, 440, 500);
		Thread.sleep(2000);
		//driver.findElement(By.name("OK")).click();

		driver.tap(1,210,735,1000);
		Thread.sleep(1000);
		driver.findElement(By.name("Enter Reminder Description Here")).sendKeys("reminder");
		try{driver.hideKeyboard();}
		catch (Exception e){}
		Thread.sleep(2000);
		driver.findElement(By.name("Save Reminder")).click();
		try {
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.name("reminder")));
		} catch (Exception e) {
			System.exit(1);
		}


	}	



	@AfterClass
	public static void tearDown() throws Exception
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		String endTime = sd.format((c.getTime()));
		System.out.println("---------------------------------------------"); 
		System.out.println("FINSHED:" + endTime); 
		driver.closeApp();
		driver.quit();
		Thread.sleep(2000);
		//		TaskKill.javaw();
		Thread.sleep(2000);
		System.exit(0);

	}*/
} 