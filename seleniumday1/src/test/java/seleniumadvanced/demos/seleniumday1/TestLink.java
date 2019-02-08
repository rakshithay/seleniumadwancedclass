package seleniumadvanced.demos.seleniumday1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLink {
	
	public static WebDriver driver;

	@BeforeMethod
	public void testLink()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.hdfcbank.com/");
		System.out.println(driver.getTitle());
		//if(driver.getTitle())
		//driver.findElement(By.id("div-close")).click();
	}
	
	@Test
	public void creditCard(){
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
		act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
		act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
		act.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
		act.perform();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("credit_card"));
	}
	
	@AfterMethod
	public void amethod()
	{
		driver.close();
	}
	

}