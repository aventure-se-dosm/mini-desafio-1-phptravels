package br.dev.marcelodeoliveira.core.context;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import br.dev.marcelodeoliveira.core.data_readers.ConfigFileReader;
import br.dev.marcelodeoliveira.core.data_readers.ExcelReader;
import br.dev.marcelodeoliveira.core.managers.DriverManager;
import br.dev.marcelodeoliveira.core.managers.EvidenceManager;
import io.cucumber.java.Scenario;

public class TestContext {

	private static DriverManager webDriverManager;
	private static ScenarioContext scenarioContext;
	private static ExcelReader excelReader;
	private static EvidenceManager evidenceManager;
	private static ConfigFileReader configFileReader;
	private static Row dataRow;

	private static void setWebDriverManager() {
		TestContext.webDriverManager = new DriverManager();
	}

	private static void setScenarioContext() {
		TestContext.scenarioContext = new ScenarioContext();
	}

	private static void setExcelReader() {
		TestContext.excelReader = new ExcelReader();
	}

	private static void setEvidenceManager(WebDriver driver) {
		TestContext.evidenceManager = new EvidenceManager(driver);
	}

	private static void setConfigFileReader() {
		TestContext.configFileReader = new ConfigFileReader();
	}

	public static ConfigFileReader getConfigFileReader() {
		if (configFileReader == null)
			setConfigFileReader();
		return configFileReader;
	}

	public static DriverManager getDriverManager() {
		if (webDriverManager == null)
			setWebDriverManager();
		return webDriverManager;
	}

	public static ScenarioContext getScenarioContext() {
		if (scenarioContext == null)
			setScenarioContext();
		return scenarioContext;
	}

	public static EvidenceManager getEvidenceManager() {
		if (evidenceManager == null)
			setEvidenceManager(getDriver());
		return evidenceManager;
	}

	public static WebDriver getDriver() {
		return getDriverManager().getDriver();
	}

	public static ExcelReader getExcelReader() {
		if (excelReader == null)
			setExcelReader();
		return excelReader;
	}

	public static void setScenarioAndUserIds(String idFromFeatureTag) {
		getScenarioContext().storeValue(ScenarioContextKeys.SCENARIO_ID, ((Object) idFromFeatureTag.replace("@", "")));
		getScenarioContext().storeValue(ScenarioContextKeys.USER_ID, (Object) setUserId());
	}

	private static Integer setUserId() {
		return Integer.valueOf(getScenarioId().replace("ID_", ""));
	}

	public static String getScenarioId() {
		return getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID);
	}

	public static Integer getUserId() {
		return Integer.parseInt(getScenarioContext().getStringValue(ScenarioContextKeys.USER_ID));
	}

	private static String getIdFromFeatureTag(Scenario scenario) {
		return scenario.getSourceTagNames().stream().filter(t -> t.startsWith("@ID_")).findFirst().get().replace("@",
				"");
	}

	public static void startApplication(Scenario scenario) {
		setId(getIdFromFeatureTag(scenario));
		setDataRow(getExcelReader().getConfigSettingSheet().getRow(getUserId()));
		getExcelReader().closeReader();
	}

	private static void setDataRow(Row row) {
		dataRow = row;
	}

	public static Row getDataRow() {
		return dataRow;
	}

	public static void setId(String idFromFeatureTag) {
		setScenarioAndUserIds(idFromFeatureTag);
	}

}
