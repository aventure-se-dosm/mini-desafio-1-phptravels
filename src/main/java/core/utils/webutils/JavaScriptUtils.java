package core.utils.webutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	private WebDriver driver;
	private JavascriptExecutor jsexec;

	public JavaScriptUtils(WebDriver driver) {
		this.driver = driver;
		this.jsexec = ((JavascriptExecutor) driver);
	}

	public void ScrollToElement(WebElement welem) {
		jsexec.executeScript("scroll(arguments[0]);", welem);
	}

}