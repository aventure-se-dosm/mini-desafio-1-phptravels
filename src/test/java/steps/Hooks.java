package steps;

import org.junit.BeforeClass;

import io.cucumber.core.api.Scenario;



public class Hooks {

	@BeforeClass
	public void prepararLeituraDeDados(Scenario scenario) {
		
		
		// Exemplo de como recuperar as tags de um cénario:
		// scenario.getSourceTagNames();
	}
}
