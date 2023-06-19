package br.dev.marcelodeoliveira.core.utils.webutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private JavascriptExecutor jsexec;

    public JavaScriptUtils(WebDriver driver) {
	this.jsexec = ((JavascriptExecutor) driver);
    }

    public void scrollToElement(WebElement welem) {
	jsexec.executeScript("scroll(arguments[0]);", welem);
    }

}