package core.dataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import core.utils.enums.CoreProperties;

public class ConfigFileReader {

	
	private String dataSourcePath;
	
	
	private static Properties properties;
	private final String GLOBAL_CONFIG_PATH = "./config/config.properties";
//	private final String CORE_CONFIG_PATH = "./config/config.properties";
//	private final String BUSINES_LOGIC_CONFIG_PATH = "./config/config.properties";

	public ConfigFileReader() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(GLOBAL_CONFIG_PATH)));
			properties = new Properties();

			properties.load(reader);
			reader.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private Properties getProperties() {
		return properties;
	}

	public String getProperty(String propertyKey) {
		return getProperties().get(propertyKey).toString();
	}
	
	public String getDataSourcePath() {
		return getProperties().get(CoreProperties.DATA_SOURCE_PATH.name()).toString();
	}
}
