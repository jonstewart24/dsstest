package com.dss.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dss.pages.gmail.GmailHomePage;

public class GmailTest extends BaseTest {
	// Replace with valid credentials before running tests
	final String GMAIL_USERNAME = "disneysstest";
	final String GMAIL_PASSWORD = "";

	@Test
	public void testLogin_ValidCredentials() {
		GmailHomePage gmailPage = new GmailHomePage(driver);

		gmailPage.openLoginPage();
		gmailPage.enterUsername(GMAIL_USERNAME);
		gmailPage.enterPassword(GMAIL_PASSWORD);
		assertTrue("Failed to login successfully", gmailPage.isLoggedIn());
	}

	@Test
	public void testLogin_BlankPassword() {
		GmailHomePage gmailPage = new GmailHomePage(driver);

		gmailPage.openLoginPage();
		gmailPage.enterUsername(GMAIL_USERNAME);
		gmailPage.enterPassword("");

		assertEquals("Correct error message was not displayed", "Enter a password", gmailPage.getErrorMessage());
	}

	@Test
	public void testLogin_BlankUsername() {
		GmailHomePage gmailPage = new GmailHomePage(driver);

		gmailPage.openLoginPage();
		gmailPage.enterUsername("");
		assertEquals("Correct error message was not displayed", "Enter an email or phone number",
				gmailPage.getErrorMessage());
	}
}