package br.dev.marcelodeoliveira.core.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import br.dev.marcelodeoliveira.core.context.TestContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverManager {

	private static DriverManagerType DEFAULT_DRIVER;
	private WebDriver driver;

	public DriverManager() {
		setDriver();
	}

	private void setDefaultDriver() {
		DriverManager.DEFAULT_DRIVER = DriverManagerType
				.valueOf(TestContext.getConfigFileReader().getDefaultWebdriverType().toUpperCase());
	}

	private void setDriver() {
		setupDrivers();
		setDefaultDriver();
		setSelectedDriver(DEFAULT_DRIVER);
	}

	public WebDriver getDriver() {
		if (driver == null) {
			setDriver();
		}
		return driver;
	}

	private void setupDrivers() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.safaridriver().setup();
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

			driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		}
		}
	}

	public void closeDriver() {

		if (driver != null) {
			driver.close();
		}

	}

	public void killDriver() {

		if (driver != null) {
			driver.quit();
		}

		driver = null;
	}

}
