package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public String path;
	public FileInputStream fis = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;

	public ReadFromExcel(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// returns the row count in a sheet
	public static int getRowCount(String sheetName) {

		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	// find whether sheets exists
	public static boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns number of columns in a sheet
	public static int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	// returns the data from a cell
	public static String getCellData(String sheetName, int colNum, int rowNum) {

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum-1);
		cell = row.getCell(colNum);
		
		return cell.getStringCellValue();
		
		
	}
	
	public static void main(String[] args) {
		
		
		ReadFromExcel excelRead = new ReadFromExcel(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ParameterFile\\Patameters.xlsx");
		
		String sheetName = "HomePageTest";
		int rowNum = excelRead.getRowCount(sheetName );
		int colNum = excelRead.getColumnCount(sheetName);

		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {

				data[rows - 2][cols] = excelRead.getCellData(sheetName, cols, rows);
				
				System.out.println(data[rows - 2][cols] + " ");

			}

		}

		
	}

		
	}


