package core.utils.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class Waits {

	private WebDriver driver;
	private FluentWait<WebDriver> fluentWait;

	public Waits(WebDriver driver) {
		this.driver = driver;
	}

}
