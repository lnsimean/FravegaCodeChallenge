package com.fravega.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fravega.utilities.Strings;

public class FilterPage {
	
	WebDriver driver;
	
	//----------------- Elements -----------------//
	
	@FindBy(name = "viewAllBrands")
	WebElement viewAllBrandsLink;
	
	@FindBy(xpath = "//div[@class='styled__StyledCheckbox-sc-37brzp-4 eTNIZl']")
	List<WebElement> brandModalWindowList;
	
	@FindBy(name = "brandAggregation")
	List<WebElement> brandList;
	
	@FindBy(name = "subcategoryAggregation")
	List<WebElement> categoryList;
	
	@FindBy(id = "apply")
	WebElement applyButton;
	
	@FindBy(xpath = "//li[@name='totalResult']/span")
	WebElement resultsCountLabel;
	
	@FindBy(xpath = "//li[contains (@class,'breadcrumbstyled__ListItem-vxt6er-3')][3]/a")
	WebElement breadCrumbLevel3Label;
	
	
	//----------------- Methods -----------------//

	public FilterPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void filterByCategory(String category) throws InterruptedException {
		for (int i = 0; i < categoryList.size(); i++) {
			if (Strings.removeAmountFromCategories(categoryList.get(i).getText()).equals(category)){
				categoryList.get(i).click();
				Thread.sleep(500);
			}
		}
	}

	public void filterByBrand(String brand) throws InterruptedException {
		if (viewAllBrandsLink.isDisplayed()) {
			openBrandModalWindow(brand);
		}
		else {
			findBrandInChecklist(brand);
		}
	}
	
	public String getResultsCountLabel() {
		return resultsCountLabel.getText();
	}
	
	public String getBreadCrumbLevel3() {
		return breadCrumbLevel3Label.getText();
	}
	
	//----------------- Private Methods -----------------//
	
	private void openBrandModalWindow(String brand) throws InterruptedException {
		viewAllBrandsLink.click();
		for (int i = 0; i < brandModalWindowList.size(); i++) {
			if (Strings.removeAmountFromCategories(brandModalWindowList.get(i).getText()).equals(brand)){
				brandModalWindowList.get(i).click();
				Thread.sleep(100);
			}
		}
		applyButton.click();
		Thread.sleep(500);
	}
	
	private void findBrandInChecklist(String brand) throws InterruptedException {
		for (int i = 0; i < brandList.size(); i++) {
			if (Strings.removeAmountFromCategories(brandList.get(i).getText()).equals(brand)){
				brandList.get(i).click();
				Thread.sleep(500);
			}
		}
	}
	
	//Me faltaria hacer algun tipo de validacion para que en caso de que no encuentre la categoria o la marca, arroje en pantalla "No se encontro la categoria X", "No se encontro la marca X" 
	
}
