package br.dev.marcelodeoliveira.hooks;

import br.dev.marcelodeoliveira.core.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before(order = 0)
	public  void setupApplication(Scenario scenario) {
		TestContext.startApplication(scenario);
	}

	@After(order = 1)
	public  void getScreenshot(Scenario scenario) {
		TestContext.getEvidenceManager().createEvidence(scenario);
	}


	@AfterAll(order = 3)
	public static void finishApplication() {
		TestContext.getDriverManager().killDriver();
	}

}
