package com.comcast.crm.Baseclassutility;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.excelutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;


public class BaseClassTest
{
	public FileUtility flib = new FileUtility();
	
	public ExcelUtility elib = new ExcelUtility();
	
	public WebDriverUtility w = new WebDriverUtility();
	
	public JavaUtility j = new JavaUtility();
	
	public static WebDriver driver = null;   //initially don't know which browser to be used
	
	public static WebDriver temp_driver = null; 

	@BeforeSuite
	public void BS()
	{
		System.out.println("-----connect to db, report config-----");
		
	}
	@BeforeClass(groups = "smokeTest")
	public void BC() throws Throwable
	{
		System.out.println("launch the broswer");
		String browser = flib.getDataFromPropFile("Browser");
		//write RTP program so as to when the user enters respective browser driver should launch it
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		temp_driver = driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = "smokeTest")
	public void BM() throws Throwable
	{
		System.out.println("login to the app");	
		String URL = flib.getDataFromPropFile("URL");
		String UN = flib.getDataFromPropFile("UN");
		String PWD = flib.getDataFromPropFile("PWD");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click(); 		
	}
	@AfterMethod(groups = "smokeTest")
	public void AM() throws Exception
	{
		System.out.println("logout to the app");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//img[@src = 'themes/softed/images/user.PNG']"));
		act.moveToElement(src).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass(groups = "smokeTest")
	public void AC()
	{
		System.out.println("close the browser");
		driver.quit();

	}
	@AfterSuite
	public void AS()
	{
		System.out.println("----close DB, report backup----");
		
	}
}
