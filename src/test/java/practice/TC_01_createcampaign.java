package practice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_createcampaign {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions settings = new ChromeOptions(); 
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(settings);
      	driver.manage().window().maximize();
    	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     	driver.get("http://49.249.28.218:8098");
     	driver.findElement(By.id("username")).sendKeys("rmgyantra");
     	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
    	    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    	    Thread.sleep(60000);
	}

}
