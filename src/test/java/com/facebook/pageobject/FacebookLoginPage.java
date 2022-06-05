package com.facebook.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	WebDriver driver;
	// webElement declaration

	@FindBy(id = "email")
	private WebElement emailField;
	@FindBy(id = "pass")
	private WebElement passwordField;
	@FindBy(xpath = "//*[text()='Log In' and @name='login']")
	private WebElement loginButton;

	public FacebookLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * Method to enter usename
	 */

	public void enterUsername(String emailAddress) {
		emailField.clear();
		emailField.sendKeys(emailAddress);
	}

	/**
	 * Method to enter password
	 */

	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	/**
	 * Method to click on log in buttons
	 */

	public void clickOnLogInButton() {
		loginButton.click();
	}

}
