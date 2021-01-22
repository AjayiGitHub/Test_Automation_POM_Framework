package com.fbistech.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fbistech.base.TestBase;
import com.fbistech.pages.HomePage;
import com.fbistech.pages.LoginPage;
import com.fbistech.util.TestUtil;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil; // class object 
	
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

		homePage = loginPage.loginDetails(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
//	@Test(priority = 1)
//	public void verifyHomePageTitleTest()
//	{
//		String homePageTitle = homePage.verifyHomePageTitle(); 
//		Assert.assertEquals(homePageTitle, "Cogmento CRM", "home page username does not matched");
//		// <-home page username not matched-> this will be printed only if the test case is getting failed
//	}
// 	
	
//	@Test(priority = 2)
//	public void verifyUsernameOnHomePageTest() 
//	{
////		testU til.switchToFrame();
//		Assert.assertTrue(homePage.verifyUserNameOnHomePage()); 
//		 
//	}
//	
//	
//	@Test(priority = 3)
//	public void verifyContactsLinkTest()
//	{
//		contactsPage = homePage.clickOnContactsLink();
//	}
//	
//	
	
	
	
	@AfterMethod
	public void teardown() throws Exception
	{	
		Thread.sleep(5000);
		driver.quit();
	}

}
