package core.managers;

import org.openqa.selenium.WebDriver;

import core.context.TestContext;
import core.utils.enums.FileFormatConstants.ImageFormats;
import core.utils.webutils.Screenshoter;
import core.utils.webutils.TimeUtils;
import io.cucumber.core.api.Scenario;

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

    public void createEvidence(Scenario s) {

	screenshoter.takeScreenshot(getDefaultEvidencePath(), getDefaultFileNameOutput(s),
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
