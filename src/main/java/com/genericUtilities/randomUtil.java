package com.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class randomUtil {

	/**
	 * This method is used to get Random Numbers
	 * @return 
	 * @return
	 */
	public Long getRandomNo(Long no)
	{
		Random ran = new Random();
		Long ranNo = ran.nextLong(no);
		return ranNo;
	}
	
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;		
	}
	
	public String getSystemDataInFormat()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date dt = new Date();
		String date = dt.toString();
		String systemDateInFormat = dateformat.format(date);
		return systemDateInFormat;
	}
}
