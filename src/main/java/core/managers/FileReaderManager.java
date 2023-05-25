package core.managers;

import core.dataProviders.ConfigFileReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	private static ConfigFileReader getConfigFileReader() {
		return (configFileReader == null ? new ConfigFileReader() : configFileReader);
	}

	public static String getGlobalProperty(String propertyKey) {
		return getConfigFileReader().getProperty(propertyKey);
	}

	public static String getXLSXDataSource() {
		return getGlobalProperty("XLSX_DATA_SOURCE");
	}

	public static String getDefaultWebdriverType() {
		return getGlobalProperty("DEFAULT_WEBDRIVER_TYPE");
	}
	
	public static String getDefaultStartingUrl() {
		return getGlobalProperty("DEFAULT_STARTING_URL");
	}

	public static String getDefaultEvidenceFormat() {
		return getGlobalProperty("DEFAULT_EVIDENCE_FORMAT");
	}

	public static String getDefaultEvidencePath() {
		return getGlobalProperty("DEFAULT_EVIDENCE_PATH");
	}

}
