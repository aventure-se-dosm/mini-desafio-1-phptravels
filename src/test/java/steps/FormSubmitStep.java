package steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.dtos.UserFormDTO;
import model.pages.FormSubmitPage;

public class FormSubmitStep extends Step {

    public FormSubmitStep() {
	super();
    }

    private UserFormDTO userForm;
    private static FormSubmitPage page;
    private String currentAlert;

    @Dado("que estou na página de demonstração")
    public void queEstouNaPáginaDeDemonstração() throws FileNotFoundException, IOException {
	userForm = userFormList.get(testContext.getUserId());
	page = testContext.getPageManager().getFormSubmitPage();
	page.startNavigation();
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
