package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import BaseClass.baseClass;

public class ExcelHandling  extends baseClass{

	public ExcelHandling() throws IOException {
		super();
		
	}
		public static  String ExcelSheet_path="../STP_magento/src/main/java/Utility/STP_credentials.xlsx";
		public static Sheet sheet;
		public static Workbook workbook;
		
		public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
			
			FileInputStream fInput=new FileInputStream(ExcelSheet_path);
			
		workbook=WorkbookFactory.create(fInput);
		
		 sheet=workbook.getSheet(sheetName);
		
		Object[][] dataObject=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int r=0;r<sheet.getLastRowNum();r++) {
			for(int c=0;c<sheet.getRow(0).getLastCellNum();c++) {
				
				dataObject[r][c]=sheet.getRow(r+1).getCell(c).toString();
				}
			}
		return dataObject;
			
		}
	
}
