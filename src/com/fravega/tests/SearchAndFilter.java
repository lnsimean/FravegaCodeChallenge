package com.fravega.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fravega.pages.FilterPage;
import com.fravega.pages.HeaderPage;
import com.fravega.pages.ResultsSectionPage;
import com.fravega.utilities.BeforeAfter;
import com.fravega.utilities.BrowserUtilities;

public class SearchAndFilter extends BeforeAfter {
	HeaderPage headerPage;
	FilterPage filterPage;
	ResultsSectionPage resultsSectionPage;
	
	@Test(priority=1, testName = "Buscar 'Heladera', y filtrar por 'Heladeras' de la marca 'Samsung'")
	public void searchAndFilter() throws InterruptedException {
		headerPage = new HeaderPage(driver);
		filterPage = new FilterPage(driver);
		resultsSectionPage = new ResultsSectionPage(driver);
		BrowserUtilities.launch(driver, "baseUrl");
		
		//Search for 'Heladera' in the header search field
		headerPage.search("Heladera");
		filterPage.filterByCategory("^Heladeras (\\d{1,3})$");
		filterPage.filterByBrand("Samsung");
		
		//---- Asserts ----//
		for (int i = 1; i <= resultsSectionPage.getBrandListObject().size(); i++) {
			assertTrue(resultsSectionPage.getBrandListObject().get(i).getText().contains("Samsung"));
		}
		
		assertEquals(resultsSectionPage.getResultsCountLabel(), resultsSectionPage.getAmmountOfResultsFromList());
		
		//El breadcrumb solo tiene las opciones, 'Heladeras, Freezers y Cavas' y 'Heladeras'
		assertEquals(resultsSectionPage.getBreadCrumbLevel3(), "Heladeras");
	}
	

}
