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

}
