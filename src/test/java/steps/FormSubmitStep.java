package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;
import pages.FormSubmitPage;
import testutils.Screenshoter;

public class FormSubmitStep{

	private static final String START_URL = "https://phptravels.com/demo/";
	private static WebDriver driver;

	public static Boolean status;
	private Screenshoter screeenshoter;

	private final static String DEFAULT_EXTENSION = ".png";
	private final static String DEFAULT_DESTINATION_DIRECTORY = "./target/Screenshots/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_hh_mm_ss";

	private void testHasPassed() {
		this.status = true;

	}


	
	// Injeção: quedê o PC?
	// @FindBy(css = "input.first_name")
	public WebElement nameInput;

	// @FindBy(css = "input.last_name")
	public WebElement surnameInput;

	// @FindBy(css = "input.business_name")
	public WebElement businessNameInput;

	// @FindBy(css = "input.email")
	public WebElement emailInput;

	// @FindBy(css = "h2.mw100")
	public WebElement enigmaExpression;

	// @FindBy(id = "numb1")
	public WebElement numb1;

	// @FindBy(id = "numb2")
	public WebElement numb2;

	// @FindBy(id = "number")
	public WebElement solutionInput;

	// @FindBy(id = "demo")
	public WebElement submitButton;

	// @FindBy(xpath = "//strong[contains(.,'Thank you!')]")
	public WebElement thankYouMessage;

	//@FindBy(css = "p.text-center.cw")
	public WebElement confirmationMailCheckMessage;
	
	private static FormSubmitPage page;
	
	public FormSubmitStep() {
		driver = DriverManager.getDriver();
		page = new FormSubmitPage(driver);
	}

	@Before
	public void acessaPagina() {
		driver = WebDriverManager.getInstance("Chrome").create();
		System.out.println("Passou pelo inicializaDriver");
		System.out.println("Passou pelo inicializaDriver");
		setScreenshoter();
	}

	private void setScreenshoter() {
		this.screeenshoter = new Screenshoter(driver);
	}

	@Dado("que estou na página de demonstração")
	public void que_estou_na_página_de_demonstração() {
		driver.get(START_URL);
	}

	@Quando("eu insiro o nome do usuário {string}")
	public void eu_insiro_o_nome_do_usuário(String name) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nameInput = driver.findElement(By.cssSelector("input.first_name"));

		nameInput.sendKeys(name);
		Assert.assertNotNull(nameInput);
	}

	@E("insiro o sobrenome {string}")
	public void insiro_o_sobrenome(String surname) {
//		surnameInput = driver.findElement(By.cssSelector("input.last_name"));
//		surnameInput.click();
//		surnameInput.sendKeys(surname);
		
		page.preencheNome(surname);
	}

	@E("insiro o e-mail {string}")
	public void insiro_o_e_mail(String email) {
		emailInput = driver.findElement(By.cssSelector("input.email"));
		emailInput.sendKeys(email);
	}

	@E("insiro o nome de sua empresa {string}")
	public void insiro_o_nome_de_sua_empresa(String businessName) {
		businessNameInput = driver.findElement(By.cssSelector("input.business_name"));
		businessNameInput.sendKeys(businessName);
	}

	@E("soluciono o enigma")
	public void soluciono_o_enigma() {
		solutionInput = driver.findElement(By.id("number"));
		solutionInput.sendKeys(solveEnigma());
	}

	@E("clico em submeter")
	public void clico_em_submeter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		submitButton = driver.findElement(By.id("demo"));
		submitButton = submitButton.findElement(By.xpath("./../*"));
		submitButton.click();

		

	}

	@Então("As informações foram enviadas com sucesso!")
	public void as_informações_foram_enviadas_com_sucesso() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		confirmationMailCheckMessage = driver.findElement(By.cssSelector("p.text-center.cw"));
		Assert.assertTrue(confirmationMailCheckMessage.isDisplayed());
		testHasPassed();

	}

	private String solveEnigma() {
		Integer result = 0;

		numb1 = driver.findElement(By.id("numb1"));
		numb2 = driver.findElement(By.id("numb2"));

		result += Integer.parseInt(numb1.getText());
		result += Integer.parseInt(numb2.getText());

		return result.toString();
	}


	@After
	public static void takeScreenshot(Scenario s) {
		Screenshoter.takeScreenshot(s);
	}
}
