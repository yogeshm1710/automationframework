 package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author yogesh
 *
 */
public class FileUtility {
/**
 * it is used to read the data from commonData.properties file based on key which you pass as an argument
 * @param key
 * @throws throwable
 */
	public String getPropertyKeyValue(String key)throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/CommonData/credential.property");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
	
	
	
	
	
	
	
	
	
	
}
