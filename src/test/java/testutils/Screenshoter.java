package testutils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//não acho uma boa mexer com a data aqui!
public class Screenshoter {

	private final static String DEFAULT_EXTENSION = ".png";
	private final static String DEFAULT_DESTINATION_DIRECTORY = "./target/Screenshots/";
	private final static String FORMATO_DATA_AVAL_1 = "dd_MM_YYYY_hh_mm_ss";
	private static WebDriver driver;
	
	public void Screenshot(WebDriver webDriver){
	    Screenshoter.driver = webDriver;
	}

	private static String stringDaData() {

		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMATO_DATA_AVAL_1));

	}

	public static void makeScreenshot(String destination, String filename) {

		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(shot, new File((destination + filename)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void takeScreenshot(Boolean status) {

		String result = (status.booleanValue() ? "SUCESSO" : "FALHOU");
		String shotFileName = String.join("_", stringDaData(), result, DEFAULT_EXTENSION);
		makeScreenshot(DEFAULT_DESTINATION_DIRECTORY, shotFileName);
	}

}
