package com.dss.pages.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dss.pages.BasePage;

public class EbayHomePage extends BasePage {
	By searchField = By.id("gh-ac");
	By searchButton = By.id("gh-btn");

	final String EBAY_URL = "http://www.ebay.com";

	public EbayHomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Search for an item on the Ebay homepage top search bar.
	 * 
	 * @param searchTerm the keyword to enter in the search bar.
	 * @return the EbaySearchResultsPage
	 */
	public EbaySearchResultsPage searchForItem(String searchTerm) {
		driver.get(EBAY_URL);
		editField(searchField, searchTerm);
		clickElement(searchButton);
		return new EbaySearchResultsPage(driver);
	}
}