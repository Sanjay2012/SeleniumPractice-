package com.project.test;

import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.facebook.pageobject.FacebookHomePage;
import com.facebook.pageobject.FacebookLoginPage;
import com.project.baseclass.BaseClass;

public class FacebookLoginPostLogoutTest extends BaseClass {
	public FacebookLoginPage loginPo = new FacebookLoginPage(driver);
	public FacebookHomePage homePo;
	SoftAssert soft = new SoftAssert();

	@Test
	public void FacebookLogin() {
		driver.get("https://www.facebook.com/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		loginPo = new FacebookLoginPage(driver);
		soft.assertTrue(driver.getPageSource().contains("log in or sign up"));
		soft.assertTrue(driver.getPageSource().contains("Log In"));
		loginPo.enterUsername("madeeasyctc@gmail.com");
		loginPo.enterPassword("Shiv@123");
		loginPo.clickOnLogInButton();
		soft.assertAll();
	}

	@Test(dependsOnMethods = "FacebookLogin")
	public void logout(){
		homePo = new FacebookHomePage(driver);
		String actProfileName = homePo.verifyProfileName();
		soft.assertEquals(actProfileName,"Shiv Kumar");
		//soft.assertTrue(driver.getPageSource().contains("Welcome to Facebook, Shiv"));
		homePo = new FacebookHomePage(driver);
		homePo.clickOnLogoutButton();
		loginPo = new FacebookLoginPage(driver);
		soft.assertTrue(driver.getPageSource().contains("log in or sign up"));
		soft.assertAll();
	}

}
