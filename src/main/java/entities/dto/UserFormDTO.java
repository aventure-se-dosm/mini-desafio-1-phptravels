package entities.dto;

import org.apache.poi.ss.usermodel.Row;

public class UserFormDTO {

	private enum formFields {

		FIRST_NAME(0), LAST_SURNAME(1), BUSINESS_NAME(2), EMAIL_ADDRESS(3);

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
		this.lastName = row.getCell(formFields.LAST_SURNAME.index).getStringCellValue();
		this.businessName = row.getCell(formFields.BUSINESS_NAME.index).getStringCellValue();
		this.emailAddress = row.getCell(formFields.EMAIL_ADDRESS.index).getStringCellValue();

	}

}
