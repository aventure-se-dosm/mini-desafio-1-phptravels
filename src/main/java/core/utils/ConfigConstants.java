package core.utils;

public class ConfigConstants {
	enum ConfigPaths {

		GLOBAL_CONFIG_PATH("./config/config.properties"),
		CORE_CONFIG_PATH("./config/config.properties"),
		BUSINES_LOGIC_CONFIG_PATH("./config/config.properties");

		private ConfigPaths(String value) {
		};
	}
}
