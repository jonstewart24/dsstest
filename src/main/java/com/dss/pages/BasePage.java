package com.dss.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Enter a string of text in a field.
	 * 
	 * @param field the field to edit
	 * @param text the text to enter in the field
	 */
	public void editField(By field, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(field));
		driver.findElement(field).clear();
		driver.findElement(field).sendKeys(text);
	}

	/**
	 * Wait for the element to be visible, then click the element.
	 * 
	 * @param element the By locator of the element to click
	 */
	public void clickElement(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.findElement(element).click();
	}

	/**
	 * Wait for the element to be visible, then click the element.
	 * 
	 * @param element the WebElement to click
	 */
	public void clickElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	/**
	 * Wait for and return the WebElement
	 * 
	 * @param element the WebElement to get
	 * @return the WebElement
	 */
	public WebElement getElement(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	/**
	 * Switch to a newly opened tab.
	 */
	public void switchToNewTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
}
