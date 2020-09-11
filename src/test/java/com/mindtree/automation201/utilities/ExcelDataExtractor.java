package com.mindtree.automation201.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataExtractor {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataExtractor(String excelpath) throws Exception {
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (NullPointerException e) {
			throw new NullPointerException("Data Not Found" + e.getMessage());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Excel Sheet Not Found" + e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getData(String sheetName, int rownum, int colnum) throws Exception {

		try {
			sheet = wb.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rownum);
			XSSFCell cell = row.getCell(colnum);
			if (cell != null) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					return cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					return String.valueOf((int) cell.getNumericCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					return String.valueOf(cell.getBooleanCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					return "";
				}
			}
			return "";
		} catch (NullPointerException e) {
			throw new NullPointerException("Data Not Found" + e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public int getRowCount(String sheetName) throws Exception {
		try {
			int row = wb.getSheet(sheetName).getLastRowNum();
			return row;
		} catch (NullPointerException e) {
			throw new NullPointerException("Data Not Found" + e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public int getColCount(String sheetName) throws Exception {
		try {
			int col = wb.getSheet(sheetName).getRow(0).getLastCellNum();
			return col;
		} catch (NullPointerException e) {
			throw new NullPointerException("Data Not Found" + e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
