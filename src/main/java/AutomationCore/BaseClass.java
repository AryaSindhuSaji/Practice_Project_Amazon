package AutomationCore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	
	public WebDriver BrowserInitialization(String browsername)	{
		
		if(browsername.equalsIgnoreCase("Chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium_Java\\amazon\\src\\main\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
		}
	
	
}
