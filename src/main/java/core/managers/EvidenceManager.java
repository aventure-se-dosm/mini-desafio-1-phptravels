package core.managers;

import org.openqa.selenium.WebDriver;

import core.utils.webutils.Screenshoter;
import core.utils.webutils.TimeUtils;
import io.cucumber.core.api.Scenario;

public class EvidenceManager {

	private Screenshoter screenshoter;
	private static WebDriver driver;
	private TimeUtils timeUtils;

	//carregar por configuration
	private final String DEFAULT_EVIDENCE_FORMAT = ".jpg";
	private final String DEFAULT_EVIDENCE_PATH = "./evidencia/";

	public EvidenceManager(WebDriver driver) {
		EvidenceManager.driver = driver;
		this.screenshoter = new Screenshoter(getDriver());
		this.timeUtils = new TimeUtils();
	}

	private WebDriver getDriver() {
		return driver;
	}

	public void createEvidence(Scenario s) {
		screenshoter
		        .takeScreenshot(DEFAULT_EVIDENCE_PATH + getTagPrefix(s) + getDefaultFileNameOutput());
	}

	private static String getTagPrefix(Scenario s) {
		return s.getSourceTagNames().stream().map(t -> t.replace("@", ""))
		        .filter(t -> t.startsWith("ID_")).findFirst().get();
	}

	private String getDefaultFileNameOutput() {

		return timeUtils.getFormattedDateTimeNow() + DEFAULT_EVIDENCE_FORMAT;
	}

}
