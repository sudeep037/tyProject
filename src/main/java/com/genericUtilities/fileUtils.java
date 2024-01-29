package com.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class fileUtils {

	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
