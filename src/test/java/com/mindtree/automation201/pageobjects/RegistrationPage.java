package com.mindtree.automation201.pageobjects;

import java.io.IOException;

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

public class RegistrationPage {

	CommonUtils utils = new CommonUtils();
	ElementLocatorFactory factory = new FileBasedElementLocatorFactory(TestBase.driver);
	Logger logger = TestBase.logger;

	@FindBy(locator = "register.link")
	private WebElement registerlink;

	@FindBy(locator = "register.firstname")
	private WebElement registerfirstname;

	@FindBy(locator = "register.lastname")
	private WebElement registerlastname;

	@FindBy(locator = "register.phone")
	private WebElement registerphone;

	@FindBy(locator = "register.email")
	private WebElement registeremail;

	@FindBy(locator = "register.addressline1")
	private WebElement registeraddressline1;

	@FindBy(locator = "register.addressline2")
	private WebElement registeraddressline2;

	@FindBy(locator = "register.city")
	private WebElement registercity;

	@FindBy(locator = "register.state")
	private WebElement registerstate;

	@FindBy(locator = "register.postalcode")
	private WebElement registerpostalcode;

	@FindBy(locator = "register.country")
	private WebElement registercountry;

	@FindBy(locator = "register.username")
	private WebElement registerusername;

	@FindBy(locator = "register.password")
	private WebElement registerpassword;

	@FindBy(locator = "register.confirmpassword")
	private WebElement registerconfirmpassword;

	@FindBy(locator = "register.submit")
	private WebElement registersubmit;

	@FindBy(locator = "register.signin")
	private WebElement registersignin;

	public RegistrationPage() {
		PageFactory.initElements(factory, this);
	}

