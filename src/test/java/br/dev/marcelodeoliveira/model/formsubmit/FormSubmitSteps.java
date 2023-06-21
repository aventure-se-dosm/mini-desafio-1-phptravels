package br.dev.marcelodeoliveira.model.formsubmit;

import org.junit.Assert;

import br.dev.marcelodeoliveira.core.context.TestContext;
import br.dev.marcelodeoliveira.core.utils.FormularioDTO;
import br.dev.marcelodeoliveira.steps.Steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FormSubmitSteps extends Steps {

	public FormSubmitSteps() {
		super();
		userForm = new FormularioDTO(TestContext.getDataRow());
	}

	private FormularioDTO userForm;
	private static FormSubmitPage page;
	private String currentAlert;

	@Dado("que estou na página {string}")
	public void queEstouNaPágina(String string) {
		page = new FormSubmitPage(testContext.getDriver());
		page.startNavigation();
	}

	@Dado("insiro o nome do usuário no campo {string}")
	public void insiroONomeDoUsuárioNoCampo(String string) {
		page.writeFirstName(userForm.getFirstName());
	}

	@Dado("insiro o sobrenome do usuário no campo {string}")
	public void insiroOSobrenomeDoUsuárioNoCampo(String string) {
		page.writeLastName(userForm.getLastName());
	}

	@Dado("insiro o nome da empresa do usuário no campo {string}")
	public void insiroONomeDaEmpresaDoUsuárioNoCampo(String string) {
		page.writeBusinessName(userForm.getBusinessName());
	}

	@Dado("insiro o e-mail do usuário no campo {string}")
	public void insiroOEMailDoUsuárioNoCampo(String string) {
		page.writeEmailAddress(userForm.getEmailAddress());
	}

	@Dado("clico no botão {string}")
	public void clicoNoBotão(String string) {
		currentAlert = page.submitForm();
	}

	@E("preencho todo o formulário")
	public void preenchoTodoOFormulário() {
		page.fillUserForm(userForm);
	}

	@Quando("soluciono o enigma")
	public void solucionoOEnigma() {
		page.solveEnigmaAndWriteTheSolution();
	}

	@Então("As informações foram enviadas com sucesso!")
	public void asInformaçõesForamEnviadasComSucesso() {
		Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());
	}

	@Então("Um alerta é exibido com a mensagem {string}")
	public void umAlertaÉExibidoComAMensagem(String message) {
		Assert.assertEquals(message, currentAlert);
	}
}
