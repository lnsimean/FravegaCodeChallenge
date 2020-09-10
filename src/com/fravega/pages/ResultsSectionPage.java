package com.fravega.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsSectionPage {
	
	WebDriver driver;
	
	//----------------- Elements -----------------//
	
	@FindBy(xpath = "//ul[@name='itemsGrid']/li/div")
	List<WebElement> results;

	
	//----------------- Methods -----------------//

	public ResultsSectionPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public String getAmountOfResultsFromList() {
		return String.valueOf(results.size());
	}
	
	public List<WebElement> getBrandListObject() {
		return results;
	}
}
