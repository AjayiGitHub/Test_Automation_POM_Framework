package com.crm.skycleon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skycleon.base.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath = "//span[contains(text(),'Joseph Ajayi')]")
	@CacheLookup
	WebElement userNameLabel; 
	
	@FindBy(xpath = "//span[contains(text(),'Calendar')]") 
	@CacheLookup
	WebElement calendarLink;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]") 
	@CacheLookup
	WebElement contactsLink;
		
	@FindBy(xpath = "//span[contains(text(),'Deals')]") 
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Tasks')]") 
	@CacheLookup
	WebElement tasksLink;
	
	@FindBy(xpath = "//span[contains(text(),'Cases')]")
	@CacheLookup
	WebElement casesLink;

	@FindBy(xpath = "//span[contains(text(),'Calls')]") 
	@CacheLookup
	WebElement callsLink;

	@FindBy(xpath = "//span[contains(text(),'Documents')]") 
	@CacheLookup
	WebElement documentsLink;

	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	} 
	 
	
	
	public String verifyHomePageTitle() 
	{
		return driver.getTitle(); 
	}
	
	
	public boolean verifyUserNameOnHomePage()
	{
		return userNameLabel.isDisplayed();
	}
	
	
	public CalendarPage clickOnCalendarLink()
	{
		calendarLink.click();
		return new CalendarPage();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	
	public CasesPage clickOnCasesLink()
	{
		casesLink.click();
		return new CasesPage();
	}
	
	public CallsPage clickOnCallsLink()
	{
		callsLink.click();
		return new CallsPage();
	}
	
	
	public DocumentsPage clickOnDocumentsLink()
	{
		documentsLink.click();
		return new DocumentsPage();
	}
	
}
