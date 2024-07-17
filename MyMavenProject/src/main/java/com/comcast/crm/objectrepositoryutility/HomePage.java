package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organization ;

	@FindBy(linkText = "Contacts")
	private WebElement contacts;

	// Just for understanding purpose 
	@FindBy(linkText = "More")
	private WebElement moreLink ;
	
	@FindBy(linkText = "Campaigns")
	private WebElement compaignLink ;
	
	//To Logout
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminLogoutImg;
	
	@FindAll({@FindBy(linkText = "Sign Out")})
	private WebElement signOut;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCompaignLink() {
		return compaignLink;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	// Business Libraries
	public void navigateToCampaignLink()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(moreLink).perform();
		compaignLink.click();
		
	}
	
	public void logOut()
	{
		Actions actions = new Actions(driver);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.moveToElement(adminLogoutImg).perform();
		signOut.click();
	}


}
