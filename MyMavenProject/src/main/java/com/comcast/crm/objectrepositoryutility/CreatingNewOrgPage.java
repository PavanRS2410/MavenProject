package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrgPage
{

	WebDriver driver;
	public CreatingNewOrgPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "detailedViewTextBox")
	private WebElement orgNameEdit;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumber;

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getPhoneNo() {
		return phoneNumber;
	}

	// orgName-> value coming from xcell
	public void createOrg(String orgName)
	{
		
		orgNameEdit.sendKeys(orgName);	
		saveBtn.click();
	}
	
	// below method will have create org with industry drop-down
	public void createOrg(String orgName , String industry)
	{
		orgNameEdit.sendKeys(orgName);	
		Select select = new Select(industryDD);
		select.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	// below method will have create org with Phone No
	
	public void createOrgWithPhoneNo(String orgName , String phoneNo)
	{
		orgNameEdit.sendKeys(orgName);
		phoneNumber.sendKeys(phoneNo);
		saveBtn.click();
	}

	
	
}
