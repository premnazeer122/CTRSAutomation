package com.uitilityfiles;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	private StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;
	
	
	 public static WebDriver browsersetUp() throws Exception {
			FirefoxDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			return driver;
		   
	
}
	 public void tearDown() throws Exception {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
	 
}
}

