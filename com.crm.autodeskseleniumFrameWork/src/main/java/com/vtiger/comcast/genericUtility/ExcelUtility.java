package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed using Apache POI libraries, which used to handle Microsoft Excel sheet
 * @author yogesh
 *
 */
public class ExcelUtility {
/**
 * it is read the Data excel based on below arguments
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return Data
 * @throws Throwable
 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheetName);
	    Row row = sh.getRow(rowNum);
	    String data = row.getCell(cellNum).getStringCellValue();
	    wb.close();
	    return data;
	    
	}
	
	/**
	 * used to get the last used row number on specific sheet
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName)throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}	
		
	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data)throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdata.xlsx");
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata/testdata.xlsx");
		wb.write(fos);
		wb.close();	
	}
	
}
	
	
	
	
	
	


