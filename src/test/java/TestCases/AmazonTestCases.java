package TestCases;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;

public class AmazonTestCases extends BaseClass{
	
	public WebDriver driver;
	public static Properties prop;
	FileInputStream fs;
	@BeforeMethod
	public void BrowserInvoke() throws IOException {
		
		prop=new Properties();
		fs=new FileInputStream("D:\\Automation\\Selenium_Java\\amazon\\src\\main\\java\\TestData\\TestdataFile.properties");
		prop.load(fs);
		driver = BrowserInitialization("Chrome");
		driver.manage().window().maximize();
		
	}
	@Test
	public void TC01() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(products.size());
		driver.navigate().to("https://www.facebook.com/login/");
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginbutton"))));*/
		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	@Test
	public void TC02() throws InterruptedException
	{
		//driver.get("https://www.goibibo.com/");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[text()='Round-trip']")).click();
		driver.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
		WebElement drp=driver.findElement(By.id("selectProductSort"));
		Select drpobj=new Select(drp);
		drpobj.selectByValue("name:asc");
		Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("(//a[text()='T-shirts'])[2]"))).build().perform();
		
		//Drag and drop
		
		driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
		WebElement iframeElement=driver.findElement(By.xpath("//div[@rel-title='Photo Manager']//iframe"));
		driver.switchTo().frame(iframeElement);
		WebElement source=driver.findElement(By.xpath("(//ul[@id='gallery']//img)[1]"));
		WebElement destination=driver.findElement(By.id("trash"));
		action.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
	}
	@Test(priority=1)
	public void TC03()
	{
		driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys(prop.getProperty("user"));
		driver.findElement(By.name("submit")).click();
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}
	@Test
	public void TC04()
	{
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (128GB) - Purple']")).click();
		
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1=s.iterator();
		while(I1.hasNext())
		{
			String childwindow=I1.next();
			if(!parent.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.id("add-to-cart-button")).click();
			}
			
		}
		driver.switchTo().window(parent);
		
	}

}
