package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadpoolSize_Attribute {
	@Test(invocationCount=6,threadPoolSize = 2)
	public void login() throws Throwable {
		WebDriver driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.quit();
	}

}
