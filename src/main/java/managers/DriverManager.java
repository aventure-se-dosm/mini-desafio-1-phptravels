package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;;

public class DriverManager {

	private static final DriverManagerType DEFAULT_DRIVER = DriverManagerType.CHROME;

	// ele deixará de ser estático quando trabalharmos com contexto!
	private static WebDriver driver;

	private DriverManager() {

	}

	public static void setupWebDrivers() {

		for (DriverManagerType dmt : DriverManagerType.values()) {
			WebDriverManager.getInstance(dmt).setup();
		}

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			setDriver(DEFAULT_DRIVER);
		}

		return driver;
	}

	private static void setDriver(DriverManagerType defaultDriver) {
		driver = WebDriverManager.getInstance(defaultDriver).timeout(30000).getWebDriver();


	}
}