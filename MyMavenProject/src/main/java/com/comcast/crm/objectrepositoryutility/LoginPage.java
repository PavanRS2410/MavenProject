package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

// Step 1 : Create a class for each test case

public class LoginPage extends WebDriverUtility
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// Step 2 : Identify all the webelement by findBy
	@FindBy(name="user_name")
	private WebElement userName;

	@FindBy(name="user_password")
	private WebElement password;

	@FindBy(id="submitButton")
	private WebElement submitBtn;

	public WebElement getEle1() {
		return userName;
	}

	public WebElement getEle2() {
		return password;
	}

	public WebElement getEle3() {
		return submitBtn;
	}
	
	// Login Action ( Business Libraries )
	
	public void loginToApp(String username, String pwd)
	{
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		userName.sendKeys(username);
		password.sendKeys(pwd);
		submitBtn.click();
	}
	
	
	public void loginToApp(String url,String username, String pwd)
	{
		waitForPageToLoad(driver);
		//driver.manage().window().maximize();
		driver.get(url);
		userName.sendKeys(username);
		password.sendKeys(pwd);
		submitBtn.click();
	}
	
	
	



}
