package com.genericUtilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseUtils {

	Connection conn = null;
	
	public void connectToDB() throws Throwable
	{
		Driver dbDriver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(dbDriver);
	    conn = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUsername, IpathConstants.dbPassword);
	}
	
	public String executeQuery(String query, int colIndex, String expData) throws Throwable
	{
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(query);
		boolean flag = false;
		
		while(result.next())
		{
			String actual = result.getString(colIndex);
			
			if(actual.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Data Verified");
			return expData;
		}
		else {
			System.out.println("Data mismatched");
			return "";
		}
	}
	
	
	public void closeDB() throws SQLException
	{
		conn.close();
	}
}
