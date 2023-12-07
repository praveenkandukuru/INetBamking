package com.inetBanking.excelutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFromExcelSheet {
	public String getdatafromExcelSheet(String sheetname, int rownum, int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\configurations\\testdata.xlsx");
		Workbook wbk = WorkbookFactory.create(fis);
		Sheet sh = wbk.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		
		return value;
	}

		public void setCellValueInExcel(String sheetname,int rownum,int cellnum,String cellvalue) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\configurations\\testdata.xlsx");
			Workbook wbk=WorkbookFactory.create(fis);
			Sheet sh=wbk.getSheet(sheetname);
			Row row=sh.createRow(rownum);
			Cell cell=row.createCell(cellnum);
			cell.setCellValue(cellvalue);
	
			
			FileOutputStream fileOutputStream=new FileOutputStream(new File(System.getProperty("user.dir")+"\\configurations\\testdata.xlsx"));
				
				wbk.write(fileOutputStream);
			fileOutputStream.flush();
					}
		

}
