package com.uitilityfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common_Ctrslogin {
	private WebDriver driver;
	
	//This are object for the id locators which can be used only object name.
	By username = By.id("username");
	By password = By.id("password");
	By Signin =By.xpath("//label[@class='checkbox']/following::button[1]");
	static By Logout = By.xpath("(//a[contains(text(),'Logout')])[2]");
	
	
	
	configReader config=new configReader(); 
	public WebDriver Ctrslogin() throws Exception {
		/*driver=Browser.browsersetUp();
		String baseUrl = "http://uatserver.info/ctrsArchUIv3/";*/
		driver=DriverFactory.DriverStart(config.getFireox_driver(), config.getURL());
		driver.findElement(username).sendKeys("admin@nfsg.com");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(Signin).click();
		return driver;
		
	}

	public  WebDriver logout() {
		driver.findElement(Logout).click();
		return driver;
		
	}
	
}