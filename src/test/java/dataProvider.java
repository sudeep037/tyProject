import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.genericUtilities.IpathConstants;

public class dataProvider {

	@DataProvider
	public void readData(String Sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet= wb.getSheet(Sheet);
		
		int rowCount;
		int colCount;
        Object[][] arr;
		
		
}
}
