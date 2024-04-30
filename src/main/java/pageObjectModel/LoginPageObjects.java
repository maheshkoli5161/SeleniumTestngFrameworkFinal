package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	public WebDriver driver;// This driver is null --This dont have scope

	// we will store locators
	private By myAccount = By.xpath("//a[@title='My Account']");
	private By login = By.xpath("//a[text()='Login']");
	private By emailAddres = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name='password']");
	private By submitButton = By.xpath("//input[@value='Login']");
	
	
	//Create the constructor
	public LoginPageObjects(WebDriver driver2) {
		this.driver=driver2;//we gave the scope here
		
	}
	
	public WebElement clickOnMyAccount() {

		return driver.findElement(myAccount);
	}
	public WebElement clickOnLogin() {

		return driver.findElement(login);
	}

	public WebElement Enteremail() {

		return driver.findElement(emailAddres);
	}
	public WebElement Enterpassword() {

		return driver.findElement(password);
	}
	public WebElement clickOnsubmitButton() {

		return driver.findElement(submitButton);
	}
	
	
	

}
