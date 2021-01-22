package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	 
	
	@BeforeTest
	public void setup() //thing to run before the test goes in here  
	{
		try {
			
		DesiredCapabilities caps = new DesiredCapabilities();
		
		String platform = "iOS"; // if the string is change to iOS the test will skip the android test 
		//and go to IOS 
		
		if (platform.equalsIgnoreCase("android"))
		
		{
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LG-M150");
		caps.setCapability(MobileCapabilityType.UDID, "LGM1509362ee13");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		}
		else if (platform.equalsIgnoreCase("iOS"))
		{
//			caps.setCapability("platforName", "iOS");
//			caps.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
			
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.6");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xs Max");
			caps.setCapability(MobileCapabilityType.UDID, "41E34088-4713-47A5-BC81-11C32DC005D6");
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "safari"); 
			
		}
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement> (url, caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
//		driver = new AndroidDriver<MobileElement> (url, caps);
//		driver = new IOSDriver<MobileElement> (url, caps); 
		
		
		} catch (Exception exp) {
			
			System.out.println("cause is : " + exp.getCause()); 
			System.out.println("Message is exp :" + exp.getMessage());
			exp.printStackTrace();
		} 
		
		
	} 
	
	@Test
	public void sampleTest()
	{
		System.out.println("I am inside sampleTest");
	}
//	
	
	
	@AfterSuite
	public void teardown() //what to run after test goes in here 
	{
//		driver.close();
	}

}
 