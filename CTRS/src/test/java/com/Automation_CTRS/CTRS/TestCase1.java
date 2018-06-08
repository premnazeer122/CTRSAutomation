/**
 * Author:Prem Nazeer >>>> New Booking <<<<
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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.uitilityfiles.Common_Ctrslogin;
import com.uitilityfiles.Scroll_Page; 

public class TestCase1 {

	ExtentReports Extent_report;
	ExtentTest Test_logger;

	Common_Ctrslogin login = new Common_Ctrslogin();
	Scroll_Page scroll = new Scroll_Page();
	public WebDriver driver;

	@BeforeSuite
	// This annotated method will be run before all test() in this suite.
	public void Report_Browser_setUp() throws Exception {
		Extent_report = new ExtentReports("./Reports/Booking.html", true);
		System.out.println("CTRS started");
		driver = login.Ctrslogin();

		System.out.println("Ctrs logined in");
	}

	@BeforeMethod
	// This annotation method will run before each test() method.
	public void beforeMethod(Method method) {

		// Test starts here
		Test_logger = Extent_report.startTest((this.getClass().getSimpleName() + "::" + method.getName()));

		// Author Name
		Test_logger.assignAuthor("Author :: Prem Nazeer");

		// Types of Test Category
		Test_logger.assignCategory("Regression");

		// Test Description
		Test_logger.log(LogStatus.PASS, "Browser launched successfully");

	}

	@Test(priority = 1)
	public void new_Booking() throws Exception {
		System.out.println("New Booking Test");
		Test_logger.log(LogStatus.INFO, "CTRS Started ");

		Test_logger.log(LogStatus.PASS, "Login into CTRS");

		Test_logger.log(LogStatus.INFO, "Ctrs logined in Success!!!");
		Thread.sleep(20000);
		Test_logger.log(LogStatus.INFO, "CTRS BOOKING Menu");

		driver.findElement(By.xpath("(//li[@id='tourbooking']/a)[2]")).click();
		Test_logger.log(LogStatus.PASS, "Booking Menu has been clicked");
		System.out.println("clicked on booking module");
		Thread.sleep(5000);

		Test_logger.log(LogStatus.INFO, "Alert Message on entering to Booking menu Present");
		driver.switchTo().alert().accept();
		Test_logger.log(LogStatus.PASS, "Accepted the Alter and Entered into booking menu");
		System.out.println("alert accepted");

		Thread.sleep(8000);
		Test_logger.log(LogStatus.INFO, "Clicking on New Booking button");
		driver.findElement(By.id("back_to_tour_booking")).click();
		Test_logger.log(LogStatus.PASS, "Clicked on New Booking");
		System.out.println("Click on New booking");

		/*Thread.sleep(7000);
		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(8000);
		JavascriptExecutor scrollup = (JavascriptExecutor) driver;
		scrollup.executeScript("window.scrollBy(0,-450)", "");
		Thread.sleep(5000);*/

		// select agent
		Test_logger.log(LogStatus.INFO, "Select Agent");
		new Select(driver.findElement(By.id("agentid"))).selectByVisibleText("AgentBond");
		System.out.println("selecting agent -- AgentBod");
		Test_logger.log(LogStatus.PASS, "AgentBond has been slected");

		// select country
		Test_logger.log(LogStatus.INFO, "Choose thr Country fot Tour");
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("SINGAPORE");
		System.out.println("selected singapore in select country");
		Test_logger.log(LogStatus.PASS, "singapore in select country as Country");

		// select product type
		Test_logger.log(LogStatus.INFO, "ProductType");
		new Select(driver.findElement(By.id("pdtype"))).selectByVisibleText("Tour");
		System.out.println("Tour: is selected in product type");
		Test_logger.log(LogStatus.PASS, "Tour: is selected as product type");
		Thread.sleep(4500);

		// click on product name filed
		Test_logger.log(LogStatus.INFO, "Elastictourname-Search");
		driver.findElement(By.id("elastictourname")).click();
		Test_logger.log(LogStatus.PASS, "Clicked on Product Search filed");
		Thread.sleep(4500);
		
		
		// type product name
		Test_logger.log(LogStatus.INFO, "Searching by Letter in product");
		driver.findElement(By.id("elastictourname")).sendKeys("Tour Around the Singapore");
		Thread.sleep(2000);

		// Select the product name
		Test_logger.log(LogStatus.INFO, "Need to Select the Product from Product Dropdown");
		driver.findElement(By.xpath("//a[contains(text(),'Tour Around the Singapore')]")).click();
		System.out.println("Selected Product: Tour around the singapore in product name");
		Test_logger.log(LogStatus.PASS, "Product has been Selected Successfully");
		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,450)", "");
		
		// visit date picker
		Thread.sleep(5000L);
		Test_logger.log(LogStatus.INFO, "Clicked on Visit Date filed");
		driver.findElement(By.xpath(".//*[@id='dp2']")).click();
		Thread.sleep(5000);

		// dateBox
		driver.findElement(By.xpath("//td[text()='22']")).click();
		Test_logger.log(LogStatus.PASS, "Selected the Visit date");

		// enter the number of child
		Thread.sleep(7000);
		driver.findElement(By.id("noofadult")).click();
		driver.findElement(By.id("noofadult")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='noofadult'][@name='noofadult']")).sendKeys("3");
		Test_logger.log(LogStatus.INFO, "Entered the no of Adult fot the trip");

		// enter the number of child
		driver.findElement(By.id("noofchild")).click();
		driver.findElement(By.id("noofchild")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='noofchild'][@name='noofchild']")).sendKeys("2");
		Test_logger.log(LogStatus.INFO, "Entered the No of child for the Trip ");

		// click on seat availability
		driver.findElement(By.id("checkseats")).click();
		Test_logger.log(LogStatus.INFO, "Checking Available Seats");
		Thread.sleep(4000);

		
		scrolldown.executeScript("window.scrollBy(0,450)", "");
		
		// clear and enter the Lead Traveller First Name
		driver.findElement(By.id("leadtraveller")).click();
		Test_logger.log(LogStatus.PASS, "Clicked into the Leadtraveller Success");
		Thread.sleep(2000);
		driver.findElement(By.id("leadtraveller")).sendKeys("Name FirstName");
		Test_logger.log(LogStatus.INFO, "First Name is Entered");

		// clear and enter the Lead Traveller Last Name
		driver.findElement(By.id("leadtravellerlast")).click();
		driver.findElement(By.id("leadtravellerlast")).sendKeys("Name LastName");
		Test_logger.log(LogStatus.INFO, "Last Name is Entered");

		// clear and enter the Last 4 digits of your Credit Card
		driver.findElement(By.id("creditcard")).clear();
		Thread.sleep(5000);
		driver.findElement(By.id("creditcard")).sendKeys("1235");
		Test_logger.log(LogStatus.INFO, "CreditCard CV number is Entered");

		// Hotel list
		new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("NOT IN THE LIST");
		Test_logger.log(LogStatus.PASS, "Hotel is sleceted from Hotels List");
		Thread.sleep(5000);
		
		scrolldown.executeScript("window.scrollBy(0,490)", "");
		
		/* driver.findElement(By.id("terms")).click(); */
		driver.findElement(By.xpath("//input[@type='checkbox'][@id='terms']")).click();
		Test_logger.log(LogStatus.PASS, "Terms and condition Check box has been clicked");

		/* driver.findElement(By.id("confirm")).click(); */
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Test_logger.log(LogStatus.PASS, "Successfully Clicked on Confirm button");
	}

	@Test(priority = 2)
	public void Booking_Payment_confirmed() throws InterruptedException {

		Test_logger.log(LogStatus.INFO, "Redirected to Booking summary page");
		Thread.sleep(15000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Booking Summary");

		if ((title.contains("Booking Summary"))) {

			Test_logger.log(LogStatus.PASS, "Title verification passed for Booking Summary Page");
		} else {
			Test_logger.log(LogStatus.FAIL, "Title text verification failed for Booking Summary Page");
		}

		String ProductName = driver
				.findElement(By.xpath("//div[@id='contentPad']/div/div/div[2]/table/tbody/tr[2]/td[2]")).getText();
		Assert.assertEquals(ProductName, "Tour Around the Singapore");

		if (ProductName.contains("Tour Around the Singapore")) {
			Test_logger.log(LogStatus.PASS, "Productname text verification passed for Booking Summary Page");
		} else {
			Test_logger.log(LogStatus.FAIL, "Productname text verification failed for Booking Summary Page");
		}

		// Scrolling the page
		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,490)", "");

		driver.findElement(By.id("referenceno")).clear();

		Test_logger.log(LogStatus.INFO, "Sending the Reference number to referrence filed");
		driver.findElement(By.id("referenceno")).sendKeys("2018020005");
		// Booking confirm on clicking confirm button in Staff booking Summary
		// page
		driver.findElement(By.id("confirmPayment")).click();
		Test_logger.log(LogStatus.PASS, "Confirmed the Booking");

		/// Close button xpath--->> html/body/div[12]/div[3]/div/button[3]
		Thread.sleep(15000);

		String Bookingletter = driver.findElement(By.id("ui-id-2")).getText();
		// Asserting the text Booking confirmation
		Assert.assertEquals(Bookingletter, "Booking Confirmation");

		if (Bookingletter.contains("Booking Confirmation")) {
			Test_logger.log(LogStatus.PASS, "Booking conformation text is verification Passed");
		} else {
			Test_logger.log(LogStatus.FAIL, "Booking conformation text verification failed");
		}

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
		System.out.println(parent_window);

		driver.findElement(By.id("printeticket")).click();

		System.out.println("Navigating to child window");
		Thread.sleep(5000);
		
		Set handles = driver.getWindowHandles();
		 
        System.out.println(handles);
        
        for (String handle_childwindow : driver.getWindowHandles()) {
        	 
        	System.out.println(handle_childwindow);

        	driver.switchTo().window(handle_childwindow);
        }

		Thread.sleep(8000);

		JavascriptExecutor scrolldown = (JavascriptExecutor) driver;
		scrolldown.executeScript("window.scrollBy(0,600)", "");
		
		System.out.println("Child window Title" + driver.getTitle());
		
		// Click on download e-ticket
		System.out.println("Scroll down to Downloading eticket button");

		// Asserting the text Download link
				String Downloadtext = driver.findElement(By.xpath("//*[text()='Download link']")).getText();
				Assert.assertEquals(Downloadtext, "Download link");
				if (Downloadtext.contains("Download link")) {
					Test_logger.log(LogStatus.PASS, "Download link text verification passed");
				} else {
					Test_logger.log(LogStatus.FAIL, "Download link text verification failed");
				}
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Download link']")));
		driver.findElement(By.xpath("//*[text()='Download link']")).click();
		System.out.println("eticket-Downloaded");

		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());

		

		Thread.sleep(5000);

		System.out.println("Title: " + driver.getTitle());

		/* for loop close flower-braces } */
		Thread.sleep(8000);
		driver.switchTo().window(parent_window);
		System.out.println("Parent window Title" + driver.getTitle());
	}

	// Test Suite Ends Here
	@AfterSuite
	// This annotation method will run after all test() method in this suite.
	public void afterSuite() throws InterruptedException {

		Test_logger.log(LogStatus.INFO, "Browser closed successfully");
		Test_logger.log(LogStatus.PASS, "New Booking Functionality is verified and Working good");

		// End the test
		driver.close();
		driver.quit();

		// End and Flush the data to report
		Extent_report.endTest(Test_logger);
		Thread.sleep(2500);
		Extent_report.flush();
		Thread.sleep(2500);
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("D:\\Workspace\\CTRSAutomation\\CTRS\\Reports\\Booking.html");
		driver.manage().window().maximize();

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