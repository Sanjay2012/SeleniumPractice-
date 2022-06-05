package com.herokuapp.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormFillPo {
	
	/**
	 * Page object init element
	 * 
	 * 1. we will capture all the locators and all are private // 
	 * variables--> declaration of all webelements
	 * 2. create a constructor // initialization
	 * pagefactory.initElement()---> lazy initialization
	 * 3. create methods as per user need--> public
	 * 4. all those methods we can call in test class
	 */
	
	WebDriver driver;
	// declaratio of webelements
	
	private By fName=By.id("first-name");
	private By lName=By.id("last-name");
	private By jobTitle=By.id("job-title");
	private By highSchool=By.xpath("//*[@value=\"radio-button-1\"]");
	private By school=By.xpath("//*[@value=\"radio-button-2\"]");
	private By gradScool=By.xpath("//*[@value=\"radio-button-3\"]");
	private By male=By.id("checkbox-1");
	private By female=By.id("checkbox-2");
	private By notToSay=By.id("checkbox-3");
	private By dropdown=By.id("select-menu");
	private By date=By.id("datepicker");
	private By submitButton=By.xpath("//*[@role=\"button\"]");
	//private By sucessMessage=By.xpath("//*[@role=\"alert\"]");
	
	
	// create constructor
	
	public FormFillPo(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstName(String Fname) {
		driver.findElement(fName).sendKeys(Fname);
	}
	
	
	public void enterLastName(String Lname) {
		driver.findElement(lName).sendKeys(Lname);
		
	}
	
	
	public void enterJobTitle(String JobTitle) {
		driver.findElement(jobTitle).sendKeys(JobTitle);
		
	}
	
	
	public void selectEduLevel(String valueToSelect) {	
		if (valueToSelect.equalsIgnoreCase("High School")) {
			driver.findElement(highSchool).click();
		}else if (valueToSelect.equalsIgnoreCase("College")) {
			driver.findElement(school).click();
		}else if (valueToSelect.equalsIgnoreCase("Grad School")) {
			driver.findElement(gradScool).click();
		}
	}
	
	
	public void selectGender(String valueToSelect) {
		if (valueToSelect.equalsIgnoreCase("male")) {
			driver.findElement(male).click();
			
		}else if (valueToSelect.equalsIgnoreCase("female")) {
			driver.findElement(female).click();
			
		}else {
			driver.findElement(notToSay).click();
		}
	}
	
	
	public void selectYearOfExp(String valueToSelect) {
		WebElement exp = driver.findElement(dropdown);
		Select select=new Select(exp);
		if (valueToSelect.equals("0-1")) {
			select.selectByValue("1");
			
		}else if (valueToSelect.equals("2-4")) {
			select.selectByValue("2");
		}else if (valueToSelect.equals("5-9")) {
			select.selectByValue("3");
		}else {
			select.selectByValue("4");
		}
			
		}
	
	
	public void enterdate(String DOB) {
		driver.findElement(date).sendKeys(DOB);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	}
	

