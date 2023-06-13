package core.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import core.context.TestContext;

public class DriverManager {

    enum DriverManagerType {
	CHROME, EDGE, FIREFOX, IEXPLORER, SAFARI;

	public String valueOf() {
	    return this.toString().toUpperCase();
	}

    }

    private static DriverManagerType DEFAULT_DRIVER;
    private WebDriver driver;
    private boolean webDriverStatus;

    public DriverManager() {
	setDriver();
	webDriverStatus = false;
    }

    private void setDefaultDriver() {
	DriverManager.DEFAULT_DRIVER = DriverManagerType
		.valueOf(TestContext.getConfigFileReader().getDefaultWebdriverType().toUpperCase());
    }

    private void setDriver() {
	setDefaultDriver();
	setSelectedDriver(DEFAULT_DRIVER);
    }

    private boolean isWebDriverClosed() {
	return webDriverStatus;
    }

    private void changeWebDriverStatus() {
	webDriverStatus = !webDriverStatus;
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
	    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
	}
	}
    }

    public void closeDriver() {

	if (driver != null || isWebDriverClosed()) {
	    driver.close();
	    changeWebDriverStatus();
	}
    }

    public void killDriver() {

	if (driver != null || isWebDriverClosed()) {
	    driver.quit();
	    changeWebDriverStatus();
	}

	driver = null;
    }

}
