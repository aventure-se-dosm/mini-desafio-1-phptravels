package core.managers;

import core.dataReaders.ConfigFileReader;


//Acabar com essa classe: eis a questão...



public class FileReaderManager {

    static ConfigFileReader configFileReader;

    public static ConfigFileReader getConfigFileReader() {
	return (configFileReader == null ? configFileReader = new ConfigFileReader() : configFileReader);
    }


}
