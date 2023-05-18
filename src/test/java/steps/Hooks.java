package steps;

import org.junit.AfterClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	// private final static String DEFAULT_USER_INDEX = "ID_0001";

	@Before(order = 0)
	public static void setupApplication(Scenario scenario) {
		// esses métodos não deveriam depender da página em Si
		// deveriam ser do pai abstrato, não?

		// scenario.
		// Steps.setId(getIdFromFeatureTag(scenario));
		// Steps.startApplication(scenario);
		FormSubmitStep.setId(getIdFromFeatureTag(scenario));
		FormSubmitStep.startApplication(scenario);
	}

	private static String getIdFromFeatureTag(Scenario scenario) {
		return scenario.getSourceTagNames().stream()
		        .filter(t -> t.startsWith("@ID_")).findFirst().get()
		        .replace("@", "");
	}

	@After(order = 1)

	public void getScreenshot(Scenario s) {
		Step.testContext.getEvidenceManager().createEvidence(s);
		Step.closeDriver();

	}
	
}
