package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormSubmitPage extends BasePage {

	@FindBy(css = "input.first_name")
	private WebElement nameInput;
	@FindBy(css = "input.last_name")
	private WebElement surnameInput;
	@FindBy(css = "input.business_name")
	private WebElement companyInput;
	@FindBy(css = "input.email")
	private WebElement emailInput;

	@FindBy(id = "numb1")
	private WebElement numb1;
	@FindBy(id = "numb2")
	private WebElement numb2;

	@FindBy(id = "number")
	private WebElement enigmaSolutionInput;
	@FindBy(id = "submit")
	private WebElement submitButton;

}
