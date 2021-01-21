package com.crm.skycleon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.crm.skycleon.base.TestBase;
import com.crm.skycleon.pages.HomePage;
import com.crm.skycleon.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;

	
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); 
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}

	
	@Test(priority = 2)
	public void crmLogoImageTest()
	{
		boolean flag = loginPage.validateCRMimage();
		Assert.assertTrue(true);
	}

	@Test(priority = 3) 
	public void signInTest()
	{
		loginPage.validateSignIn();
	}
	
	@Test(priority = 3) 
	public void loginTest() throws Exception
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	------ Scrap out -------- 
//	@Test(priority = 4)
//	public void loginTest()
//	{
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//	}
	
	
	
	// could not access web element locator
//	public void sigupTest()
//	{
//		loginPage.validateSignUp();
//	}
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		Thread.sleep(5000);
		driver.quit(); 
	}
	
	
}
