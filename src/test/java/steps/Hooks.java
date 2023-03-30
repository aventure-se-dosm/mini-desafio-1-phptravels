package steps;

import org.junit.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
}
