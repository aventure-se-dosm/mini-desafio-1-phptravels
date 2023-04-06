package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
			setDriver();
		}

		return driver;
	}

	private static void setDriver() {
        //driver = WebDriverManager.getInstance("Chrome").timeout(9999999).getWebDriver();
		driver = new ChromeDriver();	}
}