package core.utils.webutils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {

	/**
	 * deixar essas config aqui não parece legal: não deveria ser uma config 'de
	 * regra de negócio"? resolve as do core primeiro, mas pensa nisso depois!
	 */

	private JavascriptExecutor jsexec;

	public PageUtils(WebDriver driver) {
		this.jsexec = ((JavascriptExecutor) driver);
	}

	public void ScrollToElement(WebElement welem) {
		jsexec.executeScript("scrollIntoView(arguments[0]);", welem);
	}
	

}
