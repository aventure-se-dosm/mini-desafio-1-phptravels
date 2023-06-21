package br.dev.marcelodeoliveira.model.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;

import br.dev.marcelodeoliveira.model.formsubmit.UserFormDTO;

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

    public String getStringCellValue(XSSFCell cell) {
	switch (cell.getCellType()) {
	case STRING:
	case FORMULA:
	    return cell.getStringCellValue();
	case BOOLEAN:
	    return String.valueOf(cell.getBooleanCellValue());
	case ERROR:
	    return String.valueOf(cell.getErrorCellValue());
	case NUMERIC:
	    return String.valueOf(cell.getNumericCellValue());
	default: {
	    cell.setCellType(CellType.STRING);
	    return getStringCellValue(cell);
	}
	}
    }
}
