package com.dss.pages.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dss.pages.BasePage;

public class EbayProductPage extends BasePage {
	By productPrice = By.id("prcIsum");

	public EbayProductPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Get the product price listed on the product page
	 * 
	 * @return the product price
	 */
	public String getProductPrice() {
		return getElement(productPrice).getText();
	}
}