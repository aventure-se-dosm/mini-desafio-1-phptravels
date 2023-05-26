package core.dataProviders;

public abstract class AbstractReader {
    protected String readedFilePath;

    public AbstractReader(String configPath) {
	readedFilePath = configPath;
	setupReading();
    }

    protected abstract void setupReading();

    protected abstract void closeReader();
}
