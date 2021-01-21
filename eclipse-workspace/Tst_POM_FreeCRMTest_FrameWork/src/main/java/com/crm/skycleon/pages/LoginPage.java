package com.crm.skycleon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skycleon.base.TestBase;

public class LoginPage extends TestBase{
	
//	PageFactory of Object 
	
	@FindBy(xpath = "//span[text()='Log In']") 
	@CacheLookup
	WebElement signInBtn;

	@FindBy(xpath = "//input[@name='email']") 
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']") 
	@CacheLookup
	WebElement userPassword;
	
	@FindBy(xpath = "//div[@id='ui']/div/div/form/div/div[3]")  
	@CacheLookup
	WebElement loginSubmitBtn;
	
	
//	Could not fine element locator for SignUpBtn
//	@FindBy( xpath = "//a[contains(@href, 'https://register.freecrm.com')]") WebElement signUpBtn;
	
	
	@FindBy(xpath = "//a[contains(@href, 'https://freecrm.com/']") 
	@CacheLookup
	WebElement crmLogo;
	
	
	// Initializing page objects:
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean validateCRMimage()
	{
		return crmLogo.isDisplayed();
	}
	
	
	public void validateSignIn()
	{
		signInBtn.click(); 
	}
	
	public HomePage login(String un, String pwd) throws Exception
	{
		Thread.sleep(1000);
		signInBtn.click();
		
		userName.sendKeys(un);
		Thread.sleep(1000);
		
		userPassword.sendKeys(pwd);
		Thread.sleep(1000);
		
		loginSubmitBtn.click(); 
		
		//After login the method should return HomePage
		return new HomePage();
	}
	
	
	
//	public void validateSignUp() 
//	{
//		signUpBtn.click();
//	}
	
	
//	public HomePage login(String un, String pwd)
//	{
//		userName.sendKeys(un);
//		userPassword.sendKeys(pwd);
//		
//		//After login the method should return HomePage
//		loginSubmitBtn.click();
//		return new HomePage();
//	}

	
	
	
}
