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

import model.dtos.UserFormDTO;

public class ExcelReader {

	// DEVE SER PASSADO POR CONFIG!
	private static final String XLSX_DATA_SOURCE = ".\\src\\main\\resources\\DATA_SPREADSHEET.xlsx";
	private static String xlsDataSourcePath;
	// private ArrayList<UserFormDTO> userFormList;

	XSSFWorkbook wb;

	public ExcelReader(String xlsDSPath) {
		xlsDataSourcePath = xlsDSPath;
		try {
			wb = new XSSFWorkbook(new FileInputStream(xlsDataSourcePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ExcelReader() {
		this(XLSX_DATA_SOURCE);
	}




	public List<UserFormDTO> getAllUsersList() {

		List<UserFormDTO> userFormList = new ArrayList<>();

		XSSFWorkbook wb;
		try {
			// pegar da propriedade
			wb = new XSSFWorkbook(new FileInputStream(xlsDataSourcePath));
			XSSFSheet sheet = wb.getSheetAt(0);
			userFormList = new ArrayList<>();
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.hasNext();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				userFormList.add(new UserFormDTO(row));

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return userFormList;

	}

	public XSSFWorkbook getWorkBook() {
		// TODO Auto-generated method stub
		return null;
	}
}