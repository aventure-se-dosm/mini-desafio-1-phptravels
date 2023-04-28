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
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import TestDataTypes.UserFormDTO;
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

public class FormSubmitSteps extends Hooks{

	private static final String START_URL = "https://phptravels.com/demo";
    static WebDriver driver;
	public static Boolean status;
	private final static String DEFAULT_SCREENSHOT_EXTENSION = ".png";

	private final static String OUTPUT_SCREENSHOT_FOLDER = "./evidencia/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_HH_mm_ss";

	private UserFormDTO userForm;
	private List<UserFormDTO> userFormList;

	private FormSubmitPage page;

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow currentRow;
	UserFormDTO userFormDTO;

	public FormSubmitSteps() {
		if (driver == null)
			this.driver = DriverManager.getSelectedDriver(DriverManagerType.CHROME);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@Before
	public void acessaPagina() {
		carregaInfoTOdosUsuarios();
		page = new FormSubmitPage(driver);

	}

	private void carregaInfoTOdosUsuarios() {
		try {
			wb = new XSSFWorkbook(new FileInputStream(

					// it should have been (though WILL be) such as a return from ConfigReader's
					// getPetinentProperty()
					"./src/main/resources/DATA_SPREADSHEET.xlsx"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = wb.getSheet("DATA_USER_FORM");
		sheet = wb.getSheetAt(0);
		userFormList = new ArrayList<>();
		Iterator<Row> rowIterator = sheet.iterator();
		// faz este next para pular o HEADER da planilha
		// deve ter jeito melhor.
		rowIterator.next();
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

	@Quando("eu insiro as informações do usuário")
	public void euInsiroAsInformaçõesDoUsuário() {
		page.preencheFormCompleto(userFormList.iterator().next());
	}

	@Quando("eu insiro as informações do usuário {int}")
	public void euInsiroAsInformaçõesDoUsuário(Integer userFormDataIndex) {
		page.preencheFormCompleto(userFormList.get(userFormDataIndex));
	}
//
//	@E("eu insiro o nome do usuário")
//	public void euInsiroONomeDoUsuárioDeÍndice() {
//
//		page.escreveNome(userForm.getName());
//	}
//
//	@E("insiro o sobrenome")
//	public void insiroOSobrenome() {
//		page.escreveSobrenome(userForm.getSurname());
//	}
//
//	@E("insiro o e-mail")
//	public void insiroOEmail() {
//		page.escreveEmail(userForm.getEmail());
//	}
//
//	@E("insiro o nome de sua empresa")
//	public void insiro_o_nome_de_sua_empresa() {
//		page.escreveCompania(userForm.getBusinessName());
//	}

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

		finally {
			;
		}

	}

	private static String stringDaData() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_AVAL_1));
	}

	@After()
	public void takeScreenshot(Scenario s) throws IOException {
		Screenshoter screenshoter = new Screenshoter(driver);
		String result = (s.getStatus() == Status.PASSED ? "PASSOU" : "FALHOU");
		String id = s.getName().split(" ")[0];
		String shotFileName = String.join("_", id, stringDaData(), result);
		screenshoter.makeScreenshot(OUTPUT_SCREENSHOT_FOLDER, shotFileName, DEFAULT_SCREENSHOT_EXTENSION);
		//driver.close();
		wb.close();
	}

	public static WebDriver getDriver() {
		return driver;
	}




}
