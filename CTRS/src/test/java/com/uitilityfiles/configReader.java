package com.uitilityfiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * use the below code to get the method from the confiReader.java in the test
 * script configReader config;
 * 
 * @BeforeTest public void setUp(){ configReader config=new configReader();
 *             system.out.println("webdriver.chrome.driver",config.getChromePath());
 *             }
 * 
 * @Test public void chrome(){ Webdriver driver= new Chromedriver();
 *       driver.get(config.getURL()); driver.quit();
 *
 * 
 */

public class configReader {
	Properties data;

	/**
	 * Created confiReader method to access the data's from property File
	 * source(data driven).
	 */
	public configReader() {
		// TODO Auto-generated constructor stub

		try {
			File src = new File("./configuration/datadriven.property");
			FileInputStream fis = new FileInputStream(src);
			data = new Properties();
			data.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is ==" + e.getMessage());

		}

	}

	/**
	 * Created all commonly used methods in this java file and can be called any
	 * where by call this class and it's methods.
	 */

	public String getChromePath() {
		String path = data.getProperty("ChromeDriver");
		return path;

	}

	public String getURL() {
		return data.getProperty("URL");
	}

	public String getusername() {
		return data.getProperty("username");

	}

	public String getpassword() {
		return data.getProperty("password");

	}

	public String getpsw() {
		return data.getProperty("psw");

	}

	public String getFireox_driver() {
		return data.getProperty("browserName");

	}

	public String getChrome_driver() {
		return data.getProperty("browserName1");

	}

}
