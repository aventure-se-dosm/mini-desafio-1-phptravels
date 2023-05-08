package model.enums;
public enum ConfigPaths {


	GLOBAL("./config/config.properties"), 
	CORE("./src/main/core/core.properties"),
	MODEL("./src/main/model/model.properties");

	private final String path;


	private ConfigPaths(String path) {
		this.path = path;
	};


	public String getPath(ConfigPaths confPath) {
		return confPath.path;
	}
	
	
}
