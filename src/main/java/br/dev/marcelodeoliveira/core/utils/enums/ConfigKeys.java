package br.dev.marcelodeoliveira.core.utils.enums;

public enum ConfigKeys implements PropertyKeys {

    DATA_SOURCE_LOCATION("data.source.location"),
    DATA_SOURCE_NAME("data.source.name"),
    DATA_SOURCE_FORMAT("data.source.format"),

    STARTING_URL("starting.url"),
    EVIDENCE_PATH("evidence.path"), EVIDENCE_FORMAT("evidence.format"),
    WEBDRIVER_TYPE("webdriver.type"), WINDOW_MAXIMIZE("window.maximize"),
    DEFAULT_SHEET_NAME("data.source.entity");


    private String value;

    private ConfigKeys(String value) {
	this.value = value;
    };

    public String getValue() {
	return value;
    }
}
