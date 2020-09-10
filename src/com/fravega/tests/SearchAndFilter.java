package com.fravega.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
		
		SoftAssert softAssert = new SoftAssert();
		
		BrowserUtilities.launch(driver, "baseUrl");
		
		headerPage.search("Heladera");
		filterPage.filterByCategory("Heladeras");
		filterPage.filterByBrand("Samsung");
		
		//---- Asserts ----//
		
		for (int i = 0; i < resultsSectionPage.getBrandListObject().size(); i++) {
			softAssert.assertTrue(resultsSectionPage.getBrandListObject().get(i).getText().contains("Samsung"));
		}

		softAssert.assertEquals(filterPage.getResultsCountLabel(), resultsSectionPage.getAmountOfResultsFromList());
		
		//El breadcrumb solo tiene las opciones, 'Heladeras, Freezers y Cavas' y 'Heladeras', no es lo que se pide en el desafio, pero estimo que es el level 3 del breadcrumb
		softAssert.assertEquals(filterPage.getBreadCrumbLevel3(), "Heladeras");
		
		softAssert.assertAll();
	}

}
