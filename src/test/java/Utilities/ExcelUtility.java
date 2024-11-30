package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws IOException {
	    fi = new FileInputStream(path);
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetname);
	    int rowcount = sheet.getLastRowNum() ; // row indices start at 0
	    workbook.close();
	    fi.close();
	    return rowcount;
	}
	
	public int getCellCount(String sheetname, int rownum) throws IOException {
	    fi = new FileInputStream(path);
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetname);
	    row = sheet.getRow(rownum);
	    
	    int cellcount = 0;
	    if (row != null) {
	        cellcount = row.getLastCellNum(); // Returns the count of cells
	    }
	    
	    workbook.close();
	    fi.close();
	    return cellcount;
	}
	
	public String getCellData(String sheetname, int rownum, int colnum) throws IOException {
	    fi = new FileInputStream(path);
	    workbook = new XSSFWorkbook(fi);
	    sheet = workbook.getSheet(sheetname);
	    row = sheet.getRow(rownum);
	    
	    String data = "";
	    if (row != null) {
	        cell = row.getCell(colnum);
	        
	        DataFormatter formatter = new DataFormatter();
	        if (cell != null) {
	            data = formatter.formatCellValue(cell); // Returns the formatted value as a string
	        }
	    }
	    
	    workbook.close();
	    fi.close();
	    return data;
	}


	public void setCellData(String sheetname,int rownum,int colnum,String data) throws IOException {
	 File xlfile=new File(path);
	 if(!xlfile.exists()) {
		 workbook = new XSSFWorkbook();
		 fo = new FileOutputStream(path);

		 workbook.write(fo);
		 }

		 fi = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fi);

		 if (workbook.getSheetIndex(sheetname) == -1) // If sheet not exists then create new Sheet
		 workbook.createSheet(sheetname);

		 sheet = workbook.getSheet(sheetname);

		 if (sheet.getRow(rownum) == null)
		 sheet.createRow(rownum);
		 row = sheet.getRow(rownum);
		 // If row not exists then create new Row

		 cell = row.createCell(colnum);
		 cell.setCellValue(data);

		 fo = new FileOutputStream(path);
		 workbook.write(fo);

		 workbook.close();
		 fi.close();

		 fo.close();
	}

}
