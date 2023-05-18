package steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.dtos.UserFormDTO;
import model.pages.FormSubmitPage;

public class FormSubmitStep extends Steps {

	public static Boolean status;

	private UserFormDTO userForm;

	private static FormSubmitPage page;

	private String currentAlert;

	public FormSubmitStep() {

	}

	public static WebDriver getDriver() {
		return testContext.getDriverManager().getDriver();
	}

	@Dado("o usuário escolhido é de índice {int}")
	public void oUsuárioEscolhidoÉDeÍndice(Integer userIndex) {
		userForm = userFormList.get(userIndex);
	}

	@Dado("que estou na página de demonstração")
	public void queEstouNaPáginaDeDemonstração()
	        throws FileNotFoundException, IOException {
		page = testContext.getPageManager().getFormSubmitPage();
		userForm = userFormList.get(getUserIndex());
		page.startNavigation();
	}

	private int getUserIndex() {
		String s = userId;
		return Integer.valueOf(s.replace("ID_", ""));
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

		currentAlert = page.submitForm();

	}

	@Então("As informações foram enviadas com sucesso!")
	public void asInformaçõesForamEnviadasComSucesso() { // currentAlert =
	                                                     // page.getAlertMessage();
		Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());

	}

	@Então("Um alerta é exibido com a mensagem {string}")
	public void umAlertaÉExibidoComAMensagem(String message) {

		// currentAlert = page.getAlertMessage();
		Assert.assertEquals(message, currentAlert);

	}

	private static XSSFWorkbook getWorkBook() {
		return testContext.getExcelReader().getWorkBook();
	}

	public static void closeWorkBook() {

		try {
			getWorkBook().close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
