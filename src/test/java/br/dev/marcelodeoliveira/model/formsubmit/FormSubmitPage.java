package br.dev.marcelodeoliveira.model.formsubmit;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.dev.marcelodeoliveira.core.utils.FormularioDTO;
import br.dev.marcelodeoliveira.model.pages.AbstractPage;

public class FormSubmitPage extends AbstractPage {

    public FormSubmitPage(WebDriver wdriver) {
	super(wdriver);
	this.driver = wdriver;
    }

    @FindBy(css = "input.first_name")
    public WebElement txtFirstName;

    @FindBy(css = "input.last_name")
    public WebElement txtLastName;

    @FindBy(css = "input.business_name")
    public WebElement txtBusinessName;

    @FindBy(css = "input.email")
    public WebElement txtEmailAddress;

    @FindBy(css = "h2.mw100")
    public WebElement txtEnigmaExpression;

    @FindBy(id = "numb1")
    public WebElement btnArithmeticOperatior1numb1;

    @FindBy(id = "numb2")
    public WebElement btnArithmeticOperatior1numb2;

    @FindBy(id = "number")
    public WebElement txtSolution;

    @FindBy(id = "demo")
    public WebElement btnSubmit;

    @FindBy(xpath = "//strong[contains(.,'Thank you!')]")
    public WebElement lblMsgthankYou;

    @FindBy(css = "p.text-center.cw")
    public WebElement labMsgconfirmationMailCheck;

    @FindBy(xpath = "//div[contains(@class,'pace-inactive')]")
    public WebElement pageLoadingPaceActivity;

    public void writeFirstName(String firstName) {
	writeText(txtFirstName, firstName);
    }

    public void writeLastName(String lastName) {
	writeText(txtLastName, lastName);
    }

    public void writeBusinessName(String businessName) {
	writeText(txtBusinessName, businessName);
    }

    public void writeEmailAddress(String emailAddress) {
	writeText(txtEmailAddress, emailAddress);
    }

	public void fillUserForm(FormularioDTO userForm) {

	writeFirstName(userForm.getFirstName());
	writeLastName(userForm.getLastName());
	writeBusinessName(userForm.getBusinessName());
	writeEmailAddress(userForm.getEmailAddress());
    }

    public void solveEnigmaAndWriteTheSolution() {
	writeText(txtSolution, solveEnigma());
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
