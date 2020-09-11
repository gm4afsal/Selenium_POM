package com.mindtree.automation201.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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

public class PassengerAndBilling {

	CommonUtils utils = new CommonUtils();
	ElementLocatorFactory factory = new FileBasedElementLocatorFactory(TestBase.driver);
	Logger logger = TestBase.logger;

	@FindBy(locator = "pass&bill.passcount")
	private WebElement pass_count;

	@FindBy(locator = "pass&bill.pass1firstname")
	private WebElement pass1_fname;

	@FindBy(locator = "pass&bill.pass1lastname")
	private WebElement pass1_lname;

	@FindBy(locator = "pass&bill.pass1meal")
	private WebElement pass1_meal;

	@FindBy(locator = "pass&bill.pass2firstname")
	private WebElement pass2_fname;

	@FindBy(locator = "pass&bill.pass2lastname")
	private WebElement pass2_lname;

	@FindBy(locator = "pass&bill.pass2meal")
	private WebElement pass2_meal;

	@FindBy(locator = "pass&bill.pass3firstname")
	private WebElement pass3_fname;

	@FindBy(locator = "pass&bill.pass3lastname")
	private WebElement pass3_lname;

	@FindBy(locator = "pass&bill.pass3meal")
	private WebElement pass3_meal;

	@FindBy(locator = "pass&bill.pass4firstname")
	private WebElement pass4_fname;

	@FindBy(locator = "pass&bill.pass4lastname")
	private WebElement pass4_lname;

	@FindBy(locator = "pass&bill.pass4meal")
	private WebElement pass4_meal;

	@FindBy(locator = "pass&bill.creditcardtype")
	private WebElement credit_cardtype;

	@FindBy(locator = "pass&bill.creditcardno")
	private WebElement credit_cardno;

	@FindBy(locator = "pass&bill.expirymonth")
	private WebElement expiry_month;

	@FindBy(locator = "pass&bill.expiryyear")
	private WebElement expiry_year;

	@FindBy(locator = "pass&bill.cardfirstname")
	private WebElement card_fname;

	@FindBy(locator = "pass&bill.cardmiddlename")
	private WebElement card_mname;

	@FindBy(locator = "pass&bill.cardlastname")
	private WebElement card_lname;

	@FindBy(locator = "pass&bill.ticketlesstravel")
	private WebElement ticketless_travel;

	@FindBy(locator = "pass&bill.billaddressline1")
	private WebElement billaddress_line1;

	@FindBy(locator = "pass&bill.billaddressline2")
	private WebElement billaddress_line2;

	@FindBy(locator = "pass&bill.billcity")
	private WebElement bill_city;

	@FindBy(locator = "pass&bill.billstate")
	private WebElement bill_state;

	@FindBy(locator = "pass&bill.billpostalcode")
	private WebElement billpostal_code;

	@FindBy(locator = "pass&bill.billcountry")
	private WebElement bill_country;

	@FindBy(locator = "pass&bill.sameasbilling")
	private WebElement sameas_billing;

	@FindBy(locator = "pass&bill.deladdressline1")
	private WebElement deladdress_line1;

	@FindBy(locator = "pass&bill.deladdressline2")
	private WebElement deladdress_line2;

	@FindBy(locator = "pass&bill.delcity")
	private WebElement del_city;

	@FindBy(locator = "pass&bill.delstate")
	private WebElement del_state;

	@FindBy(locator = "pass&bill.delpostalcode")
	private WebElement delpostal_code;

	@FindBy(locator = "pass&bill.delcountry")
	private WebElement del_country;

	@FindBy(locator = "pass&bill.securepurchase")
	private WebElement secure_purchase;

	public PassengerAndBilling() {
		PageFactory.initElements(factory, this);
	}

