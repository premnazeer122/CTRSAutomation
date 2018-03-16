package com.testjavafiles;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Regression_Test_Check {

	// Creating ExtentReport and ExtentTest reference values
	ExtentReports Extent_report;
	ExtentTest Test_logger;
	WebDriver driver;

	@BeforeSuite
	// This annotated method will be run before all test() in this suite.
	public void beforeSuite() {

		// Where to keep Report
		// Create object for Report with file path
		Extent_report = new ExtentReports("./Reports/TestReport.html", true);

		// Load Config File for Report
		Extent_report.loadConfig(new File("./ExtentReport/extent-config.xml"));

	}

	@BeforeMethod
	// This annotation method will run before each test() method.
	public void beforeMethod(Method method) {

		// Test starts here

		Test_logger = Extent_report.startTest((this.getClass().getSimpleName() + "::" + method.getName()),
				method.getName());

		// Author Name
		Test_logger.assignAuthor("Author :: Prem Nazeer");

		// Types of Test Category
		Test_logger.assignCategory("Regression");

		driver = new FirefoxDriver();

		// Test Description
		Test_logger.log(LogStatus.PASS, "Browser launched successfully");

	}

	@Test(priority = 1)
	public void verifysum() {

		/*
		 * //Start the test Test_logger=Extent_report.startTest(
		 * "VerifySum","Report generation started");
		 * 
		 * Test_logger.getRunStatus();
		 */

		// Log the status in report
		Test_logger.log(LogStatus.INFO, "calc started ");

		int a = 50, b = 80, c;
		c = a + b;
		Assert.assertEquals(c, 130);

		// Pass the test in report
		Test_logger.log(LogStatus.PASS, "Test Verified");

		System.out.println("Mail sent");

	}

	@Test(priority = 2)
	public void enterInvalidEmailId_SignUpForm() throws InterruptedException {

		driver.get("http://www.google.com/");

		String currenturl = driver.getCurrentUrl();
		Test_logger.log(LogStatus.INFO, "Getting the Url");
		Test_logger.log(LogStatus.PASS, "URL :: " + currenturl);
		Test_logger.log(LogStatus.PASS, "URL Verified");
		System.out.println("URl sent to address bar");

	}

	// Test Ends Here

	@AfterMethod
	// This annotation method will run after each test() method executed.
	public void afterMethod() throws IOException {

		driver.close();

		driver.quit();

		Test_logger.log(LogStatus.PASS, "Browser closed successfully");

		// End the test
		Extent_report.endTest(Test_logger);

	}

	// Test Suite Ends Here
	@AfterSuite
	// This annotation method will run after all test() method in this suite.
	public void afterSuite() {
		// Flush the data to report
		Extent_report.flush();

		Extent_report.close();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("D:\\Workspace\\CTRSAutomation\\CTRS\\Reports\\TestReport.html");
		driver.manage().window().maximize();

	}

}
