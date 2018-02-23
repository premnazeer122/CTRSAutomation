package com.uitilityfiles;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


	/*
	 * private StringBuffer verificationErrors = new StringBuffer(); private
	 * static WebDriver driver;
	 * 
	 * 
	 * public static WebDriver browsersetUp() throws Exception { FirefoxDriver
	 * driver = new FirefoxDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS); return
	 * driver;
	 * 
	 * 
	 * } public void tearDown() throws Exception { driver.quit(); String
	 * verificationErrorString = verificationErrors.toString(); if
	 * (!"".equals(verificationErrorString)) { fail(verificationErrorString); }
	 * 
	 * } }
	 */

	/*
	 * private static final String browser = null; static WebDriver driver;
	 */
	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */

	/*
	 * public WebDriver browsersetUp() throws Exception {
	 * 
	 * // Check if parameter passed from TestNG is 'firefox' if
	 * (browser.equalsIgnoreCase("firefox")) { // create firefox instance
	 * System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
	 * driver = new FirefoxDriver(); } // Check if parameter passed as 'chrome'
	 * else if (browser.equalsIgnoreCase("chrome")) { // set path to
	 * chromedriver.exe System.setProperty("webdriver.chrome.driver",
	 * "D:\\Workspace\\CTRSAutomation\\chromedriver.exe"); // create Chrome
	 * instance driver = new ChromeDriver(); } // Check if parameter passed as
	 * 'Edge' else if (browser.equalsIgnoreCase("Edge")) { // set path to
	 * Edge.exe System.setProperty("webdriver.edge.driver",
	 * ".\\MicrosoftWebDriver.exe"); // create Edge instance driver = new
	 * EdgeDriver(); } else { // If no browser passed throw exception throw new
	 * Exception("Browser is not correct"); }
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); return
	 * driver; }
	 */

	public class DriverFactory  {

		static WebDriver driver;
		

		public static WebDriver DriverStart(String browserName, String url) {
			

			if (browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CTRSAutomation\\chromedriver.exe");
				driver = new ChromeDriver();
			}
				else if (browserName.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
				}
				else if (browserName.equalsIgnoreCase("ie")){
				driver = new InternetExplorerDriver();
				}
			driver.manage().window().maximize();
			driver.get(url);
			return driver;

		}

		public void close() {
			driver.close();

		}

		public WebElement findElement(By arg0) {
			return driver.findElement(arg0);
		}

		public List<WebElement> findElements(By arg0) {
			return driver.findElements(arg0);
		}

		public void get(String arg0) {
			driver.get(arg0);

		}

		public String getCurrentUrl() {
			return driver.getCurrentUrl();
		}

		public String getPageSource() {
			return driver.getPageSource();
		}

		public String getTitle() {
			return driver.getTitle();
		}

		public String getWindowHandle() {
			return driver.getWindowHandle();
		}

		public Set<String> getWindowHandles() {
			return driver.getWindowHandles();
		}

		public Options manage() {
			return driver.manage();
		}

		public Navigation navigate() {
			return driver.navigate();
		}

		public void quit() {
			driver.quit();
		}

		public TargetLocator switchTo() {
			return driver.switchTo();
		}

	}


