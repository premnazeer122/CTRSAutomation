/**
 * Author:Prem Nazeer
 * Scenario:
 * Place New booking by Administrator for Agent ="AgentBond"
 * 
 * Test Case:
 * Login with Admini with credentials.
 * Click on Booking Menu.
 * Accepting the alter.
 * Click on New booking button.
 * Do the Booking form to AgentBound for destination Singapore, and fill all required filed.
 * Click on accept terms and condition check box.
 * Click on Confirm button.
 * Verify the Booking Summary and enter the reference number.
 * Click on Confirm button in booking summary.
 * Verify the Booking Confirmation alert box.
 * Check the Print E-ticket button.
 */
package com.Automation_CTRS.CTRS;

import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uitilityfiles.Common_Ctrslogin;

public class NewBooking {
	
	Common_Ctrslogin login=new Common_Ctrslogin();
	public WebDriver driver;
	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver=login.Ctrslogin();
	}

	@Test(priority = 1)
	public void new_tBooking() throws InterruptedException {
		
		Thread.sleep(30000L);
	    driver.findElement(By.xpath("(//li[@id='tourbooking']/a)[2]")).click();
	        
	    Thread.sleep(30000L);
	    driver.switchTo().alert().accept();
	    Thread.sleep(8000L);
		driver.findElement(By.id("back_to_tour_booking")).click();

		// select agent
		new Select(driver.findElement(By.id("agentid"))).selectByVisibleText("AgentBond");

		// select country
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("SINGAPORE");

		// select product type
		new Select(driver.findElement(By.id("pdtype"))).selectByVisibleText("Tour");
		Thread.sleep(4500L);

		// click on product name filed
		driver.findElement(By.id("elastictourname")).click();
		Thread.sleep(4500L);

		// type/sent product name
		driver.findElement(By.id("elastictourname")).sendKeys("T");
		Thread.sleep(5000L);

		// click the product name
		Thread.sleep(2500L);
		driver.findElement(By.xpath(".//li[@class='ui-menu-item']/a")).click();

		// visit date picker
		Thread.sleep(7000L);
		driver.findElement(By.xpath("//*[@id='dp2']")).click();
		Thread.sleep(5000L);
		WebElement dateBox = driver.findElement(By.xpath("/html/body/div[10]/div[1]/table/tbody/tr[5]/td[7]"));
		Thread.sleep(2000L);
		dateBox.click();

		// enter the number of child
		Thread.sleep(7000L);
		driver.findElement(By.id("noofadult")).click();
		driver.findElement(By.id("noofadult")).clear();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(".//*[@id='noofadult'][@name='noofadult']")).sendKeys("3");

		// enter the number of child
		driver.findElement(By.id("noofchild")).click();
		driver.findElement(By.id("noofchild")).clear();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(".//*[@id='noofchild'][@name='noofchild']")).sendKeys("2");

		// click on seat availability
		driver.findElement(By.id("checkseats")).click();
		Thread.sleep(4000L);

		// clear and enter the Lead Traveller First Name
		driver.findElement(By.id("leadtraveller")).click();
		Thread.sleep(2000L);
		driver.findElement(By.id("leadtraveller")).sendKeys("Name FirstName");

		// clear and enter the Lead Traveller Last Name
		driver.findElement(By.id("leadtravellerlast")).click();
		driver.findElement(By.id("leadtravellerlast")).sendKeys("Name LastName");

		// clear and enter the Last 4 digits of your Credit Card
		driver.findElement(By.id("creditcard")).clear();
		Thread.sleep(5000L);
		driver.findElement(By.id("creditcard")).sendKeys("1235");

		// Hotel list
		new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("NOT IN THE LIST");

		Thread.sleep(5000L);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("confirm")).click();
	}

	@Test(priority = 2)
	public void Booking_Payment_confirmed() throws InterruptedException {

		Thread.sleep(15000L);
		Assert.assertEquals(driver.getTitle(), "Booking Summary");
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[@id='contentPad']/div/div/div[2]/table/tbody/tr[2]/td[2]")).getText(),
				"Tour Around the Singapore");
		driver.findElement(By.id("referenceno")).clear();
		driver.findElement(By.id("referenceno")).sendKeys("2018020005");
		driver.findElement(By.id("confirmPayment")).click();

		Thread.sleep(15000L);

		// Asserting the text Booking confirmation
		Assert.assertEquals(driver.findElement(By.id("ui-id-2")).getText(), "Booking Confirmation");
		String Booking_Id = driver.findElement(By.id("ui-id-1")).getText();

		// getting print the booking id on booking payment confirmation
		System.out.println("Booking Id " + " : " + Booking_Id);

		// checking print ticket button element is present
		assertTrue(isElementPresent(By.id("printeticket")));
		assertTrue(isElementPresent(By.xpath("(//button[@type='button'])[5]")));
	}

	@Test(priority = 3)
	public void print_Eticket() throws Exception {

		String parent_window = driver.getWindowHandle();

		System.out.println("Parent Window ID" + ":" + parent_window);

		driver.findElement(By.id("printeticket")).click();

		Set<String> allWindowcount = driver.getWindowHandles();

		int window_count = allWindowcount.size();

		System.out.println("Count of windows" + " : " + window_count);

		String child = null;
		driver.switchTo().window(child);

		for (String child1 : allWindowcount) {
			if (!parent_window.equalsIgnoreCase(child1)) {
				driver.switchTo().window(child1);
				System.out.println(driver.switchTo().window(child1).getTitle());
				Thread.sleep(3000L);
				// Asserting the text Download link
				Assert.assertEquals(driver.findElement(By.cssSelector("button")).getText(), "Download link");

				Thread.sleep(3000L);
				driver.findElement(By.cssSelector(".ui-dialog-buttonset>button")).click();

				Thread.sleep(1500L);
				driver.close();
			}
			driver.switchTo().window(parent_window);
			System.out.println("Parent window Title" + driver.getTitle());
			/*
			 * Thread.sleep(1500L); driver.findElement(By.xpath(
			 * ".//button[@id='confirmvoucher']/button")).click();
			 */
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
}