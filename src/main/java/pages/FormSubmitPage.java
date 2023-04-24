package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import TestDataTypes.UserFormDTO;

public class FormSubmitPage {

	private final WebDriver driver;

	private FluentWait<WebDriver> elemIsPresent, isElemClickable;

	public FormSubmitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elemIsPresent = new FluentWait<WebDriver>(this.driver);
		isElemClickable = new FluentWait<WebDriver>(this.driver);
	}

	@FindBys( { @FindBy(css = "input.last_name")})
	public WebElement nameInput;

	@FindBy(css = "input.last_name")
	public WebElement surnameInput;

	@FindBy(css = "input.business_name")
	public WebElement businessNameInput;

	@FindBy(css = "input.email")
	public WebElement emailInput;

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

	public void preencheFormCompleto(UserFormDTO userFormDTO) {
		escreveNome(userFormDTO.getName());
		escreveSobrenome(userFormDTO.getSurname());
		escreveCompania(userFormDTO.getBusinessName());
        escreveEmail(userFormDTO.getEmail());	
	}

	public void escreveNome(String nome) {
		elemIsPresent.pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(1))
				.until(ExpectedConditions.visibilityOf(nameInput));
		nameInput.sendKeys(nome);
	}

	public void escreveSobrenome(String sobrenome) {

		surnameInput.sendKeys(sobrenome);
	}

	public void escreveCompania(String companhia) {

		businessNameInput.sendKeys(companhia);
	}

	public void escreveEmail(String email) {

		emailInput.sendKeys(email);
	}

	public void solucionaEnigmaEEscreveOResultado() {

		isElemClickable.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofMinutes(1))
				.until(ExpectedConditions.visibilityOf(solutionInput));
		solutionInput.sendKeys(solveEnigma());
	}

	public void submitForm() {

		isElemClickable.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofMinutes(1))
				.until(ExpectedConditions.elementToBeClickable(submitButton));

		submitButton.click();
	}

	public boolean formHasBeenSubmitedSuccessifully() {

		try {
			elemIsPresent.pollingEvery(Duration.ofMillis(2000)).withTimeout(Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(confirmationMailCheckMessage));
			return true;
		} catch (TimeoutException texcp) {
			return false;
		}
	}

	public String solveEnigma() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Integer result = 0;
		result += Integer.parseInt(numb1.getText());
		result += Integer.parseInt(numb2.getText());
		return result.toString();
	}

	public String getAlertMessage() throws Exception {
		
		Alert alert = elemIsPresent.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(2))
				.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
		String alertMesage = alert.getText();
		alert.accept();
		return alertMesage;
	}
}
