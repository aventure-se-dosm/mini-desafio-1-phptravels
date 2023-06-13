package core.dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.managers.FileReaderManager;

public class ExcelXLSXReader extends AbstractReader {

    XSSFWorkbook wb;
    private static final int FIRST_SHEET_INDEX = 0;

    public ExcelXLSXReader(String xlsDataSourcePath) {
	super(xlsDataSourcePath);
	this.setupReading();
    }

    public ExcelXLSXReader() {
	this(FileReaderManager.getConfigFileReader().getDataSource());
    }

    @Override
    protected void setupReading() {

	try {
	    wb = new XSSFWorkbook(new FileInputStream(this.configPath));
	} catch (FileNotFoundException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();

	}

    }

    public XSSFWorkbook getWorkBook() {
	return wb;
    }

    public XSSFSheet getSheet(String sheetName) {
	return wb.getSheet(sheetName);
    }

    public XSSFSheet getSheet() {
	return wb.getSheet(FileReaderManager.getConfigFileReader().getDefaulSheetName());
    }

    public XSSFSheet getSheetAt(int index) {
	return wb.getSheetAt(FIRST_SHEET_INDEX);
    }

    @Override
    public void closeReader() {
	try {
	    wb.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}