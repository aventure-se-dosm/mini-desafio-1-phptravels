package steps;

import static managers.DriverManager.setupWebDrivers;

import org.junit.BeforeClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import testutils.Screenshoter;

public class Hooks {

	@BeforeClass
	public static void setupClass() {
		setupWebDrivers();
	}
	
	@After
	public void printa (Scenario s){
		Screenshoter.takeScreenshot(s);
	}

}
