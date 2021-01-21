package com.crm.skycleon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.skycleon.base.TestBase;

public class ContactsPage extends TestBase{




	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div") 
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath = "//i[@class='edit icon']//parent::button[@class='ui linkedin button']") 
	@CacheLookup
	WebElement newContactsLink;
	
	@FindBy(xpath = "//input[@name='first_name']") 
	@CacheLookup
	WebElement firstName;

	@FindBy(xpath = "//input[@name='middle_name']") 
	@CacheLookup
	WebElement middleName;

	@FindBy(xpath = "//input[@name='last_name']") 
	@CacheLookup
	WebElement lastName;


	@FindBy(xpath = "//input[@name='value']") 
	@CacheLookup
	WebElement emailAddres;
	
	
	@FindBy(xpath = "//input[@name='address']") 
	@CacheLookup
	WebElement houseAddres;
	
	@FindBy(xpath = "//div[@class='ui input']//input[@name='value' and @autocomplete='new-password']") 
	@CacheLookup
	WebElement phoneNo;
	
	
	@FindBy(xpath = "") WebElement Category;
	
	
	@FindBy(xpath = "//i[@class='save icon']") 
	@CacheLookup
	WebElement saveBtn;

//	private WebElement newContactsLink;

	
	
	

	// Initializing page objects:
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	 
	
	
	public boolean verifyContactsLabel()
	{ 
		return contactsLabel.isDisplayed();
	}
	
	
	public void clickOnNewContactsLink()
	{
		newContactsLink.click();		
		
	/*  THIS METHOD IS TO HOVER ON A BUTTON WITH DROP DOWN
	 <-- In case the button to be clicked has a dropdown before clicking on the actual button
	 <-- Actions class is used to mouse hover on the button.
	 <-- actions class is used for drag and drop, right click on dropdown btn and this must be use with .build().perform();
	 <-- use select class to select from the dropdown
	 contactLink = element locator of the button xpath which is pass to the reference variable
	
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();  
			
	*/
		
	}
	

	public void createNewContact(String ftName, String mdName, String ltName, String email, String homeAddress, String mobileNo)
	{	
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		middleName.sendKeys(mdName);
		lastName.sendKeys(ltName);
		emailAddres.sendKeys(email);
		houseAddres.sendKeys(homeAddress);
		phoneNo.sendKeys(mobileNo);
		saveBtn.click();
		 
		

		/* TO SELECT TITLE FROM A DROPDWON USE THIS METHOD.
<--- To select Title: Dr, Miss, Mr, Mrs, Engr, Prof, sir.)from dropdown button  use select class		
<--- In order not to hard code the value, pass a String variable (title) as argument in the method.
<--- when calling the method from the testNG class the title parameter will be pass.


		public void createNewContact(String title, String ftname, String ltname, String company, String , email)
		{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title); 

		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		companyName.sendKeys(company);
		emailAddres.sendKeys(email);
		saveBtn.click();
		}
		 */
		
	}
	
	
	/* to click on a particular contact check box we wont use page factory  */
	public void selectAddedContactsByName(String name)
	{
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).click();
		
	}
	
}
