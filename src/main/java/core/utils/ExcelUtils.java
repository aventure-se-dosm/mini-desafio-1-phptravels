package core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import model.dtos.UserFormDTO;

public class ExcelUtils {

    public static List<UserFormDTO> getAllUsersList(Sheet sheet) {

	List<UserFormDTO> userFormList = new ArrayList<>();

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
