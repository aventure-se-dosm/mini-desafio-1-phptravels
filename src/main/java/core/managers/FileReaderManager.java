package core.managers;

import core.dataProviders.ConfigFileReader;


public class FileReaderManager {
	

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public static ConfigFileReader getConfigFileReader() {
		return (configFileReader == null
		        ? new ConfigFileReader()
		        : configFileReader);
	}
	
	public static String getGlobalProperty(String propertyKey) {
		return getConfigFileReader().getProperty(propertyKey);
	}
	
	public static String getDefaultWebdriverType() {
		return getGlobalProperty("DEFAULT_WEBDRIVER_TYPE");
	}

}
