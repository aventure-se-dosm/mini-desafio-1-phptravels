package model.pages;

import java.time.Duration;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.managers.FileReaderManager;
import model.dtos.UserFormDTO;

public class FormSubmitPage extends Page {

    private WebDriver driver;

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

	driver.manage().window().maximize();
	PageFactory.initElements(driver, this);
	driver.get(FileReaderManager.getDefaultStartingUrl());
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
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

    public void fillUserForm(UserFormDTO userDataForm) {

	writeFirstName(userDataForm.getFirstName());
	writeLastName(userDataForm.getLastName());
	writeBusinessName(userDataForm.getBusinessName());
	writeEmailAddress(userDataForm.getEmailAddress());
    }

    public void solveEnigmaAndWriteTheSolution() {
	writeText(txtSolutionInput, solveEnigma());
    }

    public String submitForm() throws UnhandledAlertException {
	clickOnElement(btnSubmit);
	return getAlertMessage();
    }

    public boolean formHasBeenSubmitedSuccessifully() {
	return waits.waitUntilElementIsVisible(lblMsgthankYou);
    }

    public String solveEnigma() {

	Integer result = 0;
	result += Integer.parseInt(getText(btnArithmeticOperatior1numb1));
	result += Integer.parseInt(getText(btnArithmeticOperatior1numb2));

	return result.toString();
    }

}
