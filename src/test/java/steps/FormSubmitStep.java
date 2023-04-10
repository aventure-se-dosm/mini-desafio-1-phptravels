package steps;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.FormSubmitPage;
import testutils.Screenshoter;

public class FormSubmitStep {

	private static final String START_URL = "https://phptravels.com/demo";
	private WebDriver driver;
	// private DriverManager drvMgr;
//
	public static Boolean status;

	private final static String DEFAULT_EXTENSION = ".png";
	private final static String DEFAULT_DESTINATION_DIRECTORY = "./target/Screenshots/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_hh_mm_ss";

	private WebElement numb1;
	private WebElement numb2;
	private WebElement confirmationMailCheckMessage;
	private FormSubmitPage page;
	private FluentWait<WebDriver> elemIsPresent;

	public FormSubmitStep() {
		this.driver = new ChromeDriver();
		this.elemIsPresent = new FluentWait<WebDriver>(driver);
	}

	@Before
	public void acessaPagina() {
		System.out.println("Passou pelo inicializaDriver");
		System.out.println("Passou pelo inicializaPagina");
	}

	@Dado("que estou na página de demonstração")
	public void que_estou_na_página_de_demonstração() {
		driver.get(START_URL);
	}

	@Quando("eu insiro o nome do usuário {string}")
	public void eu_insiro_o_nome_do_usuário(String nome) {

		page = new FormSubmitPage(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		page.escreveNome(nome);

	}

	@E("insiro o sobrenome {string}")
	public void insiro_o_sobrenome(String surname) {

		page.escreveSobrenome(surname);
	}

	@E("insiro o e-mail {string}")
	public void insiro_o_e_mail(String email) {
		page.escreveEmail(email);
	}

	@E("insiro o nome de sua empresa {string}")
	public void insiro_o_nome_de_sua_empresa(String businessName) {
		page.escreveCompania(businessName);
	}

	@E("soluciono o enigma")
	public void soluciono_o_enigma() {
//		solutionInput = driver.findElement(By.id("number"));
//		solutionInput.sendKeys(solveEnigma());		
		page.escreveResultado(solveEnigma());

	}

	@E("clico em submeter")
	public void clico_em_submeter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		page.submitForm();
	}

	@Então("As informações foram enviadas com sucesso!")
	public void as_informações_foram_enviadas_com_sucesso() {

		Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());

	}

	private String solveEnigma() {
		Integer result = 0;

		numb1 = driver.findElement(By.id("numb1"));
		numb2 = driver.findElement(By.id("numb2"));

		result += Integer.parseInt(numb1.getText());
		result += Integer.parseInt(numb2.getText());

		return result.toString();
	}

	private static String stringDaData() {
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

	@After
	public void takeScreenshot(Scenario s) {

		Screenshoter screenshoter = new Screenshoter(driver);

		String result = (s.getStatus() == Status.PASSED ? "SUCESSO" : "FALHOU");
		String id = s.getName().split(" ")[0];
		String shotFileName = String.join("_", id, stringDaData(), result);
		screenshoter.makeScreenshot(DEFAULT_DESTINATION_DIRECTORY, shotFileName, DEFAULT_EXTENSION);
	}
}
