package core.utils.webutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshoter {

	private  WebDriver driver;

	public Screenshoter(WebDriver webDriver) {
		driver = webDriver;
	}

	public void takeScreenshot(String fullFilePath) {

		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(shot, new File(fullFilePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenshot(WebDriver webDriver, String destination,
	        String shotFileName, String defaultExtension) {
		takeScreenshot(destination + shotFileName + defaultExtension);
	}

}
