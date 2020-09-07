package com.fravega.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.fravega.utilities.BeforeAfter;

public class BrowserUtilities {
	
	//Method to launch the site
	public static void launch(WebDriver driver, String baseUrl) {
		driver.get(BeforeAfter.properties.getProperty(baseUrl));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
