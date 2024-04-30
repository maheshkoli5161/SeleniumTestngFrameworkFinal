package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class baseClass {
	
	public WebDriver driver;
	
	public static String email = generateRandomEmailId();
	
	//browser code
	public void driverInitialization() throws IOException {
		
		//read data from properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties");
		
	
		// Access the data from properties file---Properties java ke under ek class hai
		
		Properties prop = new Properties();
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			 driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			 driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			
			 driver = new EdgeDriver();
		}else {
			System.out.println("Please provideproper driver value");
		}
		
		
	}
	
	// This will help to create unique emailID
	public static String generateRandomEmailId() {
		return "abc" + System.currentTimeMillis()+ "@gmail.com";
	}
	
	@BeforeMethod
	public void lauchBrowserAndUrl() throws IOException {
		
		driverInitialization();
		driver.get("https://naveenautomationlabs.com/opencart/");

	}
	
	
	
	
	
}
