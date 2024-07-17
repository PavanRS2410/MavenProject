package practice.report;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.Baseclassutility.BaseClassTest;

public class Extent_Sample_ReportWithBS_ASTest extends BaseClassTest
{
	public ExtentReports report;
	ExtentTest test;
	/*
	 * ExtentReports report ;
	 * 
	 * @BeforeSuite public void configureBS() { ExtentSparkReporter spark = new
	 * ExtentSparkReporter("./AdvanceReport/report.html");
	 * spark.config().setDocumentTitle("CRM Test Suite Results");
	 * spark.config().setReportName("CRM Report");
	 * spark.config().setTheme(Theme.DARK); report = new ExtentReports();
	 * report.attachReporter(spark);
	 * 
	 * report.setSystemInfo("OS", "Windows-10"); report.setSystemInfo("BROWSER",
	 * "CHROME-10"); }
	 */
	@Test
	public void createContactTest()
	{
		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS, "contact is created");	
		}
		else
		{
			test.log(Status.FAIL, "contact is not created");		
		}
		System.out.println("login to app");
	}
	
	@Test
	public void createContactWithOrgTest()
	{
		ExtentTest test = report.createTest("createContactWithOrgTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS, "contact is created");	
		}
		else
		{
			test.log(Status.FAIL, "contact is not created");		
		}
		System.out.println("login to app");
	}
	
	@Test
	public void createContactWithPhoneNoTest()
	{
		ExtentTest test = report.createTest("createContactWithPhoneNoTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS, "contact is created");	
		}
		else
		{
			test.log(Status.FAIL, "contact is not created");		
		}
		System.out.println("login to app");
	}
	
	/*
	 * @AfterSuite public void configAS() { report.flush(); }
	 */
}
