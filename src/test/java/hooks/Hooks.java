package hooks;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.SetupStep;

public class Hooks {

    @Before(order = 0)
    public static void setupApplication(Scenario scenario) {
	SetupStep.startApplication(scenario);
    }

    @After(order = 1)
    public void getScreenshot(Scenario s) {
	SetupStep.getTestContext().getEvidenceManager().createEvidence(s);
    }

//    @AfterClass
//    public static void finishApplication() {
//	SetupStep.closeApplication();
//    }

}
