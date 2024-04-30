package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPageObjects;
import pageObjectModel.RegistrationPageObjects;
import resources.baseClass;

public class VerifyLoginTestCases extends baseClass {
	
	@Test
	public void verifyLoginwithValidData() throws IOException, InterruptedException {
		
		
		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		//driver.findElement(By.xpath("...............")).click();
		lpo.clickOnMyAccount().click();
		lpo.clickOnLogin().click();
		lpo.Enteremail().sendKeys(email);
		Thread.sleep(2000);
		lpo.Enterpassword().sendKeys("secure");
		lpo.clickOnsubmitButton().click();
		
		SoftAssert sa = new SoftAssert();
		String Actual = driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
		String Expected = "My Account";	
		sa.assertEquals(Actual, Expected);
		sa.assertAll();

		
		driver.quit();
		
		
	}
	
	@Test(priority=1)
	public void verifyLoginwithInvalidData() throws IOException, InterruptedException {

		
		LoginPageObjects lpo = new LoginPageObjects(driver);
		// driver.findElement(By.xpath("...............")).click();
		lpo.clickOnMyAccount().click();
		lpo.clickOnLogin().click();
		lpo.Enteremail().sendKeys(email);
		Thread.sleep(2000);
		lpo.Enterpassword().sendKeys("securehdgfhsdg");
		lpo.clickOnsubmitButton().click();
		
		
		SoftAssert sa = new SoftAssert();
		String LoginActual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String LoginExpected = "Warning: No match for E-Mail Address and/or Password.";
		sa.assertEquals(LoginActual, LoginExpected);
		sa.assertAll();

		driver.quit();

	}

}
