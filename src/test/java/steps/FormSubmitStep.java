package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PageUtils;

public class FormSubmitStep {

	private static final String START_URL = "https://phptravels.com/demo/";

	private static WebDriver driver;

	// Injeção: quedê o PC?
	@FindBy(css = "input.first_name")
	public static WebElement nameInput;

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

	@FindBy(xpath = "//strong[contains(.,'Thank you!')]")
	public WebElement thankYouMessage;

	@FindBy(css = "p.text-center.cw")
	public WebElement confirmationMailCheckMessage;

	public FormSubmitStep() {

	}

	@Before
	public void acessaPagina() {
		WebDriverManager.getInstance("Chrome").setup();
		driver = WebDriverManager.getInstance("Chrome").create();
		driver.manage().window().maximize();
		System.out.println("Passou pelo inicializaDriver");
		System.out.println("Passou pelo inicializaDriver");

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
		surnameInput = driver.findElement(By.cssSelector("input.last_name"));
		surnameInput.click();
		surnameInput.sendKeys(surname);
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

		//geUtils pg = new PageUtils(driver);
		submitButton = driver.findElement(By.id("demo"));
		submitButton = submitButton.findElement(By.xpath("./../*"));
		//.ScrollToElement(submitButton);
		submitButton.click();
	}

	@Então("As informações foram enviadas com sucesso!")
	public void as_informações_foram_enviadas_com_sucesso() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		confirmationMailCheckMessage = driver.findElement(By.cssSelector("p.text-center.cw"));
		Assert.assertTrue(confirmationMailCheckMessage.isDisplayed());
	}

	private String solveEnigma() {
		Integer result = 0;

		numb1 = driver.findElement(By.id("numb1"));
		numb2 = driver.findElement(By.id("numb2"));
		result += Integer.parseInt(numb1.getText());
		result += Integer.parseInt(numb2.getText());
		return result.toString();
	}

}
