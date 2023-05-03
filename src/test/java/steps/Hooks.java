package steps;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {

	// private final static String DEFAULT_USER_INDEX = "ID_0001";

	@BeforeClass
	public static void prepareData(Scenario scenario) {
		FormSubmitStep.carregaInfoTodosUsuarios();
	}

	@Before
	public static void startBrowser(Scenario scenario) {

		FormSubmitStep.setId(getIdFromFeatureTag(scenario));

		FormSubmitStep.inicializaAplicacao();
	}

	private static String getIdFromFeatureTag(Scenario scenario) {
		return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst().get();
	}

	@AfterStep
	public static void takeScreenshot(Scenario s) {

		FormSubmitStep.takeScreenshot(s);

	}

	@AfterClass
	public static void closeApllication() {

		try {
			FormSubmitStep.wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			FormSubmitStep.driver.close();
			FormSubmitStep.driver = null;
		}
	}
}
