package com.mindtree.automation201.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.automation201.base.LoadConfigFile;
import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.exceptions.DropDownElementNotFound;
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;
import com.mindtree.automation201.pageobjects.RegistrationPage;
import com.mindtree.automation201.utilities.ExcelDataExtractor;
import com.mindtree.automation201.utilities.Screenshot;
import com.mindtree.automation201.utilities.ScreenshotExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class Register_test extends TestBase {

	@BeforeSuite()
	public void setup() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		extent.loadConfig(new File("extent-config.xml"));
		logger.info("Starting browser");
		getBrowser();
	}
	
	@Test(priority = 0, dataProvider = "Registration_data")
	public void register(String firstname, String lastname, String phone, String email, String addressline1,
			String addressline2, String city, String state, String postalcode, String country, String username,
			String password, String confpassword)
			throws Exception {

		try {
			extenttest = extent.startTest("Registration");
			logger.info("Starting Register TestCase");
			extenttest.log(LogStatus.INFO, "Starting Register TestCase");
			RegistrationPage registrationpage = new RegistrationPage();
			registrationpage.register(firstname, lastname, phone, email, addressline1, addressline2, city, state,
					postalcode, country, username, password, confpassword);
			Screenshot.takeShot("Registration Successful", driver);
			ScreenshotExtentReport.captureExtentRepScreenshotPass("Registration TestCase Passed");
			registrationpage.signInAfterRegister();
			Screenshot.takeShot("Sign In after Register", driver);
			logger.info("Registration Testcase Passed");
			extent.endTest(extenttest);
		} catch (Error e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Registration TestCase Failed");
			extent.endTest(extenttest);
		} catch (ElementLoadTimeoutException e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Registration TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		} catch (DropDownElementNotFound e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Registration TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			logger.error("Unhandled Exception: " + e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Registration TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());

		}

	}

	@DataProvider(name = "Registration_data")
	public Object[][] registrationData() {
		Object[][] data = null;
		try {
			String excelpath = LoadConfigFile.loadPropertiesData("testdata_excel");
			ExcelDataExtractor exceldata = new ExcelDataExtractor(System.getProperty("user.dir") + excelpath);
			int rowcount = exceldata.getRowCount("Registration");
			int colcount = exceldata.getColCount("Registration");
			data = new Object[rowcount][colcount];
			for (int i = 0; i < rowcount; i++) {
				for (int j = 0; j < colcount; j++) {
					data[i][j] = exceldata.getData("Registration", i + 1, j);
				}
			}

		} catch (NullPointerException e) {
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return data;
	}
	
	@AfterSuite()
	public void tearDown() throws IOException {
		logger.info("Closing browser");
		driver.quit();
		logger.info("Browser Closed");
		extent.flush();
		extent.close();
	}
	
}
