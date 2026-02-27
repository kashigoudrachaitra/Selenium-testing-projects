package testng;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Assertion {
	@Test
	public void fb() {
		String expTitle = "W3Schools Online Web Tutorials";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com");
		
		
	
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expTitle,actualTitle);
		System.out.println("hello");
	}

}
