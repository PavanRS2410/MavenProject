package practice.homeTest.Assert_Implementation;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest
{

	@Test
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" <====================== Started ========================>");
		String expTitle = "Home";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();

		Assert.assertEquals(expTitle, actTitle);
		/*
		 * if(actTitle.trim().equals(expTitle)) {
		 * System.out.println(actTitle+" is varified==== [PASS] ===="); } else {
		 * System.out.println(actTitle+" is not varified==== [FAIL] ===="); }
		 */
		System.out.println(mtd.getName()+" <=====================  Ended =========================>");
		driver.close();
	}
	@Test
	public void verifyLogoHomePageTest(Method method)
	{
		System.out.println(method.getName()+" <====================== Started ========================>");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		/*
		 * if(status) { System.out.println("LOGO is varified==== [PASS] ===="); } else {
		 * System.out.println("LOGO is not varified==== [FAIL] ===="); }
		 */
		
		Assert.assertTrue(status);
		
		System.out.println(method.getName()+" <=====================  Ended =========================>");
		driver.close();

	}




}
