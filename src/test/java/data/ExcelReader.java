package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream stream = null;
	
	public FileInputStream getFileInputStream() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.xlsx";
		File src = new File(filePath);
		
		try {
			stream = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. Terminating process: " + e.getMessage());
		}
		
		return stream;
	}

	public Object[][] getExcelDate() throws IOException {
		stream = getFileInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int totalNumberOfRows = sheet.getLastRowNum() + 1;
		int totalNumberOfCols = 4;
		
		String[][] arrOfExcelData = new String[totalNumberOfRows][totalNumberOfCols];
		
		for (int i = 0; i < totalNumberOfRows; i++) {
			
			for (int j = 0; j < totalNumberOfCols; j++) {
				
				XSSFRow row = sheet.getRow(i);
				arrOfExcelData[i][j] = row.getCell(j).toString();
			}
		}
		
		workbook.close();
		
		return arrOfExcelData;
	}
}
