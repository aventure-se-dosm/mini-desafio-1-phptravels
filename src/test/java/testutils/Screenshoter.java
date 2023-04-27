package testutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshoter {

	private WebDriver driver;

	public Screenshoter(WebDriver webDriver) {
		this.driver = webDriver;
	}
	
	public void makeScreenshot(String destination, String shotFileName, String defaultExtension) {
		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(shot, new File(destination + shotFileName + defaultExtension));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
