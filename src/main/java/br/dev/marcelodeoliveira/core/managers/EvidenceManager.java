package br.dev.marcelodeoliveira.core.managers;

import org.openqa.selenium.WebDriver;

import br.dev.marcelodeoliveira.core.context.TestContext;
import br.dev.marcelodeoliveira.core.utils.enums.FileFormatConstants.ImageFormats;
import br.dev.marcelodeoliveira.core.utils.webutils.Screenshoter;
import br.dev.marcelodeoliveira.core.utils.webutils.TimeUtils;
import io.cucumber.java.Scenario;

public class EvidenceManager {

	private Screenshoter screenshoter;
	private WebDriver driver;
	private TimeUtils timeUtils;

	public EvidenceManager(WebDriver driver) {
		this.driver = driver;
		this.screenshoter = new Screenshoter(getDriver());
		this.timeUtils = new TimeUtils();
	}

	private WebDriver getDriver() {
		return driver;
	}

	public void createEvidence(Scenario scenario) {

		screenshoter.takeScreenshot(getDefaultEvidencePath(), getDefaultFileNameOutput(scenario),
				ImageFormats.valueOf(getDefaultEvidenceFormat().toUpperCase()));
	}

	private String getDefaultEvidenceFormat() {
		return TestContext.getConfigFileReader().getDefaultEvidenceFormat();
	}

	private String getDefaultEvidencePath() {
		return TestContext.getConfigFileReader().getDefaultEvidencePath();
	}

	private static String getTagPrefix(Scenario s) {
		return s.getSourceTagNames().stream().map(t -> t.replace("@", "")).filter(t -> t.startsWith("ID_")).findFirst()
				.get();
	}

	private CharSequence getStatus(Scenario scenario) {

		String status;
		switch (scenario.getStatus()) {
		case PASSED:
			status = "PASSOU";
			break;
		case FAILED:
		default:
			status = "FALHOU";
		}
		return status;
	}

	private String getDefaultFileNameOutput(Scenario scenario) {

		return String.join("_", getTagPrefix(scenario), timeUtils.getFormattedDateTimeNow(), getStatus(scenario));
	}

}
