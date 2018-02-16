package com.Runner;


import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class FailTest_ReRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TestNG runner = new TestNG();
		
		
		
		List<String> list = new ArrayList<String>();
		
		list.add("D:\\Workspace\\CTRSAutomation\\CTRS\\test-output\\Regression\\testng-failed.xml");
		runner.setTestSuites(list);
		
		runner.run();
	}

}
