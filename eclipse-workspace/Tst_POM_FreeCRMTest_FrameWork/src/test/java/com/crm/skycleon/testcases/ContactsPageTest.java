package com.crm.skycleon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.skycleon.base.TestBase; // cmd + shift + o = automatically import 
import com.crm.skycleon.pages.CalendarPage;
import com.crm.skycleon.pages.ContactsPage;
import com.crm.skycleon.pages.HomePage;
import com.crm.skycleon.pages.LoginPage;
import com.crm.skycleon.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	// class object 
	LoginPage loginPage;
	HomePage homePage;
	HomePageTest homePageTest;
	TestUtil testUtil; 
	ContactsPage contactsPage;
	CalendarPage calendarPage;
	
	String sheetName = "contacts";
	
	// once the constructor is called it will automatically call the TestBase() method 
	public ContactsPageTest()   
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
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(8000);
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(5000);
		contactsPage = new ContactsPage();
		testUtil = new TestUtil(); // Initialize // testUtil = object reference 
		calendarPage = new CalendarPage();
	} 
	

//	@Test(priority = 1)
//	public void verifyContactsPageLabelTest()
//	{
////		contactsPage = homePage.clickOnContactsLink();
//		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact labe is missing on the page");
//		
//	}
//	
//	@Test(priority = 2)
//	public void verifyCreatedNewContactTest()
//	{
//		contactsPage.clickOnNewContactsLink();	
//	}

	
	/* THIS METHOD IS TO CREATE NEW CONTACT BUT HARD CODED */
//	@Test(priority = 3)
//	public void validateCreateNewContact()
//	{
//		contactsPage.clickOnNewContactsLink();
//		contactsPage.createNewContact("Timilehin", "Olabosipo", "Shoderu", "Timilehin.O@gmail.com", "21, akorohunfayo str, fadeyi", "09023457123");
//	} 
	

   /* This is data driven frame work approach / data is provided in excel sheet  
      In util package, TestUtil class contains the code to call the data from excel sheet
      The purpose of the @DataProvider is to fetch data from getTestData(sheetName) and return data    
      This is POM with Data Driven Approach s
   */
	@DataProvider
	public Object[][] getCRMTestData() throws Exception 
	{
		Object data[][]  = TestUtil.getTestData(sheetName);
		return data;
	}
	

	@Test(priority = 3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String middleName, String lastName, String email, String homeAddress, String mobileNo)
	{
		contactsPage.clickOnNewContactsLink();
		contactsPage.createNewContact(firstName, lastName, lastName, email, homeAddress, mobileNo);
	}
	
	
	

	
	
	
//	@Test(priority = 4)
//	public void selectSingleContactTest()
//	{
//		contactsPage.selectAddedContactsByName("Oluwakemi Ajayi");
//	}
//	
//
//	@Test(priority = 5)
//	public void selectMutipleContactTest()
//	{
//		contactsPage.selectAddedContactsByName("Oluwakemi Ajayi");
//		contactsPage.selectAddedContactsByName("Rebecca Aderoju Ajayi");
//	}
	
	

	
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
