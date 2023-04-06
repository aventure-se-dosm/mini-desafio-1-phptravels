package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormSubmitPage {

	private WebDriver driver;


	@FindBy(css = "input.first_name")
	public WebElement nameInput;

	@FindBy(css = "input.last_name")
	public WebElement surnameInput;

	@FindBy(css = "input.business_name")
	public WebElement businessNameInput;

	@FindBy(css = "input.email")
	public WebElement emailInput;

	@FindBy(css = "h2.mw100")
	public WebElement enigmaExpression;

	@FindBy(id = "numb1")
	public WebElement numb1;

	@FindBy(id = "numb2")
	public WebElement numb2;

	@FindBy(id = "number")
	public WebElement solutionInput;

	@FindBy(id = "demo")
	public WebElement submitButton;

	@FindBy(xpath = "strong[contains(.,'Thank you!')]")
	public WebElement thankYouMessage;

	@FindBy(css = "p.text-center.cw")
	public WebElement confirmationMailCheckMessage;

	public FormSubmitPage(WebDriver webDriver) {
		this.driver = webDriver;
	}
//	public FormSubmitPage(WebDriver driver) {
//		super(driver);
//	}

	public void preencheNome(String nome) {
		nameInput.sendKeys(nome);
	}

	public void preencheSobreome(String sobrenome) {

	}

	public void preencheEmpresa(String empresa) {

	}

	public void preencheEmail(String email) {

	}

}
