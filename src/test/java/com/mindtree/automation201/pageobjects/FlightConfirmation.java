package com.mindtree.automation201.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.Assert;

import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.customlocator.FileBasedElementLocatorFactory;
import com.mindtree.automation201.customlocator.FindBy;
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;
import com.mindtree.automation201.utilities.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class FlightConfirmation {

	CommonUtils utils = new CommonUtils();
	ElementLocatorFactory factory = new FileBasedElementLocatorFactory(TestBase.driver);
	Logger logger = TestBase.logger;

	@FindBy(locator = "flightconfirmation.logout")
	private WebElement logout;

	public FlightConfirmation() {
		PageFactory.initElements(factory, this);
	}

	public void logoutAfterConfirm() throws ElementLoadTimeoutException {
		try {
			utils.waitForElement(20, logout);
			Assert.assertTrue(logout.isDisplayed(), "Logout button is not displayed");
			logger.info("Logout button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Logout button is displayed");
			Assert.assertTrue(logout.isEnabled(), "Logout button is not clickable");
			logger.info("Logout button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Logout button is clickable");
			utils.clickElement(logout);
			logger.info("Logout button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Logout button is clicked");
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}
}
