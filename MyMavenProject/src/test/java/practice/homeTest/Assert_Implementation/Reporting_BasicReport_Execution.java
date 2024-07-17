package practice.homeTest.Assert_Implementation;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reporting_BasicReport_Execution {


	@Test
	public void homePageTest(Method mtd)
	{
		// Want to see the report on console itself
		// have to use Reporter.log("", true);
		Reporter.log(mtd.getName()+" <====================== Started ========================>");
		
		Reporter.log("Hello",true);
		Reporter.log("hi",true);
		Reporter.log("Good",true);
		Reporter.log("Morning",true);
		
		
		Reporter.log(mtd.getName()+" <=====================  Ended =========================>");
		
	}
	@Test
	public void verifyLogoHomePageTest(Method method)
	{
		Reporter.log(method.getName()+" <====================== Started ========================>");
		Reporter.log("Hello",true);
		Reporter.log("Hi",true);
		Reporter.log("Good Night",true);
		Reporter.log(method.getName()+" <=====================  Ended =========================>");
		
	}
}
