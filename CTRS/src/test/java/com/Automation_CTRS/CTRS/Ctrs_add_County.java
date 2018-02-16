package com.Automation_CTRS.CTRS;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ctrs_add_County {

	WebDriver driver;
	private boolean acceptNextAlert = true;
	
	com.uitilityfiles.Common_Ctrslogin login = new com.uitilityfiles.Common_Ctrslogin();
	
	@BeforeClass(alwaysRun = true)
	public void login() throws Exception{
		
		login.Ctrslogin();
	}
	
	
	@Test
	  public  String addcountry() throws Exception {
		
	    driver.findElement(By.xpath("xpath=(//a[contains(text(),'Master Forms')])[2]")).click();
	    driver.findElement(By.cssSelector("a[title=\"Add Country\"] > h3")).click();
	    
	    driver.findElement(By.id("ccode")).sendKeys("KA");
	    driver.findElement(By.id("cname")).sendKeys("Karnataka");
	    driver.findElement(By.linkText("Save")).click();
	    assertEquals(closeAlertAndGetItsText(), "Country Added Sucessfully");
	    
	    try {
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        if (acceptNextAlert) {
	          alert.accept();
	        } else {
	          alert.dismiss();
	        }
	        return alertText;
	      }
	    finally {
	        acceptNextAlert = true;
	      }
	    
	    
	  }

	private Object closeAlertAndGetItsText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
