package com.fravega.utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.fravega.utilities.Reader;

public class BeforeAfter {
	
	protected static WebDriver driver;
	protected static WebElement element;
	protected static Properties properties = Reader.propertiesFile("./src/com/fravega/properties/project.properties");
	
	@BeforeTest
	@Parameters("Browser")	
	public void setUp(String browser) throws Exception {
		switch (browser) {
		case "chrome":
			System.setProperty(properties.getProperty("ChromeKey"), properties.getProperty("ChromePath"));
	        driver = new ChromeDriver();
			break;
		default:
			System.out.println("Cannot open browser(s)");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
