package core.managers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import core.dataProviders.ConfigFileReader;
import core.utils.enums.ConfigKeys;
import core.utils.enums.PropertyKeys;
import core.utils.enums.WaitKeys;

public class FileReaderManager {

    static ConfigFileReader configFileReader;

    public static ConfigFileReader getConfigFileReader() {
	return (configFileReader == null ? configFileReader = new ConfigFileReader() : configFileReader);
    }

    static String getGlobalProperty(PropertyKeys propertyKey) {
	return getConfigFileReader().getProperty(propertyKey);
    }

    static String getGlobalProperty(String attributeyKey) {
	return getConfigFileReader().getProperty(attributeyKey);
    }

    static Long getWaitNumrericalValue(String AttributeKey) {
	return Long.parseLong(AttributeKey);
    }

    public static String getDataSource() {
	return getGlobalProperty(ConfigKeys.DATA_SOURCE);
    }

    static String getDefaultWebdriverType() {
	return getGlobalProperty(ConfigKeys.WEBDRIVER_TYPE);
    }

    public static String getDefaultStartingUrl() {
	return getGlobalProperty(ConfigKeys.STARTING_URL);
    }

    static String getDefaultEvidenceFormat() {
	return getGlobalProperty(ConfigKeys.EVIDENCE_FORMAT);
    }

    static String getDefaultEvidencePath() {
	return getGlobalProperty(ConfigKeys.EVIDENCE_PATH);
    }

    static Duration getDefaultWaitPropertyDuration(WaitKeys waitKey) {
	return Duration.of(getWaitNumrericalValue(getGlobalProperty(waitKey.getNumericalValue())),
		ChronoUnit.valueOf((getGlobalProperty(waitKey.getTimeUnit())).toUpperCase()));
    }

    public static Duration getDefaultWaitPolling() {
	return getDefaultWaitPropertyDuration(WaitKeys.WAIT_POLLING);
    }

    public static Duration getAlertWaitTimeout() {
	return getDefaultWaitPropertyDuration(WaitKeys.WAIT_OUTFLOW_ALERT_TIMEOUT);
    }

    public static Duration getDomElementWaitTimeout() {
	return getDefaultWaitPropertyDuration(WaitKeys.WAIT_DOM_TIMEOUT_TIMEUNIT);
    }
}
