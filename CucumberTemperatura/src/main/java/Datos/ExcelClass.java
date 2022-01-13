package Datos;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelClass {
	
	private String filepathX; 
	
	public ExcelClass(String filepath)
	{
		filepathX = filepath;
	}

	
public String searchCampo(String sheetName, String nameCampo, String CP)
{
	String Resultado = "";
	try {



	File file = new File(filepathX);
	
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	
	int fila_CP = searchPositionCP(sheetName, CP);
	
	for (int i = 0; i < 1; i++) {
		XSSFRow row = newSheet.getRow(i);

		for (int j = 0; j < row.getLastCellNum(); j++) {
			
			if(row.getCell(j).getStringCellValue().equals(nameCampo))
			{
				//System.out.println(sheetName+" "+fila_CP+" "+j);
				Resultado = getCellValue(sheetName, fila_CP, j);
			}
			
			//System.out.println("".equals(row.getCell(j).getStringCellValue())?"":row.getCell(j).getStringCellValue() + "||");
			
		}
	}
		return Resultado;
	}catch (IOException e)
	{
		e.printStackTrace();
		return Resultado;
	}

}

public int searchPositionCP(String sheetName, String CP) throws IOException
{
	int Resultado = 0;
	File file = new File(filepathX);
	
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	
	int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
	//System.out.println("rowCount-> "+rowCount);
	for (int i = 1; i <= rowCount; i++) {
		XSSFRow row = newSheet.getRow(i);

		//System.out.println("CP-> "+CP);
		//System.out.println(row.getCell(0).getStringCellValue());
			if(row.getCell(0).getStringCellValue().equals(CP))
			{
				//System.out.println("FILA-> "+i);
				Resultado = i;
				break;
			}

	}
	return Resultado;
}

public void readExcel(String sheetName) throws IOException {
		
		File file = new File(filepathX);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);
			
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//System.out.println(row.getCell(j).getStringCellValue() + "||");
			}
		}
	}

public String getCellValue(String sheetName, int rowNumber, int cellNumber) throws IOException {
	
	File file = new File(filepathX);
	
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	
	XSSFRow row = newSheet.getRow(rowNumber);
	
	XSSFCell cell = row.getCell(cellNumber);
	
	return cell.getStringCellValue();

	
	
}

public void writeExcel(String sheetName, String[] dataToWrite) throws IOException {
	
	File file = new File(filepathX);
	
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	
	int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();
	
	XSSFRow row = newSheet.getRow(0);
	
	XSSFRow newRow = newSheet.createRow(rowCount+1);
	
	for (int i = 0; i < row.getLastCellNum(); i++) {
		XSSFCell newCell = newRow.createCell(i);
		newCell.setCellValue(dataToWrite[i]);
	}
	
	inputStream.close();
	
	FileOutputStream outputStream = new FileOutputStream(file);
	
	newWorkbook.write(outputStream);
	
	outputStream.close();
}

public void writeCellValue(String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
	
	File file = new File(filepathX);
	
	FileInputStream inputStream = new FileInputStream(file);
	
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	
	XSSFRow row = newSheet.getRow(rowNumber);
	
	XSSFCell firstCell = row.getCell(cellNumber-1);
	
	System.out.println("first cell value is:" + firstCell.getStringCellValue());
	
	XSSFCell nextCell = row.createCell(cellNumber);
	nextCell.setCellValue(resultText);
	
	System.out.println("nextcell value:" + nextCell.getStringCellValue());
	
	inputStream.close();
	
	FileOutputStream outputStream = new FileOutputStream(file);
	
	newWorkbook.write(outputStream);
	
	outputStream.close();
	
}

}