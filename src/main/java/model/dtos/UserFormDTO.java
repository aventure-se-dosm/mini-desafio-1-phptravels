package model.dtos;

import org.apache.poi.ss.usermodel.Row;

import core.utils.enums.DataAttributes;

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

		this.firstName = row.getCell(DataAttributes.FIRST_NAME.getIndex()).getStringCellValue();
		this.lastName = row.getCell(DataAttributes.LAST_NAME.getIndex()).getStringCellValue();
		this.businessName = row.getCell(DataAttributes.BUSINESS_NAME.getIndex()).getStringCellValue();
		this.emailAddress = row.getCell(DataAttributes.EMAIL_ADDRESS.getIndex()).getStringCellValue();

	}

}
