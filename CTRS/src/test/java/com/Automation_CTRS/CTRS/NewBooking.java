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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.uitilityfiles.Common_Ctrslogin;

public class NewBooking {

	Common_Ctrslogin login = new Common_Ctrslogin();
	public WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.out.println("CTRS started");
		driver = login.Ctrslogin();
		System.out.println("Ctrs logined in");
	}

	@Test(priority = 1)
	public void new_Booking() throws InterruptedException {

		Thread.sleep(20000);

		driver.findElement(By.xpath("(//li[@id='tourbooking']/a)[2]")).click();
		System.out.println("clicked on booking module");
		Thread.sleep(5000);

		driver.switchTo().alert().accept();
		System.out.println("alert accepted");

		Thread.sleep(8000);
		driver.findElement(By.id("back_to_tour_booking")).click();
		System.out.println("Click on New booking");

		// select agent
		new Select(driver.findElement(By.id("agentid"))).selectByVisibleText("AgentBond");
		System.out.println("selecting agent -- AgentBod");

		// select country
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("SINGAPORE");
		System.out.println("selected singapore in select country");

		// select product type
		new Select(driver.findElement(By.id("pdtype"))).selectByVisibleText("Tour");
		System.out.println("Tour: is selected in product type");
		Thread.sleep(4500);

		// click on product name filed
		driver.findElement(By.id("elastictourname")).click();
		Thread.sleep(4500);

		// type/sent product name
		driver.findElement(By.id("elastictourname")).sendKeys("T");
		Thread.sleep(2000);

		// click the product name
		driver.findElement(By.xpath(".//li[@class='ui-menu-item']/a")).click();
		System.out.println("Selected Tour arount the singapore in product name");

		// visit date picker
		Thread.sleep(10000L);
		driver.findElement(By.xpath(".//*[@id='dp2']")).click();
		Thread.sleep(5000);

		// dateBox
		driver.findElement(By.xpath("//td[text()='22']")).click();

		// enter the number of child
		Thread.sleep(7000);
		driver.findElement(By.id("noofadult")).click();
		driver.findElement(By.id("noofadult")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='noofadult'][@name='noofadult']")).sendKeys("3");

		// enter the number of child
		driver.findElement(By.id("noofchild")).click();
		driver.findElement(By.id("noofchild")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='noofchild'][@name='noofchild']")).sendKeys("2");

		// click on seat availability
		driver.findElement(By.id("checkseats")).click();
		Thread.sleep(4000);

		// clear and enter the Lead Traveller First Name
		driver.findElement(By.id("leadtraveller")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("leadtraveller")).sendKeys("Name FirstName");

		// clear and enter the Lead Traveller Last Name
		driver.findElement(By.id("leadtravellerlast")).click();
		driver.findElement(By.id("leadtravellerlast")).sendKeys("Name LastName");

		// clear and enter the Last 4 digits of your Credit Card
		driver.findElement(By.id("creditcard")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("creditcard")).sendKeys("1235");

		// Hotel list
		new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("NOT IN THE LIST");

		Thread.sleep(5000);
		/* driver.findElement(By.id("terms")).click(); */
		driver.findElement(By.xpath("//input[@type='checkbox'][@id='terms']")).click();
		/* driver.findElement(By.id("confirm")).click(); */
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	}

	@Test(priority = 2)
	public void Booking_Payment_confirmed() throws InterruptedException {

		Thread.sleep(15000);
		Assert.assertEquals(driver.getTitle(), "Booking Summary");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='contentPad']/div/div/div[2]/table/tbody/tr[2]/td[2]")).getText(),
				"Tour Around the Singapore");
		driver.findElement(By.id("referenceno")).clear();
		driver.findElement(By.id("referenceno")).sendKeys("2018020005");
		// Booking confirm on clicking confirm button in Staff booking Summary
		// page
		driver.findElement(By.id("confirmPayment")).click();

		Thread.sleep(15000);

		// Asserting the text Booking confirmation
		Assert.assertEquals(driver.findElement(By.id("ui-id-2")).getText(), "Booking Confirmation");
		String Booking_Id = driver.findElement(By.id("ui-id-1")).getText();

		// getting print the booking id on booking payment confirmation
		System.out.println("Booking Id " + " : " + Booking_Id);

		// checking print ticket button element is present
		assertTrue(isElementPresent(By.id("printeticket")));
		System.out.println("Printeticket Element is present");
		assertTrue(isElementPresent(By.xpath("(//button[@type='button'])[5]")));
		System.out.println("Button Element is present");
	}

	@Test(priority = 3)
	public void print_Eticket() throws Exception {

		String parent_window = driver.getWindowHandle();
		System.out.println("Parent Window ID" + ":" + parent_window);

		driver.findElement(By.id("printeticket")).click();
		
		System.out.println("Navigating to child window");
		Thread.sleep(3000);
								
		// Click on download e-ticket
		System.out.println("Downloading eticket");
		driver.findElement(By.xpath("//button[text()='Download link']")).click();
		System.out.println("eticket-Downloaded");
		Thread.sleep(1500);
		System.out.println(driver.getCurrentUrl());
		
		// Asserting the text Download link
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Download link']")).getText(), "Download link");
		Thread.sleep(5000);
		
		System.out.println("Title: "+ driver.getTitle());

		for (String childtab : driver.getWindowHandles()) {
			{
				Thread.sleep(8000);
				driver.switchTo().window(parent_window);
				System.out.println("Parent window Title" + driver.getTitle());
				
				driver.switchTo().window(childtab);
				Thread.sleep(7000);
				
				System.out.println("Tile1 =" + driver.getTitle());
				Thread.sleep(7000);
											
			}
			
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