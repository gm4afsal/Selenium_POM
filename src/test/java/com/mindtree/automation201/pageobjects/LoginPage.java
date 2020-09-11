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

public class LoginPage {

	CommonUtils utils = new CommonUtils();
	ElementLocatorFactory factory = new FileBasedElementLocatorFactory(TestBase.driver);
	Logger logger = TestBase.logger;

	@FindBy(locator = "login.username")
	private WebElement loginusername;

	@FindBy(locator = "login.password")
	private WebElement loginpassword;

	@FindBy(locator = "login.submit")
	private WebElement loginsubmit;

	@FindBy(locator = "postreg.username")
	private WebElement postregusername;

	@FindBy(locator = "postreg.password")
	private WebElement postregpassword;

	@FindBy(locator = "postreg.submit")
	private WebElement postregsubmit;

	@FindBy(locator = "login.signoff")
	private WebElement loginsignoff;

	public LoginPage() {
		PageFactory.initElements(factory, this);
	}

	public void signIn(String username, String password) throws Exception {
		try {
			String pagetitle = TestBase.driver.getTitle();
			if (pagetitle.equals("Sign-on: Mercury Tours")) {
				utils.waitForElement(20, postregusername);
				Assert.assertTrue(postregusername.isDisplayed(), "Username field is not displayed");
				logger.info("Username field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Username field is displayed");
				utils.enterValue(postregusername, username);
				logger.info("Username is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Username is entered");

				utils.waitForElement(20, postregpassword);
				Assert.assertTrue(postregpassword.isDisplayed(), "Password field is not displayed");
				logger.info("Password field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Password field is displayed");
				utils.enterValue(postregpassword, password);
				logger.info("Password is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Password is entered");

				utils.waitForElement(20, postregsubmit);
				Assert.assertTrue(postregsubmit.isDisplayed(), "Submit button is not displayed");
				logger.info("Submit button is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Submit button is displayed");
				Assert.assertTrue(postregsubmit.isEnabled(), "Submit button is not clickable");
				logger.info("Submit button is clickable");
				TestBase.extenttest.log(LogStatus.INFO, "Submit button is clickable");
				utils.clickElement(postregsubmit);
				logger.info("Submit button is clicked");
				TestBase.extenttest.log(LogStatus.INFO, "Submit button is clicked");
				
				String title=TestBase.driver.getTitle();
				Assert.assertTrue(title.equals("Find a Flight: Mercury Tours:"), "Sign in failed");
				logger.info("Sign In Successful");
				TestBase.extenttest.log(LogStatus.INFO, "Sign In Successful");

			} else {
				utils.waitForElement(20, loginusername);
				Assert.assertTrue(loginusername.isDisplayed(), "Username field is not displayed");
				logger.info("Username field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Username field is displayed");
				utils.enterValue(loginusername, username);
				logger.info("Username is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Username is entered");

				utils.waitForElement(20, loginpassword);
				Assert.assertTrue(loginpassword.isDisplayed(), "Password field is not displayed");
				logger.info("Password field is displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Password field is displayed");
				utils.enterValue(loginpassword, password);
				logger.info("Password is entered");
				TestBase.extenttest.log(LogStatus.INFO, "Password is entered");

				utils.waitForElement(20, loginsubmit);
				Assert.assertTrue(loginsubmit.isDisplayed(), "Submit button is not displayed");
				logger.info("Submit button is not displayed");
				TestBase.extenttest.log(LogStatus.INFO, "Submit button is not displayed");
				Assert.assertTrue(loginsubmit.isEnabled(), "Submit button is not clickable");
				logger.info("Submit button is clickable");
				TestBase.extenttest.log(LogStatus.INFO, "Submit button is clickable");
				utils.clickElement(loginsubmit);
				logger.info("Submit button is clicked");
				TestBase.extenttest.log(LogStatus.INFO, "Submit button is clicked");
				
				String title=TestBase.driver.getTitle();
				Assert.assertTrue(title.equals("Find a Flight: Mercury Tours:"), "Sign in failed");
				logger.info("Sign In Successful");
				TestBase.extenttest.log(LogStatus.INFO, "Sign In Successful");
			}
		} catch (Error e) {
			throw new Error(e.getMessage());
		} catch (ElementLoadTimeoutException e) {
			throw new ElementLoadTimeoutException(e.getMessage());
		}
	}

	public void signOff() throws Exception {
		try {
			utils.waitForElement(20, loginsignoff);
			Assert.assertTrue(loginsignoff.isDisplayed(), "Sign-off button is not displayed");
			logger.info("Sign-off button is displayed");
			TestBase.extenttest.log(LogStatus.INFO, "Sign-off button is displayed");
			Assert.assertTrue(loginsignoff.isEnabled(), "Sign-off button is not clickable");
			logger.info("Sign-off button is clickable");
			TestBase.extenttest.log(LogStatus.INFO, "Sign-off button is clickable");
			utils.clickElement(loginsignoff);
			logger.info("Sign-off button is clicked");
			TestBase.extenttest.log(LogStatus.INFO, "Sign-off button is clicked");

		} catch (Error e) {
			// TODO Auto-generated catch block
			throw new Error(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Sign-off button not found");
		}
	}

}
