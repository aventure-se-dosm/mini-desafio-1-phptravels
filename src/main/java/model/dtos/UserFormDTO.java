package model.dtos;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import model.utils.enums.UserDataAttributes;

public class UserFormDTO {

    private String id, firstName, lastName, businessName, emailAddress;

    public String getTxtFieldValue(UserDataAttributes attribute) {
	switch (attribute) {
	case ID:
	default:
	    return getId();
	case FIRST_NAME:
	    return getFirstName();
	case LAST_NAME:
	    return getLastName();
	case BUSINESS_NAME:
	    return getBusinessName();
	case EMAIL_ADDRESS:
	    return getEmailAddress();
	}
    }

    private String getId() {
	return id;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;

    }

    public String getBusinessName() {
	return businessName;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    private String getStringValue(Cell cell) {
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
	    return getStringValue(cell);
	}
	}

    }

    public UserFormDTO(Row row) {

	this.id = getStringValue(row.getCell(UserDataAttributes.ID.getIndex()));
	this.firstName = getStringValue(row.getCell(UserDataAttributes.FIRST_NAME.getIndex()));
	this.lastName = getStringValue(row.getCell(UserDataAttributes.LAST_NAME.getIndex()));
	this.businessName = getStringValue(row.getCell(UserDataAttributes.BUSINESS_NAME.getIndex()));
	this.emailAddress = getStringValue(row.getCell(UserDataAttributes.EMAIL_ADDRESS.getIndex()));

    }

}
