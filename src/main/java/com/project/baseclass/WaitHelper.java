package com.project.baseclass;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	WebDriver driver;
	protected WebDriverWait wait;

	public WaitHelper(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
	}
	
	/**
	 * Wait for the element to be visible ignoring the
	 * StaleElementReferenceException
	 * 
	 * @param driver
	 * @param locator  - provide locator value of element till it is visible on
	 *                 application and then click that element.
	 * @param waitTime - provide maximum wait time in seconds for driver
	 */
	public void waitForElementToBeVisible(WebElement element, int waitTime) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(waitTime)).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
