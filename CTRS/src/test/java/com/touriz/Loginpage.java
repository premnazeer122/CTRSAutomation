package com.touriz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Loginpage {

	public WebDriver driver;

	@Test
	public void touriz_login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CTRSAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://trial.wholesaler.touriz.net/");
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL Page:"+ currenturl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2500L);
		driver.findElement(By.xpath(".//login/div/form/div[1]/div[1]/input")).sendKeys("prem@saaragh.com");
		Thread.sleep(2500L);
		driver.findElement(By.xpath(".//login/div/form/div[2]/div[1]/input")).sendKeys("12345678p");
		
	}

}
