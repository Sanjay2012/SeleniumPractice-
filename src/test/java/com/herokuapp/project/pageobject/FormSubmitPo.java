package com.herokuapp.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormSubmitPo {
	WebDriver driver;
	// declare
	By sucessMessage=By.xpath("//*[@role=\"alert\"]");
	
	public FormSubmitPo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String successMessage() {
		String success = driver.findElement(sucessMessage).getText();
		return success;
		
	}
	

}
