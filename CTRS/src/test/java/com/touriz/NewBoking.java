package com.touriz;

import static org.testng.Assert.fail;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class NewBoking {

	public WebDriver driver;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CTRSAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	}

	@Test
	public void Booking_Deduct_from_Account() throws Exception {
		String baseUrl;
		baseUrl = "http://trial.wholesaler.touriz.net/";
		Thread.sleep(2500L);
		driver.get(baseUrl);
		Thread.sleep(10500L);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("prem@saaragh.com");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("12345678p");
		driver.findElement(By.xpath("//div[3]/label")).click();
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		driver.findElement(By.xpath("//span[3]/li/a/span")).click();
		driver.findElement(By.xpath("//ul[@id='sli-notebook']/li/a/span")).click();
		driver.findElement(By.name("agent_id")).click();
		Thread.sleep(2500L);
		new Select(driver.findElement(By.name("agent_id"))).selectByVisibleText("AgentA");
		Thread.sleep(2500L);
		driver.findElement(By.name("agent_id")).click();
		driver.findElement(By.name("country_code")).click();
		Thread.sleep(2500L);
		new Select(driver.findElement(By.name("country_code"))).selectByVisibleText("Singapore");
		Thread.sleep(2500L);
		driver.findElement(By.name("country_code")).click();
		driver.findElement(By.name("destination_id")).click();
		Thread.sleep(2500L);
		new Select(driver.findElement(By.name("destination_id"))).selectByVisibleText("Singapore");
		Thread.sleep(2500L);
		driver.findElement(By.name("destination_id")).click();
		driver.findElement(By.name("product_id")).click();
		Thread.sleep(2500L);
		new Select(driver.findElement(By.name("product_id"))).selectByVisibleText("Fun Tours");
		Thread.sleep(2500L);
		driver.findElement(By.name("product_id")).click();
		driver.findElement(By.xpath("//input")).click();
		driver.findElement(By.xpath("//tr[2]/td[5]/div/span")).click();
		driver.findElement(By.name("time_id")).click();
		Thread.sleep(2500L);
		new Select(driver.findElement(By.name("time_id"))).selectByVisibleText("14:00:00");
		Thread.sleep(2500L);
		driver.findElement(By.name("time_id")).click();
		driver.findElement(By.name("no_adult")).click();
		driver.findElement(By.name("no_adult")).clear();
		driver.findElement(By.name("no_adult")).sendKeys("10");
		driver.findElement(By.xpath("//input[@value='Book Now']")).click();
		Thread.sleep(1000L);
		driver.findElement(By.name("lead_traveller_fname")).click();
		driver.findElement(By.name("lead_traveller_fname")).clear();
		driver.findElement(By.name("lead_traveller_fname")).sendKeys("Chandru");
		driver.findElement(By.name("lead_traveller_lname")).clear();
		driver.findElement(By.name("lead_traveller_lname")).sendKeys("KOTAK");
		driver.findElement(By.name("customer_mobile")).clear();
		driver.findElement(By.name("customer_mobile")).sendKeys("09952267336");
		driver.findElement(By.name("customer_email")).click();
		driver.findElement(By.name("customer_email")).clear();
		driver.findElement(By.name("customer_email")).sendKeys("prem@saaragh.com");
		driver.findElement(By.name("agent_tickt_no")).click();
		driver.findElement(By.name("agent_tickt_no")).clear();
		driver.findElement(By.name("agent_tickt_no")).sendKeys("20180706001");
		driver.findElement(By.name("creditcard")).click();
		driver.findElement(By.name("creditcard")).clear();
		driver.findElement(By.name("creditcard")).sendKeys("12345");
		Thread.sleep(2500L);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2500L);
		driver.findElement(By.xpath("//input[@value='Confirm Booking']")).click();
		Thread.sleep(10500L);
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(12000L);

		String parent_window = driver.getWindowHandle();
		System.out.println("Parent Window ID" + ":" + parent_window);
		System.out.println(parent_window);

		Set handles = driver.getWindowHandles();

		System.out.println(handles);

		for (String handle_childwindow : driver.getWindowHandles()) {
			System.out.println(handle_childwindow);
			driver.switchTo().window(handle_childwindow);

		}
		Thread.sleep(2500L);
		System.out.println("check buttonlable");

		String Url = driver.getCurrentUrl();
		System.out.println("Button lable:" + driver.findElement(By.xpath(".//*[@id='noprint']/button")).getText());

		Thread.sleep(2500L);
		driver.findElement(By.xpath(".//*[@id='noprint']/button")).click();

		System.out.println(Url);
		driver.findElement(By.xpath(".//*[@id='noprint']/button")).sendKeys(Keys.ESCAPE);
		
		
		System.out.println("ESC is pressed");

		driver.switchTo().window(parent_window);
		Thread.sleep(2500L);

		driver.findElement(By.xpath("//span/li/a/span")).click();
		Thread.sleep(2500L);
		driver.findElement(By.xpath("//li[2]/a/i")).click();
		Thread.sleep(2500L);
		driver.findElement(By.xpath("//div[@id='dropdown-user']/a[2]/span")).click();

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
