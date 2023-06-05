package core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import model.dtos.UserFormDTO;

public class ExcelUtils {

    public static List<UserFormDTO> getAllUsersList(XSSFSheet sheet) {

	List<UserFormDTO> userFormList = new ArrayList<>();

	try {
	    userFormList = new ArrayList<>();
	    Iterator<Row> rowIterator = sheet.iterator();
	    rowIterator.hasNext();
	    while (rowIterator.hasNext()) {
		XSSFRow row = (XSSFRow) rowIterator.next();
		userFormList.add(new UserFormDTO(row));
	    }

	} catch (IllegalArgumentException iaexcp) {
	    iaexcp.printStackTrace();
	}
	return userFormList;

    }

}
