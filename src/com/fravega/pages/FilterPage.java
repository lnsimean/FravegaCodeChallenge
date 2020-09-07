package com.fravega.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	//----------------- Methods -----------------//

	public FilterPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void filterByCategory(String category) throws InterruptedException {
		for (int i = 1; i < categoryList.size(); i++) {
			if (categoryList.get(i).getText().matches(category)){
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
	
	//----------------- Private Methods -----------------//
	
	private void openBrandModalWindow(String brand) throws InterruptedException {
		viewAllBrandsLink.click();
		for (int i = 1; i < brandModalWindowList.size(); i++) {
			WebElement element = (WebElement) brandModalWindowList.get(i);
			if (element.getText().equals(brand)){
				System.out.println("Se encontro Samsung " + brand);
				brandModalWindowList.get(i).click();
				Thread.sleep(100);
				System.out.println("Se encontro Samsung " + brand);
			}
		}
		applyButton.click();
		Thread.sleep(500);
	}
	
	private void findBrandInChecklist(String brand) throws InterruptedException {
		for (int i = 1; i < brandList.size(); i++) {
			WebElement element = (WebElement) brandList.get(i);
			if (element.getText().equals(brand)){
				brandList.get(i).click();
				Thread.sleep(500);
			}
		}
	}
	
}
