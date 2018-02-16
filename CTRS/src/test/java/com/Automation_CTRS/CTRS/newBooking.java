/**
 * 
 */
package com.Automation_CTRS.CTRS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class newBooking {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://uatserver.info/ctrsArchUIv3/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBooking() throws InterruptedException   {
    driver.get(baseUrl);
    driver.findElement(By.id("username")).sendKeys("prem@saaragh.com");
    driver.findElement(By.id("password")).sendKeys("12345678p");
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.cssSelector("#p7menubar > #tourbooking > a")).click();
    Thread.sleep(1500L);
    
    //accept alter
    driver.switchTo().alert().accept();
    
    Thread.sleep(1500L);
    driver.findElement(By.id("back_to_tour_booking")).click();
    
    //select agent
    new Select(driver.findElement(By.id("agentid"))).selectByVisibleText("Ashik Master");
    
    //select country
    new Select(driver.findElement(By.id("country"))).selectByVisibleText("SINGAPORE");
    
    //select product type 
    new Select(driver.findElement(By.id("pdtype"))).selectByVisibleText("Tour");
    
    //click on product name filed
    driver.findElement(By.id("elastictourname")).click();
   
    //type/sent product name
    driver.findElement(By.id("elastictourname")).sendKeys("1");
    Thread.sleep(1500L);
    
    //click the product
    driver.findElement(By.xpath(".//li[2][@class='ui-menu-item']/a")).click();
    
    
  }

 
}



