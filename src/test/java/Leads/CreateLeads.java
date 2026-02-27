package Leads;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLeads {

	public static void main(String[] args) throws InterruptedException {
		
			ChromeOptions settings = new ChromeOptions();
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			WebDriver driver=new ChromeDriver(settings);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//login
			driver.get("http://49.249.28.218:8098/");
			driver.findElement(By.id("username")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			//create lead
            driver.findElement(By.linkText("Leads")).click();
            //lead page
            driver.findElement(By.xpath("//span[text()='Create Lead']")).click();
            driver.findElement(By.name("name")).sendKeys("Aarav Mehta");
            driver.findElement(By.name("company")).sendKeys("Tyss Solutions Pvt Ltd");
            driver.findElement(By.name("industry")).sendKeys("IT Services");
            driver.findElement(By.name("leadSource")).sendKeys("Website");
            driver.findElement(By.name("phone")).sendKeys("9645361475");
            driver.findElement(By.name("leadStatus")).sendKeys("new");
            
           
            //switch to new window
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    		    String parent = driver.getWindowHandle();
    		  //selecting a campaign
    		    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    		 // switch to new window
    			wait.until(d -> d.getWindowHandles().size() > 1);
    			for (String h : driver.getWindowHandles()) {
    			    if (!h.equals(parent)) {
    			        driver.switchTo().window(h);
    			        break;
    		        
    			    }
    			}
    			// wait for table heading (page loaded)
    			 wait.until(ExpectedConditions.visibilityOfElementLocated(
    			         By.xpath("//*[normalize-space()='Select a Campaign']")));

    			 // select by campaign name
    			 String campaignName = "Campaign_66189";
    			 WebElement selectBtn = wait.until(ExpectedConditions.elementToBeClickable(
    			         By.xpath("//tr[td[normalize-space()='" + campaignName + "']]//button[normalize-space()='Select']")));
    			 selectBtn.click();

    			 // switch back
    			 driver.switchTo().window(parent);
    			 driver.findElement(By.xpath("(//button[@type='submit'])")).click();
    				Thread.sleep(6000);
    				
    				// logout
    				WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
    				Actions act = new Actions(driver);
    				act.moveToElement(icon).perform();
    				driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
    				driver.quit();
    				

	}

}
