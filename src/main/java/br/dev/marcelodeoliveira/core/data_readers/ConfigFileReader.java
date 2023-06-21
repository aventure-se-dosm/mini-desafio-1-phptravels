package br.dev.marcelodeoliveira.core.data_readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import br.dev.marcelodeoliveira.core.utils.enums.ConfigKeys;
import br.dev.marcelodeoliveira.core.utils.enums.FileFormatConstants;
import br.dev.marcelodeoliveira.core.utils.enums.FileFormatConstants.WorkBookFormats;
import br.dev.marcelodeoliveira.core.utils.enums.PropertyKeys;
import br.dev.marcelodeoliveira.core.utils.enums.WaitKeys;

public class ConfigFileReader extends AbstractReader {

    private final static String CORE_CONFIG_PATH = "config/core.properties";

    private static final String DEFAULT_FILE_FORMATTER = "%s/%s.%s";

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
	return  String.format(
			DEFAULT_FILE_FORMATTER,
			getProperty(ConfigKeys.DATA_SOURCE_LOCATION),
			getProperty(ConfigKeys.DATA_SOURCE_NAME),
			getProperty(ConfigKeys.DATA_SOURCE_FORMAT)
		).replace("..", ".")
		.replace("//", "/")
		.replace("\\\\", "\\");
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

    public WorkBookFormats getDataSourceFormat() {
	return FileFormatConstants.WorkBookFormats.valueOf(getDataSourceFormatString());
    }

    public String getDataSourceFormatString() {
	return getProperty(ConfigKeys.DATA_SOURCE_FORMAT).toUpperCase();
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
