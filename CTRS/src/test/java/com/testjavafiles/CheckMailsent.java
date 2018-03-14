package com.testjavafiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckMailsent {

	
		//Creating ExtentReport and ExtentTest  reference values
		ExtentReports report;
		ExtentTest logger;
		WebDriver driver;
		
		@Test
		public void verifysum(){
			
			//Create object for Report with filepath
			report=new ExtentReports("./Reports/TestReport.html");
			
			//Start the test
			logger=report.startTest("VerifySum");
		
			//Log the status in report
			logger.log(LogStatus.INFO, "calc started ");
		
			int a=50,b=80,c;
			c=a+b;
			Assert.assertEquals(c, 130);
			
			//Pass the test in report
			logger.log(LogStatus.PASS, "Test Verified");
			
			System.out.println("Mail sent");
			//End the test
			report.endTest(logger);
			
			//Flush the data to report
			report.flush();
			FirefoxDriver driver= new FirefoxDriver(); 
			driver.get("D:\\Workspace\\CTRSAutomation\\CTRS\\Reports\\Module_click_TestReport.html");
			}
	}
	

