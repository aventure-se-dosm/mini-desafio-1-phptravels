package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before(order = 0)
	public static void setupApplication(Scenario scenario) {

		Step.startApplication(getIdFromFeatureTag(scenario));
	}

	private static String getIdFromFeatureTag(Scenario scenario) {
		return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst().get().replace("@",
				"");
	}

	@After(order = 1)
	public void getScreenshot(Scenario s) {
		Step.testContext.getEvidenceManager().createEvidence(s);
		//Step.closeDriver();
	}

}
