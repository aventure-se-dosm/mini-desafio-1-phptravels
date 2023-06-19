package br.dev.marcelodeoliveira.hooks;

import br.dev.marcelodeoliveira.steps.SetupStep;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 0)
    public static void setupApplication(Scenario scenario) {
	SetupStep.startApplication(scenario);
    }

    @After(order = 1)
    public void getScreenshot(Scenario s) {
	SetupStep.getTestContext().getEvidenceManager().createEvidence(s);
    }

}
