package model.dtos;

import org.apache.poi.ss.usermodel.Row;

import model.utils.enums.UserDataAttributes;

public class UserFormDTO {

    private String firstName, lastName, businessName, emailAddress;

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

    public UserFormDTO(Row row) {

	this.firstName = row.getCell(UserDataAttributes.FIRST_NAME.getIndex()).getStringCellValue();
	this.lastName = row.getCell(UserDataAttributes.LAST_NAME.getIndex()).getStringCellValue();
	this.businessName = row.getCell(UserDataAttributes.BUSINESS_NAME.getIndex()).getStringCellValue();
	this.emailAddress = row.getCell(UserDataAttributes.EMAIL_ADDRESS.getIndex()).getStringCellValue();

    }

}
