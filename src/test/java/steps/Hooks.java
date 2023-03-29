package steps;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import core.managers.ConfigFileMananger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class Hooks {
	
	//posteriormente obtida a partir valor lido em arq. de config/FRM:
	private WebDriver defaultDriver;
	
	private Hooks() {
		
	};
	
	@BeforeClass
	private void inicializa () {
		//baixa os executáveis dos drivers: e aí... todos ou só o que vai usar?
		this.defaultDriver = WebDriverManager.getInstance(ConfigFileMananger.getDefaulWebDriver()).getWebDriver();
		inicializaWebDriver();
	}

	private void inicializaWebDriver() {
		inicializaWebDriver(ConfigFileMananger.getDefaulWebDriver());
		
	}

	//String? não tem enums na classe WDM do BG?
	private void inicializaWebDriver(String webdriver) {
		if (defaultDriver == null) {
			defaultDriver = WebDriverManager.getInstance(webdriver).getWebDriver();
		}
		
	}
	
	private void inicializaWebDriver(DriverManagerType webdriver) {
		if (defaultDriver == null) {
			defaultDriver = WebDriverManager.getInstance(webdriver).getWebDriver();
		}
		
	}
	

		
	
	

}
