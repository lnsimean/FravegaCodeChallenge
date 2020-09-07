package com.fravega.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	WebDriver driver;
	
	//----------------- Elements -----------------//
	
	
	@FindBy(css = "div.SearchBar__SearchWrapper-xgngsx-10.bIEixJ input")
    WebElement searchInputField;
	
	@FindBy(css = "div.SearchBar__SearchWrapper-xgngsx-10.bIEixJ button")
    WebElement confirmSearchButton;
	
	//----------------- Methods -----------------//

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void search(String keyword) throws InterruptedException {
		searchInputField.sendKeys(keyword);
		confirmSearchButton.click();
		Thread.sleep(500);
	}

}
