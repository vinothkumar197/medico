package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readPatientCredentials {
	
	public static String[][] getExcelData() {
		
		String filelocation = "./test-data/Login-data.xlsx";
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(filelocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
//				System.out.println(value);
				data[i-1][j] = value;
			} 
		}
		try {
			wbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
