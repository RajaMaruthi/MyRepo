package webauto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleWebAutomation
{

	WebDriver driver=null;
	

	@BeforeTest
	void luanchBrowser()
	{
		
		String strdriverpath=System.getProperty("user.dir")+"//src//test//resources//Drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", strdriverpath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
		
	}
	
	
	@Test()
	public void login()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //wait for 10 seconds after every element
		driver.findElement(By.name("firstname")).sendKeys("Maruthiraja"); // Entering username to test texbox
		driver.findElement(By.name("lastname")).sendKeys("BN");
		driver.findElement(By.xpath("//div/input[1][@name='sex']")).click();
		
	}
	
	@Test(priority = 1)
	public void contanctUs()
	{
		
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		
	}
	
	
	@AfterTest
	void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
