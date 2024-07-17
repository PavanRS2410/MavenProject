
package practice.homeTest.Assert_Implementation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {

	@Test
	public void flipkartTest(Method mtd) throws IOException, InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
 		driver.manage().window().maximize();
 		driver.get("https://demowebshop.tricentis.com/");
 		Thread.sleep(3000);
 		TakesScreenshot ts = (TakesScreenshot)driver;   //explicitly typecast driver instance to TakesScreenshot to get methods
 		File src = ts.getScreenshotAs(OutputType.FILE);   //store the screenshot in the temporary location
 									// getting the output type which is screenshot as file
 		//create a new folder to store the screenshot--->right click on project
 		//create a new file object where the file needs to be stored in destination 
 		File dest = new File("./screenshot/test1a.jpg");
 		FileHandler.copy(src, dest);
 		Thread.sleep(3000);
 		Reporter.log("screenshot1a is captured successfully",true);
 		//to see the screen shot refresh the folder here
 		
 		driver.findElement(By.xpath("//input[@id= 'small-searchterms']")).sendKeys("hi");
 		driver.findElement(By.xpath("//input[@type= 'submit']")).click();
 		Thread.sleep(3000);
 		//to capture the screenshot after searching
 		File src1 = ts.getScreenshotAs(OutputType.FILE); 
 		File dest1 = new File("./screenshot/test1b.jpg");
 		FileHandler.copy(src1, dest1);
	}
	
}
