package model.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import core.utils.webutils.JavaScriptUtils;
import core.utils.webutils.Waits;

public abstract class Page {

	protected WebDriver driver;
	protected FluentWait<WebDriver> isElemClickable;
	protected FluentWait<WebDriver> elemIsPresent;
	protected JavaScriptUtils javaScriptUtils;
	protected Waits waits;

	public Page(WebDriver wdriver) {
		driver = wdriver;
		this.javaScriptUtils = new JavaScriptUtils(driver);
		this.elemIsPresent = new FluentWait<WebDriver>(driver);
		this.isElemClickable = new FluentWait<WebDriver>(driver);
		this.waits = new Waits(driver);
	}

	protected String getText(WebElement element) {
		return element.getText();
	}

	protected String getAttribute(WebElement element, String attibute) {
		return element.getAttribute(attibute);
	}

	protected void writeText(WebElement element, String text) {
		waits.waitUntilElementIsVisible(element);

		element.sendKeys(text);
	}

	protected void clickOnElement(WebElement element) {

		if (waits.waitUntilElementIsClickable(element))
			element.click();
	}

	protected String getAlertMessage() {
		String alertMesage = "";
		try {
			Alert alert = waits.AlertWait();
			alertMesage = alert.getText();
			alert.accept();
			return alertMesage;
		} catch (TimeoutException t) {
			return alertMesage;
		}

	}

}
