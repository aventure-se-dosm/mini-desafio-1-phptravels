package br.dev.marcelodeoliveira.core.data_readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.dev.marcelodeoliveira.core.context.TestContext;
import br.dev.marcelodeoliveira.core.utils.enums.FileFormatConstants.WorkBookFormats;

public class ExcelReader extends AbstractReader {

    Workbook wb;
    WorkBookFormats excelFormat;
    private static final int FIRST_SHEET_INDEX = 0;

    public ExcelReader(String xlsDataSourcePath) {
	super(xlsDataSourcePath);
	excelFormat = TestContext.getConfigFileReader().getDataSourceFormat();
	setupReading();
    }

    public ExcelReader() {
	this(TestContext.getConfigFileReader().getDataSource());
    }

    @Override
    protected void setupReading() {

	try {
	    switch (getExcelFormat()) {
	    case XLS: {
		wb = new HSSFWorkbook(new FileInputStream(this.configPath));
		break;
	    }
	    case XLSX:
	    default: {
		wb = new XSSFWorkbook(new FileInputStream(this.configPath));
		break;
	    }
	    }
	} catch (FileNotFoundException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();
	}

    }

    private WorkBookFormats getExcelFormat() {
	if (excelFormat == null) {
	    excelFormat = TestContext.getConfigFileReader().getDataSourceFormat();
	}
	return excelFormat;
    }

    public Workbook getWorkBook() {
	return wb;
    }

    public Sheet getSheet(String sheetName) {
	return wb.getSheet(sheetName);
    }

    public Sheet getConfigSettingSheet() {
	return wb.getSheet(TestContext.getConfigFileReader().getDefaulSheetName());
    }

    public Sheet getSheetAt(int index) {
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