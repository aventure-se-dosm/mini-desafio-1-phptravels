package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import entities.dto.UserFormDTO;
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

	private UserFormDTO userForm;
	private List<UserFormDTO> userFormList;

	private FormSubmitPage page;

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow currentRow;

	public FormSubmitStep() {
		if (driver == null)
			this.driver = DriverManager.getSelectedDriver(DriverManagerType.CHROME);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Before
	public void acessaPagina() {

		if (driver == null)
			this.driver = DriverManager.getSelectedDriver(DriverManagerType.CHROME);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Passou pelo inicializaDriver");
		System.out.println("Passou pelo inicializaPagina");

		carregaInfoTOdosUsuarios();
		page = new FormSubmitPage(driver);

	}

	private void carregaInfoTOdosUsuarios() {
		try {
			wb = new XSSFWorkbook(new FileInputStream("./src/main/resources/DATA_SPREADSHEET.xlsx"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = wb.getSheet("DATA_USER_FORM");
		sheet = wb.getSheetAt(0);
		userFormList = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.hasNext();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			userFormList.add(new UserFormDTO(row));
		}

	}

	@Dado("o usuário escolhido é de índice {int}")
	public void oUsuárioEscolhidoÉDeÍndice(Integer userIndex) {
		userForm = userFormList.get(userIndex);
	}

	@Dado("que estou na página de demonstração")
	public void queEstouNaPáginaDeDemonstração() throws FileNotFoundException, IOException {

		driver.get(START_URL);
	}

	@E("eu insiro o nome do usuário")
	public void euInsiroONomeDoUsuárioDeÍndice() {

		page.escreveNome(userForm.getName());
	}

	@E("insiro o sobrenome")
	public void insiroOSobrenome() {
		page.escreveSobrenome(userForm.getSurname());
	}

	@E("insiro o e-mail")
	public void insiroOEmail() {
		page.escreveEmail(userForm.getEmail());
	}

	@E("insiro o nome de sua empresa")
	public void insiro_o_nome_de_sua_empresa() {
		page.escreveCompania(userForm.getBusinessName());
	}

	@Quando("soluciono o enigma")
	public void solucionoOEnigma() {
		page.solucionaEnigmaEEscreveOResultado();
	}

	@E("clico em submeter")
	public void clicoEmSubmeter() {
		page.submitForm();
	}

	@Então("As informações foram enviadas com sucesso!")
	public void asInformaçõesForamEnviadasComSucesso() {
		Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());

	}

	@Então("Um alerta é exibido com a mensagem {string}")
	public void umAlertaÉExibidoComAMensagem(String message) {

		try {
			Assert.assertEquals(message, page.getAlertMessage());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static String stringDaData() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_AVAL_1));
	}

	@After(order = 0)
	public void takeScreenshot(Scenario s) throws IOException {
		Screenshoter screenshoter = new Screenshoter(driver);
		String result = (s.getStatus() == Status.PASSED ? "PASSOU" : "FALHOU");
		String id = s.getName().split(" ")[0];
		String shotFileName = String.join("_", id, stringDaData(), result);
		screenshoter.makeScreenshot(DEFAULT_DESTINATION_DIRECTORY, shotFileName, DEFAULT_EXTENSION);
		wb.close();
		driver.close();

	}

}
