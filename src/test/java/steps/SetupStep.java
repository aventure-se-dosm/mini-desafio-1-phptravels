package steps;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import core.context.TestContext;
import core.utils.ExcelUtils;
import io.cucumber.core.api.Scenario;

public class SetupStep extends Step {
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

    public static void startApplication(String id) {
	setId(id);
	userFormList = ExcelUtils.getAllUsersList(testContext.getExcelReader().getSheet());
    }

    public static void closeDriver() {

	testContext.getDriverManager().closeDriver();
    }

    public static void KillDriver() {

	testContext.getDriverManager().KillDriver();
    }

    private static Workbook getWorkBook() {
	return testContext.getExcelReader().getWorkBook();
    }

    public static void closeWorkBook() {

	try {
	    getWorkBook().close();
	} catch (IOException e) {

	    e.printStackTrace();
	}

    }

    public static void closeApplication() {
	closeWorkBook();
	KillDriver();
    }

}
