package formfill;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormFill_Junit {

	public static void main(String[] args) throws InterruptedException {
		
		// capture locators of all elements
		
		By fName=By.id("first-name");
		By lName=By.id("last-name");
		By jobTitle=By.id("job-title");
		By eduLevel=By.xpath("//*[@type=\"radio\"]");
		By sex=By.xpath("//*[@type=\"checkbox\"]");
		By dropdown=By.xpath("//*[@id=\"select-menu\"]/option");
		By date=By.id("datepicker");
		By submitButton=By.xpath("//*[@role=\"button\"]");
		By sucessMessage=By.xpath("//*[@role=\"alert\"]");
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(fName).sendKeys("Shubhangi");
		Thread.sleep(2000);
		driver.findElement(lName).sendKeys("Pandhare");
		Thread.sleep(2000);
		driver.findElement(jobTitle).sendKeys("SDET");
		Thread.sleep(2000);
		driver.findElement(eduLevel).click();
		Thread.sleep(2000);
		driver.findElement(sex).click();
		Thread.sleep(2000);
		
		WebElement exp = driver.findElement(dropdown);
		Select select=new Select(exp);
		select.selectByValue("2");
		
		Thread.sleep(2000);
		
		driver.findElement(date).sendKeys("06/05/2022");
		Thread.sleep(2000);
		
		driver.findElement(submitButton).click();
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getPageSource().contains("The form was successfully submitted!"));	
		
		String expt = driver.findElement(sucessMessage).getText();
		Assert.assertEquals(expt, "The form was successfully submitted!");
		
		driver.quit();
		
	}

}
