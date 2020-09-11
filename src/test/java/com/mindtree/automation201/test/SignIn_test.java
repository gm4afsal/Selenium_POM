package com.mindtree.automation201.test;

import java.io.FileNotFoundException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.automation201.base.LoadConfigFile;
import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;
import com.mindtree.automation201.pageobjects.LoginPage;
import com.mindtree.automation201.utilities.ExcelDataExtractor;
import com.mindtree.automation201.utilities.Screenshot;
import com.mindtree.automation201.utilities.ScreenshotExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class SignIn_test extends TestBase {

	@Test(priority = 1, dataProvider = "Login_data")
	public void signIn(String username, String password)
			throws Exception {

		try {
			extenttest = extent.startTest("Sign In");
			logger.info("Starting Sign In TestCase");
			extenttest.log(LogStatus.INFO, "Starting Sign In TestCase");
			LoginPage loginpage = new LoginPage();
			loginpage.signIn(username, password);
			Screenshot.takeShot("Sign in Successful", TestBase.driver);
			ScreenshotExtentReport.captureExtentRepScreenshotPass("Sign In TestCase Passed");
			loginpage.signOff();
			Screenshot.takeShot("Sign Off Successful", driver);
			logger.info("Sign in Testcase Passed");
			extent.endTest(extenttest);
		} catch (Error e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Sign In TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Sign In TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Sign In TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		}
	}

	@DataProvider(name = "Login_data")
	public Object[][] loginData() {
		Object[][] data = null;
		try {
			String excelpath = LoadConfigFile.loadPropertiesData("testdata_excel");
			ExcelDataExtractor exceldata = new ExcelDataExtractor(System.getProperty("user.dir") + excelpath);
			int rowcount = exceldata.getRowCount("Login");
			int colcount = exceldata.getColCount("Login");
			data = new Object[rowcount][colcount];
			for (int i = 0; i < rowcount; i++) {
				for (int j = 0; j < colcount; j++) {
					data[i][j] = exceldata.getData("Login", i + 1, j);
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

}
