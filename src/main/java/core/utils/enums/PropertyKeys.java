package core.utils.enums;

public enum PropertyKeys {

    DATA_SOURCE("data.source"),

    STARTING_URL("starting.url"),

    EVIDENCE_PATH("evidence.path"), EVIDENCE_FORMAT("evidence.format"),

    WEBDRIVER_TYPE("webdriver.type"), WINDOW_MAXIMIZE("window.maximize");

    private String value;

    private PropertyKeys(String value) {
	this.value = value;
    };

    public String getValue() {
	return value;
    }
}
