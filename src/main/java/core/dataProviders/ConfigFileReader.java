package core.dataProviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import core.utils.enums.CoreProperties;

public class ConfigFileReader extends AbstractReader {

	private final static String CORE_CONFIG_PATH = "./config/core.properties";

	private BufferedReader reader;

	public ConfigFileReader() {
		super(CORE_CONFIG_PATH);
	}

	// caso precisamos doutra instância de configFilePath
	public ConfigFileReader(String readedFilePath) {
		super(readedFilePath);
	}

	private Properties getProperties() {
		return properties;
	}

	public String getProperty(String propertyKey) {
		return getProperties().get(propertyKey).toString();
	}


	@Override
	protected void setupReading() {
		try {

			reader = new BufferedReader(
			        new FileReader(new File(readedFilePath)));
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
			// TODO Auto-generated catch block - create your own ExcepMessages!
			e.printStackTrace();
		}

	}
}
