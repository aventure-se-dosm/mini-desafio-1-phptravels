package core.utils.webutils;

import java.time.Duration;
import java.util.Collection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import core.managers.FileReaderManager;

public class Waits {

    private WebDriver driver;
    private FluentWait<WebDriver> fluentWait;

    private FluentWait<WebDriver> getFluentWait() {
	return fluentWait;
    }

    private Duration getPollingTime() {
	return pollingTime;
    }

    private Duration getAlertTimeout() {
	return alertTimeout;
    }

    private Duration getTimeout() {
	return timeout;
    }

    private Duration pollingTime;
    private Duration alertTimeout;
    private Duration timeout;

    public Waits(WebDriver driver) {
	this.setDriver(driver);
	fluentWait = new FluentWait<>(getDriver());
	setupWaits();
    }

    private void setupWaits() {
	this.pollingTime = FileReaderManager.getDefaultWaitPolling();
	this.alertTimeout = FileReaderManager.getAlertWaitTimeout();
	this.timeout = FileReaderManager.getDomElementWaitTimeout();
    }

    public boolean executeWait(WebElement element, Duration pollingDuration, Duration timeoutDuration,
	    Collection<Exception> ignoredExceptions, ExpectedCondition<?>[] expectedConditions) {
	try {
	    getFluentWait().pollingEvery(pollingDuration).withTimeout(timeoutDuration)
		    .until(ExpectedConditions.and(expectedConditions));
	    return true;
	} catch (TimeoutException texcp) {
	    return false;
	}
    }

    public boolean waitUntilElementIsClickable(WebElement element) {
	try {
	    getFluentWait().pollingEvery(getPollingTime()).withTimeout(getTimeout()).until(ExpectedConditions
		    .and(ExpectedConditions.elementToBeClickable(element), ExpectedConditions.visibilityOf(element)));
	    return true;
	} catch (TimeoutException texcp) {
	    return false;
	}
    }

    public boolean waitUntilElementIsVisible(WebElement element) {
	try {
	    getFluentWait().pollingEvery(getPollingTime()).withTimeout(getTimeout())
		    .until(ExpectedConditions.visibilityOf(element));
	    return true;
	} catch (TimeoutException texcp) {
	    return false;
	}

    }

    public Alert AlertWait() {
	try {
	    return getFluentWait().pollingEvery(getPollingTime()).withTimeout(getAlertTimeout())
		    .ignoring(ElementNotInteractableException.class, TimeoutException.class)
		    .until(ExpectedConditions.alertIsPresent());
	} catch (TimeoutException e) {
	    return null;
	}
    }

    private WebDriver getDriver() {
	return driver;
    }

    private void setDriver(WebDriver driver) {
	this.driver = driver;
    }
}
