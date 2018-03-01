package com.testjavafiles;



	
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

		public class TestBooking {
		  public static WebDriver driver;
		  public String baseUrl;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeTest(alwaysRun = true)
		  public void setUp() throws Exception {
		    driver = new FirefoxDriver();
		    baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  

		  @Test
		  public void testUntitledTestCase() throws Exception {
		    driver.get("http://uatserver.info/ctrsArchUIv3/");
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("prem@saaragh.com");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("12345678p");
		    driver.findElement(By.xpath("//label[3]")).click();
		    driver.findElement(By.xpath("//button[@type='button']")).click();
		    Thread.sleep(30000L);
		    driver.findElement(By.xpath("(//li[@id='tourbooking']/a)[2]")).click();
		    
		    
		    Thread.sleep(30000L);
		    driver.switchTo().alert().accept();
		    Thread.sleep(8000L);
		    driver.findElement(By.xpath("(//a[contains(text(),'Master Forms')])[2]")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'Reports')])[2]")).click();
		    driver.findElement(By.id("category")).click();
		    new Select(driver.findElement(By.id("category"))).selectByVisibleText("Accounts Reports");
		    driver.findElement(By.xpath("//option[@value='3']")).click();
		    driver.findElement(By.id("reports")).click();
		    driver.findElement(By.id("reports")).click();
		    new Select(driver.findElement(By.id("reports"))).selectByVisibleText("Accounts Billing (TRANSFER)");
		    driver.findElement(By.xpath("//option[@value='report/listTransferAccpac']")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'User Permission')])[2]")).click();
		    driver.findElement(By.id("usergroup")).click();
		    new Select(driver.findElement(By.id("usergroup"))).selectByVisibleText("Accounts");
		    driver.findElement(By.xpath("//option[@value='6']")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'Dashboard')])[2]")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
		  }

		  @AfterTest(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }
		

	}

