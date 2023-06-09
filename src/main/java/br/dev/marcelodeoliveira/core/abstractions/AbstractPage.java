package br.dev.marcelodeoliveira.core.abstractions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import br.dev.marcelodeoliveira.core.context.TestContext;
import br.dev.marcelodeoliveira.core.utils.webutils.JavaScriptUtils;
import br.dev.marcelodeoliveira.core.utils.webutils.Waits;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> isElemClickable;
    protected FluentWait<WebDriver> elemIsPresent;
    protected JavaScriptUtils javaScriptUtils;
    protected Waits waits;

    public AbstractPage(WebDriver wdriver) {
	driver = wdriver;
	this.javaScriptUtils = new JavaScriptUtils(driver);
	this.elemIsPresent = new FluentWait<WebDriver>(driver);
	this.isElemClickable = new FluentWait<WebDriver>(driver);
	this.waits = new Waits(driver);
    }

    public void startNavigation() {
	driver.manage().window().maximize();
	PageFactory.initElements(driver, this);
	driver.get(TestContext.getConfigFileReader().getDefaultStartingUrl());
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    protected String getText(WebElement element) {
	String texto = null;
	javaScriptUtils.scrollToElement(element);
	if (waits.waitUntilElementIsVisible(element)) {
	    return element.getText();
	}
	return texto;
    }

    protected void writeText(WebElement element, String text) {
	javaScriptUtils.scrollToElement(element);
	waits.waitUntilElementIsVisible(element);
	element.sendKeys(text);
    }

    protected void clickOnElement(WebElement element) {
	javaScriptUtils.scrollToElement(element);
	if (waits.waitUntilElementIsClickable(element))
	    element.click();
    }

    protected String getAlertMessage() {

	Alert alert = waits.alertWait();
	if (alert == null) {
	    return "";
	}
	String alertMesage = alert.getText();
	alert.accept();
	return alertMesage;
    }
}
