package core.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;;

public class DriverManager {

	private final static DriverManagerType DEFAULT_DRIVER = DriverManagerType
	        .valueOf(FileReaderManager.getDefaultWebdriverType());

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

	public WebDriver setDriver(DriverManagerType selectedtDriver) {
		driver = getSelectedDriver(selectedtDriver);

		return driver;
	}

	public static WebDriver getSelectedDriver(DriverManagerType driverType) {

		switch (driverType) {

			case EDGE : {
				return new EdgeDriver();
			}
			case FIREFOX : {
				return new FirefoxDriver();
			}
			case IEXPLORER : {
				return new InternetExplorerDriver();
			}
			case SAFARI : {
				return new SafariDriver();
			}
			case CHROME :
			default : {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				return new ChromeDriver(options);

			}
		}
	}

	public void closeDriver() {

		if (driver != null) {
			driver.close();
		}

	}

	public void KillDriver() {

		if (driver != null) {
			driver.quit();
		}

		driver = null;
	}

}
