package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sh;	
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
		
	public ExcelUtility(String path)
	{
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();	
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		int cellcount = row.getLastCellNum();	
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		cell = row.getCell(cellnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch(Exception e)
		{
			data = "";
		}	
		wb.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rownum, int cellnum, String data) throws IOException
	{
		File xlfile = new File(path);
		if(!xlfile.exists())
		{
			wb = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			wb.write(fo);
		}
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(sheetName) == -1)
			wb.createSheet(sheetName);
		sh = wb.getSheet(sheetName);
		
		if(sh.getRow(rownum) == null)
			sh.createRow(rownum);
		row = sh.getRow(rownum);
		
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();	
		fi.close();
		fo.close();	
	}
	
	public void fillGreenColor(String sheetName, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		
		row = sh.getRow(rownum);
		if(row == null) {
			row = sh.createRow(rownum);
		}
		
		cell = row.getCell(cellnum);
		if(cell == null) {
			cell = row.createCell(cellnum);
		}
			
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public void fillRedColor(String sheetName, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetName);
		
		row = sh.getRow(rownum);
		if(row == null) {
			row = sh.createRow(rownum);
		}
		
		cell = row.getCell(cellnum);
		if(cell == null) {
			cell = row.createCell(cellnum);
		}
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
}