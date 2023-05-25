package model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import core.utils.webutils.PageUtils;

public abstract class Page {

	protected WebDriver driver;
	protected FluentWait<WebDriver> isElemClickable;
	protected FluentWait<WebDriver> elemIsPresent;
	protected PageUtils pageUtils;

	public Page(WebDriver wdriver) {
		driver = wdriver;
		this.pageUtils = new PageUtils(driver);
		this.elemIsPresent = new FluentWait<WebDriver>(driver);
		this.isElemClickable = new FluentWait<WebDriver>(driver);
	}

}
