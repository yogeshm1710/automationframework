package com.vtiger.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author yogesh
 *
 */
public class JavaUtility {
/**
 * its used to generate random number
 * @return int data
 */
public int getRanDomNumber() {
	Random random= new Random();
	int intRandom = random.nextInt(1000);
	return intRandom;
}
/**
 * used to get system date and time in IST format
 * @return 	
 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
	}
	
	/**
	 * used to get system date and time in yyyy-mm-dd format
	 * @return
	 */
	
	public String getSystemDateWithformat()
	{
		Date date = new Date();
		String dateAndTime = date.toString().replace(":", "-");
		
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormate = YYYY+"-"+MM+"-"+DD;
		return finalFormate;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

