package utilities;

import basePackage.BaseClass;

public class ParameterUtil extends BaseClass{
	
	public static Object[][] getData(String sheetName) {

		
		int rowNum = ReadFromExcel.getRowCount(sheetName);
		int colNum = ReadFromExcel.getColumnCount(sheetName);

		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {

				data[rows - 2][cols] = ReadFromExcel.getCellData(sheetName, cols, rows);

			}

		}

		return data;
	}


}
