package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.RegistrationPageObjects;
import resources.baseClass;
import resources.constants;

public class VerifyRegistrationTestCases extends baseClass {
	

	
	@Test(priority=1)
	public void VerifyRegistrationWithValidData() throws IOException, InterruptedException {
		
		
		
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		//driver.findElement(By.xpath("...............")).click();
		
		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.Enterfirstname().sendKeys(constants.firstname);
		rpo.Enterlastname().sendKeys(constants.lastname);
		rpo.Enteremail().sendKeys(email);
		rpo.Entertelephone().sendKeys(constants.phone);
		rpo.Enterpassword().sendKeys(constants.password);
		rpo.Enterpasswordconfirm().sendKeys(constants.confirmpassword);
		rpo.clickOnpolicycheck().click();
		rpo.clickOnsubmit().click();
		
		
		SoftAssert sa = new SoftAssert();
		
		String Actual = rpo.clickOnactual().getText();
		String Expected = (constants.expectedRegistration);	
		sa.assertEquals(Actual, Expected);
		sa.assertAll();

		
		driver.quit();
	}

	
	@Test(priority=2)
	public void VerifyRegistrationWithInvalidData() throws IOException, InterruptedException {
		
		
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		//driver.findElement(By.xpath("...............")).click();
		
		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.clickOnsubmit().click();
		
		
		SoftAssert sa = new SoftAssert();
		
		String fnActual = driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
		String fnExpected = "First Name must be between 1 and 32 characters!";	
		sa.assertEquals(fnActual, fnExpected);
		sa.assertAll();
		
		String lnActual = driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).getText();
		String lnExpected = "Last Name must be between 1 and 32 characters!";	
		sa.assertEquals(lnActual, lnExpected);
		sa.assertAll();

		
		driver.quit();
	}

	

}
