package com.comcast.crm.generic.webdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility 
{
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialURL)
	{
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			String windowID = itr.next();
			driver.switchTo().window(windowID);
			String current_url = driver.getCurrentUrl();
			if(current_url.contains("module=Accounts"))
			{
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID); 
	}
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}


	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}


	public void select(WebElement element , String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void select(WebElement element , int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}


	public void mouseMoveOnElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}















}
