package practice.homeTest.Assert_Implementation;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage_HardAssert
{
	@Test
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" <====================== Started ========================>");
		
		System.out.println(1);
		System.out.println(2);
		Assert.assertEquals("home", "Home");
		System.out.println(3);
		
		Assert.assertEquals("Home", "Home");
		System.out.println(4);
		
		
		System.out.println(mtd.getName()+" <=====================  Ended =========================>");
		
	}
	@Test
	public void verifyLogoHomePageTest(Method method)
	{
		System.out.println(method.getName()+" <====================== Started ========================>");
	
		Assert.assertTrue(true);
		System.out.println(method.getName()+" <=====================  Ended =========================>");
		
	}
}
