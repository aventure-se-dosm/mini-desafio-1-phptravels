package core.dataReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import core.utils.enums.ConfigKeys;
import core.utils.enums.PropertyKeys;
import core.utils.enums.WaitKeys;

public class ConfigFileReader extends AbstractReader {

    private final static String CORE_CONFIG_PATH = "config/core.properties";

    private BufferedReader reader;

    private Properties properties;
    
    private static String getConfigPath() {
	return CORE_CONFIG_PATH;
    }

    public ConfigFileReader() {
	super(getConfigPath());
    }

    public ConfigFileReader(String readedFilePath) {
	super(readedFilePath);
    }

    private Properties getProperties() {
	return properties;
    }

    public String getProperty(PropertyKeys propertyKey) {
	return getProperties().get(propertyKey.getValue()).toString();
    }

    public String getProperty(String propertyKey) {
	return getProperties().get(propertyKey).toString();
    }

    public Long getWaitNumrericalValue(String AttributeKey) {
	return Long.parseLong(AttributeKey);
    }

    public String getDataSource() {
	return getProperty(ConfigKeys.DATA_SOURCE);
    }

    public String getDefaultWebdriverType() {
	return getProperty(ConfigKeys.WEBDRIVER_TYPE);
    }

    public String getDefaultStartingUrl() {
	return getProperty(ConfigKeys.STARTING_URL);
    }

    public String getDefaultEvidenceFormat() {
	return getProperty(ConfigKeys.EVIDENCE_FORMAT);
    }

    public String getDefaultEvidencePath() {
	return getProperty(ConfigKeys.EVIDENCE_PATH);
    }

    Duration getDefaultWaitPropertyDuration(WaitKeys waitKey) {
	return Duration.of(getWaitNumrericalValue(getProperty(waitKey.getNumericalValue())),
		ChronoUnit.valueOf((getProperty(waitKey.getTimeUnit())).toUpperCase()));
    }

    public Duration getDefaultWaitPolling() {
	return getDefaultWaitPropertyDuration(WaitKeys.WAIT_POLLING);
    }

    public Duration getAlertWaitTimeout() {
	return getDefaultWaitPropertyDuration(WaitKeys.WAIT_OUTFLOW_ALERT_TIMEOUT);
    }

    public Duration getDomElementWaitTimeout() {
	return getDefaultWaitPropertyDuration(WaitKeys.WAIT_DOM_TIMEOUT_TIMEUNIT);
    }
    
    public String getDefaulSheetName() {
   	return getProperty(ConfigKeys.DEFAULT_SHEET_NAME);
    }

    @Override
    protected void setupReading() {
	try {

	    reader = new BufferedReader(new FileReader(new File(configPath)));
	    properties = new Properties();
	    properties.load(reader);
	    closeReader();

	} catch (FileNotFoundException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();
	}

    }

    @Override
    protected void closeReader() {
	try {
	    reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
