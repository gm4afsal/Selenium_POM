package com.mindtree.automation201.utilities;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.mindtree.automation201.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenshotExtentReport extends TestBase {

	private static Logger logger = TestBase.logger;

	public static void captureExtentRepScreenshotPass(String imagename) throws IOException {
		try {
			String path = Screenshot.takeShot(imagename, TestBase.driver);
			String image = extenttest.addScreenCapture(path);
			extenttest.log(LogStatus.PASS, image + imagename);
			logger.info("Screenshot captured in Extent Report");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void captureExtentRepScreenshotFail(String imagename) throws Exception {
		String path = Screenshot.takeShot(imagename, TestBase.driver);
		String image = extenttest.addScreenCapture(path);
		extenttest.log(LogStatus.FAIL, image + imagename);
		logger.info("Screenshot captured in Extent Report");
	}
}
