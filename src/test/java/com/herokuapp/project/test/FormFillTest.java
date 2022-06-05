package com.herokuapp.project.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.project.baseclass.BaseClass;
import com.herokuapp.project.pageobject.FormFillPo;
import com.herokuapp.project.pageobject.FormSubmitPo;

public class FormFillTest extends BaseClass {
	FormFillPo formPo;
	FormSubmitPo submitPo;
	
	@Test
	public void FillForm() throws InterruptedException {
		formPo=new FormFillPo(driver);
		formPo.enterFirstName("Sanjay");
		Thread.sleep(1000);
		formPo.enterLastName("Waware");
		Thread.sleep(1000);
		formPo.enterJobTitle("SDET");
		Thread.sleep(1000);
		formPo.selectEduLevel("Grad School");
		Thread.sleep(1000);
		formPo.selectGender("Male");
		Thread.sleep(1000);
		formPo.selectYearOfExp("5-9");
		Thread.sleep(1000);
		formPo.enterdate("06/05/2022");
		Thread.sleep(1000);
		formPo.clickSubmitButton();
		
		submitPo=new FormSubmitPo(driver);
		String exp = submitPo.successMessage();
		Assert.assertEquals(exp, "The form was successfully submitted!");
		//Assert.assertTrue(driver.getPageSource().contains("The form was successfully submitted!"));	
		driver.quit();
	}

}
