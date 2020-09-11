package com.mindtree.automation201.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.mindtree.automation201.base.TestBase;

public class LoadConfigFile {

	public static String loadPropertiesData(String key) throws Exception {

		Logger logger = TestBase.logger;
		String value = null;
		Properties property = new Properties();
		try {
			File configfile = new File(System.getProperty("user.dir")
					+ "/src/test/java/com/mindtree/automation201/configs/config.properties");
			FileInputStream filereader = new FileInputStream(configfile);
			property.load(filereader);
			value = property.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Config file not found");
			Assert.fail();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return value;
	}

}
