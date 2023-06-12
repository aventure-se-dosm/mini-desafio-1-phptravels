package core.managers;

import org.openqa.selenium.WebDriver;

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
	return FileReaderManager.getConfigFileReader().getDefaultEvidenceFormat();
    }

    private String getDefaultEvidencePath() {
	return FileReaderManager.getConfigFileReader().getDefaultEvidencePath();
    }

    private static String getTagPrefix(Scenario s) {
	return s.getSourceTagNames().stream().map(t -> t.replace("@", "")).filter(t -> t.startsWith("ID_")).findFirst()
		.get();
    }

    private String getDefaultFileNameOutput(Scenario s) {

	return String.join("_", getTagPrefix(s), timeUtils.getFormattedDateTimeNow());
    }

}
