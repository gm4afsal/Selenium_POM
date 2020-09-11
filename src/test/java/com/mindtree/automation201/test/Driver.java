package com.mindtree.automation201.test;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Driver{
	
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {Register_test.class, SignIn_test.class, OneWayTrip_test.class, TwoWayTrip_test.class});
		testng.addListener((ITestNGListener)tla);
		testng.run();
		}
	
}
