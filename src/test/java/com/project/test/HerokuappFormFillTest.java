package com.project.test;
import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.project.pageobject.FormFillPo;
import com.herokuapp.project.pageobject.FormSubmitPo;
import com.project.baseclass.BaseClass;

public class HerokuappFormFillTest extends BaseClass {
	FormFillPo formPo;
	FormSubmitPo submitPo;
	SoftAssert soft=new SoftAssert();
	
	@Test
	public void FillForm() throws InterruptedException {
		driver.get(prop.getProperty("herokuapp_url"));	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		formPo=new FormFillPo(driver);
		soft.assertTrue(driver.getPageSource().contains("Complete Web Form"));
		formPo.enterFirstName(prop.getProperty("firstName"));
		Thread.sleep(1000);
		formPo.enterLastName(prop.getProperty("lastName"));
		Thread.sleep(1000);
		formPo.enterJobTitle(prop.getProperty("jobTitle"));
		Thread.sleep(1000);
		formPo.selectEduLevel(prop.getProperty("eduLevel"));
		Thread.sleep(1000);
		formPo.selectGender(prop.getProperty("sex"));
		Thread.sleep(1000);
		formPo.selectYearOfExp(prop.getProperty("experience"));
		Thread.sleep(1000);
		formPo.enterdate(prop.getProperty("date"));
		Thread.sleep(1000);
		formPo.clickSubmitButton();
		
		submitPo=new FormSubmitPo(driver);
		String exp = submitPo.successMessage();
		soft.assertEquals(exp, "The form was successfully submitted!");
		//Assert.assertTrue(driver.getPageSource().contains("The form was successfully submitted!"));
		
		soft.assertAll();
		
		driver.quit();
	}

}
