package core.utils.exceptions;

import org.openqa.selenium.InvalidArgumentException;

public class InvalidDataAttributeException extends InvalidArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7325184604870424614L;
	private static final String rawAttribute = "##ATTRIBUTE##";
	private static final String emptyString = "";

	private static String message = "Invalid Data Attribute: ##ATTRIBUTE## is not present on the Data table";

	public InvalidDataAttributeException(String attribute) {
		super(setMessage(attribute));
		// TODO Auto-generated constructor stub
	}
	public InvalidDataAttributeException() {
		super(setMessage(emptyString));
		// TODO Auto-generated constructor stub
	}

	private static String setMessage(String attribute) {
		return message.replace(rawAttribute, attribute);
	}

}
