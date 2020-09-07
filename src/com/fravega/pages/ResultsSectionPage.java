package com.fravega.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsSectionPage {
	
	WebDriver driver;
	
	//----------------- Elements -----------------//
	
	@FindBy(className = "PieceTitle-sc-1eg7yvt-0 akEoc")
	List<WebElement> brandList;
	
	@FindBy(css = "li.listingDesktopstyled__TotalResult-wzwlr8-2.jPwsRI span")
	WebElement resultsCountLabel;
	
	@FindBy(xpath = "//li[contains (@class,'breadcrumbstyled__ListItem-vxt6er-3')][3]/a")
	WebElement breadCrumbLevel3Label;

	
	//----------------- Methods -----------------//

	public ResultsSectionPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public String getResultsCountLabel() {
		return resultsCountLabel.getText();
	}
	
	public String getAmmountOfResultsFromList() {
		return String.valueOf(brandList.size());
	}
	
	public List<WebElement> getBrandListObject() {
		return brandList;
	}

	public String getBreadCrumbLevel3() {
		return breadCrumbLevel3Label.getText();
	}
}
