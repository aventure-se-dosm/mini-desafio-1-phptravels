
package br.dev.marcelodeoliveira.core.utils;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import br.dev.marcelodeoliveira.model.utils.enums.UserDataAttributes;

public class FormularioDTO extends AbstractDTO {

	private String id, firstName, lastName, businessName, emailAddress;

	public FormularioDTO(Row row) {
		super(row);
		this.row = row;
		setAttributes();
	}

	public String getId() {
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
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case ERROR:
			return String.valueOf(cell.getErrorCellValue());
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BLANK:
		case _NONE:
		case STRING:
		case FORMULA:
		default: {
			return cell.getStringCellValue();

		}
		}
	}

	private String setAttribute(UserDataAttributes attribute) {
		return getStringValue(row.getCell(attribute.getIndex()));
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

	public String getStringCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case FORMULA:
			return cell.getStringCellValue();
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case ERROR:
			return String.valueOf(cell.getErrorCellValue());
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case STRING:
		case BLANK:
		case _NONE:
		default: {
			cell.setCellStyle((CellStyle) CellFormatType.TEXT);
			return cell.getStringCellValue();
		}
		}
	}

}
