package com.Automation_CTRS.CTRS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uitilityfiles.Common_Ctrslogin;

public class randomSelectfromDropdown {

	WebDriver driver;
	ArrayList<String>randomselect;

	@BeforeTest(alwaysRun = true)
	public void login() throws Exception{
		
		Common_Ctrslogin login = new Common_Ctrslogin();
		driver=login.Ctrslogin();
	}
	
	
	@Test
	public void dropDonw_randomSelect()
	{
		
		driver.findElement(By.xpath(".//*[@id='p7menubar']/li[6]/a")).click();
									
				  //To get the all dropdown values from country field
				  List<WebElement> selectfromdropdown = new Select(driver.findElement(By.xpath(".//*[@id='usergroup']"))).getOptions();
				  randomselect = new ArrayList<String>();

				  for(int i=0;i<selectfromdropdown.size();i++){
				   //getting all the data from dropdown
				   String arraylistvalues =selectfromdropdown.get(i).getText();
				   //Storing each value in array list
				   randomselect.add(arraylistvalues);
				   System.out.println("value of i:" + i+"\n"+ "DropDown Text:"+arraylistvalues);
				  }
				  
				  
				  //generating random integer value
				  Random randomvalue = new Random();
				     int randomNumber = randomvalue.nextInt(randomselect.size()- 0) + 0;
				     
				     //getting random data from array List
				     String userRoll=randomselect.get(randomNumber);
				     
				     
				     //passing random data into dropdown field
				  driver.findElement(By.xpath(".//*[@id='usergroup']")).sendKeys(userRoll);
				  System.out.println("\nRandamly Choosen User_Group:"+ userRoll);
	}
	
	@Test
	public void elasticsearch_dropDown_randomSelect() throws InterruptedException
	{
		driver.findElement(By.cssSelector("#p7menubar > #tourbooking > a")).click(); 
		
		/*driver.findElement(By.xpath(".//*[@id='tourbooking']/a")).click();*/
		 Thread.sleep(3500L);
		driver.switchTo().alert().accept();
		 Thread.sleep(3000L); 
		 /*driver.findElement(By.xpath(".//div[@class='columnHead']/h4/button[5]")).click();*/
		
		driver.findElement(By.id("back_to_tour_booking")).click();
		    new Select(driver.findElement(By.id("agentid"))).selectByVisibleText("Ashik Master");
		    driver.findElement(By.cssSelector("option[value=\"597\"]")).click();
		    new Select(driver.findElement(By.id("country"))).selectByVisibleText("SINGAPORE");
		    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
		    new Select(driver.findElement(By.id("pdtype"))).selectByVisibleText("Tour");
		    driver.findElement(By.id("elastictourname")).click();
		    
		    driver.findElement(By.id("elastictourname")).sendKeys("1");
		    Thread.sleep(1500L);
		    
		    //click the product
		    driver.findElement(By.xpath(".//li[2][@class='ui-menu-item']/a")).click();
	}
	
}
