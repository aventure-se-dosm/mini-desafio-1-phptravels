package managers;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private final static String DEFAULT_BROWSER = "CHROME";
	private static WebDriverManager driverMananger;



	public static WebDriver getDriver() {
		if (driverMananger == null) {
			setWebDriver();
		}
		return driverMananger.getWebDriver();
	}

	private static void setWebDriver() {
		setWebDriver(DEFAULT_BROWSER);

	}

	public static void setWebDriver(String webDriver) {
		WebDriverManager.getInstance(webDriver).setup();
		driverMananger = WebDriverManager.getInstance(webDriver);
	}

	
}
