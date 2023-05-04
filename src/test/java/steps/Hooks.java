package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {

	private final static String DEFAULT_USER_INDEX = "ID_0001";

	@Before(order = 0)
	public static void setupApplication(Scenario scenario) {
		FormSubmitStep.inicializaAplicacao();
	}

	@Before(order = 1)
	public static void startBrowser(Scenario scenario) {
		// FormSubmitStep.inicializaAplicacao();
		FormSubmitStep.setId(getIdFromFeatureTag(scenario));

		// FormSubmitStep.inicializaAplicacao();
	}

	private static String getIdFromFeatureTag(Scenario scenario) {
		return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst()
				.orElse(DEFAULT_USER_INDEX);
	}

	@AfterStep(order = 2)
	public static void takeScreenshot(Scenario s) {

		FormSubmitStep.takeScreenshot(s);
		// FormSubmitStep.driver.close();
	}

}
