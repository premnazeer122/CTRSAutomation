package com.Automation_CTRS.CTRS;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uitilityfiles.CommonMethods;
import com.uitilityfiles.Common_Ctrslogin;


public class ModuleClick_test {

	public WebDriver driver;
	CommonMethods call_method=new CommonMethods();
	Common_Ctrslogin login= new Common_Ctrslogin();
	@BeforeTest
	public void setup() throws Exception{
		System.out.println("Chrome browser started");
		driver=login.Ctrslogin();
		System.out.println("Logged in");
	}
	
	@Test(priority=4)
	public void masterMenu() throws InterruptedException{
		
	System.out.println("Waiting time started");
	
	
	System.out.println("After Wait time click on Master menu");
	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='p7menubar']/li[2]/a")));
	System.out.println("Wait time stopped");
	driver.findElement(By.xpath(".//ul[@id='p7menubar']/li[2]/a")).click();
	}
	
	@Test(priority=2)
	public void report() throws InterruptedException{
		
		Thread.sleep(30000L);
		System.out.println("After Wait time click on report menu");
	
		driver.findElement(By.xpath("(//a[contains(text(),'Reports')])[2]")).click();
	
	}
	
	@Test(priority=3)
	public void permission() throws InterruptedException{
	System.out.println("After Wait time click on premission menu");
	driver.findElement(By.xpath(".//*[@id='p7menubar']/li[5]/a")).click();
	Thread.sleep(20000L);
	}
	
	@Test(priority=1)
	public void bookingMenu() throws InterruptedException{
	
	
	Thread.sleep(30000L);
	System.out.println("After Wait time click on booking menu");
    driver.findElement(By.xpath("(//li[@id='tourbooking']/a)[2]")).click();
	Thread.sleep(3000L);
	driver.switchTo().alert().accept();
		
	/*int ok_size=driver.findElements(By.xpath(".//div[@id='menuwrapper']/ul/li[2][@class='menu']/a")).size();

	driver.findElements(By.xpath(".//div[@id='menuwrapper']/ul/li[2][@class='menu']/a")).get(ok_size-1).click();
	
	new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='menuwrapper']/ul/li[2][@class='menu']/a")));
	driver.findElement(By.xpath(".//div[@id='menuwrapper']/ul/li[2][@class='menu']/a")).click();
	int x = driver.findElement(By.xpath(".//div[@id='menuwrapper']/ul/li[2][@class='menu']/a")).getLocation().getX();
	
	int y = driver.findElement(By.xpath(".//div[@id='menuwrapper']/ul/li[2][@class='menu']/a")).getLocation().getY();
	System.out.println("X cordinates" + x);
	System.out.println("Y cordinates" + y);*/
	
	
	}
	
	@AfterTest
	public void closebrowser(){
	driver.close();
	}
			}
	


