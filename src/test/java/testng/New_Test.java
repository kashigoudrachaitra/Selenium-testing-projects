package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New_Test {
	@Test
	public void tc()
	{
		System.out.println("TC001");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("login");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("logout");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("laucnch Browser");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("close Browser");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("pre cond");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("post cond");
	}
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("db open");
	}
	@AfterSuite
	public void afterSuit()
	{
		System.out.println("db close");
	}
}
