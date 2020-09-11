package com.fravega.utilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.fravega.utilities.Reader;
import com.fravega.utilities.EvidenceCatcher;

public class BeforeAfter {
	
	protected static WebDriver driver;
	protected static WebElement element;
	protected static Properties properties = Reader.propertiesFile("./src/com/fravega/properties/project.properties");
	
	@BeforeClass
	@Parameters("Browser")	
	public void setUp() throws Exception {
		System.setProperty(properties.getProperty("ChromeKey"), properties.getProperty("ChromePath"));
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDownAndCatchEvidence(ITestResult result) throws IOException, InterruptedException {
		EvidenceCatcher.takeScreenshot(properties.getProperty("evidenceOutput"), driver, result.getStatus());
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
