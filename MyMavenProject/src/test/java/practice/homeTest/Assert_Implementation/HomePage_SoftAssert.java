package practice.homeTest.Assert_Implementation;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePage_SoftAssert {

	@Test
	public void homePageTest(Method mtd)
	{
		
		System.out.println(mtd.getName()+" <====================== Started ========================>");
		
		System.out.println(1);
		System.out.println(2);
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals("home", "Home");
		System.out.println(3);
		
		assert1.assertEquals("Home", "Home");
		System.out.println(4);
		
		assert1.assertAll();
		
		System.out.println(mtd.getName()+" <=====================  Ended =========================>");
		
	}
	@Test
	public void verifyLogoHomePageTest(Method method)
	{
		System.out.println(method.getName()+" <====================== Started ========================>");
		SoftAssert assert1 = new SoftAssert();
		assert1.assertTrue(true);
		
		assert1.assertAll();
		System.out.println(method.getName()+" <=====================  Ended =========================>");
		
	}
}