	public void register(String firstname, String lastname, String phone, String email, String addressline1,
			String addressline2, String city, String state, String postalcode, String country, String username,
			String password, String confpassword)
			throws DropDownElementNotFound, ElementLoadTimeoutException, IOException {
		try {
			utils.waitForElement(20, registerlink);
			Assert.assertTrue(registerlink.isDisplayed(), "Register Link not displayed");
			logger.info("Register Link is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Register Link is displayed");
			Assert.assertTrue(registerlink.isEnabled(), "Register Link is not clickable");
			logger.info("Register link is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Register link is clickable");
			utils.clickElement(registerlink);
			logger.info("Register Link is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Register Link is clicked");

			utils.waitForElement(20, registerfirstname);
			Assert.assertTrue(registerfirstname.isDisplayed(), "Firstname field is not displayed");
			logger.info("Firstname field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Firstname field is displayed");
			utils.enterValue(registerfirstname, firstname);
			logger.info("Firstname is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Firstname is entered");

			utils.waitForElement(20, registerlastname);
			Assert.assertTrue(registerlastname.isDisplayed(), "Lastname field is not displayed");
			logger.info("Lastname field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Lastname field is displayed");
			utils.enterValue(registerlastname, lastname);
			logger.info("Lastname is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Lastname is entered");

			utils.waitForElement(20, registerphone);
			Assert.assertTrue(registerphone.isDisplayed(), "Phone number field is not displayed");
			logger.info("Phone number field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Phone number field is displayed");
			utils.enterValue(registerphone, phone);
			logger.info("Phone number is enetered");
			TestBase.extenttest.log(LogStatus.INFO, "Phone number is enetered");

			utils.waitForElement(20, registeremail);
			Assert.assertTrue(registeremail.isDisplayed(), "Email field is not displayed");
			logger.info("Email field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Email field is displayed");
			utils.enterValue(registeremail, email);
			logger.info("Email is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Email is entered");

			utils.waitForElement(20, registeraddressline1);
			Assert.assertTrue(registeraddressline1.isDisplayed(), "Address Line 1 field is not displayed");
			logger.info("Adderss Line 1 field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Adderss Line 1 field is displayed");
			utils.enterValue(registeraddressline1, addressline1);
			logger.info("Address Line 1 is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Address Line 1 is entered");

			utils.waitForElement(20, registeraddressline2);
			Assert.assertTrue(registeraddressline2.isDisplayed(), "Address Line 2 field is not displayed");
			logger.info("Address Line 2 field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Address Line 2 field is displayed");
			utils.enterValue(registeraddressline2, addressline2);
			logger.info("Address Line 2 is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Address Line 2 is entered");

			utils.waitForElement(20, registercity);
			Assert.assertTrue(registercity.isDisplayed(), "City field is not displayed");
			logger.info("City field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "City field is displayed");
			utils.enterValue(registercity, city);
			logger.info("City is entered");
			TestBase.extenttest.log(LogStatus.INFO, "City is entered");

			utils.waitForElement(20, registerstate);
			Assert.assertTrue(registerstate.isDisplayed(), "State field is not displayed");
			logger.info("State field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "State field is displayed");
			utils.enterValue(registerstate, state);
			logger.info("State is entered");
			TestBase.extenttest.log(LogStatus.INFO, "State is entered");

			utils.waitForElement(20, registerpostalcode);
			Assert.assertTrue(registerpostalcode.isDisplayed(), "Postal code field is not displayed");
			logger.info("Postal code field is present");
			TestBase.extenttest.log(LogStatus.INFO, "Postal code field is present");
			utils.enterValue(registerpostalcode, postalcode);
			logger.info("Postal code is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Postal code is entered");

			utils.waitForElement(20, registercountry);
			Assert.assertTrue(registercountry.isDisplayed(), "Country dropdown is not displayed");
			logger.info("Country dropdown is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Country dropdown is displayed");
			utils.selectFromDropDown(registercountry, country.toUpperCase());
			logger.info("Country selected from dropdown");
			TestBase.extenttest.log(LogStatus.INFO, "Country selected from dropdown");

			utils.waitForElement(20, registerusername);
			Assert.assertTrue(registerusername.isDisplayed(), "Username field is not displayed");
			logger.info("Username field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Username field is displayed");
			utils.enterValue(registerusername, username);
			logger.info("Username is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Username is entered");

			utils.waitForElement(20, registerpassword);
			Assert.assertTrue(registerpassword.isDisplayed(), "Password field is not displayed");
			logger.info("Password field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Password field is displayed");
			utils.enterValue(registerpassword, password);
			logger.info("Password is entered");
			TestBase.extenttest.log(LogStatus.INFO, "Password is entered");

			utils.waitForElement(20, registerconfirmpassword);
			Assert.assertTrue(registerconfirmpassword.isDisplayed(), "Confirm password field is not displayed");
			logger.info("Confirm password field is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Confirm password field is displayed");
			utils.enterValue(registerconfirmpassword, confpassword);
			logger.info("Password re-entered in confirm password field");
			TestBase.extenttest.log(LogStatus.INFO, "Password re-entered in confirm password field");

			utils.waitForElement(20, registersubmit);
			Assert.assertTrue(registersubmit.isDisplayed(), "Submit button is not displayed");
			logger.info("Submit button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Submit button is displayed");
			Assert.assertTrue(registersubmit.isEnabled(), "Submit button is not clickable");
			logger.info("Submit button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Submit button is clickable");
			utils.clickElement(registersubmit);
			logger.info("Submit button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Submit button is clicked");
		} catch (Error e) {
			// TODO: handle exception
			throw new Error(e.getMessage());
		} catch (DropDownElementNotFound e) {
			throw new DropDownElementNotFound(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}

	public void signInAfterRegister() throws ElementLoadTimeoutException {
		try {
			utils.waitForElement(20, registersignin);
			Assert.assertTrue(registersignin.isDisplayed(), "Sign in Link is not displayed");
			logger.info("Sign in Link is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Sign in Link is displayed");
			Assert.assertTrue(registersignin.isEnabled(), "Sign in Link is not clickable");
			logger.info("Sign in Link is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Sign in Link is clickable");
			utils.clickElement(registersignin);
			logger.info("Sign in Link is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Sign in Link is clicked");
		} catch (Error e) {
			// TODO: handle exception
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}
}
