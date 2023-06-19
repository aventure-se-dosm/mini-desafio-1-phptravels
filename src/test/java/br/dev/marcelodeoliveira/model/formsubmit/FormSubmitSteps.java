package br.dev.marcelodeoliveira.model.formsubmit;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import br.dev.marcelodeoliveira.steps.Steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FormSubmitSteps extends Steps {

    public FormSubmitSteps() {
	super();
    }

    private UserFormDTO userForm;
    private static FormSubmitPage page;
    private String currentAlert;

    @Dado("que estou na página de demonstração")
    public void queEstouNaPáginaDeDemonstração() throws FileNotFoundException, IOException {
	userForm = userFormList.get(testContext.getUserId());
	page = new FormSubmitPage(testContext.getDriver());
	page.startNavigation();
    }

    @E("insiro o nome do usuário")
    public void insiroONomeDoUsuárioDeÍndice() {
	page.writeFirstName(userForm.getFirstName());
    }

    @E("insiro o sobrenome do usuário")
    public void insiroOSobrenomeDoUsuário() {
	page.writeLastName(userForm.getLastName());
    }

    @E("insiro o e-mail do usuário")
    public void insiroOEmailDoUsuário() {
	page.writeEmailAddress(userForm.getEmailAddress());
    }

    @E("insiro o nome da empresa do usuário")
    public void insiroONomeDaEmpresaDoUsuário() {
	page.writeBusinessName(userForm.getBusinessName());
    }

    @E("preencho todo o formulário")
    public void preenchoTodoOFormulário() {
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
    public void asInformaçõesForamEnviadasComSucesso() {
	Assert.assertTrue(page.formHasBeenSubmitedSuccessifully());
    }

    @Então("Um alerta é exibido com a mensagem {string}")
    public void umAlertaÉExibidoComAMensagem(String message) {
	Assert.assertEquals(message, currentAlert);
    }
}
