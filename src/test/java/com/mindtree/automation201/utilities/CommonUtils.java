package com.mindtree.automation201.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.exceptions.DropDownElementNotFound;
import com.mindtree.automation201.exceptions.ElementLoadTimeoutException;

public class CommonUtils {

	public WebElement waitForElement(long time, WebElement element) throws ElementLoadTimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(TestBase.driver, time);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw new ElementLoadTimeoutException("The Webelement could not be loaded in the specified time");
		}
	}

	public void implicitWait(long time) throws ElementLoadTimeoutException {
		try {
			TestBase.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new ElementLoadTimeoutException("The Webelement could not be loaded in the specified time");
		}
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void enterValue(WebElement element, String text) {
		if (!text.equals("")) {
			element.sendKeys(text);
		}
	}

	public void pageLoad(long time) {
		TestBase.driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void browserClose() {
		TestBase.driver.quit();
	}

	public void scriptLoad(long time) {
		TestBase.driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
	}

	public void selectFromDropDown(WebElement element, String text) throws DropDownElementNotFound {
		// TODO Auto-generated method stub
		try {
			if (!text.equals("")) {
				Select item = new Select(element);
				item.selectByVisibleText(text);
			}
		} catch (Exception e) {
			throw new DropDownElementNotFound(text + " is not present in the dropdown");
		}
	}

	public boolean isAlertPresent() {
		try {
			TestBase.driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public void selectServiceClass(List<WebElement> serviceclass, String text) {
		// TODO Auto-generated method stub
		if (text.equalsIgnoreCase("Economy")) {
			serviceclass.get(0).click();
		}
		if (text.equalsIgnoreCase("Business")) {
			serviceclass.get(1).click();
		}
		if (text.equalsIgnoreCase("First")) {
			serviceclass.get(2).click();
		}

	}

	public void selectDepartFlight(List<WebElement> departflights, String text) {
		// TODO Auto-generated method stub
		if (text.equalsIgnoreCase("Blue Skies Airlines 360")) {
			departflights.get(0).click();
		}
		if (text.equalsIgnoreCase("Blue Skies Airlines 361")) {
			departflights.get(1).click();
			;
		}
		if (text.equalsIgnoreCase("Pangaea Airlines 362")) {
			departflights.get(2).click();
		}
		if (text.equalsIgnoreCase("Unified Airlines 363")) {
			departflights.get(3).click();
		}

	}

	public void selectReturnFlight(List<WebElement> returnflights, String text) {
		// TODO Auto-generated method stub
		if (text.equalsIgnoreCase("Blue Skies Airlines 630")) {
			returnflights.get(0).click();
			;
		}
		if (text.equalsIgnoreCase("Blue Skies Airlines 631")) {
			returnflights.get(1).click();
			;
		}
		if (text.equalsIgnoreCase("Pangea Airlines 632")) {
			returnflights.get(2).click();
		}
		if (text.equalsIgnoreCase("Unified Airlines 633")) {
			returnflights.get(3).click();
		}

	}

}
