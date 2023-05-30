package core.utils.webutils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Waits {

    private WebDriver driver;
    private FluentWait<WebDriver> fluentWait, alertWait;

    public Waits(WebDriver driver) {
	this.setDriver(driver);
	fluentWait = new FluentWait<>(getDriver());
	alertWait = new FluentWait<>(getDriver());
    }

    public boolean waitUntilElementIsClickable(WebElement element) {
	return fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofMinutes(1))
		.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element),
			ExpectedConditions.visibilityOf(element)));
    }

    public boolean waitUntilElementIsVisible(WebElement element) {
	try {

	    fluentWait.pollingEvery(Duration.ofMillis(50)).withTimeout(Duration.ofSeconds(20))
		    .until(ExpectedConditions.visibilityOf(element));
	    return true;
	} catch (TimeoutException texcp) {
	    return false;
	}
    }

    public Alert AlertWait() {
	return alertWait.pollingEvery(Duration.ofMillis(50)).withTimeout(Duration.ofMillis(50))
		.ignoring(Exception.class).until(ExpectedConditions.alertIsPresent());
    }

    private WebDriver getDriver() {
	return driver;
    }

    private void setDriver(WebDriver driver) {
	this.driver = driver;
    }

}
