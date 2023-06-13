package core.managers;

import core.dataProviders.ConfigFileReader;
import core.utils.enums.PropertyKeys;

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

}
