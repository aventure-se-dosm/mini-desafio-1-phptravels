package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FormSubmitPage {

	// for screenshot functionality only
	private final WebDriver driver;

	private FluentWait<WebDriver> elemIsPresent;

	private final static String DEFAULT_EXTENSION = ".png";
	private final static String DEFAULT_DESTINATION_DIRECTORY = "./target/Screenshots/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_hh_mm_ss";

	// the passed driver would be also necessariy if not screeshoting though.
	public FormSubmitPage(WebDriver driver) {

		// for screenshot functionality only
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elemIsPresent = new FluentWait<WebDriver>(this.driver);
	}

	@FindBy(css = "input.first_name")
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

	// ...algum construtor ...

	public void escreveNome(String nome) {
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

	public void escreveResultado(String resultado) {
		solutionInput.sendKeys(resultado);
	}

	public void submitForm() {
		submitButton.click();

		// pôr espera adequada!
//		try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
	}

	// ele deveria ser mais espertinho: capturar o sinal
	// pra depois decidir qual operação realizar.
	private String solveEnigma() {
		Integer result = 0;

		result += Integer.parseInt(numb1.getText());
		result += Integer.parseInt(numb2.getText());

		return result.toString();
	}

	private String stringDaData() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_AVAL_1));
	}

	public void makeScreenshot(String destination, String filename, String extension) {

		File shot;
		shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(shot, new File((destination + filename + extension)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean formHasBeenSubmitedSuccessifully() {
		// TODO Auto-generated method stub
		try {
			elemIsPresent.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofMinutes(1))
					.until(ExpectedConditions.visibilityOf(confirmationMailCheckMessage));

			return true;

		} catch (TimeoutException texcp) {
			return false;
		}
	}
}
