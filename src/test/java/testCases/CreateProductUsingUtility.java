package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesFileUtility;
import genericUtilities.WebdriverUtility;

public class CreateProductUsingUtility {

	public static void main(String[] args)throws IOException, Throwable {
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility jutil=new JavaUtility();
		PropertiesFileUtility putil=new PropertiesFileUtility();
		WebdriverUtility wutil=new WebdriverUtility();
		String BROWSER = putil.togetDataFromPropertiesFile("Browser");
		String URL = putil.togetDataFromPropertiesFile("Url");
		String USERNAME = putil.togetDataFromPropertiesFile("Username");
		String PASSWORD = putil.togetDataFromPropertiesFile("Password");
		jutil.getRandomNumber();
		
		WebDriver driver = null;
		if (BROWSER.equals("Edge")) {
		driver = new EdgeDriver();
		} else if (BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();
		} else if (BROWSER.equals("Firefox")) {
		driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Product')]")).click();
		driver.findElement(By.name("productName")).sendKeys("HP"+jutil.getRandomNumber());
		WebElement categorydropdown = driver.findElement(By.name("productCategory"));
		// Dropdown 1 select the product category by selec class
		wutil.select(categorydropdown, "Electricals");
		//Select drop1 = new Select(categorydropdown);
		//drop1.selectByValue("Electricals");
		WebElement quantity = driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("20");
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("20000");

		// DropDown 2
		WebElement vendordropdown = driver.findElement(By.name("vendorId"));
		Thread.sleep(6000);
		wutil.select(vendordropdown, 2);
		//Select drop2 = new Select(vendordropdown);
		//drop2.selectByValue("VID_007");
		
		//drop2.selectByIndex(2);
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		// logout
		WebElement icon =  driver.findElement(By.xpath("//div[@class='user-icon']"));
		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		wutil.clickOnWebElement(driver, logout);
		// close browser
		driver.quit();

	}

	}


