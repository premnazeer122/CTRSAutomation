package com.jmeter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCase1{	
	public WebDriver driver;
	
	
	//This are object for the id locators which can be used only object name.
			By username = By.id("username");
			By password = By.id("password");
			By Signin = By.xpath("//label[@class='checkbox']/following::button[1]");
			static By Logout = By.xpath("(.//a[contains(text(),'Logout')])[2]");
			
	
	 @Test
	 	public void Ctrslogin() throws Exception {
				
		/** To use Firefox >> method.getFireox_driver() <<
		 *  To use Chrome >> method.getChrome_driver() <<
		*/
		driver = new FirefoxDriver();
		driver.get("http://uatserver.info/ctrsArchUIv3/");
		driver.findElement(username).sendKeys("prem@saaragh.com");
		driver.findElement(password).sendKeys("12345678p");
		driver.findElement(Signin).click();
		Thread.sleep(10000L);
		driver.findElement(Logout).click();	
	}
	 
}