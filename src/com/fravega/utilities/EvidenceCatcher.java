package com.fravega.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class EvidenceCatcher {
	
	public static void takeScreenshot(String location, WebDriver driver, int result) {
		
		Date date = new Date();
		String timestamp = date.toString().replace(":", "_").replace(" ", "_").replace("/", "_").replace(".", "_");
		
		String status = null;
		
		if (result == ITestResult.SUCCESS) {
			status = "PASS";
	    } else if (result == ITestResult.FAILURE) {
			status = "FAIL";
	    }
		
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(location + "__" + status + "__" + timestamp + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
