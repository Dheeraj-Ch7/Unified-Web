package com.unified.infinity.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.unified.config.Config;

public class ExcelUtil {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	
	public static String getCellData(int rowNo, int ColNo) {
		String cellData = null;
		
		FormulaEvaluator evaluator = excelWBook.getCreationHelper().createFormulaEvaluator();
		XSSFCell cell = excelWSheet.getRow(rowNo).getCell(ColNo);
		cell.setCellType(CellType.STRING);
		CellValue cellValue = evaluator.evaluate(cell);
		cellData = cellValue.getStringValue();
		
		if (cellData.isEmpty()) {
			cellData = "";
		}
		
		return cellData;
		
	}
	public static HashMap<Integer, HashMap<String, String >> getTestData (String sheetName) throws IOException {
		int startIteration;
		int endIteration;
		int startCol = 2;
		int totalCols;
		
		HashMap<String, String> testdata = null;
		HashMap<Integer, HashMap<String, String>> testDataIterations = new HashMap<Integer, HashMap<String, String>>();
		
		FileInputStream excelFile = new FileInputStream(Config.Test_DATA_FILE_PATH);
		excelWBook = new XSSFWorkbook(excelFile);
		excelWSheet = excelWBook.getSheet(sheetName);
		
		startIteration = 1;
		endIteration = excelWSheet.getLastRowNum();
		totalCols = excelWSheet.getRow(0).getLastCellNum();
		int iteration = 1;
		
		for (int i = startIteration; i <= endIteration; i++) {
			if (getCellData(i,2).equalsIgnoreCase("Y")) {
				testdata = new HashMap<String, String>();
				
				for (int j = startCol; j < totalCols; j++) {
					testdata.put(getCellData(startIteration-1, j), getCellData(i,j));
				}
				testDataIterations.put(iteration, testdata);
				iteration = iteration + 1;	
			}
		}
		return testDataIterations;	
		
	}
}
