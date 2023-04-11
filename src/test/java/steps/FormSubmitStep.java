package steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import managers.DriverManager;
import pages.FormSubmitPage;
import testutils.Screenshoter;

public class FormSubmitStep {

	private static final String START_URL = "https://phptravels.com/demo";
	private WebDriver driver;
	public static Boolean status;
	private final static String DEFAULT_EXTENSION = ".png";
	private final static String DEFAULT_DESTINATION_DIRECTORY = "./target/Screenshots/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_HH_mm_ss";

	private FormSubmitPage page;
	
	public FormSubmitStep() {
		this.driver = DriverManager.getSelectedDriver(DriverManagerType.CHROME);
	}
	@Before
	public void acessaPagina() {
		System.out.println("Passou pelo inicializaDriver");
		System.out.println("Passou pelo inicializaPagina");
	}
	@Dado("que estou na página de demonstração")
	public void que_estou_na_página_de_demonstração() {
		page = new FormSubmitPage(driver);
		driver.get(START_URL);
	}
	@Quando("eu insiro o nome do usuário {string}")
	public void eu_insiro_o_nome_do_usuário(String nome) {
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
		page.escreveResultado();
	}
	@E("clico em submeter")
	public void clico_em_submeter() {
		page.submitForm();
	}
	@Então("As informações foram enviadas com sucesso!")
	public void as_informações_foram_enviadas_com_sucesso() {
		Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());
	}
	private static String stringDaData() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_AVAL_1));
	}
	@After
	public void takeScreenshot(Scenario s) {
		Screenshoter screenshoter = new Screenshoter(driver);
		String result = (s.getStatus() == Status.PASSED ? "SUCESSO" : "FALHOU");
		String id = s.getName().split(" ")[0];
		String shotFileName = String.join("_", id, stringDaData(), result);
		screenshoter.makeScreenshot(DEFAULT_DESTINATION_DIRECTORY, shotFileName, DEFAULT_EXTENSION);
		driver.quit();
	}
}
