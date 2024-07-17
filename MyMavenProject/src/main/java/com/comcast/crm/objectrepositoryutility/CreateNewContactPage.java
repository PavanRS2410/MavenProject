package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage 
{
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastEdit ;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn ;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement last_info;
	
	
	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getLastEdit() {
		return lastEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getLastInfo() {
		return last_info;
	}
	
	// Creating Contact
	public void createContact(String lastName)
	{
		lastEdit.sendKeys(lastName);
		saveBtn.click();
	}
	
	// Creating Contact with SupportDate
	public void createContactWithSupportDate(String lname , String startDate, String endDate)
	{
		lastEdit.sendKeys(lname);
		this.startDate.clear();
		this.startDate.sendKeys(startDate);
		this.endDate.clear();
		this.endDate.sendKeys(endDate);
		
		saveBtn.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
