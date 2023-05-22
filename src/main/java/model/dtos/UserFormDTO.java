package model.dtos;

import org.apache.poi.ss.usermodel.Row;

public class UserFormDTO {

	private enum formFields {

		ID(0), FIRST_NAME(1), LAST_NAME(2), BUSINESS_NAME(3), EMAIL_ADDRESS(4);

		private int index;

		private formFields(int index) {
			this.index = index;
		}

	}

	
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
		this.firstName = row.getCell(formFields.FIRST_NAME.index).getStringCellValue();
		this.lastName = row.getCell(formFields.LAST_NAME.index).getStringCellValue();
		this.businessName = row.getCell(formFields.BUSINESS_NAME.index).getStringCellValue();
		this.emailAddress = row.getCell(formFields.EMAIL_ADDRESS.index).getStringCellValue();

	}

}
