package seleniumadvanced.demos.seleniumday1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class testAJAX {
  
	public static WebDriver driver;
	
	@BeforeMethod
	public void testLink()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		System.out.println(driver.getTitle());
	}
	
	@Test
		public void ajax() {
		WebElement from = driver.findElement(By.xpath
				("//div[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to 	= driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementWithText
				(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		String result = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println(result);
		Assert.assertTrue(result.contains("$3999"));
		}
	
	@AfterMethod
		public void amethod()
		{
		driver.close();
		}
}
