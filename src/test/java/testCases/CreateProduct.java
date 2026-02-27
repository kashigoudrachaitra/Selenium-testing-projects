package testCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Random ran=new Random();
		int rand = ran.nextInt(1000);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		driver.findElement(By.name("productName")).sendKeys("HP"+rand);
		WebElement categorydropdown = driver.findElement(By.name("productCategory"));
		// Dropdown 1 select the product category by selec class
		Select drop1 = new Select(categorydropdown);
		drop1.selectByValue("Electricals");
		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("20");
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("20000");

		// DropDown 2
		WebElement vendordropdown = driver.findElement(By.name("vendorId"));
		Select drop2 = new Select(vendordropdown);
		//drop2.selectByValue("VID_007");
		Thread.sleep(6000);
		drop2.selectByIndex(2);
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		// logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
		

	}
}
