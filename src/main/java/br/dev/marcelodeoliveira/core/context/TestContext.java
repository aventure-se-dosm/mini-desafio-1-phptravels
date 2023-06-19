package br.dev.marcelodeoliveira.core.context;

import org.openqa.selenium.WebDriver;

import br.dev.marcelodeoliveira.core.dataReaders.ConfigFileReader;
import br.dev.marcelodeoliveira.core.dataReaders.ExcelReader;
import br.dev.marcelodeoliveira.core.managers.DriverManager;
import br.dev.marcelodeoliveira.core.managers.EvidenceManager;

public class TestContext {

    private DriverManager webDriverManager;
    private ScenarioContext scenarioContext;
    private ExcelReader excelReader;
    private EvidenceManager evidenceManager;
    private static ConfigFileReader configFileReader = new ConfigFileReader();;

    public TestContext() {
	this.webDriverManager = new DriverManager();
	this.scenarioContext = new ScenarioContext();
	TestContext.configFileReader = new ConfigFileReader();

	this.excelReader = new ExcelReader();
	this.evidenceManager = new EvidenceManager(getDriver());
    }

    public static ConfigFileReader getConfigFileReader() {
	return configFileReader;
    }

    public DriverManager getDriverManager() {
	return webDriverManager;
    }

    public WebDriver getDriver() {
	return webDriverManager.getDriver();
    }

    public ScenarioContext getScenarioContext() {
	return scenarioContext;
    }

    public EvidenceManager getEvidenceManager() {
	return evidenceManager;
    }

    public ExcelReader getExcelReader() {
	return excelReader;
    }

    public void setScenarioAndUserIds(String idFromFeatureTag) {
	getScenarioContext().storeValue(ScenarioContextKeys.SCENARIO_ID, (Object) idFromFeatureTag.replace("@", ""));
	getScenarioContext().storeValue(ScenarioContextKeys.USER_ID, (Object) setUserId());
    }

    private Integer setUserId() {
	String s = getScenarioId();
	return Integer.valueOf(s.replace("ID_", ""));
    }

    public String getScenarioId() {
	return getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID);
    }

    public Integer getUserId() {
	return Integer.parseInt(getScenarioContext().getStringValue(ScenarioContextKeys.USER_ID));
    }

//    public void startApplication(Scenario scenario) {
//	List<AbstractDTO> dtoList = new ArrayList<>();
//	setId(getIdFromFeatureTag(scenario));
//
//	// dtoList =
//	// ExcelUtils.getAllUsersList(getExcelReader().getConfigSettingSheet());
//	getExcelReader().closeReader();
//    }
//
//    public void setId(String idFromFeatureTag) {
//	setScenarioAndUserIds(idFromFeatureTag);
//    }

}
