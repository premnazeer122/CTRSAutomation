package com.Asserting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uitilityfiles.Browser;
import com.uitilityfiles.CommonMethods;

public class LoginElementAssertion {

	
	
	
	WebDriver driver;
	CommonMethods method=new CommonMethods(); 
	
	//element with value and object
	By username = By.id("username");
	By password = By.id("password");
	By Signin =By.xpath("//label[@class='checkbox']/following::button[1]");
	
	
	@BeforeTest
	public void Browserstartup(){
		driver=Browser.DriverStart(method.getFireox_driver(), method.getURL());
	}
	
	@Test
	  public void testAssertingtextinLoginPage() throws Exception {
		Thread.sleep(4000);
		System.out.println("Title: "+driver.getTitle());
	    try {
			Assert.assertEquals(driver.getTitle(), "Login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println((e.getMessage()));
		}
	    System.out.println(username);
	    try {
			Assert.assertTrue(isElementPresent((username)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
	    
	    System.out.println(password);
	    try {
			Assert.assertTrue(isElementPresent(password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
System.out.println(e.getMessage());
		}
	    
	    System.out.println(driver.findElement(By.cssSelector("label.checkbox")));
	    try {
			Assert.assertEquals(driver.findElement(By.cssSelector("label.checkbox")).getText(), "Remember me");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	    Assert.assertTrue(driver.findElement(By.linkText("Forgot your password?")).getText().matches("Forgot your password?"));
	    Assert.assertTrue(driver.findElement(By.linkText("New Sign up?")).getText().matches("New Sign up?"));
	    Assert.assertEquals(driver.findElement(By.xpath("//button[@type='button']")).getText(), "Sign in");
	    Assert.assertTrue(isElementPresent(By.cssSelector("img")));
	    Thread.sleep(5000);
	    driver.close(); 
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
