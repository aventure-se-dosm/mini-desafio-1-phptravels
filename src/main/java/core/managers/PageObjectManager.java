package core.managers;

import org.openqa.selenium.WebDriver;

import model.pages.FormSubmitPage;

public class PageObjectManager {

	private FormSubmitPage formSubmitPage;

	private WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public FormSubmitPage getFormSubmitPage() {
		if (formSubmitPage == null)
			formSubmitPage = new FormSubmitPage(driver);
		return formSubmitPage;
	}
}
