package model.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.managers.FileReaderManager;
import model.dtos.UserFormDTO;

public class FormSubmitPage extends Page {

	private WebDriver driver;
	// private FluentWait<WebDriver> elemIsPresent, isElemClickable;

	public FormSubmitPage(WebDriver wdriver) {
		super(wdriver);
		this.driver = wdriver;

	}

	@FindBy(css = "input.first_name")
	public WebElement txtFirstNameInput;

	@FindBy(css = "input.last_name")
	public WebElement txtLastNameInput;

	@FindBy(css = "input.business_name")
	public WebElement txtBusinessNameInput;

	@FindBy(css = "input.email")
	public WebElement txtEmailAddressInput;

	@FindBy(css = "h2.mw100")
	public WebElement txtEnigmaExpression;

	@FindBy(id = "numb1")
	public WebElement btnArithmeticOperatior1numb1;

	@FindBy(id = "numb2")
	public WebElement btnArithmeticOperatior1numb2;

	@FindBy(id = "number")
	public WebElement txtSolutionInput;

	@FindBy(id = "demo")
	public WebElement btnSubmit;

	@FindBy(xpath = "//strong[contains(.,'Thank you!')]")
	public WebElement lblMsgthankYou;

	@FindBy(css = "p.text-center.cw")
	public WebElement labMsgconfirmationMailCheck;

	@FindBy(xpath = "//div[contains(@class,'pace-inactive')]")
	public WebElement pageLoadingPaceActivity;

	public void startNavigation() {

//		O uso e o gere. do WebDriver não deveria ser 
//		feito por métodos do WebDriverManager?
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		driver.get(FileReaderManager.getDefaultStartingUrl());
	}

	public void writeFirstName(String firstName) {
		writeText(txtFirstNameInput, firstName);
	}

	public void writeLastName(String lastName) {
		writeText(txtLastNameInput, lastName);
	}

	public void writeBusinessName(String businessName) {
		writeText(txtBusinessNameInput, businessName);
	}

	public void writeEmailAddress(String emailAddress) {
		writeText(txtEmailAddressInput, emailAddress);
	}

	public void fillUserForm(UserFormDTO udf) {

		writeFirstName(udf.getFirstName());
		writeLastName(udf.getLastName());
		writeBusinessName(udf.getBusinessName());
		writeEmailAddress(udf.getEmailAddress());
	}

	public void solveEnigmaAndWriteTheSolution() {
		txtSolutionInput.sendKeys(solveEnigma());
	}

	public String submitForm() throws UnhandledAlertException {
		clickOnElement(btnSubmit);
		return getAlertMessage();

	}

	public boolean formHasBeenSubmitedSuccessifully() {

		try {

			waits.waitUntilElementIsVisible(lblMsgthankYou);
			return true;
		} catch (TimeoutException texcp) {
			return false;
		}
	}

	public String solveEnigma() {

		Integer result = 0;
		result += Integer.parseInt(btnArithmeticOperatior1numb1.getText());
		result += Integer.parseInt(btnArithmeticOperatior1numb2.getText());

		return result.toString();
	}

//	public String getAlertMessage() {
//		String alertMesage = "";
//		try {
//
//			Alert alert = elemIsPresent.pollingEvery(Duration.ofMillis(50)).withTimeout(Duration.ofMillis(50))
//					.ignoring(Exception.class).until(ExpectedConditions.alertIsPresent());
//			alertMesage = alert.getText();
//			alert.accept();
//			return alertMesage;
//		} catch (TimeoutException t) {
//			return alertMesage;
//		}
//
//	}
}