	public void passDetailsAndBilling(String pass1fname, String pass1lname, String pass1meal, String pass2fname,
			String pass2lname, String pass2meal, String pass3fname, String pass3lname, String pass3meal,
			String pass4fname, String pass4lname, String pass4meal, String cardtype, String cardno, String expirymonth,
			String expiryyear, String cardfname, String cardmname, String cardlname, String ticketless, String billadd1,
			String billadd2, String billcity, String billstate, String billpcode, String billcountry, String sameasbill,
			String deladd1, String deladd2, String delcity, String delstate, String delpcode, String delcountry)
			throws DropDownElementNotFound, ElementLoadTimeoutException {
		try {
			utils.waitForElement(20, pass_count);
			Assert.assertTrue(pass_count.isDisplayed(), "Number of passengers is not displayed");
			int passengers = Integer.parseInt(pass_count.getText());
			logger.info("Total number of passengers: " + passengers);
			TestBase.extenttest.log(LogStatus.INFO, "Total number of passengers: " + passengers);
			if (passengers == 1) {
				utils.waitForElement(20, pass1_fname);
				Assert.assertTrue(pass1_fname.isDisplayed(), "Passenger 1 firstname field is not displayed");
				logger.info("Passenger 1 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname field is displayed");
				pass1_fname.clear();
				utils.enterValue(pass1_fname, pass1fname);
				logger.info("Passenger 1 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname is entered");

				utils.waitForElement(20, pass1_lname);
				Assert.assertTrue(pass1_lname.isDisplayed(), "Passenger 1 lastname field is not displayed");
				logger.info("Passenger 1 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname field is displayed");
				pass1_lname.clear();
				utils.enterValue(pass1_lname, pass1lname);
				logger.info("Passenger 1 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname is entered");

				utils.waitForElement(20, pass1_meal);
				Assert.assertTrue(pass1_meal.isDisplayed(), "Passenger 1 meal dropdown is not displayed");
				logger.info("Passenger 1 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal dropdown is displayed");
				utils.selectFromDropDown(pass1_meal, pass1meal);
				logger.info("Passenger 1 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal is selected");
			}

			else if (passengers == 2) {
				utils.waitForElement(20, pass1_fname);
				Assert.assertTrue(pass1_fname.isDisplayed(), "Passenger 1 firstname field is not displayed");
				logger.info("Passenger 1 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname field is displayed");
				pass1_fname.clear();
				utils.enterValue(pass1_fname, pass1fname);
				logger.info("Passenger 1 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname is entered");

				utils.waitForElement(20, pass1_lname);
				Assert.assertTrue(pass1_lname.isDisplayed(), "Passenger 1 lastname field is not displayed");
				logger.info("Passenger 1 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname field is displayed");
				pass1_lname.clear();
				utils.enterValue(pass1_lname, pass1lname);
				logger.info("Passenger 1 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname is entered");

				utils.waitForElement(20, pass1_meal);
				Assert.assertTrue(pass1_meal.isDisplayed(), "Passenger 1 meal dropdown is not displayed");
				logger.info("Passenger 1 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal dropdown is displayed");
				utils.selectFromDropDown(pass1_meal, pass1meal);
				logger.info("Passenger 1 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal is selected");

				utils.waitForElement(20, pass2_fname);
				Assert.assertTrue(pass2_fname.isDisplayed(), "Passenger 2 firstname field is not displayed");
				logger.info("Passenger 2 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 firstname field is displayed");
				pass2_fname.clear();
				utils.enterValue(pass2_fname, pass2fname);
				logger.info("Passenger 2 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 firstname is entered");

				utils.waitForElement(20, pass2_lname);
				Assert.assertTrue(pass2_lname.isDisplayed(), "Passenger 2 lastname field is not displayed");
				logger.info("Passenger 2 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 lastname field is displayed");
				pass2_lname.clear();
				utils.enterValue(pass2_lname, pass2lname);
				logger.info("Passenger 2 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 lastname is entered");

				utils.waitForElement(20, pass2_meal);
				Assert.assertTrue(pass2_meal.isDisplayed(), "Passenger 2 meal dropdown is not displayed");
				logger.info("Passenger 2 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 meal dropdown is displayed");
				utils.selectFromDropDown(pass2_meal, pass2meal);
				logger.info("Passenger 2 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 meal is selected");
			}

			else if (passengers == 3) {
				utils.waitForElement(20, pass1_fname);
				Assert.assertTrue(pass1_fname.isDisplayed(), "Passenger 1 firstname field is not displayed");
				logger.info("Passenger 1 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname field is displayed");
				pass1_fname.clear();
				utils.enterValue(pass1_fname, pass1fname);
				logger.info("Passenger 1 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname is entered");

				utils.waitForElement(20, pass1_lname);
				Assert.assertTrue(pass1_lname.isDisplayed(), "Passenger 1 lastname field is not displayed");
				logger.info("Passenger 1 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname field is displayed");
				pass1_lname.clear();
				utils.enterValue(pass1_lname, pass1lname);
				logger.info("Passenger 1 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname is entered");

				utils.waitForElement(20, pass1_meal);
				Assert.assertTrue(pass1_meal.isDisplayed(), "Passenger 1 meal dropdown is not displayed");
				logger.info("Passenger 1 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal dropdown is displayed");
				utils.selectFromDropDown(pass1_meal, pass1meal);
				logger.info("Passenger 1 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal is selected");

				utils.waitForElement(20, pass2_fname);
				Assert.assertTrue(pass2_fname.isDisplayed(), "Passenger 2 firstname field is not displayed");
				logger.info("Passenger 2 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 firstname field is displayed");
				pass2_fname.clear();
				utils.enterValue(pass2_fname, pass2fname);
				logger.info("Passenger 2 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 firstname is entered");

				utils.waitForElement(20, pass2_lname);
				Assert.assertTrue(pass2_lname.isDisplayed(), "Passenger 2 lastname field is not displayed");
				logger.info("Passenger 2 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 lastname field is displayed");
				pass2_lname.clear();
				utils.enterValue(pass2_lname, pass2lname);
				logger.info("Passenger 2 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 lastname is entered");

				utils.waitForElement(20, pass2_meal);
				Assert.assertTrue(pass2_meal.isDisplayed(), "Passenger 2 meal dropdown is not displayed");
				logger.info("Passenger 2 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 meal dropdown is displayed");
				utils.selectFromDropDown(pass2_meal, pass2meal);
				logger.info("Passenger 2 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 meal is selected");

				utils.waitForElement(20, pass3_fname);
				Assert.assertTrue(pass3_fname.isDisplayed(), "Passenger 3 firstname field is not displayed");
				logger.info("Passenger 3 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 firstname field is displayed");
				pass3_fname.clear();
				utils.enterValue(pass3_fname, pass3fname);
				logger.info("Passenger 3 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 firstname is entered");

				utils.waitForElement(20, pass3_lname);
				Assert.assertTrue(pass3_lname.isDisplayed(), "Passenger 3 lastname field is not displayed");
				logger.info("Passenger 3 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 lastname field is displayed");
				pass3_lname.clear();
				utils.enterValue(pass3_lname, pass3lname);
				logger.info("Passenger 3 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 lastname is entered");

				utils.waitForElement(20, pass3_meal);
				Assert.assertTrue(pass3_meal.isDisplayed(), "Passenger 3 meal dropdown is not displayed");
				logger.info("Passenger 3 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 meal dropdown is displayed");
				utils.selectFromDropDown(pass3_meal, pass3meal);
				logger.info("Passenger 3 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 meal is selected");
			}

			else if (passengers == 4) {
				utils.waitForElement(20, pass1_fname);
				Assert.assertTrue(pass1_fname.isDisplayed(), "Passenger 1 firstname field is not displayed");
				logger.info("Passenger 1 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname field is displayed");
				pass1_fname.clear();
				utils.enterValue(pass1_fname, pass1fname);
				logger.info("Passenger 1 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 firstname is entered");

				utils.waitForElement(20, pass1_lname);
				Assert.assertTrue(pass1_lname.isDisplayed(), "Passenger 1 lastname field is not displayed");
				logger.info("Passenger 1 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname field is displayed");
				pass1_lname.clear();
				utils.enterValue(pass1_lname, pass1lname);
				logger.info("Passenger 1 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 lastname is entered");

				utils.waitForElement(20, pass1_meal);
				Assert.assertTrue(pass1_meal.isDisplayed(), "Passenger 1 meal dropdown is not displayed");
				logger.info("Passenger 1 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal dropdown is displayed");
				utils.selectFromDropDown(pass1_meal, pass1meal);
				logger.info("Passenger 1 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 1 meal is selected");

				utils.waitForElement(20, pass2_fname);
				Assert.assertTrue(pass2_fname.isDisplayed(), "Passenger 2 firstname field is not displayed");
				logger.info("Passenger 2 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 firstname field is displayed");
				pass2_fname.clear();
				utils.enterValue(pass2_fname, pass2fname);
				logger.info("Passenger 2 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 firstname is entered");

				utils.waitForElement(20, pass2_lname);
				Assert.assertTrue(pass2_lname.isDisplayed(), "Passenger 2 lastname field is not displayed");
				logger.info("Passenger 2 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 lastname field is displayed");
				pass2_lname.clear();
				utils.enterValue(pass2_lname, pass2lname);
				logger.info("Passenger 2 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 lastname is entered");

				utils.waitForElement(20, pass2_meal);
				Assert.assertTrue(pass2_meal.isDisplayed(), "Passenger 2 meal dropdown is not displayed");
				logger.info("Passenger 2 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 meal dropdown is displayed");
				utils.selectFromDropDown(pass2_meal, pass2meal);
				logger.info("Passenger 2 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 2 meal is selected");

				utils.waitForElement(20, pass3_fname);
				Assert.assertTrue(pass3_fname.isDisplayed(), "Passenger 3 firstname field is not displayed");
				logger.info("Passenger 3 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 firstname field is displayed");
				pass3_fname.clear();
				utils.enterValue(pass3_fname, pass3fname);
				logger.info("Passenger 3 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 firstname is entered");

				utils.waitForElement(20, pass3_lname);
				Assert.assertTrue(pass3_lname.isDisplayed(), "Passenger 3 lastname field is not displayed");
				logger.info("Passenger 3 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 lastname field is displayed");
				pass3_lname.clear();
				utils.enterValue(pass3_lname, pass3lname);
				logger.info("Passenger 3 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 lastname is entered");

				utils.waitForElement(20, pass3_meal);
				Assert.assertTrue(pass3_meal.isDisplayed(), "Passenger 3 meal dropdown is not displayed");
				logger.info("Passenger 3 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 meal dropdown is displayed");
				utils.selectFromDropDown(pass3_meal, pass3meal);
				logger.info("Passenger 3 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 3 meal is selected");

				utils.waitForElement(20, pass4_fname);
				Assert.assertTrue(pass4_fname.isDisplayed(), "Passenger 4 firstname field is not displayed");
				logger.info("Passenger 4 firstname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 4 firstname field is displayed");
				pass4_fname.clear();
				utils.enterValue(pass4_fname, pass4fname);
				logger.info("Passenger 4 firstname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 4 firstname is entered");

				utils.waitForElement(20, pass4_lname);
				Assert.assertTrue(pass4_lname.isDisplayed(), "Passenger 4 lastname field is not displayed");
				logger.info("Passenger 4 lastname field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 4 lastname field is displayed");
				pass4_lname.clear();
				utils.enterValue(pass4_lname, pass4lname);
				logger.info("Passenger 4 lastname is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 4 lastname is entered");

				utils.waitForElement(20, pass4_meal);
				Assert.assertTrue(pass4_meal.isDisplayed(), "Passenger 4 meal dropdown is not displayed");
				logger.info("Passenger 4 meal dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 4 meal dropdown is displayed");
				utils.selectFromDropDown(pass4_meal, pass4meal);
				logger.info("Passenger 4 meal is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Passenger 4 meal is selected");

			}

			utils.waitForElement(20, credit_cardtype);
			Assert.assertTrue(credit_cardtype.isDisplayed(), "Credit card type dropdown is not displayed");
			logger.info("Credit card type dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card type dropdown is displayed");
			utils.selectFromDropDown(credit_cardtype, cardtype);
			logger.info("Credit card type is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card type is selected");

			utils.waitForElement(20, credit_cardno);
			Assert.assertTrue(credit_cardno.isDisplayed(), "Credit card number field is not displayed");
			logger.info("Credit card number field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card number field is displayed");
			credit_cardno.clear();
			utils.enterValue(credit_cardno, cardno);
			logger.info("Credit card number is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card number is entered");

			utils.waitForElement(20, expiry_month);
			Assert.assertTrue(expiry_month.isDisplayed(), "Expiry month dropdown is not displayed");
			logger.info("Expiry month dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Expiry month dropdown is displayed");
			utils.selectFromDropDown(expiry_month, expirymonth);
			logger.info("Expiry month is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Expiry month is selected");

			utils.waitForElement(20, expiry_year);
			Assert.assertTrue(expiry_year.isDisplayed(), "Expiry year dropdown is not displayed");
			logger.info("Expiry year dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Expiry year dropdown is displayed");
			utils.selectFromDropDown(expiry_year, expiryyear);
			logger.info("Expiry year is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Expiry year is selected");

			utils.waitForElement(20, card_fname);
			Assert.assertTrue(card_fname.isDisplayed(), "Credit card firstname field is not displayed");
			logger.info("Credit card firstname field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card firstname field is displayed");
			card_fname.clear();
			utils.enterValue(card_fname, cardfname);
			logger.info("Credit card firstname is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card firstname is entered");

			utils.waitForElement(20, card_mname);
			Assert.assertTrue(card_mname.isDisplayed(), "Credit card middle name is not displayed");
			logger.info("Credit card middle name field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card middle name field is displayed");
			card_mname.clear();
			utils.enterValue(card_mname, cardmname);
			logger.info("Credit card middle name is enetered");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card middle name is enetered");

			utils.waitForElement(20, card_lname);
			Assert.assertTrue(card_lname.isDisplayed(), "Credit card lastname field is not displayed");
			logger.info("Credit card lastname field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Credit card lastname field is displayed");
			card_lname.clear();
			utils.enterValue(card_lname, cardlname);
			logger.info("Credit Card lastname is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Credit Card lastname is entered");

			utils.waitForElement(20, ticketless_travel);
			Assert.assertTrue(ticketless_travel.isDisplayed(), "Ticketless travel checkbox is not displayed");
			logger.info("Ticketless travel checkbox is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Ticketless travel checkbox is displayed");
			String ticketlesschkbox = ticketless;
			if (ticketlesschkbox.equalsIgnoreCase("yes")) {
				utils.clickElement(ticketless_travel);
				Assert.assertTrue(ticketless_travel.isSelected(), "Not able to select Ticketless Travel");
				logger.info("Ticketless Travel is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Ticketless Travel is selected");
			} else {
				logger.info("Not opted for Ticketless travel");
				TestBase.extenttest.log(LogStatus.INFO, "Not opted for Ticketless travel");
			}

			utils.waitForElement(20, billaddress_line1);
			Assert.assertTrue(billaddress_line1.isDisplayed(), "Billing address line 1 field is not displayed");
			logger.info("Billing address line 1 field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Billing address line 1 field is displayed");
			billaddress_line1.clear();
			utils.enterValue(billaddress_line1, billadd1);
			logger.info("Billing address line 1 is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Billing address line 1 is entered");

			utils.waitForElement(20, billaddress_line2);
			Assert.assertTrue(billaddress_line2.isDisplayed(), "Billing address line 2 field is not displayed");
			logger.info("Billing address line 2 field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Billing address line 2 field is displayed");
			billaddress_line2.clear();
			utils.enterValue(billaddress_line2, billadd2);
			logger.info("Billing address line 2 is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Billing address line 2 is entered");

			utils.waitForElement(20, bill_city);
			Assert.assertTrue(bill_city.isDisplayed(), "Billing city field is not displayed");
			logger.info("Billing city field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Billing city field is displayed");
			bill_city.clear();
			utils.enterValue(bill_city, billcity);
			logger.info("Billing city is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Billing city is entered");

			utils.waitForElement(20, bill_state);
			Assert.assertTrue(bill_state.isDisplayed(), "Billing state field is not displayed");
			logger.info("Billing state field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Billing state field is displayed");
			bill_state.clear();
			utils.enterValue(bill_state, billstate);
			logger.info("Billing state is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Billing state is entered");

			utils.waitForElement(20, billpostal_code);
			Assert.assertTrue(billpostal_code.isDisplayed(), "Billing postal code field is not displayed");
			logger.info("Billing postal code is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Billing postal code is displayed");
			billpostal_code.clear();
			utils.enterValue(billpostal_code, billpcode);
			logger.info("Billing postal code is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Billing postal code is entered");

			utils.waitForElement(20, bill_country);
			Assert.assertTrue(bill_country.isDisplayed(), "Billing country dropdown is not displayed");
			logger.info("Billing country dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Billing country dropdown is displayed");
			utils.selectFromDropDown(bill_country, billcountry.toUpperCase());
			logger.info("Billing country is selected");
			TestBase.extenttest.log(LogStatus.INFO, "Billing country is selected");

			utils.waitForElement(20, sameas_billing);
			Assert.assertTrue(sameas_billing.isDisplayed(), "Same as billing address checkbox is not displayed");
			logger.info("Same as billing address checkbox is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Same as billing address checkbox is displayed");
			String sameasbillingchkbox = sameasbill;
			if (sameasbillingchkbox.equalsIgnoreCase("yes")) {
				utils.clickElement(sameas_billing);
				Assert.assertTrue(sameas_billing.isSelected(), "Not able to select Same as billing address checkbox");
				logger.info("Same as billing address checkbox selected");
				TestBase.extenttest.log(LogStatus.INFO, "Same as billing address checkbox selected");

				utils.waitForElement(20, deladdress_line1);
				Assert.assertTrue(deladdress_line1.isDisplayed(), "Delivery address line 1 field is not displayed");
				logger.info("Delivery address line 1 field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 1 field is displayed");
				deladdress_line1.clear();
				utils.enterValue(deladdress_line1, billadd1);
				logger.info("Delivery address line 1 entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 1 entered");

				utils.waitForElement(20, deladdress_line2);
				Assert.assertTrue(deladdress_line2.isDisplayed(), "Delivery address line 2 field is not displayed");
				logger.info("Delivery address line 2 field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 2 field is displayed");
				deladdress_line2.clear();
				utils.enterValue(deladdress_line2, billadd2);
				logger.info("Delivery address line 2 entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 2 entered");

				utils.waitForElement(20, del_city);
				Assert.assertTrue(del_city.isDisplayed(), "Delivery city field is not displayed");
				logger.info("Delivery city field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery city field is displayed");
				del_city.clear();
				utils.enterValue(del_city, billcity);
				logger.info("Delivery city is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery city is entered");

				utils.waitForElement(20, del_state);
				Assert.assertTrue(del_state.isDisplayed(), "Delivery state field is not displayed");
				logger.info("Delivery state  field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery state  field is displayed");
				del_state.clear();
				utils.enterValue(del_state, billstate);
				logger.info("Delivery state is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery state is entered");

				utils.waitForElement(20, delpostal_code);
				Assert.assertTrue(delpostal_code.isDisplayed(), "Delivery postal code field is not displayed");
				logger.info("Delivey postal code field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivey postal code field is displayed");
				delpostal_code.clear();
				utils.enterValue(delpostal_code, billpcode);
				logger.info("Delivery postal code is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery postal code is entered");

				utils.waitForElement(20, del_country);
				Assert.assertTrue(del_country.isDisplayed(), "Delivery country dropdown is not displayed");
				logger.info("Delivery country dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery country dropdown is displayed");
				utils.selectFromDropDown(del_country, billcountry.toUpperCase());
				logger.info("Delivery country is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery country is selected");
			} else {
				logger.info("Not opted for same as billing address");
				TestBase.extenttest.log(LogStatus.INFO, "Not opted for same as billing address");

				utils.waitForElement(20, deladdress_line1);
				Assert.assertTrue(deladdress_line1.isDisplayed(), "Delivery address line 1 field is not displayed");
				logger.info("Delivery address line 1 field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 1 field is displayed");
				deladdress_line1.clear();
				utils.enterValue(deladdress_line1, deladd1);
				logger.info("Delivery address line 1 entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 1 entered");

				utils.waitForElement(20, deladdress_line2);
				Assert.assertTrue(deladdress_line2.isDisplayed(), "Delivery address line 2 field is not displayed");
				logger.info("Delivery address line 2 field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 2 field is displayed");
				deladdress_line2.clear();
				utils.enterValue(deladdress_line2, deladd2);
				logger.info("Delivery address line 2 entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery address line 2 entered");

				utils.waitForElement(20, del_city);
				Assert.assertTrue(del_city.isDisplayed(), "Delivery city field is not displayed");
				logger.info("Delivery city field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery city field is displayed");
				del_city.clear();
				utils.enterValue(del_city, delcity);
				logger.info("Delivery city is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery city is entered");

				utils.waitForElement(20, del_state);
				Assert.assertTrue(del_state.isDisplayed(), "Delivery state field is not displayed");
				logger.info("Delivery state  field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery state  field is displayed");
				del_state.clear();
				utils.enterValue(del_state, delstate);
				logger.info("Delivery state is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery state is entered");

				utils.waitForElement(20, delpostal_code);
				Assert.assertTrue(delpostal_code.isDisplayed(), "Delivery postal code field is not displayed");
				logger.info("Delivey postal code field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivey postal code field is displayed");
				delpostal_code.clear();
				utils.enterValue(delpostal_code, delpcode);
				logger.info("Delivery postal code is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery postal code is entered");

				utils.waitForElement(20, del_country);
				Assert.assertTrue(del_country.isDisplayed(), "Delivery country dropdown is not displayed");
				logger.info("Delivery country dropdown is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery country dropdown is displayed");
				utils.selectFromDropDown(del_country, delcountry.toUpperCase());
				logger.info("Delivery country is selected");
				TestBase.extenttest.log(LogStatus.INFO, "Delivery country is selected");
			}
			if (utils.isAlertPresent()) {
				logger.info("Alert is present");
				TestBase.extenttest.log(LogStatus.INFO, "Alert is present");
				Alert alert = TestBase.driver.switchTo().alert();
				String alertmessage = alert.getText();
				logger.info("Alert message: " + alertmessage);
				TestBase.extenttest.log(LogStatus.INFO, "Alert message: " + alertmessage);
				alert.accept();
			}

			utils.waitForElement(20, secure_purchase);
			Assert.assertTrue(secure_purchase.isDisplayed(), "Secure purchase button is not displayed");
			logger.info("Secure purchase button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Secure purchase button is displayed");
			Assert.assertTrue(secure_purchase.isEnabled(), "Secure purchase button is not clickable");
			logger.info("Secure purchase button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Secure purchase button is clickable");
			utils.clickElement(secure_purchase);
			logger.info("Secure purchase button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Secure purchase button is clicked");

		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		} catch (DropDownElementNotFound e) {
			throw new DropDownElementNotFound(e.getMessage());
		}
	}

}
