package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.Baseclassutility.BaseClassTest;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrgPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class CreateContactTest extends BaseClassTest
{

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable
	{

		// [READING] the [TEST SCRIPT DATA] from xlsx file
		String lastName = elib.getDataFromExcel("contact", 1, 2);

		// Step 2: navigate to Contact Module	
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();

		// Step 3: Click on " create Contact " Button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();

		//Pass the details in Contact and clicking on save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		//dtlview_Last Name -> we should add in repository
		//Verification of Header
		//getHeaderMessage() is present in ContactPage
		
		String actHeader = cp.getHeaderMessage().getText();
		//Hence above statement is mandatory will use HardAssert
		//actHeader if it contains lastName
		System.out.println(actHeader);
		System.out.println(lastName);
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		System.out.println("================");
		/*
		 * if(actHeader.equals(lastName)) { System.out.println(actHeader +
		 * " Header is verifed"); }else { System.out.println(actHeader +
		 * " Header is not verifed"); }
		 */
		//According to automation data should not be hard-coded
		
		//Verification 
		String actualLastName = cncp.getLastInfo().getText();
		//Hence above statement is not mandatory will use SoftAssert
		SoftAssert assert1 = new SoftAssert();
		System.out.println(actualLastName);
		System.out.println(lastName);
		assert1.assertEquals(actualLastName, lastName);
		assert1.assertAll();
		
		/*
		 * if(actualLastName.equals(lastName)) { System.out.println(lastName +
		 * " lastname is verifed"); }else { System.out.println(lastName +
		 * " lastname is not verifed"); }
		 */
	}

	// 
	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable 
	{
		String lastName = elib.getDataFromExcel("contact",1,2)+j.getRandonNumber();

		// Step 2: navigate to Contact Module HomePage hp = new HomePage(driver);
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();

		// Step 3: Click on " create Contact " Button ContactPage cp = new
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();

		// Step 4: Enter all the details String startDate =
		String startDate= j.getSystemDataYYYYMMDD();
		String endDate =j.getRequiredDataYYYYMMDD(30);

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContactWithSupportDate(lastName, startDate, endDate);

		//Validation for Contact, StartDate and EndDate String actualLastName=
		w.waitForPageToLoad(driver);
		
		//According to automation data should not be hard-coded
		//dtlview_Last Name -> we should add in repository
		
		String actualLastName=driver.findElement(By.id("dtlview_Last Name")).getText();

		if(actualLastName.equals(lastName)) { System.out.println(lastName+
				" lastname is verifed"); } else { System.out.println(lastName+
						" lastname is not verifed"); }

		String startDate_ =
				driver.findElement(By.id("dtlview_Support Start Date")).getText();

		if(startDate.equals(startDate_)) { System.out.println(startDate_+
				" is verifed"); } else { System.out.println(startDate_+ " is not verifed"); }

		String endDate_ =
				driver.findElement(By.id("dtlview_Support End Date")).getText();

		if(endDate.equals(endDate_)) { System.out.println(endDate_+ " is verifed"); }
		else { System.out.println(endDate_+ " is not verifed"); }
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable
	{
		String orgName = elib.getDataFromExcel("org", 7, 2)+j.getRandonNumber();
		String lastName = elib.getDataFromExcel("contact", 1, 2) + j.getRandonNumber();
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContact().click();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);
		hp.getOrganization().click();
	}
}
