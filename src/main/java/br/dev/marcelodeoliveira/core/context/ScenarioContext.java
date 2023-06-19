package br.dev.marcelodeoliveira.core.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<ScenarioContextKeys, Object> scenarioContext;

    public ScenarioContext() {
	scenarioContext = new HashMap<>();
    }

    void storeValue(ScenarioContextKeys key, Object value) {
	scenarioContext.put(key, value);
    }

    Object getValue(ScenarioContextKeys key) {
	return scenarioContext.get(key);
    }

    String getStringValue(ScenarioContextKeys key) {
 	return getValue(key).toString();
    }

}
