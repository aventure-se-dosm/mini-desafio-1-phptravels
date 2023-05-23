package core.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.managers.FileReaderManager;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelXLSXReader extends AbstractReader {

	XSSFWorkbook wb;

	public ExcelXLSXReader(String xlsDataSourcePath) {
		super(xlsDataSourcePath);
		try {
			wb = new XSSFWorkbook(new File(xlsDataSourcePath));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ExcelXLSXReader() {

		this(FileReaderManager.getXLSXDataSource());
	}

	@Override
	protected void setupReading() {

		try {
			wb = new XSSFWorkbook(new FileInputStream(readedFilePath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public XSSFWorkbook getWorkBook() {
		return wb;
	}

	public void closeReader() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}