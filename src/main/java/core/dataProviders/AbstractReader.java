package core.dataProviders;

import java.util.Properties;

public abstract class AbstractReader {
	protected Properties properties;
	protected String readedFilePath;


	public AbstractReader(String configPath) {
		this.readedFilePath = configPath;
		setupReading();
	}

	protected abstract void setupReading();
	
	protected abstract void closeReader();
}
