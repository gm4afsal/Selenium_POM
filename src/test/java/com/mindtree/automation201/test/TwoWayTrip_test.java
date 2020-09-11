package com.mindtree.automation201.test;

import java.io.FileNotFoundException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.automation201.base.LoadConfigFile;
import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.exceptions.DropDownElementNotFound;
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;
import com.mindtree.automation201.pageobjects.FlightConfirmation;
import com.mindtree.automation201.pageobjects.FlightFinder;
import com.mindtree.automation201.pageobjects.LoginPage;
import com.mindtree.automation201.pageobjects.PassengerAndBilling;
import com.mindtree.automation201.pageobjects.SelectFlight;
import com.mindtree.automation201.utilities.ExcelDataExtractor;
import com.mindtree.automation201.utilities.Screenshot;
import com.mindtree.automation201.utilities.ScreenshotExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class TwoWayTrip_test extends TestBase {

	@Test(priority = 3, dataProvider = "Two_Way_data")
	public void twoWayTripFlight(String username, String password, String passcount, String departfrom,
			String departmonth, String departday, String arriveto, String returnmonth, String returnday,
			String serviceclass, String airline, String departflight, String returnflight, String pass1fname,
			String pass1lname, String pass1meal, String pass2fname, String pass2lname, String pass2meal,
			String pass3fname, String pass3lname, String pass3meal, String pass4fname, String pass4lname,
			String pass4meal, String cardtype, String cardno, String expirymonth, String expiryyear, String cardfname,
			String cardmname, String cardlname, String ticketless, String billadd1, String billadd2, String billcity,
			String billstate, String billpcode, String billcountry, String sameasbill, String deladd1, String deladd2,
			String delcity, String delstate, String delpcode, String delcountry)
			throws Exception {

		try {
			extenttest = extent.startTest("Two Way Trip");
			logger.info("Starting Two Way Trip TestCase");
			extenttest.log(LogStatus.INFO, "Starting Two Way Trip TestCase");
			LoginPage loginPage = new LoginPage();
			loginPage.signIn(username, password);
			Screenshot.takeShot("Sign In Successful", driver);
			FlightFinder flightfinder = new FlightFinder();
			flightfinder.twoWayFlightFinder(passcount, departfrom, departmonth, departday, arriveto, returnmonth,
					returnday, serviceclass, airline);
			Screenshot.takeShot("Flight Finder Successful", driver);
			SelectFlight selectflight = new SelectFlight();
			selectflight.selectDepartFlight(departflight);
			selectflight.selectReturnFlight(returnflight);
			Screenshot.takeShot("Select Flight Successful", driver);
			selectflight.confirm();
			Screenshot.takeShot("Confirm", driver);
			PassengerAndBilling billing = new PassengerAndBilling();
			billing.passDetailsAndBilling(pass1fname, pass1lname, pass1meal, pass2fname, pass2lname, pass2meal,
					pass3fname, pass3lname, pass3meal, pass4fname, pass4lname, pass4meal, cardtype, cardno, expirymonth,
					expiryyear, cardfname, cardmname, cardlname, ticketless, billadd1, billadd2, billcity, billstate,
					billpcode, billcountry, sameasbill, deladd1, deladd2, delcity, delstate, delpcode, delcountry);
			FlightConfirmation confirmation = new FlightConfirmation();
			Screenshot.takeShot("Passenger and Billing Successful", driver);
			ScreenshotExtentReport.captureExtentRepScreenshotPass("Two Way Trip TestCase Passed");
			confirmation.logoutAfterConfirm();
			Screenshot.takeShot("Logout after Confirm", driver);
			logger.info("Two Way Trip TestCase Passed");
			extent.endTest(extenttest);
		} catch (Error e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Two Way Trip TestCase Failed");
			extent.endTest(extenttest);
		} catch (ElementLoadTimeoutException e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Two Way Trip TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		} catch (DropDownElementNotFound e) {
			logger.error(e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Two Way Trip TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			logger.error("Unhandled Exception: " + e.getMessage());
			extenttest.log(LogStatus.ERROR, e.getMessage());
			ScreenshotExtentReport.captureExtentRepScreenshotFail("Two Way Trip TestCase Failed");
			extent.endTest(extenttest);
			Assert.fail(e.getMessage());

		}

	}

	@DataProvider(name = "Two_Way_data")
	public Object[][] twowayData() {
		Object[][] data = null;
		try {
			String excelpath = LoadConfigFile.loadPropertiesData("testdata_excel");
			ExcelDataExtractor exceldata = new ExcelDataExtractor(System.getProperty("user.dir") + excelpath);
			int rowcount = exceldata.getRowCount("Two Way Trip");
			int colcount = exceldata.getColCount("Two Way Trip");
			data = new Object[rowcount][colcount];
			for (int i = 0; i < rowcount; i++) {
				for (int j = 0; j < colcount; j++) {
					data[i][j] = exceldata.getData("Two Way Trip", i + 1, j);
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
