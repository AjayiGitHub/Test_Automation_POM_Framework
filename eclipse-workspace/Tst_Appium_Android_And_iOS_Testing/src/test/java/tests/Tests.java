package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Tests extends BaseClass {



	@Test 
	public void testOne() 
	{
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); // means I just want to press enter on keyboard
		//		driver.findElement(By.name("btnK")).click(); 
		System.out.println("Completed testOne....Automation input");
	}

	@Test
	public void testTwo() 

	{
		//		driver.get("http://google.com");
		driver.findElementByName("q").sendKeys("Software Testing");
		driver.findElementByName("q").sendKeys(Keys.ENTER);// means I just want to press enter on keyboard 

		System.out.println("Completed testTwo......Software Testing");
	}

	@Test
	public void testOrangeDemoHrm() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("MP_link")).click();
		driver.findElement(By.id("Subscriber_link")).click();
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}




}
