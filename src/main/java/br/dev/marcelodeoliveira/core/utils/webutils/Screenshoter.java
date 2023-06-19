package br.dev.marcelodeoliveira.core.utils.webutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.dev.marcelodeoliveira.core.utils.enums.FileFormatConstants.ImageFormats;

public class Screenshoter {

    private WebDriver driver;

    public Screenshoter(WebDriver webDriver) {
	this.driver = webDriver;
    }

    public void takeScreenshot(String fullFilePath) {

	File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
	    FileUtils.copyFile(shot, new File(fullFilePath));

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void takeScreenshot(String destination, String shotFileName, String defaultExtension) {
	takeScreenshot(destination + shotFileName + defaultExtension);
    }
    
    public void takeScreenshot(String destination, String shotFileName, ImageFormats defaultExtension) {
	takeScreenshot(destination + shotFileName + "." + defaultExtension.name());
    }

}
