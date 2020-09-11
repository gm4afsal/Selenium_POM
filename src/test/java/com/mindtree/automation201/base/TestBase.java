package com.mindtree.automation201.base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.mindtree.automation201.baseInterface.TestBaseInterface;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase implements TestBaseInterface {
	
	public static WebDriver driver;
	public static ExtentReports extent = new ExtentReports(
			System.getProperty("user.dir") + "/Extent_Report/Extent_Report.html", true);
	public static ExtentTest extenttest;
	public static Logger logger = Logger.getLogger("NewTours_Automation_201_Logs");

	public void getBrowser() throws IOException {
		try {
			String browser = LoadConfigFile.loadPropertiesData("browser");
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "/src/test/java/com/mindtree/automation201/configs/chromedriver.exe");
				driver = new ChromeDriver();
				logger.info("Browser started");
				driver.manage().window().maximize();
				driver.get(LoadConfigFile.loadPropertiesData("url"));
				logger.info("Url entered");
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "");
				driver = new FirefoxDriver();
				logger.info("Browser started");
				driver.manage().window().maximize();
				driver.get(LoadConfigFile.loadPropertiesData("url"));
				logger.info("Url entered");
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
						+ "/src/test/java/com/mindtree/automation201/configs/IEDriverServer.exe");
				InternetExplorerOptions caps = new InternetExplorerOptions();
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new InternetExplorerDriver(caps);
				logger.info("Browser started");
				driver.manage().window().maximize();
				driver.get(LoadConfigFile.loadPropertiesData("url"));
				logger.info("Url entered");

			}
		} catch (Exception e) {
			logger.error("Some error occurred");
			logger.error(e.getMessage());
		}
	}
}
