package practice.report;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Sample_ReportTest 
{

	@Test
	public void createContactTest()
	{
		//[[HIGH - LEVEL]]  ---> Report <---
		
		// Step 1 : SPARK REPORT CONFIG //
		// Where you want to generate the report
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		// Title of the report
		spark.config().setDocumentTitle("CRM Test Suite Results");
		// Name of the report
		spark.config().setReportName("CRM Report");
		// Theme of the report
		spark.config().setTheme(Theme.DARK);
		
		// Step 2 : add Env Information and create test //
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-10");
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
		
		report.flush();
		System.out.println("login to app");
	}
}
