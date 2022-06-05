package com.facebook.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.baseclass.WaitHelper;

public class FacebookHomePage{
	WebDriver driver;
	WaitHelper waitHelper;
	Actions builder;
	JavascriptExecutor js;
	// declaration
	@FindBy(xpath = "//div[@class=\"rq0escxv l9j0dhe7 du4w35lb j83agx80 cbu4d94t qowsmv63 dp1hu0rb\"]//div[@class=\"ow4ym5g4 auili1gw rq0escxv j83agx80 buofh1pr g5gj957u i1fnvgqd oygrvhab cxmmr5t8 hcukyx3x kvgmc6g5 hpfvmrgz qt6c0cv9 jb3vyjys l9j0dhe7 du4w35lb bp9cbjyn btwxx1t3 dflh9lhu scb9dxdr nnctdnn4\"]//span[@class=\"a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7\"]")
	private WebElement profile;

	@FindBy(xpath = "//*[@class=\"m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b\"]")
	private WebElement statusTxt;

	@FindBy(xpath = "//*[@class=\"_1mf _1mj\"]")
	private WebElement statusBox;

	@FindBy(xpath = "//*[@class=\"k4urcfbm discj3wi dati1w0a hv4rvrfc i1fnvgqd j83agx80 rq0escxv bp9cbjyn\"]")
	private WebElement postButton;

	@FindBy(xpath = "//div[@class=\"l9j0dhe7 du4w35lb cjfnh4rs j83agx80 cbu4d94t lzcic4wl ni8dbmo4 stjgntxs oqq733wu cwj9ozl2 io0zqebd m5lcvass fbipl8qg nwvqtn77 nwpbqux9 iy3k6uwz e9a99x49 g8p4j16d bv25afu3 d2edcug0\"]")
	private WebElement postDialog;
	
	@FindBy(xpath="//div[@aria-label=\"Your profile\" and @role=\"button\"]")
	private WebElement profileMenu;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logOutButton;
	
	

	public FacebookHomePage(WebDriver driver) {
		this.driver=driver;
		waitHelper = new WaitHelper(driver);
		builder=new Actions(driver);
		js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to verify profile Name
	 */

	public String verifyProfileName() {
		return profile.getText();
	}

	/**
	 * Method to verify the element is present or not on webpage
	 */

	public boolean verifyPostDialogPresent() {
		return postDialog.isDisplayed();
	}

	/**
	 * Method to click on profile Name
	 */

	public void clickOnProfile() {
		//waitHelper.waitForElementToBeVisible(profile, 20);
		profile.click();

	}

	/**
	 * Method to click on post text area
	 */

	public void clickOnStatusText() {
		//waitHelper.waitForElementToBeVisible(statusTxt, 20);
		statusTxt.click();
	}

	/**
	 * Method to enter message into post box
	 */
	public void enterMessage(String message) {
		statusBox.sendKeys(message);
	}

	/**
	 * Method to click on post button
	 */
	public void clickOnPostButton() {
		postButton.click();

	}
	
	
	/**
	 * Method to click on profile menu
	 */
	
	public void clickOnLogoutButton() {
		profileMenu.click();
//		builder.moveToElement(profileMenu).perform();
//		builder.click(profileMenu).click().perform();
		//js.executeScript("arguments[0].click();", logOutButton);
		logOutButton.click();
		
	}
}
