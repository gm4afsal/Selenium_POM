package com.mindtree.automation201.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mindtree.automation201.base.LoadConfigFile;
import com.mindtree.automation201.base.TestBase;

public class Screenshot {

	public static String takeShot(String imagename, WebDriver driver) throws Exception {
		Logger logger = TestBase.logger;
		String screenshotpath=LoadConfigFile.loadPropertiesData("screenshots");
		if (imagename.equals("")) {
			imagename = "blank";
		}
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String imagepath = System.getProperty("user.dir") + screenshotpath + imagename + "_"
				+ formatter.format(calendar.getTime()) + ".png";
		FileUtils.copyFile(screenshot, new File(imagepath));
		logger.info("Screenshot Taken");
		return imagepath;
	}

}
