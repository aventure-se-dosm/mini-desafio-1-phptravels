package core.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.config.DriverManagerType;;

public class DriverManager {

	private final static DriverManagerType DEFAULT_DRIVER = DriverManagerType
			.valueOf(FileReaderManager.getDefaultWebdriverType());

	private WebDriver driver;

	public DriverManager() {
	//	if (this.driver == null) {
			setDriver();
		//}
	}

	private void setDriver() {
		setSelectedDriver(DEFAULT_DRIVER);
	}

	public WebDriver getDriver() {
		if (driver == null) {
			setSelectedDriver(DEFAULT_DRIVER);
		}
		return driver;
	}

	private void setSelectedDriver(DriverManagerType driverType) {

		switch (driverType) {

		case EDGE: {
			driver = new EdgeDriver();
		}
		case FIREFOX: {
			driver = new FirefoxDriver();
		}
		case IEXPLORER: {
			driver = new InternetExplorerDriver();
		}
		case SAFARI: {
			driver = new SafariDriver();
		}
		case CHROME:
		default: {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		}
		}
	}

	public void closeDriver() {

		if (driver != null) {
			driver.close();
		}
		// driver = null;
	}

	public void KillDriver() {

		if (driver != null) {
			driver.quit();
		}

		// driver = null;
	}

}
