package com.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class excelUtils implements IpathConstants {

	public String readDataFromExcel(String Sheet, int row, int col) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet(Sheet);
		int rowCount = sheet.getLastRowNum();
		String cellData = null;
		
		for(int r = row; r<=rowCount; r++)
		{
			Row rows = sheet.getRow(r);
			int cellCount = rows.getLastCellNum();
			
			for(int c = col; c<=cellCount; c++)
			{
			  cellData = rows.getCell(c).getStringCellValue();
			}
		}
     	return cellData;
	}
	
	public int rowCount(String Sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(Sheet);
		int noOfRows = sheet.getLastRowNum();
		return noOfRows;	
	}
	
	public int colCount(String Sheet, int row) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(Sheet);
		
		return row;
		
	}
	
	public HashMap<String, String> hashMapData(String sheetName, int col) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
	    
		HashMap<String, String> map = new HashMap<>();

		for(int r = 0; r<=rowCount; r++)
		{
			String key = sheet.getRow(r).getCell(col).getStringCellValue();
			String value = sheet.getRow(r).getCell(col++).getStringCellValue();
			map.put(key, value);
		}
		
	   return map;
	}
	
	public void writeDataIntoExcel(String Sheet) throws IOException
	{
		Faker faker = new Faker();
		randomUtil rand = new randomUtil();
		String pswd = faker.internet().password();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(Sheet);
		
		// 2D Array
		        Object arrData [][] = 
		    {
				{"docname", faker.name().firstName()},
				{"clinicaddress", faker.address().city()},
				{"docfees", faker.numerify("5500")},
				{"doccontact", faker.numerify("7456890987")},
				{"docemail",faker.internet().emailAddress()},
				{"npass", pswd},
				{"cfpass", pswd}
	    	};
		        
		        int rowCount = 0;
		        
		        for(Object arr[]:arrData) 
		        {
		        	XSSFRow row = sheet.createRow(rowCount++);
		        	int colCount = 0;
		        	  for(Object value:arr)
		        	  {
		        		  XSSFCell cell = row.createCell(colCount++);
		        		  
		        		   if(value instanceof String)
		        				cell.setCellValue((String)value);
		        				
		        		   if(value instanceof Integer)
		        				cell.setCellValue((Integer)value);
		        				
		        		   if(value instanceof Boolean)
		        				cell.setCellValue((Boolean)value);	
		        	  }
		        }
		        
	
		  FileOutputStream fos = new FileOutputStream(IpathConstants.excelPath);
		  workbook.write(fos);
		  fos.close();
		  System.out.println("Employee2.xlsx file has written successfull");
		    	
	}
	
	public void writeDataIntoExcel1(String Sheet, Object arr[][]) throws IOException
	{
		Faker faker = new Faker();
		randomUtil rand = new randomUtil();
		String pswd = faker.internet().password();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(Sheet);
		
		// 2D Array
		        Object arrData [][] = {};
		        
		        int rowCount = 0;
		        
		        for(Object arrValue[]:arrData) 
		        {
		        	XSSFRow row = sheet.createRow(rowCount++);
		        	int colCount = 0;
		        	  for(Object value:arr)
		        	  {
		        		  XSSFCell cell = row.createCell(colCount++);
		        		  
		        		   if(value instanceof String)
		        				cell.setCellValue((String)value);
		        				
		        		   if(value instanceof Integer)
		        				cell.setCellValue((Integer)value);
		        				
		        		   if(value instanceof Boolean)
		        				cell.setCellValue((Boolean)value);	
		        	  }
		        }
		        
		  FileOutputStream fos = new FileOutputStream(IpathConstants.excelPath);
		  workbook.write(fos);
		  fos.close();
		  System.out.println("Data has been written successfully");
		    		  
	}
	
	
   }
