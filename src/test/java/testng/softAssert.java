package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class softAssert {
	@Test
	public void fb() {
		String expTitle = "W3Schools Online Web Tutorials";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com");
		
		
	
		String actualTitle = driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expTitle,actualTitle);
		System.out.println("hello");
	}


}
