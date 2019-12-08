package com.dss.pages.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.dss.pages.BasePage;

public class EbaySearchResultsPage extends BasePage {
	By searchField = By.id("gh-ac");
	By searchButton = By.id("gh-btn");
	By resultLink = By.className("s-item__link");

	public EbaySearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public EbayProductPage openResult(int resultNumber) {
		By result = By.id("srp-river-results-listing" + resultNumber);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(result));

		WebElement link = driver.findElement(result).findElement(resultLink);
		clickElement(link);
		return new EbayProductPage(driver);
	}
}