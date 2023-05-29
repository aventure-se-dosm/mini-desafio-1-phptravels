package core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import core.dataProviders.UserDataMethods;
import core.managers.FileReaderManager;
import core.utils.enums.UserDataAttributes;
import core.utils.exceptions.InvalidDataAttributeException;
import model.dtos.UserFormDTO;

public class ExcelUtils implements UserDataMethods {

    private Sheet sheet;

    public ExcelUtils(Workbook wb) {

	this.sheet = wb.getSheet(FileReaderManager.getXLSXDataSource());
    }

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

    @Override
    public String searchForIndex(String id) {
	return searchForAttribute(UserDataAttributes.ID, id);
    }

    @Override
    public String searchForAttribute(UserDataAttributes attribute, String value) {

	Iterator<Row> rowIterator = sheet.iterator();
	rowIterator.hasNext();
	String readString;
	while (rowIterator.hasNext()) {
	    Row row = rowIterator.next();
	    if ((readString = row.getCell(attribute.getIndex()).getStringCellValue()).equals(value))
		return readString;
	}

	throw new InvalidDataAttributeException(attribute.toString());

    }

    @Override
    public String searchForFirstName(String firstName) {
	return searchForAttribute(UserDataAttributes.FIRST_NAME, firstName);
    }

    @Override
    public String searchForLastName(String lastName) {
	return searchForAttribute(UserDataAttributes.LAST_NAME, lastName);
    }

    @Override
    public String searchForEmailAddress(String emailAddress) {
	return searchForAttribute(UserDataAttributes.EMAIL_ADDRESS, emailAddress);
    }

    @Override
    public String searchForBusinessName(String businessName) {
	return searchForAttribute(UserDataAttributes.BUSINESS_NAME, businessName);
    }

}
