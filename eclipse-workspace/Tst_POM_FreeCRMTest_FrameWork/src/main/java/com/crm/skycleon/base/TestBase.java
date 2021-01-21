package com.crm.skycleon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.skycleon.util.TestUtil;
import com.crm.skycleon.util.WebEventListener;

public class TestBase {
	/*---Reference Variables----*/
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/josephajayi/eclipse-workspace/Tst_POM_FreeCRMTest_FrameWork/src/main/java/com/crm/skycleon/config/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	 
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		System.setProperty("webdriver.chrome.driver", "/Users/josephajayi/Desktop/Selenium Drivers/web-Drivers-2020/chromedriver85v" );
		driver = new ChromeDriver();

		
//		if (browserName.equals("Chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "/Users/josephajayi/Desktop/Selenium Drivers/web-Drivers-2020/chromedriver84v" );
//			driver = new ChromeDriver();
//		}
//		else if (browserName.equals("Firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "/Users/josephajayi/Desktop/Selenium Drivers/web-Drivers-2020/geckodriver");
//			driver = new FirefoxDriver();
//		}
//		else 
//		{
//			System.out.print("We Do Not Supported This Browser...");
//		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
/*----- the below configuration is to call all the webEventListener inside @ util package -----*/
		e_driver = new EventFiringWebDriver(driver);
/* ---- Now create an object of EventListenerHandler to register it with EventFiringWebDriver ----*/
		eventListener = new WebEventListener(); // eventListener is an object of -> new WebEventListener() class
		e_driver.register(eventListener); // registering the eventListener object to e_driver
		driver = e_driver;               //assign e_driver to driver  
		
		
		
	}
}
