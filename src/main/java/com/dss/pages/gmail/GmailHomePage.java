package com.dss.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dss.pages.BasePage;

public class GmailHomePage extends BasePage {

	By signInLink = By.linkText("Sign in");
	final String GMAIL_URL = "https://www.google.com/gmail/about/#";

	public GmailHomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter the Gmail username and click the next button.
	 * 
	 * @param username the username to enter.
	 */
	public void enterUsername(String username) {
		editField(By.id("identifierId"), username);
		clickElement(By.id("identifierNext"));
	}

	/**
	 * Enter the Gmail password and click the next button.
	 * 
	 * @param password the password to enter.
	 */
	public void enterPassword(String password) {
		editField(By.name("password"), password);
		clickElement(By.id("passwordNext"));
	}

	/**
	 * Open the login page and switch to the new tab.
	 */
	public void openLoginPage() {
		driver.get(GMAIL_URL);
		clickElement(signInLink);
		switchToNewTab();
	}

	/**
	 * Whether or not the user is logged in by the checking for the user profile icon.
	 * 
	 * @return boolean if the user is logged in or not.
	 */
	public boolean isLoggedIn() {
		getElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a"));
		return driver.findElements(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a")).size() > 0;
	}

	/**
	 * Get the given error message on the login screen.
	 * 
	 * @return the error message string.
	 */
	public String getErrorMessage() {
		return getElement(By.xpath(
				"//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]"))
						.getText();

	}
}