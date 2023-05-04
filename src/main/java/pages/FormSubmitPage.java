package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FormSubmitPage {

	private final WebDriver driver;

	private FluentWait<WebDriver> elemIsPresent, isElemClickable;

	public FormSubmitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elemIsPresent = new FluentWait<WebDriver>(this.driver);
		isElemClickable = new FluentWait<WebDriver>(this.driver);
	}

	@FindBy(css = "input.first_name")
	public WebElement firstNameInput;

	@FindBy(css = "input.last_name")
	public WebElement lastNameInput;

	@FindBy(css = "input.business_name")
	public WebElement businessNameInput;

	@FindBy(css = "input.email")
	public WebElement emailAddressInput;

	@FindBy(css = "h2.mw100")
	public WebElement enigmaExpression;

	@FindBy(id = "numb1")
	public WebElement numb1;

	@FindBy(id = "numb2")
	public WebElement numb2;

	@FindBy(id = "number")
	public WebElement solutionInput;

	@FindBy(id = "demo")
	public WebElement submitButton;

	@FindBy(xpath = "strong[contains(.,'Thank you!')]")
	public WebElement thankYouMessage;

	@FindBy(css = "p.text-center.cw")
	public WebElement confirmationMailCheckMessage;

	@FindBy(xpath = "//div[contains(@class,'pace-inactive')]")
	public WebElement pageLoadingPaceActivity;

	public void writeFirstName(String firstName) {
		elemIsPresent.pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(1))
				.until(ExpectedConditions.visibilityOf(firstNameInput));
		firstNameInput.sendKeys(firstName);
	}

	public void writeLastName(String lastName) {

		lastNameInput.sendKeys(lastName);
	}

	public void writeBusinessName(String businessName) {

		businessNameInput.sendKeys(businessName);
	}

	public void writeEmailAddress(String emailAddress) {

		emailAddressInput.sendKeys(emailAddress);
	}

	public void fillUserForm(entities.dto.UserFormDTO udf) {

		writeFirstName(udf.getFirstName());
		writeLastName(udf.getLastName());
		writeEmailAddress(udf.getEmailAddress());
		writeBusinessName(udf.getBusinessName());
	}

	public void solveEnigmaAndWriteTheSolution() {

		isElemClickable.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofMinutes(1))
				.until(ExpectedConditions.visibilityOf(solutionInput));
		solutionInput.sendKeys(solveEnigma());
	}

	public String submitForm() throws UnhandledAlertException {

		String alertMessage = "";
		isElemClickable.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofMinutes(1))
				.until(ExpectedConditions.elementToBeClickable(submitButton));

		submitButton.click();
		Alert alert = elemIsPresent.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(2))
				.ignoring(NoAlertPresentException.class, TimeoutException.class)
				.until(ExpectedConditions.alertIsPresent());
		if (alert != null) {
			try {
				alertMessage = getAlertMessage();
			} catch (Exception e) {
				return alertMessage;
			}

		}
		return alertMessage;
	}

	public boolean formHasBeenSubmitedSuccessifully() {

		try {
			elemIsPresent.pollingEvery(Duration.ofMillis(2000)).withTimeout(Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOf(confirmationMailCheckMessage));
			return true;
		} catch (TimeoutException texcp) {
			return false;
		}
	}

	public String solveEnigma() {

		Integer result = 0;
		result += Integer.parseInt(numb1.getText());
		result += Integer.parseInt(numb2.getText());

		return result.toString();
	}

	public String getAlertMessage() {
		String alertMesage = "";
		try {
			Alert alert = elemIsPresent.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(2))
					.ignoring(NoAlertPresentException.class, TimeoutException.class)
					.until(ExpectedConditions.alertIsPresent());
			alertMesage = alert.getText();
			alert.dismiss();
			return alertMesage;
		} catch (TimeoutException t) {
			return alertMesage;
		}
	}
}
