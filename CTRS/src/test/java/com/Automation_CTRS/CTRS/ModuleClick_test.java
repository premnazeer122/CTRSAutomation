package com.Automation_CTRS.CTRS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.uitilityfiles.CommonMethods;
import com.uitilityfiles.Common_Ctrslogin;

public class ModuleClick_test {

	// Creating ExtentReport and ExtentTest reference values
	ExtentReports Extent_report;
	ExtentTest Test_logger;

	public WebDriver driver;
	CommonMethods call_method = new CommonMethods();
	Common_Ctrslogin login = new Common_Ctrslogin();

	@BeforeTest
	public void setup() throws Exception {
		System.out.println("Chrome browser started");
		driver = login.Ctrslogin();
		System.out.println("Logged in");
		// Create object for Report with filepath
				Extent_report = new ExtentReports("./Reports/CheckModules_clickfunctionality.html");

				// start the test report
				Test_logger = Extent_report.startTest("ClickFunctionality_MainModules");


	}

	@Test()
	public void CTRSModules() throws InterruptedException {

		System.out.println("Modules Click Test");
		System.out.println("Waiting time started");
		Test_logger.log(LogStatus.INFO, "Click on Booking menu");
		Thread.sleep(20000L);
		System.out.println("After Wait click on booking menu");
		driver.findElement(By.xpath("(//a[contains(text(),'Book Services')])[2]")).click();
		Thread.sleep(3000L);
		driver.switchTo().alert().accept();
		Test_logger.log(LogStatus.PASS, "Booking menu is Clicked");

		Thread.sleep(3000L);
		Test_logger.log(LogStatus.INFO, "Click on Master menu");
		System.out.println("After Wait time click on Master menu");
		new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Master Forms')])[2]")));
		System.out.println("Wait time stopped");
		driver.findElement(By.xpath("(//a[contains(text(),'Master Forms')])[2]")).click();
		Test_logger.log(LogStatus.PASS, "Master Menu is clicked");

		Thread.sleep(30000L);
		Test_logger.log(LogStatus.INFO, "Click on Report menu");
		System.out.println("After Wait time click on report menu");

		driver.findElement(By.xpath("(//a[contains(text(),'Reports')])[2]")).click();
		Test_logger.log(LogStatus.PASS, "Clicked on Report menu");

		Thread.sleep(20000L);
		Test_logger.log(LogStatus.INFO, "Click on Permission menu");
		System.out.println("After Wait time click on premission menu");
		driver.findElement(By.xpath("(//a[contains(text(),'User Permission')])[2]")).click();
		Test_logger.log(LogStatus.PASS, "Clicked on Permission menu");

		Thread.sleep(20000L);
		Test_logger.log(LogStatus.INFO, "Click on Dashboard menu");
		driver.findElement(By.xpath("(//a[contains(text(),'Dashboard')])[2]")).click();
		Test_logger.log(LogStatus.PASS, "Clicked on Dashboard menu");
		Thread.sleep(30000L);
		
		// End and Flush the data to report
				Extent_report.endTest(Test_logger);
				Extent_report.flush();
		Thread.sleep(2000L);
		System.out.println("Open the test report");
		driver.get("D:\\Workspace\\CTRSAutomation\\CTRS\\Reports\\CheckModules_clickfunctionality.html");
		System.out.println("Test report in opened");
	}

	@AfterTest
	public void closebrowser() throws Exception {
		
		Thread.sleep(30000L);
		driver.close();
	}

}
