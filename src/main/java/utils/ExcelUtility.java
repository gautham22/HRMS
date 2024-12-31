package utils;

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

	public FileInputStream file;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path = System.getProperty("user.dir")+"/xcel files/ExcelTestData.xlsx";
	

	public int getRowCount(String sheetName) throws IOException 
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowcount;		
	}
	

	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		file.close();
		return cellcount;
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		file.close();
		return data;
	}
	
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
		}
				
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		
		sheet=workbook.getSheet(sheetName);
					
		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);		
		workbook.close();
		file.close();
		fo.close();
	}
	
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		file.close();
		fo.close();
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		workbook.write(fo);
		workbook.close();
		file.close();
		fo.close();
	}
    
    
    public void writetoxcel(String SheetName,int row,int col,String value) throws IOException {
    	File file=new File(path);
    	FileInputStream fis= new FileInputStream(file);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	wb.getSheet(SheetName).getRow(row).getCell(col).setCellValue(value);
    	FileOutputStream fos = new FileOutputStream(new File(path));
    	wb.write(fos);
    	wb.close();
    	fos.close();
    }
    
    
}
