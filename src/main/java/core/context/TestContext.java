package core.context;

import org.openqa.selenium.WebDriver;

import core.dataProviders.ExcelXLSXReader;
import core.managers.DriverManager;
import core.managers.EvidenceManager;
import core.managers.PageObjectManager;

public class TestContext {

	private PageObjectManager pageObjectManager;
	private DriverManager webDriverManager;
	private ScenarioContext scenarioContext;
	private ExcelXLSXReader excelReader;
	private EvidenceManager evidenceManager;

	public TestContext() {
		this.webDriverManager = new DriverManager();
		this.pageObjectManager = new PageObjectManager(getDriver());
		this.scenarioContext = new ScenarioContext();
		this.excelReader = new ExcelXLSXReader();
		this.evidenceManager = new EvidenceManager(getDriver());
	}

	public PageObjectManager getPageManager() {
		return pageObjectManager;
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

}
