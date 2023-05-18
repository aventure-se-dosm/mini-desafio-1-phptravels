package core.dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.managers.FileReaderManager;
import model.dtos.UserFormDTO;

public class ExcelXLSXReader extends AbstractReader {

	XSSFWorkbook wb;

	public ExcelXLSXReader(String xlsDataSourcePath) {
		super(xlsDataSourcePath);
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