package core.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.managers.FileReaderManager;
import core.utils.ExcelUtils;

public class ExcelXLSXReader extends AbstractReader {

	XSSFWorkbook wb;
	ExcelUtils excelUtils;

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
		}
		this.excelUtils = new ExcelUtils(wb);
	}

	public ExcelXLSXReader() {
		// outra ideia: deixar enum de properties:
		this(FileReaderManager.getGlobalProperty("XLSX_DATA_SOURCE"));
	}

	@Override
	protected void setupReading() {

		try {
			wb = new XSSFWorkbook(new FileInputStream(readedFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block - create your own pertinent
			// excepMessages!
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block - create your own pertinent
			// excepMessages!
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