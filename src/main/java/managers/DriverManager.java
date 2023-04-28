package managers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;;

public class DriverManager {

	private final static DriverManagerType DEFAULT_DRIVER = DriverManagerType.CHROME;

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

	public WebDriver getDriver(WebDriver extDriver) {
		if (extDriver == null) {
			// detectar o tipo de driver renová-lo pelo tipo mais específico.
			extDriver = new ChromeDriver();
		}
		return extDriver;
	}

	public WebDriver setDriver(DriverManagerType selectedtDriver) {
		driver = getSelectedDriver(selectedtDriver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		return driver;
	}

	public static WebDriver getSelectedDriver(DriverManagerType driverType) {

		switch (driverType) {
			case EDGE: {
				return new EdgeDriver();
			}
			case FIREFOX: {
				return new FirefoxDriver();
			}
			case IEXPLORER: {
				return new InternetExplorerDriver();
			}
	
			case SAFARI: {
				return new SafariDriver();
			}
			case CHROME:
			default: {
				return new ChromeDriver();
			}
		}
	}

	public static WebDriver setNewChromeDriver() {
		WebDriver extDriver = new ChromeDriver();
		extDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		return extDriver;
	}
}