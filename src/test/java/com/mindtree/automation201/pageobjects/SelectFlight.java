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
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;
import com.mindtree.automation201.utilities.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class SelectFlight {

	CommonUtils utils = new CommonUtils();
	ElementLocatorFactory factory = new FileBasedElementLocatorFactory(TestBase.driver);
	Logger logger = TestBase.logger;

	@FindBy(locator = "selectdepartflight.blueskies360")
	private WebElement blueskies360;

	@FindBy(locator = "selectdepartflight.blueskies361")
	private WebElement blueskies361;

	@FindBy(locator = "selectdepartflight.pangaea362")
	private WebElement pangaea362;

	@FindBy(locator = "selectfdepartflight.unified363")
	private WebElement unified363;

	@FindBy(locator = "selectreturnflight.blueskies630")
	private WebElement blueskies630;

	@FindBy(locator = "selectreturnflight.blueskies631")
	private WebElement blueskies631;

	@FindBy(locator = "selectreturnflight.pangaea632")
	private WebElement pangaea632;

	@FindBy(locator = "selectreturnflight.unified633")
	private WebElement unified633;

	@FindBy(locator = "selectflight.confirm")
	private WebElement confirm;

	public SelectFlight() {
		PageFactory.initElements(factory, this);
	}

	public void selectDepartFlight(String departflight) throws ElementLoadTimeoutException {
		try {
			List<WebElement> departflights = new ArrayList<>();
			utils.waitForElement(20, blueskies360);
			Assert.assertTrue(blueskies360.isDisplayed(), "Blueskies 360 radio button is not displayed");
			departflights.add(blueskies360);
			utils.waitForElement(20, blueskies361);
			Assert.assertTrue(blueskies361.isDisplayed(), "Blueskies 361 radio button is not displayed");
			departflights.add(blueskies361);
			utils.waitForElement(20, pangaea362);
			Assert.assertTrue(pangaea362.isDisplayed(), "Pangea 362 radio button is not displayed");
			departflights.add(pangaea362);
			utils.waitForElement(20, unified363);
			Assert.assertTrue(unified363.isDisplayed(), "Unified 363 radio button is not displayed");
			departflights.add(unified363);
			logger.info("All departing flights radio buttons are displayed");
			TestBase.extenttest.log(LogStatus.INFO, "All departing flights radio buttons are displayed");
			utils.selectDepartFlight(departflights, departflight);
			logger.info("Departing flight selected");
			TestBase.extenttest.log(LogStatus.INFO, "Departing flight selected");
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}

	public void selectReturnFlight(String returnflight) throws ElementLoadTimeoutException {
		try {
			List<WebElement> returnflights = new ArrayList<>();
			utils.waitForElement(20, blueskies630);
			Assert.assertTrue(blueskies630.isDisplayed(), "Blueskies 630 radio button is not displayed");
			returnflights.add(blueskies630);
			utils.waitForElement(20, blueskies631);
			Assert.assertTrue(blueskies631.isDisplayed(), "Blueskies 631 radio button is not displayed");
			returnflights.add(blueskies631);
			utils.waitForElement(20, pangaea632);
			Assert.assertTrue(pangaea632.isDisplayed(), "Pangea 632 radio button is not displayed");
			returnflights.add(pangaea632);
			utils.waitForElement(20, unified633);
			Assert.assertTrue(unified633.isDisplayed(), "Unified 633 radio button is not displayed");
			returnflights.add(unified633);
			logger.info("All returning flights radio buttons are displayed");
			TestBase.extenttest.log(LogStatus.INFO, "All returning flights radio buttons are displayed");
			utils.selectReturnFlight(returnflights, "Unified Airlines 633");
			logger.info("Returning flight selected");
			TestBase.extenttest.log(LogStatus.INFO, "Returning flight selected");
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}

	public void confirm() throws ElementLoadTimeoutException {
		try {
			utils.waitForElement(20, confirm);
			Assert.assertTrue(confirm.isDisplayed(), "Confirm button is not displayed");
			logger.info("Confirm button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Confirm button is displayed");
			Assert.assertTrue(confirm.isEnabled(), "Confirm button is not clickable");
			logger.info("Confirm button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Confirm button is clickable");
			utils.clickElement(confirm);
			logger.info("Confirm button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Confirm button is clicked");
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}

}
