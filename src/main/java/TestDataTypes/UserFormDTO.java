package TestDataTypes;

import org.apache.poi.ss.usermodel.Row;

public class UserFormDTO {

	private enum formFields {
		NAME(0), SURNAME(1), BUSINESS_NAME(2), EMAIL(3);

		private int index;

		private formFields(int index) {
			this.index = index;
		}

	}

	private String name, surname, businessName, email;

	public String getUserFormFirstName() {
		return name;
	}

	public String getUserFormLastName() {
		return surname;
	}

	public String getUserFormBusinessName() {
		return businessName;
	}

	public String getUserFormEmail() {
		return email;
	}

	public UserFormDTO(Row row) {
		this.name = row.getCell(formFields.NAME.index).getStringCellValue();
		this.surname = row.getCell(formFields.SURNAME.index).getStringCellValue();
		this.businessName = row.getCell(formFields.BUSINESS_NAME.index).getStringCellValue();
		this.email = row.getCell(formFields.EMAIL.index).getStringCellValue();
	}

}
