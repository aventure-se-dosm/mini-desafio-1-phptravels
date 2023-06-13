package steps;

import io.cucumber.core.api.Scenario;
import model.utils.ExcelUtils;

public class SetupStep extends Steps {

    public SetupStep() {
    }

    private static String getIdFromFeatureTag(Scenario scenario) {
	return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst().get().replace("@",
		"");
    }

    public static void startApplication(Scenario scenario) {
	setId(getIdFromFeatureTag(scenario));
	userFormList = ExcelUtils.getAllUsersList(testContext.getExcelReader().getSheet());
	testContext.getExcelReader().closeReader();
    }

    public static void setId(String idFromFeatureTag) {
	getTestContext().setScenarioAndUserIds(idFromFeatureTag);
    }

}
