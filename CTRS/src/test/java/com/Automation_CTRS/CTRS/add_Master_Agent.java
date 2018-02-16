package com.Automation_CTRS.CTRS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class add_Master_Agent {
	
WebDriver driver;




@BeforeClass(alwaysRun = true)
public void login() throws Exception{
	
	com.uitilityfiles.Common_Ctrslogin login = new com.uitilityfiles.Common_Ctrslogin();
	driver=login.Ctrslogin();
}
	@Test
	  public void testAddAgent() throws Exception {
	    
	    driver.findElement(By.cssSelector("#p7menubar > #master > a")).click();
	    driver.findElement(By.cssSelector("a[title=\"Add Agent\"] > h3")).click();
	    
	    driver.findElement(By.id("agentname")).sendKeys("Test Tours Agent");
	       
	    driver.findElement(By.id("agentcode")).sendKeys("91");
	    
	    new Select(driver.findElement(By.id("accountmasterid"))).selectByVisibleText("Ashik Account staff");
	    new Select(driver.findElement(By.id("newcountry_id"))).selectByVisibleText("Australia");
	    
	    driver.findElement(By.id("newdestination_id")).clear();
	    driver.findElement(By.id("newdestination_id")).sendKeys("Ooty");
	    driver.findElement(By.id("address")).clear();
	    driver.findElement(By.id("address")).sendKeys("No 11 Sree ram nagar");
	    driver.findElement(By.id("zipcode")).clear();
	    driver.findElement(By.id("zipcode")).sendKeys("641004");
	   
	    driver.findElement(By.id("phone")).sendKeys("9523666000");
	    
	    driver.findElement(By.id("mobile")).sendKeys("1234567890");
	   
	    driver.findElement(By.id("fax")).sendKeys("123548");
	    
	    driver.findElement(By.id("email")).sendKeys("premnazeer122@gmail.com");
	    
	    driver.findElement(By.id("licences")).sendKeys("12354687");
	    
	    driver.findElement(By.id("url")).sendKeys("www.saaragh solution");
	    
	    driver.findElement(By.id("ownername")).sendKeys("Santhosh");
	    
	    new Select(driver.findElement(By.id("relationmanagerid"))).selectByVisibleText("CITY DISCOVERY INC");
	    new Select(driver.findElement(By.id("agentype"))).selectByVisibleText("AgentRate(s)(T1)");
	    
	    driver.findElement(By.id("allowpayment")).click();
	    driver.findElement(By.id("disallowpayment")).click();
	    driver.findElement(By.id("use_email_acc")).click();
	    
	    new Select(driver.findElement(By.id("agentpaymode"))).selectByVisibleText("DEDUCT FROM CREDIT");
	    
	    driver.findElement(By.id("suppress")).click();
	    
	    driver.findElement(By.id("agentreferenceno")).sendKeys("123002");
	    driver.findElement(By.id("voucher_report")).click();
	    driver.findElement(By.id("allow_bulk_upload")).click();
	    driver.findElement(By.id("allow_advance_ticket")).click();
	    
	    new Select(driver.findElement(By.id("allow_logo_to_voucher"))).selectByVisibleText("Yes");
	    
	    driver.findElement(By.id("view_redemption_status")).click();
	    
	    driver.findElement(By.id("bank")).sendKeys("ICICI");
	    
	    driver.findElement(By.id("bankaccountnumber")).sendKeys("0002154747");
	    
	    driver.findElement(By.id("remarks")).sendKeys("Welcome");
	    
	    driver.findElement(By.id("dsh_msg")).sendKeys("welcome");
	    
	    new Select(driver.findElement(By.id("language"))).selectByVisibleText("English");
	    
	    driver.findElement(By.id("agentcreditlimit")).clear();
	    
	    driver.findElement(By.id("agentcreditlimit")).sendKeys("2500.25");
	    
	    driver.findElement(By.cssSelector("option[value=\"26\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"146\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"Activity\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"ActivityEventShowConcert\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"ActivitySpa\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"AdvancedTicketBooking\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"CSVTicketBooking\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"Discount\"]")).click();
	    
	    driver.findElement(By.cssSelector("option[value=\"Hotel\"]")).click();
	   
	    // driver.findElement(By.linkText("Save")).click();
	  }
	
	
	
	
}
