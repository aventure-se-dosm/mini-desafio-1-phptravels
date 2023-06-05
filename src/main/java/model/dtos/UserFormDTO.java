package model.dtos;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import model.utils.enums.UserDataAttributes;

public class UserFormDTO {

    private String id, firstName, lastName, businessName, emailAddress;
    private XSSFRow row;

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

    private String getStringValue(XSSFCell cell) {
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

    private String setAttribute(UserDataAttributes attribute) {
	return getStringValue(row.getCell(attribute.getIndex()));
    }

    public UserFormDTO(XSSFRow row) {
	this.row = row;
	setAttributes();
    }

    private void setAttributes() {
	setId();
	setFirstName();
	setLastName();
	setBusinessName();
	setEmailAddress();
    }

    private void setId() {
	this.id = setAttribute(UserDataAttributes.ID);
    }

    private void setFirstName() {
	this.firstName = setAttribute(UserDataAttributes.FIRST_NAME);
    };

    private void setLastName() {
	this.lastName = setAttribute(UserDataAttributes.LAST_NAME);
    };

    private void setBusinessName() {
	this.businessName = setAttribute(UserDataAttributes.BUSINESS_NAME);
    };

    private void setEmailAddress() {
	this.emailAddress = setAttribute(UserDataAttributes.EMAIL_ADDRESS);
    };
}
