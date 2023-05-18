package core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import model.dtos.UserFormDTO;

public class ExcelUtils {
	
	
	
	//tá muito Regra de negócio pra estar no CORE
	public static List<UserFormDTO> getAllUsersList(XSSFSheet sheet) {

		List<UserFormDTO> userFormList = new ArrayList<>();

		// pegar da propriedade
		// wb = new XSSFWorkbook(new FileInputStream(xlsDataSourcePath));
		try {
			
			userFormList = new ArrayList<>();
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.hasNext();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				userFormList.add(new UserFormDTO(row));
			}

		} catch (IllegalArgumentException iaexcp) {
			iaexcp.printStackTrace();
		}
		return userFormList;

	}

}
