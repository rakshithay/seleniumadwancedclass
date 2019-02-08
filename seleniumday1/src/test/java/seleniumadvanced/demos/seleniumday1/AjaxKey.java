package seleniumadvanced.demos.seleniumday1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AjaxKey {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void testLink()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=1)
  public void fromTest() throws InterruptedException 
	{
		WebElement from = driver.findElement(By.id("FromTag"));
		
		Thread.sleep(5000);
		from.sendKeys("hyd");
		
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
		String city = driver.findElement(By.id("FromTag")).getAttribute("value");
		Assert.assertEquals(city, "Hyderabad, IN - Rajiv Gandhi International (HYD)");
	}
	
	@Test(priority =2)
	public void toTestDynamicWait()
	{
		WebElement to = driver.findElement(By.id("ToTag"));
		to.sendKeys("ban");
		
		//Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-2")));
		
		WebElement ul = driver.findElement(By.id("ui-id-2"));
		List<WebElement> list = ul.findElements(By.tagName("li"));
		Assert.assertEquals(10,list.size());
		
		for(WebElement li:list)
		{
			if(li.getText().contains("BKK"))
			{
				li.click();
				break;
			}
		}
	}
	
	@AfterTest
	public void amethod()
	{
	driver.close();
	}
}
