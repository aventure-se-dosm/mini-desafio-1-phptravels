package core.utils.enums;

public class ConfigConstants {
	
	enum ConfigPaths {

		GLOBAL_CONFIG_PATH("./config/config.properties"),
		CORE_CONFIG_PATH("./config/core.properties"),
		BUSINES_LOGIC_CONFIG_PATH("./config/businessLogic.properties");

		private ConfigPaths(String value) {
		};
	}
}
