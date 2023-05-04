package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import entities.dto.UserFormDTO;
import io.cucumber.core.api.Scenario;
import io.cucumber.core.event.Status;
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
	static WebDriver driver;
	public static Boolean status;
	private final static String DEFAULT_EXTENSION = ".png";
	private final static String DEFAULT_DESTINATION_DIRECTORY = "./evidencia/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_HH_mm_ss";

	private static String userId;

	private UserFormDTO userForm;
	private static List<UserFormDTO> userFormList;

	private static FormSubmitPage page;

	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	XSSFRow currentRow;
	private String currentAlert;

	public FormSubmitStep() {
		if (driver == null)
			FormSubmitStep.driver = DriverManager.getSelectedDriver(DriverManagerType.CHROME);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	public static void inicializaAplicacao() {

		if (driver == null) {
			driver = DriverManager.getSelectedDriver(DriverManagerType.CHROME);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
		}

		System.out.println("Passou pelo inicializaDriver");
		System.out.println("Passou pelo inicializaPagina");
		carregaInfoTodosUsuarios();
		page = new FormSubmitPage(driver);

	}

	static void carregaInfoTodosUsuarios() {
		try {
			wb = new XSSFWorkbook(new FileInputStream(".\\src\\main\\resources\\DATA_SPREADSHEET.xlsx"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		// sheet = wb.getSheet("DATA_USER_FORM");
		sheet = wb.getSheetAt(0);
		userFormList = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.hasNext();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			userFormList.add(new UserFormDTO(row));
		}
//		driver.get(START_URL);
	}

	@Dado("o usuário escolhido é de índice {int}")
	public void oUsuárioEscolhidoÉDeÍndice(Integer userIndex) {
		userForm = userFormList.get(userIndex);
	}

	@Dado("que estou na página de demonstração")
	public void queEstouNaPáginaDeDemonstração() throws FileNotFoundException, IOException {
		userForm = userFormList.get(getUserIndex());

		driver.get(START_URL);
	}

	private int getUserIndex() {
		return Integer.valueOf(userId.replace("@ID_", ""));
	}

	@E("eu insiro o nome do usuário")
	public void euInsiroONomeDoUsuárioDeÍndice() {
		page.writeFirstName(userForm.getFirstName());
	}

	@E("insiro o sobrenome")
	public void insiroOSobrenome() {
		page.writeLastName(userForm.getLastName());
	}

	@E("insiro o e-mail")
	public void insiroOEmail() {
		page.writeEmailAddress(userForm.getEmailAddress());
	}

	@E("insiro o nome de sua empresa")
	public void insiroONomeDeSuaEmpresa() {
	}

	@E("preencho todo o formulário")
	public void preenchoTOdoOFormulário() {
		page.fillUserForm(userForm);
	}

	@Quando("soluciono o enigma")
	public void solucionoOEnigma() {
		page.solveEnigmaAndWriteTheSolution();
	}

	@E("clico em submeter")
	public void clicoEmSubmeter() {
		try {
			currentAlert = page.submitForm();
		} catch (Exception e) {
			return;
		}
	}

	@Então("As informações foram enviadas com sucesso!")
	public void asInformaçõesForamEnviadasComSucesso() {
		// currentAlert = page.getAlertMessage();
		Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());
	}

	@Então("Um alerta é exibido com a mensagem {string}")
	public void umAlertaÉExibidoComAMensagem(String message) {
		// currentAlert = page.getAlertMessage();
		Assert.assertEquals(message, currentAlert);
	}

	private static String stringDaData() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_AVAL_1));
	}

	public static void takeScreenshot(Scenario s) {

		Screenshoter screenshoter = new Screenshoter(driver);
		String result = (s.getStatus() == Status.PASSED ? "PASSOU" : "FALHOU");
		String id = s.getSourceTagNames().stream().findFirst().get().replace("@", "");

		String shotFileName = String.join("_", id, stringDaData(), result);
		screenshoter.makeScreenshot(DEFAULT_DESTINATION_DIRECTORY, shotFileName, DEFAULT_EXTENSION);

	}

	public static void setId(String idFromFeatureTag) {
		FormSubmitStep.userId = idFromFeatureTag;

	}

	public static void closeDriver() {

		if (driver != null) {
			getDriver().close();
			getDriver().quit();
		}
		driver = null;
	}

	private static WebDriver getDriver() {
		return driver;
	}

	private static XSSFWorkbook getWorkBook() {
		return wb;
	}

	public static void closeWorkBOok() {
		try {
			getWorkBook().close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void closeApllication() {
		closeWorkBOok();
		closeDriver();
	}

}
