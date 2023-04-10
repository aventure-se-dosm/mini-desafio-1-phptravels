package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;;

public class DriverManager {

	private final static DriverManagerType DEFAULT_DRIVER = DriverManagerType.CHROME;

	// ele deixará de ser estático quando trabalharmos com contexto!
	private WebDriver driver;

	public DriverManager() {
		if (this.driver == null) {
			setDriver(DEFAULT_DRIVER);
		}
	}

	public static void setupWebDrivers() {

		for (DriverManagerType dmt : DriverManagerType.values()) {
			WebDriverManager.getInstance(dmt).setup();
		}

	}

	public WebDriver getDriver() {
		if (driver == null) {
			driver = setDriver(DEFAULT_DRIVER);
		}

		return driver;
	}

	private WebDriver setDriver(DriverManagerType selectedtDriver) {
//		driver = WebDriverManager.getInstance(selectedtDriver).timeout(30000).getWebDriver();
		driver = new ChromeDriver();
//      driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		return driver;

	}

	public static WebDriver setNewChromeDriver() {
		WebDriver chDriver = WebDriverManager.getInstance(DriverManagerType.CHROME).timeout(30000).getWebDriver();

//		WebDriver chDriver = new ChromeDriver();
		// chDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		chDriver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

		return chDriver;

	}
}