package com.crm.skycleon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.skycleon.base.TestBase;
import com.crm.skycleon.pages.CalendarPage;
import com.crm.skycleon.pages.ContactsPage;
import com.crm.skycleon.pages.HomePage;
import com.crm.skycleon.pages.LoginPage;
import com.crm.skycleon.util.TestUtil;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil; // class object 
	ContactsPage contactsPage;
	CalendarPage calendarPage;
	
	// once the constructor is called it will automatically call the TestBase() method 
	public HomePageTest()   
	{
		super();
	}
	
	
	// Test cases should separated --- independent with each other
	// Before each test case --- launch the browser and login
	// @Test --- execute test case
	// After each test case --- close the browser
	
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil(); // Initialize // testUtil = object reference 
		contactsPage = new ContactsPage();
		calendarPage = new CalendarPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle(); 
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "home page username does not matched");
		// <-home page username not matched-> this will be printed only if the test case is getting failed
	}
 	
	
	@Test(priority = 2)
	public void verifyUsernameOnHomePageTest()
	{
//		testU til.switchToFrame();
		Assert.assertTrue(homePage.verifyUserNameOnHomePage()); 
		 
	}
	
	
	@Test(priority = 3)
	public void verifyContactsLinkTest()
	{
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority = 4)
	public void verifyCalendarLinkTest()
	{
		calendarPage = homePage.clickOnCalendarLink();
	}
	
	
	
	@AfterMethod
	public void teardown() throws Exception
	{	
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
