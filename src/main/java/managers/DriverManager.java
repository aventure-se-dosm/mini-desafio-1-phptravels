package managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;;

public class DriverManager {

	private final DriverManagerType DEFAULT_DRIVER = DriverManagerType.CHROME;

	// ele deixará de ser estático quando trabalharmos com contexto!
	private WebDriver driver;

	private DriverManager() {

	}

	public static void setupWebDrivers() {

		for (DriverManagerType dmt : DriverManagerType.values()) {
			WebDriverManager.getInstance(dmt).setup();
		}

	}

	public WebDriver getDriver() {
		if (driver == null) {
			setDriver(DEFAULT_DRIVER);
		}

		return driver;
	}

	private void setDriver(DriverManagerType defaultDriver) {
		driver = WebDriverManager.getInstance(defaultDriver).timeout(30000).getWebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
}