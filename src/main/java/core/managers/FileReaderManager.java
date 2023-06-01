package core.managers;

import core.dataProviders.ConfigFileReader;
import core.utils.enums.PropertyKeys;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    public static FileReaderManager getInstance() {
	return fileReaderManager;
    }

    private static ConfigFileReader getConfigFileReader() {
	return (configFileReader == null ? configFileReader = new ConfigFileReader() : configFileReader);

    }

    private static String getGlobalProperty(PropertyKeys propertyKey) {
	return getConfigFileReader().getProperty(propertyKey);
    }

    public static String getDataSource() {
	return getGlobalProperty(PropertyKeys.DATA_SOURCE);
    }

    public static String getDefaultWebdriverType() {
	return getGlobalProperty(PropertyKeys.WEBDRIVER_TYPE);
    }

    public static String getDefaultStartingUrl() {
	return getGlobalProperty(PropertyKeys.STARTING_URL);
    }

    public static String getDefaultEvidenceFormat() {
	return getGlobalProperty(PropertyKeys.EVIDENCE_FORMAT);
    }

    public static String getDefaultEvidencePath() {
	return getGlobalProperty(PropertyKeys.EVIDENCE_PATH);
    }

}
