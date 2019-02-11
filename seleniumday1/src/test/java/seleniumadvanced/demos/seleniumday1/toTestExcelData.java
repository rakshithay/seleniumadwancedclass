package seleniumadvanced.demos.seleniumday1;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class toTestExcelData 
{

	public static WebDriver driver;

	@BeforeTest
	@Parameters("Browser")
	public void testLink(String value, ITestContext result)
	{
		System.out.println(result.getCurrentXmlTest().getName()+" test is started");

		if(value.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(value.equals("mozilla"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\training_b4c.06.01\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
	}

	@Test(dataProvider="dp1")
	public void testExcelData(String username, String password) {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.getTitle().contentEquals("Demo Web Shop"));
		driver.findElement(By.linkText("Log out")).click();
	}

	@DataProvider(name="dp1")
	public Object[][] getData() throws IOException
	{
		return readExcel.testExcel();
	}

	@AfterTest
	public void afterTest(ITestContext result)
	{
		driver.close();
		System.out.println(result.getCurrentXmlTest().getName()+" test is completed");
	}
}
