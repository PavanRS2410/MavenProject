package com.comcast.crm.orgtest;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.Baseclassutility.BaseClassTest;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrgPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

// this is help us to run the class directly, dont need testNg.xml file to run the class

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClassTest
{
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable
	{
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		
		// Reading OrgName from Excel file
		String orgName = elib.getDataFromExcel("org", 1, 2)+j.getRandonNumber();

		// Navigating to Organization Page 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hm = new HomePage(driver);
		hm.getOrganization().click();

		// Clicking on Organization button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrg().click();

		// Pass the details of Organization and clicking on SAVE
		UtilityClassObject.getTest().log(Status.INFO, "create a new org");
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.createOrg(orgName);

		// Verifying the Header Msg
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		String header=infoPage.getHeaderMsg().getText();

		Assert.assertEquals(true, header.contains(orgName));

	}


	@Test//(groups = "regressionTest") 
	public void createOrgWithIndustryTest() throws Throwable
	{ 
		String orgName =elib.getDataFromExcel("org", 4, 2)+j.getRandonNumber();
		String industry  = elib.getDataFromExcel("org", 4, 3); 
		//	Navigating to Organization Page 
		HomePage hm = new HomePage(driver);
		hm.getOrganization().click();

		// Clicking on Organization button 
		OrganizationsPage op = new OrganizationsPage(driver); op.getCreateNewOrg().click();

		// Pass the details of Organization along with Industry 
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.createOrg(orgName, industry);

		//Verifying is pending.... for OrganizatioName and IndustryName 
	}

	@Test(groups = "regressionTest")
	public void createOrgTestWithPhoneNo() throws Throwable
	{
		// Reading OrgName from Excel file
		String orgName = elib.getDataFromExcel("org", 7, 2)+j.getRandonNumber();
		String phoneNo = elib.getDataFromExcel("org", 7, 3);


		// Navigating to Organization Page 
		HomePage hm = new HomePage(driver);
		hm.getOrganization().click();

		// Clicking on Organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrg().click();

		// Pass the details of Organization along with Industry
		CreatingNewOrgPage cnop = new CreatingNewOrgPage(driver);
		cnop.createOrgWithPhoneNo(orgName, phoneNo);


	}
}


