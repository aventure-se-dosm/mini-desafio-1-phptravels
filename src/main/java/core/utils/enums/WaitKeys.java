package core.utils.enums;

public enum WaitKeys implements PropertyKeys {

    WAIT_POLLING("wait.polling.timeUnit", "wait.polling.value"),
    WAIT_DOM_TIMEOUT_TIMEUNIT("wait.dom.timeout.timeUnit", "wait.dom.timeout.value"),
    WAIT_OUTFLOW_ALERT_TIMEOUT("wait.outflow.alert.timeout.timeUnit", "wait.outflow.alert.timeout.value");

    private String timeUnitValue;
    private String numericalValue;

    private WaitKeys(String timeUnitValue, String numericalValue) {
	this.timeUnitValue = timeUnitValue;
	this.numericalValue = numericalValue;
    };


    public String getTimeUnit() {
	return this.timeUnitValue;
    };

    public String getNumericalValue() {
	return this.numericalValue;
    }

    @Override
    public Object getValue() {
	return this.toString();
    };

}
