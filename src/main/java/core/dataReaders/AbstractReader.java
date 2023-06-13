package core.dataReaders;

public abstract class AbstractReader {
    protected String configPath;

    public AbstractReader(String configPath) {
	this.configPath = configPath;
	setupReading();
    }

    protected abstract void setupReading();

    protected abstract void closeReader();
}
