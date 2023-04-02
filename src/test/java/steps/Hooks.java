package steps;

import static managers.DriverManager.setupWebDrivers;

import org.junit.BeforeClass;

public class Hooks {

	@BeforeClass
	public static void setupClass() {
		setupWebDrivers();
	}

}
