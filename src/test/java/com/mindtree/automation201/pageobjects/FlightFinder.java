package com.mindtree.automation201.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.Assert;
import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.customlocator.FileBasedElementLocatorFactory;
import com.mindtree.automation201.customlocator.FindBy;
import com.mindtree.automation201.exceptions.DropDownElementNotFound;
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;
import com.mindtree.automation201.utilities.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class FlightFinder {

	CommonUtils utils = new CommonUtils();
	ElementLocatorFactory factory = new FileBasedElementLocatorFactory(TestBase.driver);
	Logger logger = TestBase.logger;

	@FindBy(locator = "flightfinder.oneway")
	private WebElement oneway;

	@FindBy(locator = "flightfinder.twoway")
	private WebElement twoway;

	@FindBy(locator = "flightfinder.passengers")
	private WebElement passengers;

	@FindBy(locator = "flightfinder.departingfrom")
	private WebElement depart;

	@FindBy(locator = "flightfinder.departingmonth")
	private WebElement depart_month;

	@FindBy(locator = "flightfinder.departingday")
	private WebElement depart_day;

	@FindBy(locator = "flightfinder.arrivingto")
	private WebElement arrive_to;

	@FindBy(locator = "flightfinder.returningmonth")
	private WebElement return_month;

	@FindBy(locator = "flightfinder.returningday")
	private WebElement return_day;

	@FindBy(locator = "flightfinder.economyclass")
	private WebElement economy_class;

	@FindBy(locator = "flightfinder.businessclass")
	private WebElement business_class;

	@FindBy(locator = "flightfinder.firstclass")
	private WebElement first_class;

	@FindBy(locator = "flightfinder.airline")
	private WebElement air_line;

	@FindBy(locator = "flightfinder.continue")
	private WebElement flightcontinue;

	public FlightFinder() {
		PageFactory.initElements(factory, this);
	}

	public void oneWayFlightFinder(String passcount, String departfrom, String departmonth, String departday,
			String arriveto, String returnmonth, String returnday, String serviceclass, String airline)
			throws DropDownElementNotFound, ElementLoadTimeoutException {

		try {
			utils.waitForElement(20, oneway);
			Assert.assertTrue(oneway.isDisplayed(), "Oneway radio button is not displayed");
			logger.info("Oneway radio button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Oneway radio button is displayed");
			utils.clickElement(oneway);
			Assert.assertTrue(oneway.isSelected(), "Oneway radio button is not selected");
			logger.info("Oneway is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Oneway is selected");

			utils.waitForElement(20, passengers);
			Assert.assertTrue(passengers.isDisplayed(), "Passengers dropdown is not displayed");
			logger.info("Passengers dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Passengers dropdown is displayed");
			utils.selectFromDropDown(passengers, passcount);
			logger.info("Number of passengers selected");
			TestBase.extenttest.log(LogStatus.INFO, "Number of passengers selected");

			utils.waitForElement(20, depart);
			Assert.assertTrue(depart.isDisplayed(), "Departing city dropdown is not displayed");
			logger.info("Departing city dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Departing city dropdown is displayed");
			utils.selectFromDropDown(depart, departfrom);
			logger.info("Departing city is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Departing city is selected");

			utils.waitForElement(20, depart_month);
			Assert.assertTrue(depart_month.isDisplayed(), "Departing month dropdown is not displayed");
			logger.info("Departing month dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Departing month dropdown is displayed");
			utils.selectFromDropDown(depart_month, departmonth);
			logger.info("Departing month is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Departing month is selected");

			utils.waitForElement(20, depart_day);
			Assert.assertTrue(depart_day.isDisplayed(), "Departing day dropdown is not displayed");
			logger.info("Departing day dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Departing day dropdown is displayed");
			utils.selectFromDropDown(depart_day, departday);
			logger.info("Departing day is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Departing day is selected");

			utils.waitForElement(20, arrive_to);
			Assert.assertTrue(arrive_to.isDisplayed(), "Arriving city dropdown is not displayed");
			logger.info("Arriving city dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Arriving city dropdown is displayed");
			utils.selectFromDropDown(arrive_to, arriveto);
			logger.info("Arriving city is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Arriving city is selected");

			List<WebElement> service_class = new ArrayList<>();
			utils.waitForElement(20, economy_class);
			Assert.assertTrue(economy_class.isDisplayed(), "Economy class radio button is not displayed");
			service_class.add(economy_class);
			utils.waitForElement(20, business_class);
			Assert.assertTrue(business_class.isDisplayed(), "Business class radio button is not displayed");
			service_class.add(business_class);
			utils.waitForElement(20, first_class);
			Assert.assertTrue(first_class.isDisplayed(), "First class radio button is not displayed");
			service_class.add(first_class);
			logger.info("All service class radio buttons are present");
			TestBase.extenttest.log(LogStatus.INFO, "All service class radio buttons are present");
			utils.selectServiceClass(service_class, serviceclass);
			logger.info("Service class is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Service class is selected");

			utils.waitForElement(20, air_line);
			Assert.assertTrue(air_line.isDisplayed(), "Airline dropdown is not displayed");
			logger.info("Airline dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Airline dropdown is displayed");
			utils.selectFromDropDown(air_line, airline);
			logger.info("Airline is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Airline is selected");

			utils.waitForElement(20, flightcontinue);
			Assert.assertTrue(flightcontinue.isDisplayed(), "Continue button is not displayed");
			logger.info("Continue button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Continue button is displayed");
			Assert.assertTrue(flightcontinue.isEnabled(), "Continue button is not clickable");
			logger.info("Continue button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Continue button is clickable");
			utils.clickElement(flightcontinue);
			logger.info("Continue button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Continue button is clicked");
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (DropDownElementNotFound e) {
			throw new DropDownElementNotFound(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}

	}

	public void twoWayFlightFinder(String passcount, String departfrom, String departmonth, String departday,
			String arriveto, String returnmonth, String returnday, String serviceclass, String airline)
			throws DropDownElementNotFound, ElementLoadTimeoutException {

		try {
			utils.waitForElement(20, twoway);
			Assert.assertTrue(twoway.isDisplayed(), "Twoway radio button is not displayed");
			logger.info("Twoway radio button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Twoway radio button is displayed");
			Assert.assertTrue(twoway.isEnabled(), "Twoway radio button is not clickable");
			logger.info("Twoway radio button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Twoway radio button is clickable");
			utils.clickElement(twoway);
			Assert.assertTrue(twoway.isSelected(), "Twoway radio button is not selected");
			logger.info("Two way radio button is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Two way radio button is selected");

			utils.waitForElement(20, passengers);
			Assert.assertTrue(passengers.isDisplayed(), "Passengers dropdown is not displayed");
			logger.info("Passengers dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Passengers dropdown is displayed");
			utils.selectFromDropDown(passengers, passcount);
			logger.info("Number of passengers selected");
			TestBase.extenttest.log(LogStatus.INFO, "Number of passengers selected");

			utils.waitForElement(20, depart);
			Assert.assertTrue(depart.isDisplayed(), "Departing city dropdown is not displayed");
			logger.info("Departing city dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Departing city dropdown is displayed");
			utils.selectFromDropDown(depart, departfrom);
			logger.info("Departing city is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Departing city is clicked");

			utils.waitForElement(20, depart_month);
			Assert.assertTrue(depart_month.isDisplayed(), "Departing month dropdown is not displayed");
			logger.info("Departing month dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Departing month dropdown is displayed");
			utils.selectFromDropDown(depart_month, departmonth);
			logger.info("Departing month is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Departing month is selected");

			utils.waitForElement(20, depart_day);
			Assert.assertTrue(depart_day.isDisplayed(), "Departing day dropdown is not displayed");
			logger.info("Departing day dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Departing day dropdown is displayed");
			utils.selectFromDropDown(depart_day, departday);
			logger.info("Departing day is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Departing day is selected");

			utils.waitForElement(20, arrive_to);
			Assert.assertTrue(arrive_to.isDisplayed(), "Arriving city dropdown is not displayed");
			logger.info("Arriving city dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Arriving city dropdown is displayed");
			utils.selectFromDropDown(arrive_to, arriveto);
			logger.info("Arriving city is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Arriving city is selected");

			utils.waitForElement(20, return_month);
			Assert.assertTrue(return_month.isDisplayed(), "Returning month dropdown is not displayed");
			logger.info("Returning month dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Returning month dropdown is displayed");
			utils.selectFromDropDown(return_month, returnmonth);
			logger.info("Returning month is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Returning month is selected");

			utils.waitForElement(20, return_day);
			Assert.assertTrue(return_day.isDisplayed(), "Returning day dropdown is not displayed");
			logger.info("Returning day dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Returning day dropdown is displayed");
			utils.selectFromDropDown(return_day, returnday);
			logger.info("Returning day is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Returning day is selected");

			List<WebElement> service_class = new ArrayList<>();
			utils.waitForElement(20, economy_class);
			Assert.assertTrue(economy_class.isDisplayed(), "Economy class radio button is not displayed");
			service_class.add(economy_class);
			utils.waitForElement(20, business_class);
			Assert.assertTrue(business_class.isDisplayed(), "Business class radio button is not displayed");
			service_class.add(business_class);
			utils.waitForElement(20, first_class);
			Assert.assertTrue(first_class.isDisplayed(), "First class radio button is not displayed");
			service_class.add(first_class);
			logger.info("All service class radio buttons are present");
			TestBase.extenttest.log(LogStatus.INFO, "All service class radio buttons are present");
			utils.selectServiceClass(service_class, serviceclass);
			logger.info("Service class is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Service class is selected");

			utils.waitForElement(20, air_line);
			Assert.assertTrue(air_line.isDisplayed(), "Airline dropdown is not displayed");
			logger.info("Airline dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Airline dropdown is displayed");
			utils.selectFromDropDown(air_line, airline);
			logger.info("Airline is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Airline is selected");

			utils.waitForElement(20, flightcontinue);
			Assert.assertTrue(flightcontinue.isDisplayed(), "Continue button is not displayed");
			logger.info("Continue button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Continue button is displayed");
			Assert.assertTrue(flightcontinue.isEnabled(), "Continue button is not clickable");
			logger.info("Continue button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Continue button is clickable");
			utils.clickElement(flightcontinue);
			logger.info("Continue button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Continue button is clicked");
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (DropDownElementNotFound e) {
			throw new DropDownElementNotFound(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}
}
