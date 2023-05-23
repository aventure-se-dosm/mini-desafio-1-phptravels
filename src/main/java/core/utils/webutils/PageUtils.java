package core.utils.webutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {

	private JavascriptExecutor jsexec;

	public PageUtils(WebDriver driver) {
		this.jsexec = ((JavascriptExecutor) driver);
	}

	public void ScrollToElement(WebElement welem) {
		jsexec.executeScript("scrollIntoView(arguments[0]);", welem);
	}

}
