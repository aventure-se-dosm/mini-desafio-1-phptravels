package core.dataReaders.excelReaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import core.context.TestContext;

public class ExcelXLSReader extends ExcelReader {

    public ExcelXLSReader(String xlsDataSourcePath) {
	super(xlsDataSourcePath);
	this.setupReading();
    }

    HSSFWorkbook wb;

    @Override
    protected void setupReading() {

	try {
	    wb = new HSSFWorkbook(new FileInputStream(this.configPath));
	} catch (FileNotFoundException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();

	}

    }

    public HSSFWorkbook getWorkBook() {
	return wb;
    }

    public HSSFSheet getSheet(String sheetName) {
	return wb.getSheet(sheetName);
    }

    public HSSFSheet getConfigSettingSheet() {
	return wb.getSheet(TestContext.getConfigFileReader().getDefaulSheetName());
    }

    public HSSFSheet getSheetAt(int index) {
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
