package com.mindtree.automation201.customlocator;

import com.google.common.base.Preconditions;
import com.mindtree.automation201.base.LoadConfigFile;
import com.mindtree.automation201.base.TestBase;
import com.mindtree.automation201.utilities.ExcelDataExtractor;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

class CustomAnnotations extends AbstractAnnotations {

	Logger logger = TestBase.logger;
	private final Field field;

	CustomAnnotations(Field field) {
		this.field = field;
	}

	@Override
	public By buildBy() {
		FindBy search = field.getAnnotation(FindBy.class);
		ExcelDataExtractor locatorsexcel;
		String locatorinfile = null;
		By locateby = null;
		Preconditions.checkArgument(search != null, "Failed to locate the annotation @FindBy");
		String elementName = search.locator();
		try {
			String excelpath = LoadConfigFile.loadPropertiesData("locators_excel");
			locatorsexcel = new ExcelDataExtractor(System.getProperty("user.dir") + excelpath);
			int rows = locatorsexcel.getRowCount("Locators");
			for (int rowiterator = 0; rowiterator <= rows; rowiterator++) {
				if (elementName.equals(locatorsexcel.getData("Locators", rowiterator, 0))) {
					locatorinfile = locatorsexcel.getData("Locators", rowiterator, 1);
					Preconditions.checkArgument(isNotNullAndEmpty(locatorinfile), "Locator cannot be null (or) empty.");
					locateby = By.xpath(locatorinfile);
					break;
				}
			}

		} catch (NullPointerException e) {
			logger.fatal("Data not found");
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.fatal("Excel Sheet throwPath wrong");
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.fatal("Excel Sheet Not Found");
			logger.fatal(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			logger.error("Some error occurred");
			logger.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		return locateby;
	}

	@Override
	public boolean isLookupCached() {
		return (field.getAnnotation(CacheLookup.class) != null);
	}

	private boolean isNotNullAndEmpty(String arg) {
		return ((arg != null) && (!arg.trim().isEmpty()));
	}
}