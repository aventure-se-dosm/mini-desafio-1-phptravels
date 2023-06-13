package core.context;

import org.openqa.selenium.WebDriver;

import core.dataReaders.ConfigFileReader;
import core.dataReaders.ExcelXLSXReader;
import core.managers.DriverManager;
import core.managers.EvidenceManager;

public class TestContext {

    private DriverManager webDriverManager;
    private ScenarioContext scenarioContext;
    private ExcelXLSXReader excelReader;
    private EvidenceManager evidenceManager;
    private static ConfigFileReader configFileReader = new ConfigFileReader();;

    public TestContext() {
	this.webDriverManager = new DriverManager();
	this.scenarioContext = new ScenarioContext();
	TestContext.configFileReader = new ConfigFileReader();

	this.excelReader = new ExcelXLSXReader();
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

    public ExcelXLSXReader getExcelReader() {
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

}
