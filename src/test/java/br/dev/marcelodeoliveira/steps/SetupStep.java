package br.dev.marcelodeoliveira.steps;

import br.dev.marcelodeoliveira.model.utils.ExcelUtils;
import io.cucumber.core.api.Scenario;

public class SetupStep extends Steps {

    public SetupStep() {
    }

    private static String getIdFromFeatureTag(Scenario scenario) {
	return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst().get().replace("@",
		"");
    }

    public static void startApplication(Scenario scenario) {
	setId(getIdFromFeatureTag(scenario));
	userFormList = ExcelUtils.getAllUsersList(testContext.getExcelReader().getConfigSettingSheet());
	testContext.getExcelReader().closeReader();
    }

    public static void setId(String idFromFeatureTag) {
	getTestContext().setScenarioAndUserIds(idFromFeatureTag);
    }
}
