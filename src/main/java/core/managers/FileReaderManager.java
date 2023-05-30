package core.managers;

import core.dataProviders.ConfigFileReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    public static FileReaderManager getInstance() {
	return fileReaderManager;
    }

    private static ConfigFileReader getConfigFileReader() {
	return (configFileReader == null ? configFileReader = new ConfigFileReader() : configFileReader);

    }

    public static String getGlobalProperty(String propertyKey) {
	return getConfigFileReader().getProperty(propertyKey);
    }

    public static String getXLSXDataSource() {
	return getGlobalProperty("data.source");
    }

    public static String getDefaultWebdriverType() {
	return getGlobalProperty("webdriver.type");
    }

    public static String getDefaultStartingUrl() {
	return getGlobalProperty("starting.url");
    }

    public static String getDefaultEvidenceFormat() {
	return getGlobalProperty("evidence.format");
    }

    public static String getDefaultEvidencePath() {
	return getGlobalProperty("evidence.path");
    }

}
