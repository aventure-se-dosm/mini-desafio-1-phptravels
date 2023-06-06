package steps;

import core.context.TestContext;
import io.cucumber.core.api.Scenario;
import model.utils.ExcelUtils;

public class SetupStep extends Steps {
    public static Boolean status;

    public SetupStep() {
    }

    private static String getIdFromFeatureTag(Scenario scenario) {
	return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst().get().replace("@",
		"");
    }

    public static void startApplication(Scenario scenario) {
	setId(getIdFromFeatureTag(scenario));
	userFormList = ExcelUtils.getAllUsersList(testContext.getExcelReader().getSheet());
    }

    public static void setId(String idFromFeatureTag) {
	getTestContext().setScenarioAndUserIds(idFromFeatureTag);
    }

    private static TestContext getTestContext() {
	return testContext;
    }

}
