package core.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	
	private enum ScenarioContextKeys {
		WEBDRIVER,
		SCENARIO_ID,
	}

	private Map<String, Object> scenarioContext;
	
	public ScenarioContext() {
		scenarioContext = new HashMap<>();
	}
	
	public void storeValue (ScenarioContextKeys key, Object value) {
		scenarioContext.put(key.toString(), value);
	}
	
	public Object getValue (String key) {
		return scenarioContext.get(key);
	}
	
	public boolean isValuePresent () {
		return false;
	}
	
}
