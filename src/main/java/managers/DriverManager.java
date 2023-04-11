package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;;

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

	public WebDriver setDriver(DriverManagerType selectedtDriver) {
		driver = getSelectedDriver(selectedtDriver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
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
			case OPERA: {
				return new OperaDriver();
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
		WebDriver chDriver = WebDriverManager.getInstance(DriverManagerType.CHROME).timeout(30000).getWebDriver();
		chDriver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		return chDriver;
	}
}