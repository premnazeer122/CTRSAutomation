package com.Automation_CTRS.CTRS;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uitilityfiles.Common_Ctrslogin;

public class AgentCredit_Topup {

	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	Common_Ctrslogin login = new Common_Ctrslogin();
	

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		System.out.println("CTRS started");
		driver = login.Ctrslogin();
		System.out.println("Ctrs logined in");
	  }

	  @Test
	  public void testUntitledTestCase() throws Exception {
		Thread.sleep(20000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Master Forms')])[2]")));
	    driver.findElement(By.xpath("(//a[contains(text(),'Master Forms')])[2]")).click();
		driver.findElement(By.xpath("//div[@id='content_master']/ul/li[2]/div/div/a/h3")).click();
		driver.findElement(By.id("agent_country")).click();
	    new Select(driver.findElement(By.id("agent_country"))).selectByVisibleText("SINGAPORE");
	    driver.findElement(By.id("agent_country")).click();
	    driver.findElement(By.id("agent_destination")).click();
	    new Select(driver.findElement(By.id("agent_destination"))).selectByVisibleText("SINGAPORE");
	    driver.findElement(By.id("agent_destination")).click();
	    driver.findElement(By.id("topupfor")).click();
	    driver.findElement(By.id("topupfor")).click();
	    driver.findElement(By.id("agent")).click();
	    new Select(driver.findElement(By.id("agent"))).selectByVisibleText("Agent A");
	    driver.findElement(By.id("agent")).click();
	    driver.findElement(By.id("topup")).click();
	    driver.findElement(By.id("topup")).clear();
	    driver.findElement(By.id("topup")).sendKeys("500");
	    driver.findElement(By.id("pay_mode")).click();
	    new Select(driver.findElement(By.id("pay_mode"))).selectByVisibleText("Arunkumar");
	    driver.findElement(By.id("pay_mode")).click();
	    driver.findElement(By.id("pdate")).click();
	    driver.findElement(By.xpath("//td[text()='22']")).click();
	    driver.findElement(By.id("refno")).click();
	    driver.findElement(By.id("refno")).clear();
	    driver.findElement(By.id("refno")).sendKeys("201700313");	
	        
	    driver.findElement(By.linkText("Save")).click();
	    Assert.assertEquals(closeAlertAndGetItsText(), "Successfully Added The Credit Amount");
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
